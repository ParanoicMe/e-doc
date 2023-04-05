package e.doc.service;

import e.doc.dao.Dao;
import e.doc.dao.DaoImpl;
import e.doc.dao.exception.DaoException;
import e.doc.domain.sm.wi.SMSpecBy;
import e.doc.domain.sm.wo.SMSpecWO;
import e.doc.domain.smoracle.ClientInfo;
import e.doc.domain.smoracle.ClientProperties;
import e.doc.domain.smoracle.SMCardProperties;
import e.doc.domain.smoracle.hlp.ClientInfoHlp;
import e.doc.domain.smoracle.SMWayBillsIn;
import e.doc.service.config.PropertiesImpl;
import e.doc.service.config.PropertyE;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.query.Query;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServiceUtils {
    private static Logger logger = LogManager.getLogger(ServiceUtils.class);
    private static long smDocNUM;
    public Dao<SMWayBillsIn, Long> smWayBillsInLongDao;
    public Dao<ClientInfo, Long> clientInfoLongDao;
    public Dao<SMCardProperties, Long> smCardPropertiesLongDao;
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

    Properties getDbProperty(PropertyE p) {
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

    String getProviderId() {
        return new PropertiesImpl().getProperty(PropertyE.APP).getProperty("provider.id");
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

    String getWODocumentId(String mainGln, String docNumSM) {
        return getProviderId() + "-" + mainGln + "-" + docNumSM;
    }

    public ClientInfoHlp getContractInfo(String gln) {
        ClientInfoHlp clientHlp = new ClientInfoHlp();
        int contractCh = Integer.valueOf(convertProp.getProperty("sm.wo.contract.info"));
        logger.info("contractInfo - " + clientHlp);
        clientInfoLongDao = new DaoImpl<ClientInfo, Long>(ClientInfo.class);
        switch (contractCh) {
            case 1: {
                try {
                    Query q = clientInfoLongDao.getQuery("from ClientInfo where gln = " + gln);
                    ClientInfo clientInfo = (ClientInfo) q.uniqueResult();
                    String contractInf = clientInfo.getComment();
                    Pattern patternDate = Pattern.compile("№(.*)от\\s?([0-3]*[0-9]?\\.[0-1]*[1-9]?\\.[20|19]*[0-9]?[0-9]?)(.*)?");
                    Matcher matcher = patternDate.matcher(contractInf);
                    clientHlp.setAddress(clientInfo.getAddress());
                    if (matcher.find()) {
                        String num = matcher.group(1).trim();
                        String date = matcher.group(2).trim();
                        clientHlp.setDate(date);
                        clientHlp.setNum(num);
                        System.out.println("matcher1.find() = " + num + " __" + date);
                    }
                } catch (DaoException e) {
                    logger.info(e);
                }
            }
            case 2: {
                try {
                    String propId = convertProp.getProperty("sm.wo.contract.info.properties.id");
                    Query q = clientInfoLongDao.getQuery("from ClientProperties cp " +
                            "where cp.clientInfo.gln = " + gln + " and cp.propId = " + propId);
                    ClientProperties clientProperties = (ClientProperties) q.uniqueResult();
                    Pattern patternDate = Pattern.compile("№(.*)от\\s?([0-3]*[0-9]?\\.[0-1]*[1-9]?\\.[20|19]*[0-9]?[0-9]?)(.*)?");
                    Matcher matcher = patternDate.matcher(clientProperties.getPropVal());
                    clientHlp.setAddress(clientProperties.getClientInfo().getAddress());
                    if (matcher.find()) {
                        String num = matcher.group(1).trim();
                        String date = matcher.group(2).trim();
                        clientHlp.setDate(date);
                        clientHlp.setNum(num);
                        System.out.println("matcher1.find() = " + num + " __" + date + "++++ " + clientHlp.getAddress());
                    }
                } catch (DaoException e) {
                    logger.info(e);
                }
            }
        }
        return clientHlp;
    }

    public ClientInfo getClientInfoByGln(String gln) {
        if (!(clientInfoLongDao instanceof Dao)) {
            clientInfoLongDao = new DaoImpl<ClientInfo, Long>(ClientInfo.class);
        }
        ClientInfo clientInfo = new ClientInfo();
        try {
            Query q = clientInfoLongDao.getQuery("from ClientInfo where gln = " + gln);
            clientInfo = (ClientInfo) q.uniqueResult();
            String contractInf = clientInfo.getComment();
        } catch (DaoException e) {
            logger.info(e);
        }
        return clientInfo;
    }

    public List<SMCardProperties> getWeight(List<SMSpecWO> smSpecWOS) {
        smCardPropertiesLongDao = new DaoImpl<>(SMCardProperties.class);
        List<SMCardProperties> smCardProperties = new ArrayList<>();
        String propId = convertProp.getProperty("sm.card.properties.gross.weight.value.id");
        logger.info("propId -- " + propId);
        List articles = new ArrayList();
        int i = 0;
        for (SMSpecWO swo : smSpecWOS) {
            articles.add(swo.getArticle());
        }
        logger.info("Arrays.toString(s) -- " + articles);
        try {
            Query q = smCardPropertiesLongDao.getQuery("from SMCardProperties where article in (:articles) and propid=:propId");
            q.setParameter("articles", articles);
            q.setParameter("propId", propId);
            smCardProperties = q.list();
        } catch (DaoException e) {
            logger.info(e);
        }
        return smCardProperties;
    }

    void initSmDocNum() {
        if (ServiceUtils.smDocNUM == 0) {
            try {
                //logger.info("Create object");
                smWayBillsInLongDao = new DaoImpl<SMWayBillsIn, Long>(SMWayBillsIn.class);
                Query q = smWayBillsInLongDao.getQuery("select max(id) FROM SMWayBillsIn where doctype='WI' and id like 'еПН%'");
                //and supplierDoc like 'еПН'
                String docId = (String) q.uniqueResult();
                if (docId != null) {
                    //logger.info("Qury object" + toString());
                    int lehgth = Integer.parseInt(convertProp.getProperty("sm.wi.length"));
                    smDocNUM = Integer.parseInt(docId.substring(docId.length() - lehgth, docId.length()));
                } else {
                    smDocNUM = 0;
                }
                logger.info("init smDocNUM - " + smDocNUM);
                //logger.info("List<SMWayBillsIn> list - " + docId + "num - " + num);
                smWayBillsInLongDao.closeSession();
            } catch (DaoException e) {
                logger.info(e);
                smWayBillsInLongDao.closeSession();
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

    String getDocNum(String fullNum) {
        String s = fullNum.substring(2, fullNum.length());
        logger.info("getDocNum ---- " + fullNum + "----" + s);
        return s;//fullNum.substring(2,fullNum.length());
    }

}
