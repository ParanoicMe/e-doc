package e.doc.service;

import java.util.Properties;

public interface Service {
    Properties getAppProperty();
    Properties getDBProperty(String dbName);
}
