package e.docs.service;

import e.doc.dao.Dao;
import e.doc.dao.DaoImpl;
import e.doc.dao.exception.DaoException;
import e.doc.domain.smoracle.ClientInfo;
import e.doc.domain.smoracle.SMWayBillsIn;
import e.docs.service.config.PropertiesImpl;
import e.docs.service.config.PropertyE;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.query.Query;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

public class ServiceUtils {
    private static Logger logger = LogManager.getLogger(ServiceUtils.class);
    private static long smDocNUM;
    public Dao<SMWayBillsIn, Long> smWayBillsInLongDao;
    public Dao<ClientInfo, Long> clientInfoLongDao;
    Properties convertProp;

    public ServiceUtils() {
        convertProp = getConverterProperty(PropertyE.CONVERTER);
        //logger.info("utils - ");

    }

    String createPackageName(String pname) {
        return getDocId() + pname.substring(pname.lastIndexOf("-"));
    }

    Properties getApplicationProperty(PropertyE p) {
        return new PropertiesImpl().getProperty(p);
    }

    Properties getConverterProperty(PropertyE p) {
        return new PropertiesImpl().getProperty(p);
    }

    String getDBPath() {
        return new PropertiesImpl().getProperty(PropertyE.APP).getProperty("database.path");
    }

    String getDBFileName() {
        return new PropertiesImpl().getProperty(PropertyE.APP).getProperty("database.file.name");
    }

    String getDocId() {
        return convertProp.getProperty("sm.wi.prefix") + String.format("%0" + convertProp.getProperty("sm.wi.length") + "d", smDocNUM);
    }

    String getDocType() {
        return convertProp.getProperty("sm.wi.doc.type");
    }

    String getPostObjDescription() {
        return convertProp.getProperty("sm.wi.doc.description");
    }

    String getPostObjAction() {
        return convertProp.getProperty("sm.wi.doc.action");
    }

    String getDocBornIn() {
        return convertProp.getProperty("sm.wi.doc.born.in");
    }


    String getDocState() {
        return convertProp.getProperty("sm.wi.doc.state.in");
    }

    String getMainOrgId() {
        return convertProp.getProperty("sm.wo.main.organization.id");
    }

    String getOpCode() {
        return convertProp.getProperty("sm.wi.doc.operation.code");
    }

    String getPriceRoundMode() {
        return convertProp.getProperty("sm.wi.doc.price.round.mode");
    }

    String getBaseDocType() {
        return convertProp.getProperty("sm.wi.doc.base.doc.type");
    }

    String getTaxId() {
        return convertProp.getProperty("sm.wi.doc.tax.id");
    }

    void getContractInfo(){
        //try {
        //ClientInfo clientInfo = clientInfoLongDao.get(1l);
        //logger.info("clientInfo.toString() - " + clientInfo.toString());
        //String contractInf= clientInfo.getComment();
        String teststr = "lдог № 154 от 15.04.21";
            if (Pattern.compile(".*№.*от.*")
                    .matcher(teststr)
                    .matches()) {
                logger.info("Pattern true");
            }else {
                logger.info("Pattern false");

            }
        //String num = contractInf.substring(teststr.indexOf("№"), )
            //clientInfoLongDao.closeSession();
    /*} catch (DaoException e) {
            clientInfoLongDao.closeSession();
        logger.error(e);
    }*/
    }
    void initSmDocNum() {
        if (ServiceUtils.smDocNUM == 0) {
            try {
                smWayBillsInLongDao = new DaoImpl<SMWayBillsIn, Long>(SMWayBillsIn.class);
                Query q = smWayBillsInLongDao.getQuery("select max(id) FROM SMWayBillsIn where doctype='WI' and id like 'еПН%'");
                //and supplierDoc like 'еПН'
                String docId = (String) q.uniqueResult();
                int lehgth = Integer.parseInt(convertProp.getProperty("sm.wi.length"));
                smDocNUM = Integer.parseInt(docId.substring(docId.length() - lehgth, docId.length()));
                logger.info(smDocNUM);
                //logger.info("List<SMWayBillsIn> list - " + docId + "num - " + num);
                smWayBillsInLongDao.closeSession();
            } catch (DaoException e) {
                smWayBillsInLongDao.closeSession();
                logger.error(e);
            }
        }
        smDocNUM++;
    }

    String getBase64String(File f) {
        try {
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer, 0, buffer.length);
            String s = Base64.getEncoder().encodeToString(buffer);
            fis.close();
            return s;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
