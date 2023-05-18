package e.doc.service;

import e.doc.service.exception.ServiceException;

import java.io.File;
import java.util.List;
import java.util.Properties;

public interface Service {
    Properties getAppProperty();
    Properties getDBProperty(String dbName);
    boolean checkFileBarcode(String fileName) throws ServiceException;
    void convertSMReply(File f);
    String convertFormSM(File f) throws ServiceException;
    void convertChain(File f) throws ServiceException;
}
