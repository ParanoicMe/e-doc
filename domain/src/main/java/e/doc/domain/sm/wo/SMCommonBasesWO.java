package e.doc.domain.sm.wo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SMCommonBasesWO implements SupermagDomain {
    @JsonProperty("ID")
    String id;
    @JsonProperty("DOCTYPE")
    String docType;
    @JsonProperty("BASEDOCTYPE")
    String baseDocType;
    @JsonProperty("BASEID")
    String baseId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getBaseDocType() {
        return baseDocType;
    }

    public void setBaseDocType(String baseDocType) {
        this.baseDocType = baseDocType;
    }

    public String getBaseId() {
        return baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }
}
