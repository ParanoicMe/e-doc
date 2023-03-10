package e.doc.dao;

import e.doc.dao.exception.DaoErrorCode;
import e.doc.dao.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zarubaiko
 * Date: 20.08.14
 * Time: 14:59
 * To change this template use File | Settings | File Templates.
 */
public class DaoImpl<T, PK extends Serializable> implements Dao<T, PK> {
    private static Logger log = LogManager.getLogger(DaoImpl.class);
    private SessionFactory sessionFactoryOracle = OracleFactory.getINSTANCE().getFactory();
    private Class<T> type;
    private String typeName;

    public DaoImpl(Class<T> type) {
        this.type = type;
        this.typeName = type.getName();
        log.debug(String.format("Created Dao for %s.", typeName));
    }

    //private SessionFactory
    @Override
    public List<T> getAll() throws DaoException {
        log.debug(String.format("Get all <%s>.", typeName));
        List<T> list = new ArrayList<T>();
        try {
            //Criteria criteria = getSession().createCriteria(type);
            //list = criteria.list();
            log.debug(String.format("Got %d products", list == null ? 0 : list.size()));
        } catch (HibernateException e) {
            throw new DaoException(e, DaoErrorCode.HU_DAO_001, typeName);
        }
        return list;
    }

    @Override
    public T get(PK id) throws DaoException {
        try {
            log.debug(String.format("Get %s with id=%s.", typeName, id));
            T o = (T) getSession().get(type, id);
            log.debug(String.format("Got %s: %s.", typeName, o));
            closeSession();
            return o;
        } catch (HibernateException e) {
            throw new DaoException(e, DaoErrorCode.HU_DAO_000, typeName, id);
        }

    }

    @Override
    public T add(T o) throws DaoException {
        try {
            log.info(String.format("Create %s: %s.", typeName, o));
            PK id = (PK) getSession().save(o);
            log.info(String.format("Created %s with id=%s.", typeName, id));
            closeSession();
            return get(id);
        } catch (HibernateException e) {
            throw new DaoException(e, DaoErrorCode.HU_DAO_000, o);
        }
    }

    @Override
    public void update(T o) throws DaoException {
        try {
            log.debug(String.format("Update %s: %s.", typeName, o));
            getSession().update(o);
            log.debug(String.format("Updated %s: %s.", typeName, o));
            closeSession();
        } catch (HibernateException e) {
            throw new DaoException(e, DaoErrorCode.HU_DAO_000, o);
        }
    }

    @Override
    public void delete(T o) throws DaoException {
        try {
            log.debug(String.format("Delete %s: %s.", typeName, o));
            if (o != null) {
                getSession().delete(o);
                log.debug(String.format("Deleted %s: %s.", typeName, o));
                closeSession();
            }
        } catch (HibernateException e) {
            throw new DaoException(e, DaoErrorCode.HU_DAO_000, o);
        }
    }

    @Override
    public Query getQuery(String hql) throws DaoException {
        try {
            Query query = getSession().createQuery(hql);
            log.debug(String.format("Created query: %s.", hql));
            return query;
        } catch (HibernateException e) {
            throw new DaoException(e, DaoErrorCode.HU_DAO_000, hql);
        }
    }


    private Session getSession() {
        return getSessionFactoryOracle().openSession();
    }
    @Override
    public void closeSession() {
        getSessionFactoryOracle().close();
    }
    public SessionFactory getSessionFactoryOracle() {
        return sessionFactoryOracle;
    }
}
