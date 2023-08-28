package e.doc.docApp;

import e.doc.service.Service;
import e.doc.service.ServiceImpl;
import e.doc.service.exception.ServiceException;
import e.doc.service.shedule.ServiceSchedule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.SimpleTimeZone;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ListenerInFolder implements Runnable {

    private static Logger logger = LogManager.getLogger(ListenerInFolder.class);
    final String TAG = "ListenerInFolder";
    private Thread thread;
    Service service = new ServiceImpl();
    ServiceSchedule serviceSchedule = new ServiceSchedule();
    Properties properties = service.getAppProperty();
    String pathin = properties.getProperty("path.in");
    String regexXML = properties.getProperty("xml.regexp.in");
    String regexZIP = properties.getProperty("xml.regexp.in.zip");
    int timeSleep = Integer.parseInt(properties.getProperty("time.sleep.in"));

    public ListenerInFolder() throws ServiceException {
        thread = new Thread(this, "in");
        thread.start();
    }

    @Override
    public void run() {
        boolean sleep = true;
        while (true) {
            try {
                if (!serviceSchedule.checkSchedule())
                    Thread.sleep(1800000);
                File dirin = new File(pathin);
                String[] files = dirin.list();
                //logger.info("Listener In files - " + Arrays.toString(files));
                for (String s : files) {
                    logger.info("Check Listener In file - " + s);
                    File file = new File(pathin + s);
                    if (Pattern.compile(regexXML)
                            .matcher(s)
                            .matches()) {
                        logger.debug("Start to convert IN file - " + pathin + s + ".");
                        service.convertChain(file); //check and convert
                        //file.delete();
                    } else if (Pattern.compile(regexZIP)
                            .matcher(s)
                            .matches()) {
                        unzip(file);
                        sleep = false;
                        continue;
                    } else {
                        logger.debug(" ListenerIn Delete file - " + file.getName());
                        file.delete();
                        continue;
                    }
                    file.delete();
                }
                //System.out.println(" While");
                if (sleep)
                    Thread.sleep(timeSleep);
                sleep = true;
            } catch (ServiceException e) {
                logger.info("ListenerIn . Error convert Chain");
            } catch (InterruptedException e) {
                logger.error(TAG, "In thread stoped");
            } catch (IllegalStateException e) {
                logger.error(TAG, "In IllegalStateException stoped");
            }
        }
    }

    void unzip(File f) {
        try {
            ZipInputStream zis = new ZipInputStream(new FileInputStream(pathin + f.getName()));
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                File newFile = new File(pathin, zipEntry.getName());
                if (!zipEntry.isDirectory()) {
                    // fix for Windows-created archives
                    File parent = newFile.getParentFile();
                    if (!parent.isDirectory() && !parent.mkdirs()) {
                        throw new IOException("Failed to create directory " + parent);
                    }
                    // write file content
                    if (Pattern.compile(regexXML)
                            .matcher(newFile.getName())
                            .matches()) {
                        FileOutputStream fos = new FileOutputStream(newFile);
                        int len;
                        byte[] buffer = new byte[1024];
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                        fos.close();
                    }
                }
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
            f.delete();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void tryToDelete(File file) {
        while (true)
            if (file.exists())
                file.delete();

    }
}
