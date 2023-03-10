/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package e.docs.docApp;

import e.docs.service.Service;
import e.docs.service.ServiceCTTImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Arrays;
import java.util.Properties;
import java.util.regex.Pattern;

class ListenerOutFolder implements Runnable {
    private static Logger logger = LogManager.getLogger(ListenerOutFolder.class);
    final String TAG = "ListenerOutFolder";
    private Thread thread;
    Properties properties;
    Service service = new ServiceCTTImpl();

    String pathOutPost;
    String pathOutBackup;
    String pathOut;
    String regexSmToProvider;
    int provederId;

    public ListenerOutFolder() {
        thread = new Thread(this, "out");
        properties = service.getAppProperty();
        pathOutPost = properties.getProperty("path.out.post");
        pathOutBackup = properties.getProperty("path.out.backup");
        pathOut = properties.getProperty("path.out");
        regexSmToProvider = properties.getProperty("xml.regexp.out.post");
        provederId = Integer.parseInt(properties.getProperty("provider.id"));
        thread.start();
    }

    @Override
    public void run() {
        logger.info(TAG, "Out thread: ");
        //while (true) {
            /*try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                logger.info("e" + e);
                throw new RuntimeException(e);
            }*/

        File dirin = new File(pathOutPost);
        String[] files = dirin.list();
        logger.info("files - " + Arrays.toString(files));
        for (String s : files) {
            logger.info("Check file - " + s);
            File file = new File(pathOutPost + s);
            if (Pattern.compile("^[\\d,_]+\\.(XML)$")
                    .matcher(s)
                    .matches()) {
                logger.info("Start convert SM to CTT file - " + pathOutPost + s + ".");
                new ServiceCTTImpl().convertFormSM(file);
            } else if(Pattern.compile(".*\\.(Reply)\\.(xml)$")
                    .matcher(s)
                    .matches()) {
                file.delete();
                logger.info("else - " + s);
            }
        }
        //}
    }
}
