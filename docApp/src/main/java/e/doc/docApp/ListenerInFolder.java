package e.doc.docApp;

import e.doc.service.Service;
import e.doc.service.ServiceImpl;
import e.doc.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
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
    Properties properties = service.getAppProperty();
    String pathin = properties.getProperty("path.in");
    String pathHolder;
    String regexXML = properties.getProperty("xml.regexp.in");
    String regexZIP = properties.getProperty("xml.regexp.in.zip");
    //int provederId  = Integer.parseInt(properties.getProperty("provider.id"));

    public ListenerInFolder() throws ServiceException {
        thread = new Thread(this, "in");
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                File dirin = new File(pathin);
                String[] files = dirin.list();
                if (files.length == 0) {
                    logger.debug("Break listen in folder");
                    break;
                }
                for (String s : files) {
                    //logger.info("Check file - " + s);
                    File file = new File(pathin + s);
                    if (Pattern.compile(regexXML)
                            .matcher(s)
                            .matches()) {
                        logger.debug("Start to convert file - " + pathin + s + ".");
                        try {
                            service.convertChain(file); //check and convert
                        } catch (ServiceException e) {
                            logger.info("ListenerInFolder. Error convert Chain" + pathin + s + ".");
                        }
                    } else if (Pattern.compile(regexZIP)
                            .matcher(s)
                            .matches()) {
                        unzip(file);
                        continue;
                    } else {
                        logger.debug("file.delete();");
                        file.delete();
                        //break;
                    }
                    file.delete();
                }
                //System.out.println(" While");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                logger.error(TAG, "In thread stoped");
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
            //logger.info("Try to delete zip - " + f.getName());
            f.delete();
            //logger.info("delete zip - " + f.getName());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
