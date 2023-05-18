package e.doc.docApp;

import e.doc.domain.sqllite.HolderBarcode;
import e.doc.service.Service;
import e.doc.service.ServiceImpl;
import e.doc.service.exception.ServiceException;
import e.doc.service.shedule.ServiceSchedule;
import e.doc.service.sqllite.ServiceSQLLite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

public class ListenerHolderFolder implements Runnable {

    private static Logger logger = LogManager.getLogger(ListenerHolderFolder.class);
    final String TAG = "ListenerInFolder";
    private Thread thread;
    Service service = new ServiceImpl();
    Properties properties = service.getAppProperty();
    ServiceSchedule serviceSchedule = new ServiceSchedule();
    String pathIn = properties.getProperty("path.in");
    String pathInPost = properties.getProperty("path.in.post");
    String pathHolder = properties.getProperty("path.holder");

    public ListenerHolderFolder() throws ServiceException {
        thread = new Thread(this, "in");
        thread.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1800000);
                File dirholder = new File(pathHolder);
                String[] files = dirholder.list();
                if (!serviceSchedule.checkSchedule())
                    Thread.sleep(1800000);

                for (String f : files) {
                    logger.debug("Check file" + f);
                    if (service.checkFileBarcode(f)) {
                        logger.debug("Check file success " + f);
                        Files.move(Paths.get(pathHolder + f), Paths.get(pathInPost + f));
                    }
                }
                    /*fixFiles = service.getFixFiles();
                    for (String fn : fixFiles) {
                        Files.move(Paths.get(pathHolder + fn), Paths.get(pathInPost));
                    }*/
            }

        } catch (ServiceException e) {
            logger.error(TAG, "Holder error");

        } catch (InterruptedException e) {
            logger.error(TAG, "Holder thread stoped");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
