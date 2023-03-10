package e.doc.dao.exception.sqllite;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;

public class DaoSQLLite {
    SessionFactory factory;
    String url;
    String sql = "CREATE TABLE IF NOT EXISTS parameter (\n"
            + " id integer PRIMARY KEY,\n"
            + " name text NOT NULL,\n"
            + " value real\n"
            + ");";

    /*public DaoSQLLite(String url, String sql) {
        this.url = url;
    }

    Connection conn;
    public void initDB(String path, String name){
        try {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                Statement stmt = conn.createStatement();
                stmt.execute(sql);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    void setUrl(String path, String name){
        url="jdbc:sqlite:"+ path + name;
    }
    void initConnection(){
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/
    public void setup(String url) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Configuration.class)
                .setProperty("hibernate.connection.driver_class", "org.sqlite.JDBC")
                .setProperty("hibernate.connection.url", "jdbc:sqlite:"+url)
                .setProperty("hibernate.dialect", "org.hibernate.dialect.SQLiteDialect")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.hdm2ddl.auto", "create-drop");
        configuration.configure();
        factory = new Configuration().configure().buildSessionFactory();
    }
}
