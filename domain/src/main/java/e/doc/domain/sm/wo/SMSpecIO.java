package e.doc.domain.sm.wo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class SMSpecIO implements SupermagDomain {
    @JsonProperty("DOCID")
    String docId;
    @JsonProperty("DOCTYPE")
    String docType;
    @JsonProperty("SPECITEM")
    String specItem;
    @JsonProperty("NPOS")
    String nPos;

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getSpecItem() {
        return specItem;
    }

    public void setSpecItem(String specItem) {
        this.specItem = specItem;
    }

    public String getnPos() {
        return nPos;
    }

    public void setnPos(String nPos) {
        this.nPos = nPos;
    }
}
