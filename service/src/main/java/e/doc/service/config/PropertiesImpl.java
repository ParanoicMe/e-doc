package e.doc.service.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;


public class PropertiesImpl implements Property {
    private static Logger logger = LogManager.getLogger(PropertiesImpl.class);
    Properties property = new Properties();
    InputStreamReader fis;
    public Properties getProperty(PropertyE p) {
        switch (p) {
            case APP: {
                try {
                    //new File( "qwer1234.txt").createNewFile();

                    fis = new InputStreamReader(
                            new FileInputStream("edoc.properties"),
                            //new FileInputStream("./docApp/src/main/resources/edoc.properties"),
                            "UTF-8");
                    property.load(fis);
                } catch (IOException e) {
                    logger.error("Error: File edoc.properties does not exist!" + e);
                }
            }
            case CONVERTER: {
                try {
                    //new File( "qwer123456.txt").createNewFile();
                    fis = new InputStreamReader(
                            new FileInputStream("converter.properties"),
                            //new FileInputStream("./service/src/main/resources/converter.properties"),
                            "UTF-8");
                    property.load(fis);
                } catch (IOException e) {
                    logger.error("Error: File edoc.properties does not exist!" + e);
                }
            }
        }
        return property;
    }

}
