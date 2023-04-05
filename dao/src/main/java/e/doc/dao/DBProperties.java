package e.doc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class DBProperties implements DBProperty{
    private static Logger logger = LogManager.getLogger(DBProperties.class);
    @Override
    public Properties getOracleProperties() {
        Properties property = new Properties();
        InputStreamReader fis;
        try {
            //new File( "qwer1234.txt").createNewFile();

            fis = new InputStreamReader(
                    new FileInputStream("oracle.properties"),
                    //new FileInputStream("./docApp/src/main/resources/edoc.properties"),
                    "UTF-8");
            property.load(fis);
        } catch (IOException e) {
            logger.error("Error: File oracle.properties does not exist!" + e);
        }
        return property;
    }
}
