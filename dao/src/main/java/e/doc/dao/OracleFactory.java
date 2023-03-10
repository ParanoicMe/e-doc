package e.doc.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class OracleFactory {

    private static Logger logger = LogManager.getLogger(OracleFactory.class);
    private static OracleFactory INSTANCE;
    private SessionFactory factory;

    public OracleFactory() {
        logger.info("OracleFactory const");
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        logger.info("OracleFactory const");
    }

    public static synchronized OracleFactory getINSTANCE() {
        if(OracleFactory.INSTANCE == null){
            synchronized (OracleFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new OracleFactory();
                }
            }
        }
        return INSTANCE;
    }

    public SessionFactory getFactory() {
        return factory;
    }
/*public void init() {

        try {

            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            session.close();
            factory.close();

        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }*/
}
