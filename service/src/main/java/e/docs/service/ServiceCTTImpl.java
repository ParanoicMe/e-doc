package e.docs.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import e.doc.domain.providerctt.blrwbl.BLRWBL;
import e.doc.domain.sm.wi.PostPackageWI;
import e.doc.domain.sm.wo.PostPackageWO;
import e.docs.service.buildectt.CTTDocBuilder;
import e.docs.service.buildectt.CTTDocBuilderImpl;
import e.docs.service.buildersm.SMDocBuilder;
import e.docs.service.buildersm.SMDocBuilderImpl;
import e.docs.service.config.PropertyE;
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
import java.util.Properties;

public class ServiceCTTImpl implements Service {

    private static Logger logger = LogManager.getLogger(ServiceCTTImpl.class);

    ServiceUtils serviceUtils = new ServiceUtils();
    SMDocBuilder smDocBuilder = new SMDocBuilderImpl();

    public void convert(File f, String pathPost) throws IOException {
        serviceUtils.initSmDocNum();
        smDocBuilder.setDocId(serviceUtils.getDocId());

        smDocBuilder.setDocType(serviceUtils.getDocType());
        XmlMapper xmlMapper = new XmlMapper();
        BLRWBL blrwbl;
        blrwbl = xmlMapper.readValue(f, BLRWBL.class);

        String packageName = serviceUtils.createPackageName(blrwbl.getDeliveryNote().getDeliveryNoteID());

        smDocBuilder.reset();
        smDocBuilder.setPostPackage(packageName);
        smDocBuilder.setPostObject(serviceUtils.getPostObjDescription(), serviceUtils.getPostObjAction());
        smDocBuilder.setSMDocument(blrwbl, serviceUtils.getDocBornIn(), serviceUtils.getDocState(),
                serviceUtils.getOpCode(), serviceUtils.getPriceRoundMode());
        String orderId = blrwbl.getDeliveryNote().getOrderID();
        //logger.info("orderId - " + orderId);
        if (orderId != null && !orderId.trim().isEmpty() && !orderId.equals("0"))
            smDocBuilder.setCommonBases(serviceUtils.getBaseDocType(), blrwbl.getDeliveryNote().getOrderID());
        smDocBuilder.setWayBillsIn(blrwbl);
        smDocBuilder.setDocProps(blrwbl);
        smDocBuilder.setSMDocBlobFile(f.getName(), serviceUtils.getBase64String(f));
        smDocBuilder.setSMSpec(blrwbl.getDeliveryNote().getLineItem(), serviceUtils.getTaxId());
        smDocBuilder.setSMWI();

        PostPackageWI pp = smDocBuilder.getPostPackage();
        logger.info("Write xml" + packageName);
        xmlMapper.writeValue(new File(pathPost + packageName + ".xml"), pp);

    }

    @Override
    public Properties getAppProperty() {
        return serviceUtils.getApplicationProperty(PropertyE.APP);
    }

    public void convertFormSM(File f) {
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
                cttDocBuilder.setMessageHeader(serviceUtils.getMainOrgId(), pp.getPostObject().getWo().getSmDocument().getClientGLN());
                serviceUtils.getContractInfo();
                logger.info(pp.toString());
            } else {
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
        /*try {
            XmlMapper xmlMapper = new XmlMapper();
            //PostPackageWO pp = xmlMapper.readValue(f, PostPackageWO.class);
            //logger.info(pp.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }

}
