package e.doc.service;

import e.doc.domain.providerctt.blrwbl.BLRWBL;
import e.doc.domain.providerctt.blrwbl.LineItem;
import e.doc.domain.sm.wi.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SMDocBuilderImpl implements SMDocBuilder {
    private static final String CURRENCYMULTORDER = "0";
    private static final String CURRENCYRATE = "1";
    private static final String CURRENCYTYPE = "1";
    private static final String ISROUBLES = "1";
    private static final String GGODSOWNER = "0";
    private static final String PAYCASH = "0";
    private static final String INSERTID = "1";
    private static final String INSERTTYPEID = "0";
    private static final String EXTRACHARGE = "0";
    private PostPackageWI pp;
    //private ProviderDomain pd;
    private PostObjectWI po;
    private SMWI wi;
    private SMDocumentWI sd;
    private SMCommonBasesWI scb;
    private SMWayBillsIn swb;
    private List<SMDocPropWI> listProps;
    private SMDocBlobFileWI sbf;
    private List<SMSpecWI> specs;
    private List<SMSpecTax> specsTax;
    private List<SMSpecBy> specsBy;
    private String docId;
    private String docType;

    public SMDocBuilderImpl() {
        //this.pd = pd;
    }

    @Override
    public void reset() {
        pp = new PostPackageWI();
        po = new PostObjectWI();
        //scb = new SMCommonBases();
        swb = new SMWayBillsIn();
        listProps = new ArrayList<>();
        sbf = new SMDocBlobFileWI();
        sd = new SMDocumentWI();
        wi = new SMWI();
        specs = new ArrayList<>();
        specsTax = new ArrayList<>();
        specsBy = new ArrayList<>();
    }

    @Override
    public void setPostPackage(String name) {
        pp.setName(name);
        pp.setPostObjectWI(po);
    }

    @Override
    public void setPostObject(String description, String action) {
        po.setDescription(description);
        po.setAction(action);
        po.setId(docType + docId);
        po.setWi(wi);
    }

    @Override
    public void setCommonBases(String baseDocType, String orderId) {
        scb = new SMCommonBasesWI();
        scb.setId(docId);
        scb.setDocType(docType);
        scb.setBaseDocType(baseDocType);
        scb.setBaseId(orderId=="0" ? docId : orderId);
    }

    @Override
    public void setSMDocBlobFile(String fileName, String base64) {

        sbf.setId(docId);
        sbf.setDocType(docType);
        sbf.setInsertionId(INSERTID);
        sbf.setFileName(fileName);
        sbf.setInsertedtTypeId(INSERTTYPEID);
        sbf.setTheContents(base64);
        sbf.setTitle(fileName);
    }

    @Override
    public void setDocProps(BLRWBL b) {
        SMDocPropWI paperTTNNumber = new SMDocPropWI();
        paperTTNNumber.setDocId(docId);
        paperTTNNumber.setDocType(docType);
        paperTTNNumber.setParamName("CustomLabels.User.PaperTTNNumber");
        paperTTNNumber.setParamValue(b.getDeliveryNote().getDeliveryNoteID());

        SMDocPropWI shippingPoint = new SMDocPropWI();
        shippingPoint.setDocId(docId);
        shippingPoint.setDocType(docType);
        shippingPoint.setParamName("CustomLabels.User.ShippingPoint");
        shippingPoint.setParamValue(b.getDeliveryNote().getShipFrom().getGLN());

        SMDocPropWI dischargePoint = new SMDocPropWI();
        dischargePoint.setDocId(docId);
        dischargePoint.setDocType(docType);
        dischargePoint.setParamName("CustomLabels.User.DischargePoint");
        dischargePoint.setParamValue(b.getDeliveryNote().getShipTo().getGLN());

        listProps.add(paperTTNNumber);
        listProps.add(shippingPoint);
        listProps.add(dischargePoint);
    }

    @Override
    public void setSMDocument(BLRWBL b, String bornIn, String docState, String opCode, String priceRoundMode) {
        sd.setId(docId);
        sd.setDocType(docType);
        sd.setBornin(bornIn);
        sd.setCreateDate(convertDate(b.getDeliveryNote().getDeliveryNoteDate()));
        sd.setCurrencyMultOrder(CURRENCYMULTORDER);
        sd.setCurrencyRate(CURRENCYRATE);
        sd.setCurrencyType(CURRENCYTYPE);
        sd.setDocState(docState);
        sd.setIsRoubles(ISROUBLES);
        sd.setOpCode(opCode);
        sd.setPriceRoundMode(priceRoundMode);
        sd.setTotalSum(b.getDeliveryNote().getTotal().getTotalAmount());
        sd.setTotalSumCur(b.getDeliveryNote().getTotal().getTotalAmount());
        sd.setSupplierGln(b.getDeliveryNote().getShipper().getGLN());
        sd.setDestinationGln(b.getDeliveryNote().getShipTo().getGLN());
        sd.setBuyergln(b.getDeliveryNote().getReceiver().getGLN());
    }

    @Override
    public void setSMSpec(List<LineItem> list, String taxId) {
        for (LineItem li : list) {
            SMSpecWI ss = new SMSpecWI();
            SMSpecTax sst = new SMSpecTax();
            SMSpecBy ssb = new SMSpecBy();
            ss.setDocId(docId);
            ss.setDocType(docType);
            ss.setSpecItem(li.getLineItemNumber());
            ss.setDisplayItem(li.getLineItemNumber());
            ss.setItemPrice(priceWithTax(li.getLineItemPrice(), li.getTaxRate()));
            ss.setItemPriceCur(priceWithTax(li.getLineItemPrice(), li.getTaxRate()));
            ss.setItemPriceNoTax(li.getLineItemPrice());
            ss.setQuantity(li.getQuantityDespatched());
            ss.setTotalPrice(li.getLineItemAmount());
            ss.setTotalPriceCur(li.getLineItemAmount());
            ss.setTotalPriceNoTax(li.getLineItemAmountWithoutCharges());
            ss.setBarcode(li.getLineItemID());
            specs.add(ss);

            sst.setDocId(docId);
            sst.setDocType(docType);
            sst.setSpecItem(li.getLineItemNumber());
            sst.setTaxId(taxId);
            sst.setTaxRate(li.getTaxRate());
            sst.setTaxSum(li.getLineItemAmountCharges());
            specsTax.add(sst);

            ssb.setDocId(docId);
            ssb.setDocType(docType);
            ssb.setSpecItem(li.getLineItemNumber());
            ssb.setExtracharge(EXTRACHARGE);
            ssb.setManufacturersPrice(li.getLineItemPrice());
            specsBy.add(ssb);
        }
    }

    @Override
    public void setWayBillsIn(BLRWBL b) {
        swb.setId(docId);
        swb.setDocType(docType);
        swb.setGoodsOwner(GGODSOWNER);
        swb.setPayCash(PAYCASH);
        swb.setSupplierDoc(b.getDeliveryNote().getDeliveryNoteID().trim());
        swb.setSupplierDocCreate(convertDate(b.getDeliveryNote().getCreationDateTime()));
    }

    @Override
    public void setSMWI() {
        wi.setSmDocumentWI(sd);
        wi.setSmCommonBasesWI(scb);
        wi.setSmWayBillsIn(swb);
        wi.setSmDocProps(listProps);
        wi.setSmDocBlobFiles(sbf);
        wi.setSpecs(specs);
        wi.setSmSpecsTax(specsTax);
        wi.setSmSpecsBy(specsBy);
    }

    BigDecimal priceWithTax(BigDecimal p, BigDecimal n) {
        return p.multiply(new BigDecimal(1).add(n.divide(new BigDecimal(100))));
    }

    public PostPackageWI getPostPackage() {
        return pp;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    String convertDate(String dateProvider) {
        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyyMMddhhmmss").parse(dateProvider);
        } catch (ParseException e) {

        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ") {
            public StringBuffer format(Date date, StringBuffer toAppendTo, java.text.FieldPosition pos) {
                StringBuffer toFix = super.format(date, toAppendTo, pos);
                toFix.insert(toFix.length() - 5, '.');
                toFix.insert(toFix.length() - 5, '0');
                toFix.insert(toFix.length() - 5, '0');
                toFix.insert(toFix.length() - 5, '0');
                toFix.insert(toFix.length() - 2, ':');
                return toFix;
            }
        };
        return dateFormat.format(date);
    }
    /*String convertDate(String dateDelivery){
        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyyMMddhhmmss").parse(dateDelivery);
        } catch (ParseException e) {

        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ") {
            public StringBuffer format(Date date, StringBuffer toAppendTo, java.text.FieldPosition pos) {
                StringBuffer toFix = super.format(date, toAppendTo, pos);
                toFix.insert(toFix.length() - 5, '.');
                toFix.insert(toFix.length() - 5, '0');
                toFix.insert(toFix.length() - 5, '0');
                toFix.insert(toFix.length() - 5, '0');
                toFix.insert(toFix.length() - 2, ':');
                return toFix;
            }
        };
        return dateFormat.format(date);
    }*/
}
