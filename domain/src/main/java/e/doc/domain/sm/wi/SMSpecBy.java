package e.doc.domain.sm.wi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class SMSpecBy implements SupermagDomain {
    @JsonProperty("DOCID")
    String docId;
    @JsonProperty("DOCTYPE")
    String docType;
    @JsonProperty("SPECITEM")
    String specItem;
    @JsonProperty("DELIVERYSUM")
    String deliverySum;
    @JsonProperty("EXTRACHARGE")
    String extracharge;
    @JsonProperty("MANUFACTURERSPRICE")
    BigDecimal manufacturersPrice;
    @JsonProperty("RETAILPRICE")
    BigDecimal retailPrice;
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

    public String getDeliverySum() {
        return deliverySum;
    }

    public void setDeliverySum(String deliverySum) {
        this.deliverySum = deliverySum;
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

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getStateRegulation() {
        return stateRegulation;
    }

    public void setStateRegulation(String stateRegulation) {
        this.stateRegulation = stateRegulation;
    }
}
