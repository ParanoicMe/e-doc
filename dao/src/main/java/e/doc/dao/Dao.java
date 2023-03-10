package e.doc.dao;

import e.doc.dao.exception.DaoException;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zarubaiko
 * Date: 20.08.14
 * Time: 15:00
 * To change this template use File | Settings | File Templates.
 */
public interface Dao<T, PK extends Serializable> {
    List<T> getAll() throws DaoException;
    T get(PK id) throws DaoException;
    T add(T object) throws DaoException;
    void update(T object) throws DaoException;
    void delete(T object) throws DaoException;
    //public Criteria getCriteria() throws DaoException;
    Query getQuery(String hql) throws DaoException;
    void closeSession();
}
