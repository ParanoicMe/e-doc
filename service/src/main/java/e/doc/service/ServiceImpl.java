package e.doc.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import e.doc.domain.providerctt.blrwbl.BLRWBL;
import e.doc.domain.sm.post.ReplyError;
import e.doc.domain.sm.wi.PostPackageWI;
import e.doc.domain.sm.wo.PostPackageWO;
import e.doc.domain.sm.wo.SMDocPropWO;
import e.doc.domain.smoracle.ClientInfo;
import e.doc.domain.smoracle.hlp.ClientInfoHlp;
import e.doc.domain.smoracle.hlp.LableWOHlp;
import e.doc.domain.sqllite.HolderBarcode;
import e.doc.service.buildersm.BLRWBLParser;
import e.doc.service.buildersm.SMDocBuilder;
import e.doc.service.buildectt.CTTDocBuilder;
import e.doc.service.buildectt.CTTDocBuilderImpl;
import e.doc.service.buildersm.SMDocBuilderImpl;
import e.doc.service.config.PropertyE;
import e.doc.service.exception.ServiceErrorCode;
import e.doc.service.exception.ServiceException;
import e.doc.service.mail.PostGroup;
import e.doc.service.sqllite.ServiceSQLLite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServiceImpl implements Service {

    private static Logger logger = LogManager.getLogger(ServiceImpl.class);
    private static final String ERRORMESSAGE = "Ошибка при загрузке накладной";
    private static final String SUCCESMESSAGE = "Загружена Новая накладная";
    ServiceUtils serviceUtils = new ServiceUtils();
    Properties properties = this.getAppProperty();
    String pathHolder = properties.getProperty("path.holder");
    String pathPost = properties.getProperty("path.in.post");
    String pathinbackup = properties.getProperty("path.in.backup");
    String pathOut = properties.getProperty("path.out");
    SMDocBuilder smDocBuilder = new SMDocBuilderImpl();
    ServiceSQLLite serviceSQLLite = new ServiceSQLLite();

    public ServiceImpl() throws ServiceException {
    }

    BLRWBL getBLRWBLValue(File f) {
        BLRWBL blrwbl = null;
        try {
            XmlMapper xmlMapper = new XmlMapper();
            blrwbl = xmlMapper.readValue(f, BLRWBL.class);
        } catch (IOException e) {
            logger.info("ERROR MAPPING - " + e.toString());
        }
        return blrwbl;
    }

    public void convertChain(File f) throws ServiceException {
        BLRWBLParser blrwblParser = new BLRWBLParser();
        BLRWBL blrwbl = blrwblParser.parseBLRWBL(f); //getBLRWBLValue(f);
        if (serviceUtils.isExist(blrwbl.getDeliveryNote().getDeliveryNoteID())) {
            logger.info("Try to write existed document - " + blrwbl.getDeliveryNote().getDeliveryNoteID());
        } else {
            convert(f, blrwbl);
        }
        /*String packageName = serviceUtils.createPackageName(blrwbl.getDeliveryNote().getDeliveryNoteID());

        smDocBuilder.reset();
        smDocBuilder.fillPostPackage(packageName);
        smDocBuilder.fillPostObject(serviceUtils.getPostObjDescription(), serviceUtils.getPostObjAction());
        smDocBuilder.fillSMDocument(blrwbl, serviceUtils.getDocBornIn(), serviceUtils.getDocState(),
                serviceUtils.getOpCode(), serviceUtils.getPriceRoundMode());
        String orderId = blrwbl.getDeliveryNote().getOrderID();
        //logger.info("orderId - " + orderId);
        if (orderId != null && !orderId.trim().isEmpty() && !orderId.equals("0"))
            smDocBuilder.fillCommonBases(serviceUtils.getBaseDocType(), blrwbl.getDeliveryNote().getOrderID());
        smDocBuilder.fillWayBillsIn(blrwbl);
        smDocBuilder.fillDocProps(blrwbl);
        smDocBuilder.fillSMDocBlobFile(f.getName(), serviceUtils.getBase64String(f));
        smDocBuilder.fillSMSpec(blrwbl.getDeliveryNote().getLineItem(), serviceUtils.getTaxId());
        smDocBuilder.fillSMWI();

        PostPackageWI pp = smDocBuilder.getPostPackage();
        //logger.info("Write xml" + packageName);
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        xmlMapper.writeValue(new File(pathPost + packageName + ".xml"), pp);
*/
    }

    public void convert(File f, BLRWBL blrwbl) throws ServiceException {
        logger.info("Convert file for SM " + f.getName());
        serviceUtils.initSmDocNum();
        smDocBuilder.setDocId(serviceUtils.getDocId());

        smDocBuilder.setDocType(serviceUtils.getDocType());
        String packageName = serviceUtils.createPackageName(blrwbl.getDeliveryNote().getDeliveryNoteID());
        smDocBuilder.reset();
        smDocBuilder.fillPostPackage(packageName);
        smDocBuilder.fillPostObject(serviceUtils.getPostObjDescription(), serviceUtils.getPostObjAction());
        smDocBuilder.fillSMDocument(blrwbl, serviceUtils.getDocBornIn(), serviceUtils.getDocState(),
                serviceUtils.getOpCode(), serviceUtils.getPriceRoundMode());
        String orderId = blrwbl.getDeliveryNote().getOrderID();
        //logger.info("orderId - " + orderId);
        if (orderId != null && !orderId.trim().isEmpty() && !orderId.equals("0"))
            smDocBuilder.fillCommonBases(serviceUtils.getBaseDocType(), blrwbl.getDeliveryNote().getOrderID());
        smDocBuilder.fillWayBillsIn(blrwbl);
        smDocBuilder.fillDocProps(blrwbl);
        smDocBuilder.fillSMDocBlobFile(f.getName(), serviceUtils.getBase64String(f));
        smDocBuilder.fillSMSpec(blrwbl.getDeliveryNote().getLineItem(), serviceUtils.getTaxId());
        smDocBuilder.fillSMWI();

        PostPackageWI pp = smDocBuilder.getPostPackage();
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        List<String> barcodes = null;

        barcodes = checkBarcodes(serviceUtils.getBarcodes(blrwbl.getDeliveryNote().getLineItem()));
        try {
            if (barcodes.isEmpty()) {
                logger.info("Write file to post folder" + pathPost + packageName + ".xml");
                File smXML = new File(pathPost + packageName + ".xml");
                xmlMapper.writeValue(smXML, pp);
                backupFile(new File(pathPost + packageName + ".xml"));
                //smXML.delete();
                //System.out.println("writefor SM - " + pathPost + packageName + ".xml");
            } else {
                logger.info("Missed barcodes for eTTN" + blrwbl.getDeliveryNote().getDeliveryNoteID() + ", " + barcodes.toString());
                serviceUtils.writeHoldsBarcode(barcodes, packageName + ".xml");
                serviceUtils.mailbarcode(barcodes, blrwbl.getDeliveryNote().getLineItem(), properties.getProperty("shop.name"));
                File smXMLH = new File(pathHolder + packageName + ".xml");
                xmlMapper.writeValue(smXMLH, pp);
                backupFile(new File(pathHolder + packageName + ".xml"));
                //smXMLH.delete();
            }
        } catch (IOException e) {
            logger.info("WRITE ERROR - " + e.getMessage());
            throw new ServiceException(e, ServiceErrorCode.HU_SERVICE_014);
        }
        //f.delete();
    }

    void backupFile(File f) {
        logger.debug("Make backup file" + pathinbackup + f.getName());
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(f);
            fos = new FileOutputStream(pathinbackup + f.getName());
            byte[] buffer = new byte[1024];
            int len;
            while (true) {
                if (!((len = fis.read(buffer)) > 0)) break;
                fos.write(buffer, 0, len);
            }
            fos.close();
            fis.close();
            //f.delete();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Properties getAppProperty() {
        return serviceUtils.getApplicationProperty(PropertyE.APP);
    }

    @Override
    public Properties getDBProperty(String dbName) {
        switch (dbName) {
            case "oracle":
                return serviceUtils.getDbProperty(PropertyE.ORACLE);
            default:
                return null;
        }
    }

    public String convertFormSM(File f) throws ServiceException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        Document doc = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(f);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("WO");
            if (nList.getLength() > 0) {
                logger.info("Convert WO - " + f.getName());
                XmlMapper xmlMapper = new XmlMapper();

                PostPackageWO pp = xmlMapper.readValue(f, PostPackageWO.class);
                CTTDocBuilder cttDocBuilder = new CTTDocBuilderImpl();
                cttDocBuilder.reset();
                String clientGln = pp.getPostObject().getWo().getSmDocument().getClientGLN();
                String mainGln = serviceUtils.getMainOrgId();
                String shopGln = serviceUtils.getMainOrgId();
                String docNumSM = serviceUtils.getDocNum(pp.getPostObject().getWo().getSmDocument().getId());
                cttDocBuilder.setMessageHeader(mainGln, clientGln, docNumSM);
                ClientInfoHlp contractInfo = serviceUtils.getContractInfo(clientGln);
                //functiot code Статус накладной:
                //9 = Оригинал (накладная, которая формируется
                //грузоотправителем изначально)
                //1 = Отмена (отмена ранее созданной накладной)

                //String contact="";
                LableWOHlp lableWOHlp = new LableWOHlp();

                for (SMDocPropWO smDocPropWO : pp.getPostObject().getWo().getSmDocProps()) {
                    switch (smDocPropWO.getParamName()) {
                        case "CustomLabels.User.OtpuskRazreshil":
                            lableWOHlp.setOtpuskRazreshil(smDocPropWO.getParamValue());
                            break;
                        case "CustomLabels.User.DriverName":
                            lableWOHlp.setDriver(smDocPropWO.getParamValue());
                            break;
                        case "CustomLabels.User.NumberAuto":
                            lableWOHlp.setNumCar(smDocPropWO.getParamValue());
                            break;
                        case "CustomLabels.User.Dover":
                            Pattern patternDate = Pattern.compile("№(.*)от\\s?([0-3]*[0-9]?\\.[0-1]*[1-9]?\\.[20|19]*[0-9]?[0-9]?)(.*)?");
                            Matcher matcher = patternDate.matcher(smDocPropWO.getParamValue());
                            if (matcher.find()) {
                                String num = matcher.group(1).trim();
                                String date = matcher.group(2).trim();
                                lableWOHlp.setDover(num);
                                lableWOHlp.setDoverDate(date);
                                System.out.println("matcher1.find() = " + num + " __" + date + "++++ ");
                            }
                            lableWOHlp.setDover(smDocPropWO.getParamValue());
                            break;
                        case "CustomLabels.User.DovPut":
                            lableWOHlp.setDoverPut(smDocPropWO.getParamValue());
                            break;
                    }
                }
                ClientInfo ci = serviceUtils.getClientInfoByGln(clientGln);
                cttDocBuilder.setDeliveryNote("9", contractInfo.getNum(), contractInfo.getDate(), lableWOHlp.getNumCar(), serviceUtils.getWODocumentId(mainGln, docNumSM));
                cttDocBuilder.setShipper(serviceUtils.getClientInfoByGln(mainGln), lableWOHlp.getOtpuskRazreshil());
                cttDocBuilder.setReceiver(ci);
                cttDocBuilder.setFreightPayer(ci);
                cttDocBuilder.setShipFrom(serviceUtils.getClientInfoByGln(shopGln), lableWOHlp.getOtpuskRazreshil());
                cttDocBuilder.setShipTo(ci);
                cttDocBuilder.setCarrier(lableWOHlp);
                cttDocBuilder.setLineItems(pp.getPostObject().getWo(), serviceUtils.getWeight(pp.getPostObject().getWo().getSpecs()));
                cttDocBuilder.setTotal();
                cttDocBuilder.setExtraField();
                xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                xmlMapper.writeValue(new File(pathOut + pp.getPostObject().getWo().getSmDocument().getId() + ".xml"), cttDocBuilder.getBlrwbl());
                return pp.getPostObject().getWo().getSmDocument().getId() + ".xml";

                //logger.info("ci.getDate" + contractInfo.getDate());
                //logger.info(pp.toString());
            } else {
                logger.debug("Node WO null. Irs WI " + " s " + nList.getLength() + "   " + f.getName());
                return null;
                //XmlMapper xmlMapper = new XmlMapper();
                //PostPackageWI pp = xmlMapper.readValue(f, PostPackageWI.class);
                //logger.info(pp.toString());
            }
        } catch (SAXException e) {
            throw new ServiceException(e, ServiceErrorCode.HU_SERVICE_003);
        } catch (IOException e) {
            throw new ServiceException(e, ServiceErrorCode.HU_SERVICE_004);
        } catch (ParserConfigurationException e) {
            throw new ServiceException(e, ServiceErrorCode.HU_SERVICE_005);
        }
    }

    public void convertSMReply(File f) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            ReplyError replyError = xmlMapper.readValue(f, ReplyError.class);
            StringBuffer message = new StringBuffer();
            if (replyError.getPostobjectReply() != null) {
                logger.info("edoc does not load in Supermag. error " + replyError.getPostobjectReply().getError().toString());
                message.append(replyError.getName());
                message.append(replyError.getPostobjectReply().getError().toString());
                serviceUtils.serviceMail.sendMail(message.toString(), PostGroup.ADMIN, ERRORMESSAGE);
            } else {
                logger.info("edoc loaded in Supermag" + replyError.getName());
                message.append(replyError.getName());
                serviceUtils.serviceMail.sendMail(message.toString(), PostGroup.SHOP, SUCCESMESSAGE);
            }
        } catch (ServiceException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private List<String> checkHolderBarcodes(List<String> holderBarcodes) throws ServiceException {
        List<String> fixBarcodes = new ArrayList<>();
        List<String> articles = new ArrayList<>();
        List<String> cardsBarcodes = new ArrayList();
        logger.debug("checkHolderBarcodes. holderBarcodes - " + holderBarcodes.toString());
        if (holderBarcodes.size() > 2) {
            logger.debug("checkHolderBarcodes. holderBarcodes.size() > 2 - ");
            articles = serviceUtils.getArticlesByBarcodes(holderBarcodes);
            cardsBarcodes = serviceUtils.getBarcodesByArticles(articles);
            for (String b : holderBarcodes) {
                if (cardsBarcodes.contains(b)) {
                    //System.out.println("fixBarcodes - " + cardsBarcodes.toString());
                    fixBarcodes.add(b);
                }
            }
        } else {
            logger.debug("checkHolderBarcodes. holderBarcodes.size() < 2 - ");
            for (String barcode : holderBarcodes) {
                String b = serviceUtils.findBarcode(barcode);
                if (b != null) {
                    fixBarcodes.add(barcode);
                }
            }
        }
        return fixBarcodes;
    }

    List<String> checkBarcodes(List<String> barcodes) throws ServiceException {
        List<String> missedBarcodes = new ArrayList();
        //System.out.println(Loader -);
        List<String> articles = new ArrayList<>();
        List<String> cardsBarcodes = new ArrayList();
        if (barcodes.size() > 2) {
            System.out.println("barcodes.size() > 2");
            //Query qBarcode = smStoreUnitLongDao.getQuery("FROM SMStoreUnit where barcode in(:barcodes)");
            //Query qBarcode = smStoreUnitLongDao.getQuery("select article FROM SMStoreUnit where barcode in(:barcodes)");
            //qBarcode.setParameter("barcodes", barcodes);
            articles = serviceUtils.getArticlesByBarcodes(barcodes);//qBarcode.getResultList();
            //System.out.println("articles - " + articles.toString());
            //Query qArticle = smStoreUnitLongDao.getQuery("select barcode FROM SMStoreUnit where article in(:articles)");
            //qArticle.setParameter("articles", articles);
            cardsBarcodes = serviceUtils.getBarcodesByArticles(articles);//qArticle.getResultList();
            // System.out.println("cardsBarcodes - " + cardsBarcodes.toString());
            //System.out.println("barcodes - " + barcodes.toString());
            for (String b : barcodes) {
                if (!cardsBarcodes.contains(b)) {
                    System.out.println("missedBarcodes - " + cardsBarcodes.toString());
                    missedBarcodes.add(b);
                    //writeHoldsBarcode(b, filename);
                    //mailbarcode(b);
                }
            }
        } else {
            System.out.println("barcodes.size() <=2");
            for (String barcode : barcodes) {
                String b = serviceUtils.findBarcode(barcode);
                //Query q = smStoreUnitLongDao.getQuery("select barcode FROM SMStoreUnit where barcode=:barcode");
                //q.setParameter("barcode", barcode);
                //String b = (String) q.uniqueResult();
                if (b == null) {
                    //writeHoldsBarcode(barcode, filename);
                    //mailbarcode(barcode);
                    missedBarcodes.add(barcode);
                }
            }
        }
        return missedBarcodes;
    }

    @Override
    public boolean checkFileBarcode(String fileName) throws ServiceException {
        logger.debug("checkFileBarcode");
        List<String> holderBarcodes = serviceSQLLite.getHolderBarcodesByFileName(fileName);
        List<String> fixBarcodes = checkHolderBarcodes(holderBarcodes);
        //Delete fixed barcodes from holder DB

        for (String b : fixBarcodes) {
            serviceSQLLite.deleteHolderBarcode(b);
        }
        logger.debug("Try to equals size");
        logger.debug("holderBarcodes - " + holderBarcodes.toString() + " fixBarcodes - " + fixBarcodes.toString());
        if (fixBarcodes.size() == holderBarcodes.size())
            return true;
        else
            return false;
    }
}