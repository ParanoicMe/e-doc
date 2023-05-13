package e.doc.service;

import e.doc.service.exception.ServiceException;

import java.util.List;
import java.util.Properties;

public interface Service {
    Properties getAppProperty();
    Properties getDBProperty(String dbName);
    boolean checkFileBarcode(String fileName) throws ServiceException;
}
