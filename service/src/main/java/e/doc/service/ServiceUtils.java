package e.doc.service;

import e.doc.dao.Dao;
import e.doc.dao.DaoImpl;
import e.doc.dao.exception.DaoException;
import e.doc.domain.providerctt.blrwbl.BLRWBL;
import e.doc.domain.providerctt.blrwbl.LineItem;
import e.doc.domain.sm.wo.SMSpecWO;
import e.doc.domain.smoracle.*;
import e.doc.domain.smoracle.hlp.ClientInfoHlp;
import e.doc.service.config.PropertiesImpl;
import e.doc.service.config.PropertyE;
import e.doc.service.exception.ServiceErrorCode;
import e.doc.service.exception.ServiceException;
import e.doc.service.mail.PostGroup;
import e.doc.service.mail.ServiceMail;
import e.doc.service.sqllite.ServiceSQLLite;
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
    public Dao<SMStoreUnit, Long> smStoreUnitLongDao;
    public Dao<SMCardProperties, Long> smCardPropertiesLongDao;
    Properties convertProp;
    ServiceSQLLite serviceSQLLite = new ServiceSQLLite();
    ServiceMail serviceMail = new ServiceMail();

    public ServiceUtils() throws ServiceException {
        convertProp = getConverterProperty(PropertyE.CONVERTER);
        smStoreUnitLongDao = getSmStoreUnitLongDao();
        //logger.info("utils - ");

    }

    String createPackageName(String pname) {
        return getDocId() + pname.substring(pname.indexOf("-"));
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

    public ClientInfoHlp getContractInfo(String gln) throws ServiceException {
        ClientInfoHlp clientHlp = new ClientInfoHlp();
        int contractCh = Integer.valueOf(convertProp.getProperty("sm.wo.contract.info"));
        logger.info("contractInfo - " + clientHlp);
        try {
            clientInfoLongDao = new DaoImpl<ClientInfo, Long>(ClientInfo.class);
            switch (contractCh) {
                case 1: {

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
                        //System.out.println("matcher1.find() = " + num + " __" + date);
                    }

                }
                case 2: {
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
                        //System.out.println("matcher1.find() = " + num + " __" + date + "++++ " + clientHlp.getAddress());
                    }
                }
            }
        } catch (DaoException e) {
            throw new ServiceException(e, ServiceErrorCode.HU_SERVICE_000);
        }
        return clientHlp;
    }

    public ClientInfo getClientInfoByGln(String gln) throws ServiceException {
        ClientInfo clientInfo = new ClientInfo();
        try {
            //if (!(clientInfoLongDao instanceof Dao)) {
            clientInfoLongDao = new DaoImpl<ClientInfo, Long>(ClientInfo.class);
            //}

            Query q = clientInfoLongDao.getQuery("from ClientInfo where gln = " + gln);
            clientInfo = (ClientInfo) q.uniqueResult();
            String contractInf = clientInfo.getComment();
        } catch (DaoException e) {
            throw new ServiceException(e, ServiceErrorCode.HU_SERVICE_001);
        }
        return clientInfo;
    }

    public List<SMCardProperties> getWeight(List<SMSpecWO> smSpecWOS) throws ServiceException {
        List<SMCardProperties> smCardProperties = new ArrayList<>();

        try {
            smCardPropertiesLongDao = new DaoImpl<>(SMCardProperties.class);
            String propId = convertProp.getProperty("sm.card.properties.gross.weight.value.id");
            //logger.info("propId -- " + propId);
            List articles = new ArrayList();
            int i = 0;
            for (SMSpecWO swo : smSpecWOS) {
                articles.add(swo.getArticle());
            }
            logger.info("Arrays.toString(s) -- " + articles);

            Query q = smCardPropertiesLongDao.getQuery("from SMCardProperties where article in (:articles) and propid=:propId");
            q.setParameter("articles", articles);
            q.setParameter("propId", propId);
            smCardProperties = q.list();
        } catch (DaoException e) {
            throw new ServiceException(e, ServiceErrorCode.HU_SERVICE_002);
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
                //smWayBillsInLongDao.closeSession();
            } catch (DaoException e) {
                logger.info(e);
                smWayBillsInLongDao.closeSession();
            }
        }
        smDocNUM++;
    }

    boolean isExist(String num) {
        try {
            //logger.info("Create object");
            smWayBillsInLongDao = new DaoImpl<SMWayBillsIn, Long>(SMWayBillsIn.class);
            Query q = smWayBillsInLongDao.getQuery("FROM SMWayBillsIn where supplierDoc=:num");
            q.setParameter("num", num);
            //and supplierDoc like 'еПН'
            List<SMWayBillsIn> smWayBillsIns = q.list();
            System.out.println("num - " + num + "smWayBillsIn ==" + smWayBillsIns.toString());
            if (smWayBillsIns.isEmpty()) {
                return false;
            } else {
                return true;
            }
        } catch (DaoException e) {
            logger.info(e);
            smWayBillsInLongDao.closeSession();
        }
        //smWayBillsInLongDao.closeSession();
        return false;
    }



    public List<String> getBarcodesByArticles(List<String> articles) throws ServiceException {
        List<String> cardsBarcodes = new ArrayList<>();
        try {
            Query qArticle = smStoreUnitLongDao.getQuery("select barcode FROM SMStoreUnit where article in(:articles)");
            qArticle.setParameter("articles", articles);
            cardsBarcodes = qArticle.getResultList();
        } catch (DaoException e) {
            throw new ServiceException(e, ServiceErrorCode.HU_SERVICE_016);
        }
        return cardsBarcodes;
    }

    public List<String> getArticlesByBarcodes(List<String> barcodes) throws ServiceException {
        List<String> articles = new ArrayList<>();
        try {
            Query qBarcode = smStoreUnitLongDao.getQuery("select article FROM SMStoreUnit where barcode in(:barcodes)");
            qBarcode.setParameter("barcodes", barcodes);
            articles = qBarcode.getResultList();
        } catch (DaoException e) {
            throw new ServiceException(e, ServiceErrorCode.HU_SERVICE_016);
        }
        return articles;
    }

    public String findBarcode(String barcode) throws ServiceException {
        String b;
        try {
            Query q = smStoreUnitLongDao.getQuery("select barcode FROM SMStoreUnit where barcode=:barcode");
            q.setParameter("barcode", barcode);
            b = (String) q.uniqueResult();
        } catch (DaoException e) {
            throw new ServiceException(e, ServiceErrorCode.HU_SERVICE_019);
        }
        return b;
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

    List getBarcodes(List<LineItem> list) {
        ArrayList<String> barcodes = new ArrayList<>();
        for (LineItem li : list) {
            barcodes.add(li.getLineItemID());
        }
        return barcodes;
    }

    void writeHoldsBarcode(List<String> barcodes, String filename) throws ServiceException {
        for (String b : barcodes)
            serviceSQLLite.writeHoldBarcode(b, filename);
    }

    void mailbarcode(List<String> barcodes, List<LineItem> lis) throws ServiceException {
        StringBuffer textMail = new StringBuffer();
        if (barcodes.size() > 1)
            textMail.append("Список отсутствующих, в Супермаг, товаров:\n");
        else
            textMail.append("Отсутствующий, в Супермаге, товар:\n");
        for (String b : barcodes) {
            for (LineItem li : lis) {
                if (b.equals(li.getLineItemID())) {
                    textMail.append(b);
                    textMail.append(" ");
                    textMail.append(li.getLineItemName());
                    textMail.append(" НДС -");
                    textMail.append(li.getTaxRate());
                    textMail.append("\n");
                }
            }
        }
        //System.out.println(textMail.toString());
        serviceMail.sendMail(textMail.toString(), PostGroup.CARDS, "Отсутствующие ШК по эТТН");
    }

    public Dao<SMStoreUnit, Long> getSmStoreUnitLongDao() throws ServiceException {
        try {
            if (smStoreUnitLongDao == null)
                return new DaoImpl<SMStoreUnit, Long>(SMStoreUnit.class);
            else
                return smStoreUnitLongDao;
        } catch (DaoException e) {
            throw new ServiceException(e, ServiceErrorCode.HU_SERVICE_018);
        }

    }

    public void setSmStoreUnitLongDao(Dao<SMStoreUnit, Long> smStoreUnitLongDao) {
        this.smStoreUnitLongDao = smStoreUnitLongDao;
    }
}
