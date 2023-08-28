/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package e.doc.docApp;

import e.doc.domain.web.JsonBLRWBL;
import e.doc.service.Service;
import e.doc.service.ServiceImpl;
import e.doc.service.exception.ServiceException;
import e.doc.service.restservice.RestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

class ListenerOutFolder implements Runnable {
    private static Logger logger = LogManager.getLogger(ListenerOutFolder.class);
    final String TAG = "ListenerOutFolder";
    private Thread thread;
    Service service = new ServiceImpl();
    RestService restService = new RestService();
    Properties properties = service.getAppProperty();
    String pathOutPost = properties.getProperty("path.out.post");
    String pathOut = properties.getProperty("path.out");
    int timeSleep  = Integer.parseInt(properties.getProperty("time.sleep.out"));

    public ListenerOutFolder() throws ServiceException {
        thread = new Thread(this, "out");
        thread.start();
        //String uuid = restService.getConnection();
        //restService.uploadEDoc(pathOut + "РН37013401.zip");
    }

    @Override
    public void run() {
        logger.info(TAG, "Out thread: ");
        String uuid = null;
        //restService.getConnection();
        //restService.uploadEDoc(pathOut + "РН16035476.zip");
//int i=1;
        while (true /*i==2*/) {
            try {
                File dirin = new File(pathOutPost);
                String[] files = dirin.list();
                //logger.info("Listener out files - " + Arrays.toString(files));
                for (String s : files) {
                    //logger.info("Check Listener out file - " + s);
                    File file = new File(pathOutPost + s);
                    if (Pattern.compile("^[\\d,_]+\\.(XML)$")
                            .matcher(s)
                            .matches()) {
                        logger.debug("Start convert SM to CTT file - " + pathOutPost + s + ".");
                        String fileName = null;
                        fileName = service.convertFormSM(file);
                        String zipFilePath = zipFile(fileName);

                        if (uuid != null && !uuid.isEmpty()) {

                        } else {
                            uuid = restService.getConnection();
                            continue;
                        }
                        //restService.uploadEDoc(zipFilePath);

                    } else if (Pattern.compile(".*\\.(Reply)\\.(xml)$")
                            .matcher(s)
                            .matches()) {
                        logger.debug("Start convert Listener out Reply" + s);
                        service.convertSMReply(file);
                    }
                    logger.info("Listener out delete file - " + file.getName());
                    //logger.info("Listener out delete file CW - " + file.canWrite());
                    file.delete();
                }
                Thread.sleep(timeSleep);
            } catch (ServiceException e) {
                logger.info("OUT " + e.getMessage());
            } catch (InterruptedException e) {
                logger.info("e" + e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    String zipFile(String fileName) {
        if (fileName != null) {
            try {
                String zioFilePath=pathOut + fileName.substring(0, fileName.length() - 4) + ".zip";
                FileOutputStream fos = new FileOutputStream(zioFilePath);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ZipOutputStream zos = new ZipOutputStream(bos);
                zos.putNextEntry(new ZipEntry(fileName));
                InputStream in = new FileInputStream(pathOut + fileName);
                File f = new File(pathOut + fileName);
                try {
                    byte[] buffer = new byte[1024];
                    while (true) {
                        int readCount = in.read(buffer);
                        if (readCount < 0) {
                            break;
                        }
                        zos.write(buffer, 0, readCount);
                    }
                } finally {
                    in.close();
                }
                zos.close();
                fos.close();
                bos.close();
                f.delete();
                return zioFilePath;
            } catch (FileNotFoundException e) {
                logger.info(e);
            } catch (IOException ex) {
                logger.info(ex);
            }
        }
        return "";
    }
}
