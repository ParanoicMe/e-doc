package e.doc.docApp;

import e.doc.domain.sqllite.HolderBarcode;
import e.doc.service.Service;
import e.doc.service.ServiceImpl;
import e.doc.service.config.PropertiesImpl;
import e.doc.service.config.PropertyE;
import e.doc.service.exception.ServiceException;
import e.doc.service.shedule.ServiceSchedule;
import e.doc.service.sqllite.ServiceSQLLite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

public class ListenerHolderFolder implements Runnable {

    private static Logger logger = LogManager.getLogger(ListenerHolderFolder.class);
    final String TAG = "ListenerInFolder";
    private Thread thread;
    Service service = new ServiceImpl();
    Properties properties = getApplicationProperty(PropertyE.APP);
    ServiceSchedule serviceSchedule = new ServiceSchedule();
    String pathIn = properties.getProperty("path.in");
    String pathInPost = properties.getProperty("path.in.post");
    String pathHolder = properties.getProperty("path.holder");
    int timeSleep = Integer.parseInt(properties.getProperty("time.sleep.holder"));


    public ListenerHolderFolder() throws ServiceException {
        thread = new Thread(this, "in");
        thread.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                File dirholder = new File(pathHolder);
                String[] files = dirholder.list();
                logger.debug("Files holder - " + Arrays.toString(files));
                if (!serviceSchedule.checkSchedule())
                    Thread.sleep(1800000);

                for (String f : files) {
                    logger.debug("Check holder file" + f);
                    if (service.checkFileBarcode(f)) {
                        logger.debug("Check file success " + f + " Then move file");
                        Files.move(Paths.get(pathHolder + f), Paths.get(pathInPost + f), StandardCopyOption.REPLACE_EXISTING);
                    }
                }
                    /*fixFiles = service.getFixFiles();
                    for (String fn : fixFiles) {
                        Files.move(Paths.get(pathHolder + fn), Paths.get(pathInPost));
                    }*/
                Thread.sleep(timeSleep);
            }

        } catch (ServiceException e) {
            logger.error(TAG, "Holder error");

        } catch (InterruptedException e) {
            logger.error(TAG, "Holder thread stoped");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (IllegalStateException e) {
            logger.error(TAG, "In IllegalStateException ");
        }
    }

    Properties getApplicationProperty(PropertyE p) {
        return new PropertiesImpl().getProperty(p);
    }
}
