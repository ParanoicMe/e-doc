package e.doc.docApp;

import e.doc.domain.web.JsonBLRWBL;
import e.doc.service.exception.ServiceException;
import e.doc.service.restservice.RestService;
import e.doc.service.shedule.ServiceSchedule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class ListenerWeb implements Runnable {
    private static Logger logger = LogManager.getLogger(ListenerWeb.class);
    RestService restService;
    ServiceSchedule serviceSchedule = new ServiceSchedule();
    Properties properties;

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
                if (uuid!=null && !uuid.isEmpty()) {
                    JsonBLRWBL[] jsonBlrwbl = restService.getEWayBill();
                    if (jsonBlrwbl.length > 0) {
                        int[] arrE = restService.getServiceUtils().convertEWayBill(jsonBlrwbl);
                        if (arrE.length > 0) {
                            restService.downloadEWayBill(arrE);
                            if (serviceSchedule.checkSchedule()) {
                                listenerInFolder = new ListenerInFolder();
                            }
                        }
                    }
                }else {
                    uuid = restService.getConnection();
                    continue;
                }
                Thread.sleep(600000);
            }
        } catch (ServiceException e) {
            logger.info(e.toString());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
