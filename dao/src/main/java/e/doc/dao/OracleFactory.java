package e.doc.dao;

import e.doc.domain.smoracle.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class OracleFactory {

    private static Logger logger = LogManager.getLogger(OracleFactory.class);
    private static OracleFactory INSTANCE;
    private Properties oracleProperties;
    private SessionFactory factory;

    public OracleFactory() {
        //logger.debug("OracleFactory const");
        Configuration configuration = new Configuration();
        oracleProperties = new DBProperties().getOracleProperties();
        configuration.setProperties(oracleProperties);
        configuration.addAnnotatedClass(SMWayBillsIn.class);
        configuration.addAnnotatedClass(ClientInfo.class);
        configuration.addAnnotatedClass(ClientProperties.class);
        configuration.addAnnotatedClass(ClientPropertiesPK.class);
        configuration.addAnnotatedClass(SMCardProperties.class);
        configuration.addAnnotatedClass(SMCardtPropertiesPK.class);
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        factory = configuration.buildSessionFactory(registry);//new MetadataSources(registry).buildMetadata().buildSessionFactory();

        logger.debug("OracleFactory const end");
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
