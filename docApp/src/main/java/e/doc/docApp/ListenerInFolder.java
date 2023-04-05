package e.doc.docApp;

import e.doc.service.Service;
import e.doc.service.ServiceCTTImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ListenerInFolder implements Runnable {

    private static Logger logger = LogManager.getLogger(ListenerInFolder.class);
    final String TAG = "ListenerInFolder";
    private Thread thread;
    Properties properties;
    Service service = new ServiceCTTImpl();
    String pathin;
    String pathPost;
    String pathinbackup;
    String pathout;
    String regexXML;
    String regexZIP;
    int provederId;

    public ListenerInFolder() {
        thread = new Thread(this, "in");
        properties = service.getAppProperty();
        pathin = properties.getProperty("path.in");
        pathPost = properties.getProperty("path.in.post");
        pathinbackup = properties.getProperty("path.in.backup");
        pathout = properties.getProperty("path.out");
        regexXML = properties.getProperty("xml.regexp.in");
        regexZIP = properties.getProperty("xml.regexp.in.zip");
        provederId = Integer.parseInt(properties.getProperty("provider.id"));
        //logger.info("init \n pathin - " + pathin +
        //        ";\n pathout - " + pathout);
        thread.start();
    }

    @Override
    public void run() {
        //new ServiceCTTImpl().initDatabase();
        //logger.info("run");
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                //logger.info("e" + e);
                throw new RuntimeException(e);
            }
            File dirin = new File(pathin);
            String[] files = dirin.list();
            //logger.info("In Check - ");
            try {
                for (String s : files) {
                    //logger.info("Check file - " + s);
                    File file = new File(pathin + s);
                    if (Pattern.compile(regexXML)
                            .matcher(s)
                            .matches()) {
                        //logger.info("Start to convert file - " + pathin + s + ".");
                        try {
                            //System.out.println("Start to convert file - " + pathin + s + " - . -" + provederId);
                            logger.info("Start to convert cTT file - " + pathin + s + ".");
                            new ServiceCTTImpl().convert(file, pathPost);
                            makeBackUp(file);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (Pattern.compile(regexZIP)
                            .matcher(s)
                            .matches()) {
                        unzip(file);
                    } else {
                        file.delete();
                        break;
                    }
                }
                //System.out.println(" While");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                logger.error(TAG, "In thread stoped");
            }
        }
    }

    void makeBackUp(File f) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(f);
            fos = new FileOutputStream(pathinbackup + f.getName());
            byte[] buffer = new byte[1024];
            int len;
            while (true) {
                if (!((len = fis.read(buffer)) > 0)) break;
                fos.write(buffer, 0, len);
            }
            fos.close();
            fis.close();
            //logger.info("Try to delete xml - " + f.getName());
            while (true) {
                if (f.delete()) {
                    //logger.info("delete xml - " + f.getName());
                    break;
                } else if (!f.exists()) {
                    //logger.info("exists xml - " + f.getName());
                    break;
                }
                //logger.info("xml - " + f.getName());
            }
            //logger.info("delete xml - " + f.getName());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
