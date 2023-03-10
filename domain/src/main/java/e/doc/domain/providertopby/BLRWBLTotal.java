package e.doc.domain.providertopby;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BLRWBLTotal implements ProviderDomain {
    @JsonProperty("TotalAmountWithoutCharges")
    Float totalAmountWithoutCharges;
    @JsonProperty("TotalAmountCharges")
    Float totalAmountCharges;
    @JsonProperty("TotalAmount")
    Float totalAmount;
    @JsonProperty("TotalLineItem")
    Integer totalLineItem;
    @JsonProperty("TotalLineItemQuantity")
    Float totalLineItemQuantity;
    @JsonProperty("TotalGrossWeight")
    Float totalGrossWeight;
    @JsonProperty("TotalDespatchUnitQuantity")
    Float totalDespatchUnitQuantity;
    @JsonProperty("TotalAmountExcise")
    Float totalAmountExcise;

    public Float getTotalAmountWithoutCharges() {
        return totalAmountWithoutCharges;
    }

    public void setTotalAmountWithoutCharges(Float totalAmountWithoutCharges) {
        this.totalAmountWithoutCharges = totalAmountWithoutCharges;
    }

    public Float getTotalAmountCharges() {
        return totalAmountCharges;
    }

    public void setTotalAmountCharges(Float totalAmountCharges) {
        this.totalAmountCharges = totalAmountCharges;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getTotalLineItem() {
        return totalLineItem;
    }

    public void setTotalLineItem(Integer totalLineItem) {
        this.totalLineItem = totalLineItem;
    }

    public Float getTotalLineItemQuantity() {
        return totalLineItemQuantity;
    }

    public void setTotalLineItemQuantity(Float totalLineItemQuantity) {
        this.totalLineItemQuantity = totalLineItemQuantity;
    }

    public Float getTotalGrossWeight() {
        return totalGrossWeight;
    }

    public void setTotalGrossWeight(Float totalGrossWeight) {
        this.totalGrossWeight = totalGrossWeight;
    }

    public Float getTotalDespatchUnitQuantity() {
        return totalDespatchUnitQuantity;
    }

    public void setTotalDespatchUnitQuantity(Float totalDespatchUnitQuantity) {
        this.totalDespatchUnitQuantity = totalDespatchUnitQuantity;
    }

    public Float getTotalAmountExcise() {
        return totalAmountExcise;
    }

    public void setTotalAmountExcise(Float totalAmountExcise) {
        this.totalAmountExcise = totalAmountExcise;
    }
}
