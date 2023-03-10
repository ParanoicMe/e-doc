package e.doc.domain.providertopby;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class BLRWBLLineItem implements ProviderDomain {
    @JsonProperty("LineItemNumber")
    String lineItemNumber;
    @JsonProperty("LineItemID")
    String lineItemID;
    @JsonProperty("LineItemBuyerID")
    String lineItemBuyerID;
    @JsonProperty("LineItemSupplierID")
    String lineItemSupplierID;
    @JsonProperty("LineItemSign")
    String lineItemSign;
    @JsonProperty("LineItemName")
    String lineItemName;
    @JsonProperty("GrossWeightValue")
    String grossWeightValue;
    @JsonProperty("QuantityDespatched")
    BigDecimal quantityDespatched;
    @JsonProperty("LineItemQuantityUOM")
    String lineItemQuantityUOM;
    @JsonProperty("DespatchUnitQuantityDespatched")
    String despatchUnitQuantityDespatched;
    @JsonProperty("CountryOfOrigin")
    String countryOfOrigin;
    @JsonProperty("BestBeforeDate")
    String bestBeforeDate;
    @JsonProperty("TaxRate")
    BigDecimal taxRate;
    @JsonProperty("AdditionalInformation")
    String additionalInformation;
    @JsonProperty("LineItemAmountWithoutCharges")
    BigDecimal lineItemAmountWithoutCharges;
    @JsonProperty("LineItemAmountCharges")
    BigDecimal lineItemAmountCharges;
    @JsonProperty("LineItemAmount")
    BigDecimal lineItemAmount;
    @JsonProperty("LineItemPrice")
    BigDecimal lineItemPrice;
    @JsonProperty("LineItemManufacturerPrice")
    String lineItemManufacturerPrice;
    @JsonProperty("BulkDiscountRate")
    String bulkDiscountRate;
    @JsonProperty("DiscountRate")
    String discountRate;
    @JsonProperty("LineItemAmountExcise")
    String lineItemAmountExcise;
    @JsonProperty("SGBY01")
    BLRWBLSGBY01 blrwblsgby01;
    @JsonProperty("LineItemExtraField")
    BLRWBLLineItemExtraField blrwblLineItemExtraField;

    public String getLineItemNumber() {
        return lineItemNumber;
    }

    public void setLineItemNumber(String lineItemNumber) {
        this.lineItemNumber = lineItemNumber;
    }

    public String getLineItemID() {
        return lineItemID;
    }

    public void setLineItemID(String lineItemID) {
        this.lineItemID = lineItemID;
    }

    public String getLineItemBuyerID() {
        return lineItemBuyerID;
    }

    public void setLineItemBuyerID(String lineItemBuyerID) {
        this.lineItemBuyerID = lineItemBuyerID;
    }

    public String getLineItemSupplierID() {
        return lineItemSupplierID;
    }

    public void setLineItemSupplierID(String lineItemSupplierID) {
        this.lineItemSupplierID = lineItemSupplierID;
    }

    public String getLineItemSign() {
        return lineItemSign;
    }

    public void setLineItemSign(String lineItemSign) {
        this.lineItemSign = lineItemSign;
    }

    public String getLineItemName() {
        return lineItemName;
    }

    public void setLineItemName(String lineItemName) {
        this.lineItemName = lineItemName;
    }

    public String getGrossWeightValue() {
        return grossWeightValue;
    }

    public void setGrossWeightValue(String grossWeightValue) {
        this.grossWeightValue = grossWeightValue;
    }

    public BigDecimal getQuantityDespatched() {
        return quantityDespatched;
    }

    public void setQuantityDespatched(BigDecimal quantityDespatched) {
        this.quantityDespatched = quantityDespatched;
    }

    public String getLineItemQuantityUOM() {
        return lineItemQuantityUOM;
    }

    public void setLineItemQuantityUOM(String lineItemQuantityUOM) {
        this.lineItemQuantityUOM = lineItemQuantityUOM;
    }

    public String getDespatchUnitQuantityDespatched() {
        return despatchUnitQuantityDespatched;
    }

    public void setDespatchUnitQuantityDespatched(String despatchUnitQuantityDespatched) {
        this.despatchUnitQuantityDespatched = despatchUnitQuantityDespatched;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getBestBeforeDate() {
        return bestBeforeDate;
    }

    public void setBestBeforeDate(String bestBeforeDate) {
        this.bestBeforeDate = bestBeforeDate;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public BigDecimal getLineItemAmountWithoutCharges() {
        return lineItemAmountWithoutCharges;
    }

    public void setLineItemAmountWithoutCharges(BigDecimal lineItemAmountWithoutCharges) {
        this.lineItemAmountWithoutCharges = lineItemAmountWithoutCharges;
    }

    public BigDecimal getLineItemAmountCharges() {
        return lineItemAmountCharges;
    }

    public void setLineItemAmountCharges(BigDecimal lineItemAmountCharges) {
        this.lineItemAmountCharges = lineItemAmountCharges;
    }

    public BigDecimal getLineItemAmount() {
        return lineItemAmount;
    }

    public void setLineItemAmount(BigDecimal lineItemAmount) {
        this.lineItemAmount = lineItemAmount;
    }

    public BigDecimal getLineItemPrice() {
        return lineItemPrice;
    }

    public void setLineItemPrice(BigDecimal lineItemPrice) {
        this.lineItemPrice = lineItemPrice;
    }

    public String getLineItemManufacturerPrice() {
        return lineItemManufacturerPrice;
    }

    public void setLineItemManufacturerPrice(String lineItemManufacturerPrice) {
        this.lineItemManufacturerPrice = lineItemManufacturerPrice;
    }

    public String getBulkDiscountRate() {
        return bulkDiscountRate;
    }

    public void setBulkDiscountRate(String bulkDiscountRate) {
        this.bulkDiscountRate = bulkDiscountRate;
    }

    public String getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate;
    }

    public String getLineItemAmountExcise() {
        return lineItemAmountExcise;
    }

    public void setLineItemAmountExcise(String lineItemAmountExcise) {
        this.lineItemAmountExcise = lineItemAmountExcise;
    }

    public BLRWBLSGBY01 getBlrwblsgby01() {
        return blrwblsgby01;
    }

    public void setBlrwblsgby01(BLRWBLSGBY01 blrwblsgby01) {
        this.blrwblsgby01 = blrwblsgby01;
    }

    public BLRWBLLineItemExtraField getBlrwblLineItemExtraField() {
        return blrwblLineItemExtraField;
    }

    public void setBlrwblLineItemExtraField(BLRWBLLineItemExtraField blrwblLineItemExtraField) {
        this.blrwblLineItemExtraField = blrwblLineItemExtraField;
    }
}
