package e.doc.service.sqllite;

import e.doc.dao.exception.DaoException;
import e.doc.dao.sqllite.SQLLite;
import e.doc.domain.sqllite.HolderBarcode;
import e.doc.service.config.PropertiesImpl;
import e.doc.service.config.PropertyE;
import e.doc.service.exception.ServiceErrorCode;
import e.doc.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Properties;

public class ServiceSQLLite {
    private static Logger logger = LogManager.getLogger(ServiceSQLLite.class);

    Properties properties = new PropertiesImpl().getProperty(PropertyE.APP);

    SQLLite sqlLite = new SQLLite(properties.getProperty("database.path") + properties.getProperty("database.file.name"));

    public void initDB() throws ServiceException {
        logger.debug("init Database");
        try {
            sqlLite.init();
        } catch (DaoException e) {
            throw new ServiceException(e, ServiceErrorCode.HU_SERVICE_006);
        }
        //System.out.println("props " + properties.getProperty("database.path"));

    }

    public String getStartTime(String name) throws ServiceException {
        try {
            return sqlLite.getParameter(name);
        } catch (DaoException e) {
            throw new ServiceException(e, ServiceErrorCode.HU_SERVICE_007);
        }
    }

    public void updateStartTime(String name, String val) throws ServiceException {
        try {
            sqlLite.updateParameter(name, val);
        } catch (DaoException e) {
            throw new ServiceException(e, ServiceErrorCode.HU_SERVICE_008);
        }
    }

    public void writeHoldBarcode(String barcode, String filename) throws ServiceException {
        try {
            sqlLite.setEDocHold(barcode, filename);
        } catch (DaoException e) {
            throw new ServiceException(e, ServiceErrorCode.HU_SERVICE_009);
        }
    }

    public List<HolderBarcode> getHoldBarcode() throws ServiceException {
        try {
            return sqlLite.getHolderBarcode();
        } catch (DaoException e) {
            throw new ServiceException(e, ServiceErrorCode.HU_SERVICE_015);
        }
    }

    public void deleteHolderBarcode(String barcode) throws ServiceException {
        try {
            sqlLite.deleteHolderBarcode(barcode);
        } catch (DaoException e) {
            throw new ServiceException(e, ServiceErrorCode.HU_SERVICE_015);
        }
    }

    public List<String> getHolderBarcodesByFileName(String filename) throws ServiceException {
        try {
            return sqlLite.getHolderBarcodeByFileName(filename);
        } catch (DaoException e) {
            throw new ServiceException(e, ServiceErrorCode.HU_SERVICE_015);
        }
    }


}
