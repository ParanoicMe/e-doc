package e.doc.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import e.doc.domain.providerctt.blrwbl.BLRWBL;
import e.doc.domain.providerctt.blrwbl.LineItem;
import e.doc.domain.sm.wi.PostPackageWI;
import e.doc.domain.sm.wo.PostPackageWO;
import e.doc.domain.sm.wo.SMDocPropWO;
import e.doc.domain.smoracle.ClientInfo;
import e.doc.domain.smoracle.SMCardProperties;
import e.doc.domain.smoracle.hlp.ClientInfoHlp;
import e.doc.domain.smoracle.hlp.LableWOHlp;
import e.doc.service.buildersm.SMDocBuilder;
import e.doc.service.buildectt.CTTDocBuilder;
import e.doc.service.buildectt.CTTDocBuilderImpl;
import e.doc.service.buildersm.SMDocBuilderImpl;
import e.doc.service.config.PropertyE;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServiceCTTImpl implements Service {

    private static Logger logger = LogManager.getLogger(ServiceCTTImpl.class);

    ServiceUtils serviceUtils = new ServiceUtils();
    SMDocBuilder smDocBuilder = new SMDocBuilderImpl();

    public void convert(File f, String pathPost) throws IOException {
        //logger.info("once");
        serviceUtils.initSmDocNum();
        smDocBuilder.setDocId(serviceUtils.getDocId());

        smDocBuilder.setDocType(serviceUtils.getDocType());
        XmlMapper xmlMapper = new XmlMapper();
        BLRWBL blrwbl;
        blrwbl = xmlMapper.readValue(f, BLRWBL.class);

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
        //logger.info("Write xml" + packageName);
        xmlMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        xmlMapper.writeValue(new File(pathPost + packageName + ".xml"), pp);

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

    public String convertFormSM(File f, String pathOut) {
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
                return null;
                //logger.info("Node null " + " s " + nList.getLength() + "   " + f.getName());
                //XmlMapper xmlMapper = new XmlMapper();
                //PostPackageWI pp = xmlMapper.readValue(f, PostPackageWI.class);
                //logger.info(pp.toString());
            }
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}
