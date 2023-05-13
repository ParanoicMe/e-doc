package e.doc.dao.sqllite;

import e.doc.dao.exception.DaoErrorCode;
import e.doc.dao.exception.DaoException;
import e.doc.domain.sqllite.Configuration;
import e.doc.domain.sqllite.HolderBarcode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLLite {
    private static Logger logger = LogManager.getLogger(SQLLite.class);
    String filePath;
    File file;
    String url;
    Connection connection;

    public SQLLite(String filePath) {
        url = "jdbc:sqlite:" + filePath;
        //System.out.println(url);
        this.filePath = filePath;
        file = new File(filePath);
        //System.out.println("Constructor file.exists() - " + file.exists());
    }

    Connection getConnect() throws DaoException {
        try {
            if (connection == null) {

                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(url);
            }
        } catch (SQLException e) {
            throw new DaoException(e, DaoErrorCode.HU_DAO_006);
        } catch (ClassNotFoundException e) {
            throw new DaoException(e, DaoErrorCode.HU_DAO_007);
        }
        return connection;
    }

    public void init() throws DaoException {

        //System.out.println("file.exists() - " + file.exists());
        if (!file.exists()) {
            Connection conn = getConnect();
            //System.out.println("Create");
            //createDatabase(conn);
            createTables();
        }

    }

    /*public void createDatabase(Connection conn) {
        try {
            System.out.println(url);

            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/

    public void createTables() throws DaoException {
        logger.debug("Create tables");
        String edoc = "CREATE TABLE IF NOT EXISTS edochold (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " filename text NOT NULL,\n"
                + " barcode text\n"
                + ");";
        String parameters = "CREATE TABLE IF NOT EXISTS parameter (\n"
                + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                + " name text NOT NULL UNIQUE,\n"
                + " value text\n"
                + ");";
        String startDate = "INSERT INTO parameter (NAME) VALUES ('start.time')";
        try {
            connection = getConnect();
            Statement stmt = connection.createStatement();
            stmt.execute(edoc);
            stmt.execute(parameters);
            stmt.execute(startDate);
            stmt.close();
        } catch (SQLException e) {
            throw new DaoException(e, DaoErrorCode.HU_DAO_008);
        }
    }

    public void clean() {

    }

    public String getParameter(String name) throws DaoException {
        logger.debug("Get Parameter name - " + name);
        String startDate = "";
        try {
            String query = "SELECT value FROM parameter WHERE name='" + name + "'";
            connection = getConnect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                startDate = rs.getString("value");
            }
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            throw new DaoException(e, DaoErrorCode.HU_DAO_009);
        }
        return startDate;
    }

    public void setParameter(String name, String val) throws DaoException {
        try {
            String query = "INSERT INTO parameter (NAME,VALUE)" +
                    "VALUES ('" + name + "', '" + val + "')";
            connection = getConnect();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);

            stmt.close();
        } catch (SQLException e) {
            throw new DaoException(e, DaoErrorCode.HU_DAO_010);
        }
    }

    public void updateParameter(String name, String val) throws DaoException {
        //System.out.println("name val - " + name + "  " + val);
        logger.debug("Update Parameter name - " + name + " value - " + val);
        try {
            String query = "UPDATE parameter SET VALUE = '" + val + "' WHERE NAME='" + name + "'";
            connection = getConnect();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException e) {
            throw new DaoException(e, DaoErrorCode.HU_DAO_010);
        }
    }

    public void setEDocHold(String barcode, String filename) throws DaoException {
        try {
            String query = "INSERT INTO edochold (filename,barcode)" +
                    "VALUES ('" + filename + "', '" + barcode + "')";
            Connection conn = getConnect();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException e) {
            throw new DaoException(e, DaoErrorCode.HU_DAO_011);
        }
    }

    public List<HolderBarcode> getHolderBarcode() throws DaoException {
        try {
            List<HolderBarcode> holderBarcodes = new ArrayList<>();
            String query = "Select * edochold";
            Connection conn = getConnect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                HolderBarcode holderBarcode = new HolderBarcode();
                Integer id = rs.getInt("id");
                String barcode = rs.getString("barcode");
                String fn = rs.getString("filename");
                holderBarcode.setId(id);
                holderBarcode.setBarcode(barcode);
                holderBarcode.setFilename(fn);
                holderBarcodes.add(holderBarcode);
            }
            rs.close();
            stmt.close();
            return holderBarcodes;
        } catch (SQLException e) {
            throw new DaoException(e, DaoErrorCode.HU_DAO_011);
        }
    }

    public void deleteHolderBarcode(String barcode) throws DaoException {
        logger.debug("deleteHolderBarcode -  " + barcode);
        try {
            String query = "DELETE FROM edochold WHERE barcode = '" + barcode + "'";
            connection = getConnect();
            Statement stmt = connection.createStatement();
            stmt.execute(query);
            stmt.close();
        } catch (SQLException e) {
            logger.debug(e.getMessage());
            throw new DaoException(e, DaoErrorCode.HU_DAO_010);
        }
    }

    public List<String> getHolderBarcodeByFileName(String filename) throws DaoException {
        logger.debug("getHolderBarcodeByFileName");
        List<String> holderBarcodes = new ArrayList<>();
        try {
            String query = "Select barcode FROM edochold WHERE filename='" + filename + "'";
            connection = getConnect();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                holderBarcodes.add(rs.getString(1));
            }
            rs.close();
            stmt.close();
            return holderBarcodes;
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new DaoException(e, DaoErrorCode.HU_DAO_010);
        }
    }

}
