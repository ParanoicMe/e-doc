package e.docs.service.buildectt;

import e.doc.domain.providerctt.blrwbl.*;
import e.doc.domain.sm.wi.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CTTDocBuilderImpl implements CTTDocBuilder {

    private final String MESSAGETYPE = "BLRWBL";
    private final String DELIVERYNOTETYPE = "700";
    private final String CONTRACTNAME = "Договор";
    private MessageHeader messageHeader;
    private DeliveryNote deliveryNote;
    private List<SecurityShipper> securityShipper;
    private List<BLRWBL.SecurityEnd> securityEnd;
    private String version = "1.0";

    public CTTDocBuilderImpl() {
        messageHeader = new MessageHeader();
    }

    @Override
    public void reset() {
        BLRWBL blrwbl = new BLRWBL();
    }

    @Override
    public void setMessageHeader(String orgId, String receiverId) {
        //messageHeader.setMessageID("1");
        messageHeader.setMsgDateTime(getDateTime());
        messageHeader.setMessageType(MESSAGETYPE);
        messageHeader.setMsgSenderID(orgId);
        messageHeader.setMsgReceiverID(receiverId);
        //messageHeader.setTestIndicator("");
        //messageHeader.setUserID("");
    }

    public void setDeliveryNote(String funcCode, String contractId, String contractDate){
        deliveryNote.setDeliveryNoteType(DELIVERYNOTETYPE);
        deliveryNote.setCreationDateTime(getDateTime());
        deliveryNote.setFunctionCode(funcCode);
        deliveryNote.setDeliveryNoteDate(getDate());
        deliveryNote.setContractName(CONTRACTNAME);
        deliveryNote.setContractID(contractId);
        deliveryNote.setContractDate(contractDate);
    }

    @Override
    public void setSecurityShipper() {
        SecurityShipper shipper = new SecurityShipper();
        shipper.setSecurityID("");
        shipper.setCertificateID("");
        shipper.setSecurityPartyID("");
        shipper.setCreationSignatureDate("");
        shipper.setCreationSignatureTime("");
        shipper.setSignatureValue("");
        DVCS dvcs = new DVCS();
        ///dvcs.setDVCSInfo(dvcs);
        shipper.setDVCS(dvcs);
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
