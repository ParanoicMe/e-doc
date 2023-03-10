package e.doc.domain.sm.wo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class SMSpecByWO implements SupermagDomain {
    @JsonProperty("DOCID")
    String docId;
    @JsonProperty("DOCTYPE")
    String docType;
    @JsonProperty("SPECITEM")
    String specItem;
    @JsonProperty("EXTRACHARGE")
    String extracharge;
    @JsonProperty("MANUFACTURERSPRICE")
    BigDecimal manufacturersPrice;
    @JsonProperty("STATEREGULATION")
    String stateRegulation;

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

    public String getExtracharge() {
        return extracharge;
    }

    public void setExtracharge(String extracharge) {
        this.extracharge = extracharge;
    }

    public BigDecimal getManufacturersPrice() {
        return manufacturersPrice;
    }

    public void setManufacturersPrice(BigDecimal manufacturersPrice) {
        this.manufacturersPrice = manufacturersPrice;
    }

    public String getStateRegulation() {
        return stateRegulation;
    }

    public void setStateRegulation(String stateRegulation) {
        this.stateRegulation = stateRegulation;
    }
}
