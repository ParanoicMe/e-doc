package e.doc.service.buildectt;

import e.doc.domain.providerctt.blrwbl.BLRWBL;
import e.doc.domain.sm.wo.SMWO;
import e.doc.domain.smoracle.ClientInfo;
import e.doc.domain.smoracle.SMCardProperties;
import e.doc.domain.smoracle.hlp.LableWOHlp;

import java.util.List;

public interface CTTDocBuilder {

    void reset();

    void setMessageHeader(String orgId, String receiverId, String docNum);

    void setDeliveryNote(String funcCode, String contractId, String contractDate, String transportId, String documentId);

    void setShipper(ClientInfo ci, String contact);

    void setReceiver(ClientInfo ci);

    void setFreightPayer(ClientInfo ci);

    void setShipFrom(ClientInfo ci, String contact);

    void setShipTo(ClientInfo ci);

    void setCarrier(LableWOHlp lableWOHlp);

    void setLineItems(SMWO smwo, List<SMCardProperties> cp);

    BLRWBL getBlrwbl();

    void setTotal();
    void setExtraField();
}
