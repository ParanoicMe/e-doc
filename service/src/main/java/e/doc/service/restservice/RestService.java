package e.doc.service.restservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import e.doc.domain.web.*;
import e.doc.service.Service;
import e.doc.service.ServiceImpl;
import e.doc.service.exception.ServiceErrorCode;
import e.doc.service.exception.ServiceException;
import e.doc.service.mail.ServiceMail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class RestService {
    private static Logger logger = LogManager.getLogger(RestService.class);

    private static String TYPEPOST = "POST";
    private static String TYPEGET = "GET";
    private static String PROPACCEPT = "accept";
    private static String PROPACCEPTVAL = "*/*";
    private static String CONTENTTYPE = "Content-Type";
    private static String CONTENTTYPEVAL = "application/json";
    private static String EDOCTYPE = "BLRWBL";
    private static String AUTHNAME = "Authorization";
    private static String CODEFORMAT = "UTF-8";
    private Service service = new ServiceImpl();
    private Properties properties = service.getAppProperty();
    ;
    private JsonAutentificateUser user;
    private ServiceMail serviceMail = new ServiceMail();
    private String startTime;
    private String nowTime;
    private RestServiceUtils serviceUtils = new RestServiceUtils();
    //HttpURLConnection connection;

    public RestService() throws ServiceException {
    }

    public String getConnection() {
        URL url = null;
        HttpURLConnection connection = null;
        try {
            String jsonCredential = new JsonCredential(properties.getProperty("provider.web.username"), properties.getProperty("provider.web.password")).toString();
            url = new URL(properties.getProperty("provider.web.base.url") + properties.getProperty("provider.web.auth"));
            // Open a connection(?) on the URL(??) and cast the response(???)
            connection = (HttpURLConnection) url.openConnection();
            // Now it's "open", we can set the request method, headers etc.
            connection.setRequestMethod(TYPEPOST);
            connection.setRequestProperty(PROPACCEPT, PROPACCEPTVAL);
            //connection.setRequestProperty("Authorization", "");
            connection.setRequestProperty(CONTENTTYPE, CONTENTTYPEVAL);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            //System.out.println("CURL" + toCurlRequest(connection, jsonCredential.toString().getBytes("UTF-8")));
            OutputStream os = connection.getOutputStream();
            os.write(jsonCredential.getBytes("UTF-8"));
            os.close();
            int responseCode = connection.getResponseCode();
            BufferedReader br = null;
            logger.debug("getConnection responseCode - " + responseCode);
            if (responseCode != HttpURLConnection.HTTP_OK) {
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                logger.error("Connection Error" + responseCode);
                return "";
            } else {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String responseBody = br.lines().collect(Collectors.joining());
                //logger.debug("responseBody -- " + responseBody);
                ObjectMapper mapper = new ObjectMapper();
                user = mapper.readValue(responseBody, JsonAutentificateUser.class);
                //System.out.println("Connection success. User.toString() -- " + user.toString());
                br.close();

                return user.getUuid();
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null)
                connection.disconnect();
        }

    }

    // Request /api/EWAYBILL/{documentState}/filteredList
    public JsonBLRWBL[] getEWayBill() throws ServiceException {
        JsonBLRWBL[] rb = null;
        HttpURLConnection connection = null;
        try {
            startTime = startTime == null ? serviceUtils.getStartTime() : startTime;
            nowTime = serviceUtils.getTime();
            //serviceMail.sendMail("Test mail", PostGroup.ADMIN);
            //serviceUtils.updateStartTime(startTime);

            logger.debug("getEWayBill startTime - " + startTime);
            logger.debug("getEWayBill nowTime - " + nowTime);

            JsonListWayBill jsonListWayBill = new JsonListWayBill();
            jsonListWayBill.setDocumentDateStart(startTime);
            jsonListWayBill.setDocumentDateEnd(nowTime);
            jsonListWayBill.setDocumentType(EDOCTYPE);
            jsonListWayBill.setDocumentStage("ALL");
            URL url = new URL(properties.getProperty("provider.web.base.url") + properties.getProperty("provider.web.edoc.incoming.list"));

            connection = (HttpURLConnection) url.openConnection();
            // Now it's "open", we can set the request method, headers etc.
            connection.setRequestMethod(TYPEPOST);
            connection.setRequestProperty(AUTHNAME, user.getUuid());
            connection.setRequestProperty(PROPACCEPT, PROPACCEPTVAL);
            connection.setRequestProperty(CONTENTTYPE, CONTENTTYPEVAL);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            //connection.connect();
            //logger.debug("jsonListWayBill.toString().getBytes(CODEFORMAT) " + jsonListWayBill.toString());
            //logger.debug(toCurlRequest(connection, jsonListWayBill.toString().getBytes(CODEFORMAT)));
            OutputStream os = connection.getOutputStream();
            os.write(jsonListWayBill.toString().getBytes(CODEFORMAT));

            int responseCode = connection.getResponseCode();
            BufferedReader br = null;
            logger.debug("getEWayBill responseCode - " + responseCode);
            if (responseCode != HttpURLConnection.HTTP_OK) {
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                //logger.error("getEWayBill. Connection Failed. ResponseCode is - " + responseCode);
                //logger.error("BufferedReader is - " + br.lines().collect(Collectors.joining()));
            } else {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String responseBody = br.lines().collect(Collectors.joining());
                //logger.debug("getEWayBill responseBody - " + responseBody);
                ObjectMapper mapper = new ObjectMapper();
                rb = mapper.readValue(responseBody, JsonBLRWBL[].class);
            }
            os.close();
            br.close();
            connection.disconnect();
            logger.debug("getEWayBill JsonBLRWBL[] rb - " + Arrays.toString(rb));
        } catch (JsonProcessingException e) {
            System.out.println(e);
        } catch (MalformedURLException ue) {
            System.out.println(ue);
        } catch (IOException ioe) {
            System.out.println(ioe);
        } finally {
            if (connection != null)
                connection.disconnect();
        }
        return rb;
    }

    public String downloadEWayBill(int[] ids) throws ServiceException {
        HttpURLConnection connection = null;
        int BUFFER_SIZE = 4096;
        try {
            URL url = new URL(properties.getProperty("provider.web.base.url") + properties.getProperty("provider.web.edoc.download.xml"));//?exportFormatType=XML&printEds=false&shortForm=true
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(TYPEPOST);
            connection.setRequestProperty(AUTHNAME, user.getUuid());
            connection.setRequestProperty(PROPACCEPT, PROPACCEPTVAL);
            connection.setRequestProperty(CONTENTTYPE, CONTENTTYPEVAL);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            logger.debug(toCurlRequest(connection, ids.toString().getBytes(CODEFORMAT)));
            OutputStream os = connection.getOutputStream();
            os.write(Arrays.toString(ids).getBytes(CODEFORMAT));
            os.close();
            int responseCode = connection.getResponseCode();
            //BufferedReader br = null;
            logger.debug("downloadEWayBill. response Code - " + responseCode);
            if (responseCode != HttpURLConnection.HTTP_OK) {
                logger.error("downloadEWayBill. Error responseCode - " + responseCode);
                return "";
            } else {
                String fileName = "";
                String disposition = connection.getHeaderField("Content-Disposition");
                int contentLength = connection.getContentLength();
                if (disposition != null) {
                    // extracts file name from header field
                    int index = disposition.indexOf("filename=");
                    if (index > 0) {
                        fileName = disposition.substring(index + 10,
                                disposition.length());
                    }
                } else {
                    fileName = "BLRWBL0001.zip";
                }

                //System.out.println("Content-Type = " + contentType);
                logger.debug("Content-Disposition = " + disposition);
                logger.debug("Create file - " + fileName);

                // opens input stream from the HTTP connection
                InputStream inputStream = connection.getInputStream();
                String saveFilePath = properties.getProperty("path.in") + fileName;

                // opens an output stream to save into file
                FileOutputStream outputStream = new FileOutputStream(saveFilePath);

                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                outputStream.close();
                inputStream.close();
                serviceUtils.updateStartTime(nowTime);
                return saveFilePath;
            }
        } catch (JsonProcessingException e) {
            throw new ServiceException(e, ServiceErrorCode.HU_SERVICE_010);
        } catch (MalformedURLException ue) {
            throw new ServiceException(ue, ServiceErrorCode.HU_SERVICE_011);
        } catch (IOException ioe) {
            throw new ServiceException(ioe, ServiceErrorCode.HU_SERVICE_012);
        } finally {
            if (connection != null)
                connection.disconnect();
        }
    }

    public RestServiceUtils getServiceUtils() {
        return serviceUtils;
    }

    public static String toCurlRequest(HttpURLConnection connection, byte[] body) {
        StringBuilder builder = new StringBuilder("curl -v ");

        // Method
        builder.append("-X ").append(connection.getRequestMethod()).append(" \\\n  ");
        logger.debug("connection.getRequestProperties() " + connection.getRequestProperties().toString());
        // Headers
        for (Map.Entry<String, List<String>> entry : connection.getRequestProperties().entrySet()) {
            builder.append("-H \"").append(entry.getKey()).append(":");
            for (String value : entry.getValue())
                builder.append(" ").append(value);
            builder.append("\" \\\n  ");
        }

        // Body
        if (body != null)
            builder.append("-d '").append(new String(body)).append("' \\\n  ");

        // URL
        builder.append("\"").append(connection.getURL()).append("\"");

        return builder.toString();
    }
}
