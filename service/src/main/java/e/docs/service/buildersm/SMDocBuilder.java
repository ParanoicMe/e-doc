package e.docs.service.buildersm;

import e.doc.domain.providerctt.blrwbl.BLRWBL;
import e.doc.domain.providerctt.blrwbl.LineItem;
import e.doc.domain.sm.wi.PostPackageWI;

import java.util.List;

public interface SMDocBuilder {

    void reset();

    void setPostPackage(String name);

    void setPostObject(String docName, String action);

    void setCommonBases(String baseDocType, String orderId);

    void setSMDocBlobFile(String fileName, String base64);

    void setDocProps(BLRWBL b);

    void setSMDocument(BLRWBL b, String bornIn, String docState, String opCode, String priceRoundMode);

    void setSMSpec(List<LineItem> list, String taxId);

    void setWayBillsIn(BLRWBL b);

    void setSMWI();
    void setDocId(String id);
    void setDocType(String type);
    PostPackageWI getPostPackage();
}
