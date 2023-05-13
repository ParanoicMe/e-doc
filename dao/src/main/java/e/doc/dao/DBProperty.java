package e.doc.dao;

import e.doc.dao.exception.DaoException;

import java.util.Properties;

public interface DBProperty {
    Properties getOracleProperties() throws DaoException;
}
