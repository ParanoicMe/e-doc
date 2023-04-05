package e.doc.service.buildersm;

import e.doc.domain.providerctt.blrwbl.BLRWBL;
import e.doc.domain.providerctt.blrwbl.LineItem;
import e.doc.domain.sm.wi.PostPackageWI;

import java.util.List;

public interface SMDocBuilder {

    void reset();

    void fillPostPackage(String name);

    void fillPostObject(String docName, String action);

    void fillCommonBases(String baseDocType, String orderId);

    void fillSMDocBlobFile(String fileName, String base64);

    void fillDocProps(BLRWBL b);

    void fillSMDocument(BLRWBL b, String bornIn, String docState, String opCode, String priceRoundMode);

    void fillSMSpec(List<LineItem> list, String taxId);

    void fillWayBillsIn(BLRWBL b);

    void fillSMWI();
    void setDocId(String id);
    void setDocType(String type);
    PostPackageWI getPostPackage();
}
