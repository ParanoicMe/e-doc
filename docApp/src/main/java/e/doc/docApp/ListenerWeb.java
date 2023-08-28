package e.doc.docApp;

import e.doc.domain.web.JsonBLRWBL;
import e.doc.service.Service;
import e.doc.service.ServiceImpl;
import e.doc.service.exception.ServiceException;
import e.doc.service.restservice.RestService;
import e.doc.service.shedule.ServiceSchedule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Properties;

public class ListenerWeb implements Runnable {
    private static Logger logger = LogManager.getLogger(ListenerWeb.class);

    Service service = new ServiceImpl();
    RestService restService;
    ServiceSchedule serviceSchedule = new ServiceSchedule();
    Properties properties =service.getAppProperty();
    int timeSleep = Integer.parseInt(properties.getProperty("time.sleep.web"));
    String regexXML;
    String regexZIP;

    private Thread thread;

    public ListenerWeb() throws ServiceException {
        thread = new Thread(this, "web");
        thread.start();
    }


    @Override
    public void run() {
        try {
            ListenerInFolder listenerInFolder;
            String uuid = null;
            restService = new RestService();

            while (true) {
                serviceSchedule.checkSchedule();
                String filePath = "";
                if (uuid != null && !uuid.isEmpty()) {
                    JsonBLRWBL[] jsonBlrwbl = restService.getEWayBill();
                    //logger.debug("jsonBlrwbl.length" + jsonBlrwbl.length);
                    if (jsonBlrwbl.length > 0) {
                        int[] arrE = restService.convertEWayBill(jsonBlrwbl);
                        //logger.debug("Arrays.toString(arrE)" + Arrays.toString(arrE));
                        if (arrE.length > 0) {
                            restService.downloadEWayBill(arrE);
                        }
                    }
                } else {
                    uuid = restService.getConnection();
                    continue;
                }
                Thread.sleep(timeSleep);
            }
        } catch (ServiceException e) {
            logger.info("ERRRRRR ListenerWeb" + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
