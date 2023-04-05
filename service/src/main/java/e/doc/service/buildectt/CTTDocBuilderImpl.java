package e.doc.service.buildectt;

import e.doc.domain.providerctt.blrwbl.*;
import e.doc.domain.sm.wi.SMSpecTax;
import e.doc.domain.sm.wo.SMSpecTaxWO;
import e.doc.domain.sm.wo.SMSpecWO;
import e.doc.domain.sm.wo.SMWO;
import e.doc.domain.smoracle.ClientInfo;
import e.doc.domain.smoracle.SMCardProperties;
import e.doc.domain.smoracle.hlp.LableWOHlp;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CTTDocBuilderImpl implements CTTDocBuilder {

    private final String MESSAGETYPE = "BLRWBL";
    private final String DELIVERYNOTETYPE = "700";
    private final String CONTRACTNAME = "Договор";
    private final String COUNTRY = "BY";
    private final String CURRENCY = "BYN";
    private final String PROD = "PROD";
    BLRWBL blrwbl;
    private MessageHeader messageHeader;
    private DeliveryNote deliveryNote;
    private Shipper shipper;
    private SecurityShipper securityShipper;
    private Receiver receiver;
    private FreightPayer freightPayer;
    private ShipFrom shipFrom;
    private ShipTo shipTo;
    private Carrier carrier;
    private Total total;
    private List<LineItem> lineItems;

    private String version = "1.0";

    public CTTDocBuilderImpl() {

    }

    @Override
    public void reset() {
        blrwbl = new BLRWBL();
        messageHeader = new MessageHeader();
        deliveryNote = new DeliveryNote();
        shipper = new Shipper();
        receiver = new Receiver();
        freightPayer = new FreightPayer();
        shipFrom = new ShipFrom();
        shipTo = new ShipTo();
        carrier = new Carrier();
        lineItems = new ArrayList<>();
        total = new Total();
        securityShipper = null;
    }

    @Override
    public void setMessageHeader(String orgId, String receiverId, String docNum) {
        messageHeader.setMessageID(docNum);
        messageHeader.setMsgDateTime(getDateTime());
        //System.out.println(getDateTime());
        messageHeader.setMessageType(MESSAGETYPE);
        messageHeader.setMsgSenderID(orgId);
        messageHeader.setMsgReceiverID(receiverId);
        messageHeader.setTestIndicator("1");
        blrwbl.setMessageHeader(messageHeader);
        //messageHeader.setUserID("");
    }

    public void setDeliveryNote(String funcCode, String contractId, String contractDate, String transportId, String documentId) {
        deliveryNote.setDeliveryNoteType(DELIVERYNOTETYPE);
        deliveryNote.setDocumentID(documentId);
        deliveryNote.setCreationDateTime(getDateTime());
        deliveryNote.setFunctionCode(funcCode);
        deliveryNote.setDeliveryNoteID(documentId);
        deliveryNote.setDeliveryNoteDate(getDate());
        deliveryNote.setContractName(CONTRACTNAME);
        deliveryNote.setContractID(contractId);
        deliveryNote.setContractDate(contractDate);
        deliveryNote.setTransportID(transportId);
        deliveryNote.setCurrency(CURRENCY);

        blrwbl.setDeliveryNote(deliveryNote);
    }

    @Override
    public void setShipper(ClientInfo ci, String contact) {
        shipper.setGLN(ci.getGln());
        shipper.setCountry(COUNTRY);
        shipper.setName(ci.getName());
        shipper.setAddress(ci.getAddress());
        shipper.setContact(contact);
        shipper.setVatRegNumber(ci.getInn());
        deliveryNote.setShipper(shipper);
    }

    @Override
    public void setReceiver(ClientInfo ci) {
        receiver.setGLN(ci.getGln());
        receiver.setAddress(ci.getAddress());
        receiver.setName(ci.getName());
        receiver.setVatRegNumber(ci.getInn());
        deliveryNote.setReceiver(receiver);
    }

    @Override
    public void setFreightPayer(ClientInfo ci) {
        freightPayer.setGLN(ci.getGln());
        freightPayer.setAddress(ci.getAddress());
        freightPayer.setName(ci.getName());
        freightPayer.setVatRegNumber(ci.getInn());
        deliveryNote.setFreightPayer(freightPayer);
    }

    @Override
    public void setShipFrom(ClientInfo ci, String contact) {
        shipFrom.setGLN(ci.getGln());
        shipFrom.setAddress(ci.getAddress());
        shipFrom.setContact(contact);
        deliveryNote.setShipFrom(shipFrom);
    }

    @Override
    public void setShipTo(ClientInfo ci) {
        shipTo.setGLN(ci.getGln());
        shipTo.setAddress(ci.getAddress());
        deliveryNote.setShipTo(shipTo);
    }

    @Override
    public void setCarrier(LableWOHlp lableWOHlp) {
        carrier.setTransportContact(lableWOHlp.getDriver());
        carrier.setDeliveryContact(lableWOHlp.getDriver());
        carrier.setProxyID(lableWOHlp.getDover());
        carrier.setPartyIssuingProxyName(lableWOHlp.getDoverPut());
        deliveryNote.setCarrier(carrier);
    }

    @Override
    public void setLineItems(SMWO smwo, List<SMCardProperties> cps) {
        lineItems = new ArrayList<>();
        LineItem li = null;
        for (SMSpecWO smSpecWO : smwo.getSpecs()) {
            for (SMCardProperties cp : cps) {
                if (cp.getArticle() == smSpecWO.getArticle()) {
                    li.setGrossWeightValue(new BigDecimal(cp.getPropVal()));
                    total.setTotalGrossWeight(total.getTotalGrossWeight().add(li.getGrossWeightValue()));
                }
            }
            li = new LineItem();
            li.setLineItemNumber(smSpecWO.getSpecItem());
            li.setLineItemSign(PROD);
            li.setLineItemID(smSpecWO.getBarcode());
            li.setLineItemName(smSpecWO.getName());
            li.setQuantityDespatched(smSpecWO.getQuantity());
            li.setLineItemQuantityUOM(smSpecWO.getMeasureCode());
            li.setLineItemAmountWithoutCharges(smSpecWO.getTotalPriceNoTax());
            li.setLineItemAmount(smSpecWO.getTotalPrice());
            li.setLineItemPrice(smSpecWO.getItemPriceNoTax());
            li.setGrossWeightValue(new BigDecimal("0.0001"));

            total.setTotalAmountWithoutCharges(
                    total.getTotalAmountWithoutCharges() == null ?
                            new BigDecimal(0).add(li.getLineItemAmountWithoutCharges()) :
                            total.getTotalAmountWithoutCharges().add(li.getLineItemAmountWithoutCharges()));

            total.setTotalAmount(
                    total.getTotalAmount() == null ?
                            new BigDecimal(0).add(li.getLineItemAmount()) :
                            total.getTotalAmount().add(li.getLineItemAmount()));
            total.setTotalLineItemQuantity(
                    total.getTotalLineItemQuantity() == null ?
                            new BigDecimal(0).add(li.getQuantityDespatched()) :
                            total.getTotalLineItemQuantity().add(li.getQuantityDespatched()));
            total.setTotalGrossWeight(
                    total.getTotalGrossWeight() == null ?
                            new BigDecimal(0).add(li.getGrossWeightValue()) :
                            total.getTotalGrossWeight().add(li.getGrossWeightValue()));
            lineItems.add(li);

        }
        for (SMSpecTaxWO smSpecTax : smwo.getSmSpecsTax()) {
            for (LineItem l : lineItems) {
                if (l.getLineItemNumber().equals(smSpecTax.getSpecItem())) {
                    l.setTaxRate(smSpecTax.getTaxRate());
                    l.setLineItemAmountCharges(smSpecTax.getTaxSum());
                    total.setTotalAmountCharges(
                            total.getTotalAmountCharges() == null ?
                                    new BigDecimal(0).add(l.getLineItemAmountCharges()) :
                                    total.getTotalAmountCharges().add(l.getLineItemAmountCharges()));
                }
            }
        }
        deliveryNote.setLineItem(lineItems);
    }

    @Override
    public void setTotal() {
        total.setTotalLineItem(Long.valueOf(lineItems.size()));
        total.setTotalDespatchUnitQuantity(new BigDecimal(0));
        total.setTotalAmountExcise(new BigDecimal(0));
        deliveryNote.setTotal(total);
    }

    @Override
    public void setExtraField() {
        ExtraField extraField = new ExtraField();
        extraField.setFieldName("Возвратная накладная");
        extraField.setFieldCode("PW0013");
        extraField.setFieldValue("1");
        System.out.println("setExtraField");
        deliveryNote.setExtraField(extraField);
    }

    public BLRWBL getBlrwbl() {
        return blrwbl;
    }

    BigDecimal priceWithTax(BigDecimal p, BigDecimal n) {
        return p.multiply(new BigDecimal(1).add(n.divide(new BigDecimal(100))));
    }

    String getDateTime() {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        return date;
    }

    String getDate() {
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        return date;
    }
}
