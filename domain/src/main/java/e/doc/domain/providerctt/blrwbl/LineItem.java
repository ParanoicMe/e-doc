package e.doc.domain.providerctt.blrwbl;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LineItem {

    @JsonProperty("LineItemNumber")
    protected String lineItemNumber;
    @JsonProperty("LineItemSign")
    protected String lineItemSign;
    @JsonProperty("LineItemItemIdentification")
    protected String lineItemItemIdentification;
    @JsonProperty("LineItemID")
    protected String lineItemID;
    @JsonProperty("LineItemBuyerID")
    protected String lineItemBuyerID;
    @JsonProperty("ItemCustomCode")
    protected String itemCustomCode;
    @JsonProperty("DeliveryTypePrev")
    protected String deliveryTypePrev;
    @JsonProperty("DeliveryNotePrev")
    protected String deliveryNotePrev;
    @JsonProperty("DeliveryNoteDatePrev")
    protected String deliveryNoteDatePrev;
    @JsonProperty("DeliveryNotePrevLineID")
    protected String deliveryNotePrevLineID;
    @JsonProperty("LineItemSupplierID")
    protected String lineItemSupplierID;
    @JsonProperty("LineItemName")
    protected String lineItemName;
    @JsonProperty("GrossWeightValue")
    protected BigDecimal grossWeightValue;
    @JsonProperty("QuantityDespatched")
    protected BigDecimal quantityDespatched;
    @JsonProperty("LineItemQuantityUOM")
    protected String lineItemQuantityUOM;
    @JsonProperty("DespatchUnitQuantityDespatched")
    protected BigDecimal despatchUnitQuantityDespatched;
    @JsonProperty("CountryOfOrigin")
    protected String countryOfOrigin;
    @JsonProperty("BestBeforeDate")
    protected String bestBeforeDate;
    @JsonProperty("QuantityDespatchedSPT")
    protected BigDecimal quantityDespatchedSPT;
    @JsonProperty("LineItemQuantitySPT")
    protected String lineItemQuantitySPT;
    @JsonProperty("TaxRate")
    protected BigDecimal taxRate;
    @JsonProperty("AdditionalInformation")
    protected String additionalInformation;
    @JsonProperty("LineItemPartyNumber")
    protected String lineItemPartyNumber;
    @JsonProperty("LineItemProductDate")
    protected String lineItemProductDate;
    @JsonProperty("LineItemAmountWithoutCharges")
    protected BigDecimal lineItemAmountWithoutCharges;
    @JsonProperty("LineItemAmountCharges")
    protected BigDecimal lineItemAmountCharges;
    @JsonProperty("LineItemAmount")
    protected BigDecimal lineItemAmount;
    @JsonProperty("LineItemPrice")
    protected BigDecimal lineItemPrice;
    @JsonProperty("LineItemPriceSPT")
    protected BigDecimal lineItemPriceSPT;
    @JsonProperty("LineItemManufacturerPrice")
    protected BigDecimal lineItemManufacturerPrice;
    @JsonProperty("BulkDiscountRate")
    protected BigDecimal bulkDiscountRate;
    @JsonProperty("DiscountRate")
    protected BigDecimal discountRate;
    @JsonProperty("LineItemAmountExcise")
    protected BigDecimal lineItemAmountExcise;
    @JsonProperty("SGBY01")
    protected SGBY01 sgby01;
    @JsonProperty("LineItemExtraField")
    protected LineItemExtraField lineItemExtraField;

    /**
     * Gets the value of the lineItemNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLineItemNumber() {
        return lineItemNumber;
    }

    /**
     * Sets the value of the lineItemNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLineItemNumber(String value) {
        this.lineItemNumber = value;
    }

    /**
     * Gets the value of the lineItemSign property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLineItemSign() {
        return lineItemSign;
    }

    /**
     * Sets the value of the lineItemSign property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLineItemSign(String value) {
        this.lineItemSign = value;
    }

    /**
     * Gets the value of the lineItemItemIdentification property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLineItemItemIdentification() {
        return lineItemItemIdentification;
    }

    /**
     * Sets the value of the lineItemItemIdentification property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLineItemItemIdentification(String value) {
        this.lineItemItemIdentification = value;
    }

    /**
     * Gets the value of the lineItemID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLineItemID() {
        return lineItemID;
    }

    /**
     * Sets the value of the lineItemID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLineItemID(String value) {
        this.lineItemID = value;
    }

    /**
     * Gets the value of the lineItemBuyerID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLineItemBuyerID() {
        return lineItemBuyerID;
    }

    /**
     * Sets the value of the lineItemBuyerID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLineItemBuyerID(String value) {
        this.lineItemBuyerID = value;
    }

    /**
     * Gets the value of the itemCustomCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getItemCustomCode() {
        return itemCustomCode;
    }

    /**
     * Sets the value of the itemCustomCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setItemCustomCode(String value) {
        this.itemCustomCode = value;
    }

    /**
     * Gets the value of the deliveryTypePrev property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDeliveryTypePrev() {
        return deliveryTypePrev;
    }

    /**
     * Sets the value of the deliveryTypePrev property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDeliveryTypePrev(String value) {
        this.deliveryTypePrev = value;
    }

    /**
     * Gets the value of the deliveryNotePrev property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDeliveryNotePrev() {
        return deliveryNotePrev;
    }

    /**
     * Sets the value of the deliveryNotePrev property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDeliveryNotePrev(String value) {
        this.deliveryNotePrev = value;
    }

    /**
     * Gets the value of the deliveryNoteDatePrev property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDeliveryNoteDatePrev() {
        return deliveryNoteDatePrev;
    }

    /**
     * Sets the value of the deliveryNoteDatePrev property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDeliveryNoteDatePrev(String value) {
        this.deliveryNoteDatePrev = value;
    }

    /**
     * Gets the value of the deliveryNotePrevLineID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDeliveryNotePrevLineID() {
        return deliveryNotePrevLineID;
    }

    /**
     * Sets the value of the deliveryNotePrevLineID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDeliveryNotePrevLineID(String value) {
        this.deliveryNotePrevLineID = value;
    }

    /**
     * Gets the value of the lineItemSupplierID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLineItemSupplierID() {
        return lineItemSupplierID;
    }

    /**
     * Sets the value of the lineItemSupplierID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLineItemSupplierID(String value) {
        this.lineItemSupplierID = value;
    }

    /**
     * Gets the value of the lineItemName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLineItemName() {
        return lineItemName;
    }

    /**
     * Sets the value of the lineItemName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLineItemName(String value) {
        this.lineItemName = value;
    }

    /**
     * Gets the value of the grossWeightValue property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getGrossWeightValue() {
        return grossWeightValue;
    }

    /**
     * Sets the value of the grossWeightValue property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setGrossWeightValue(BigDecimal value) {
        this.grossWeightValue = value;
    }

    /**
     * Gets the value of the quantityDespatched property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getQuantityDespatched() {
        return quantityDespatched;
    }

    /**
     * Sets the value of the quantityDespatched property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setQuantityDespatched(BigDecimal value) {
        this.quantityDespatched = value;
    }

    /**
     * Gets the value of the lineItemQuantityUOM property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLineItemQuantityUOM() {
        return lineItemQuantityUOM;
    }

    /**
     * Sets the value of the lineItemQuantityUOM property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLineItemQuantityUOM(String value) {
        this.lineItemQuantityUOM = value;
    }

    /**
     * Gets the value of the despatchUnitQuantityDespatched property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getDespatchUnitQuantityDespatched() {
        return despatchUnitQuantityDespatched;
    }

    /**
     * Sets the value of the despatchUnitQuantityDespatched property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDespatchUnitQuantityDespatched(BigDecimal value) {
        this.despatchUnitQuantityDespatched = value;
    }

    /**
     * Gets the value of the countryOfOrigin property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    /**
     * Sets the value of the countryOfOrigin property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCountryOfOrigin(String value) {
        this.countryOfOrigin = value;
    }

    /**
     * Gets the value of the bestBeforeDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBestBeforeDate() {
        return bestBeforeDate;
    }

    /**
     * Sets the value of the bestBeforeDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBestBeforeDate(String value) {
        this.bestBeforeDate = value;
    }

    /**
     * Gets the value of the quantityDespatchedSPT property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getQuantityDespatchedSPT() {
        return quantityDespatchedSPT;
    }

    /**
     * Sets the value of the quantityDespatchedSPT property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setQuantityDespatchedSPT(BigDecimal value) {
        this.quantityDespatchedSPT = value;
    }

    /**
     * Gets the value of the lineItemQuantitySPT property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLineItemQuantitySPT() {
        return lineItemQuantitySPT;
    }

    /**
     * Sets the value of the lineItemQuantitySPT property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLineItemQuantitySPT(String value) {
        this.lineItemQuantitySPT = value;
    }

    /**
     * Gets the value of the taxRate property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    /**
     * Sets the value of the taxRate property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTaxRate(BigDecimal value) {
        this.taxRate = value;
    }

    /**
     * Gets the value of the additionalInformation property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * Sets the value of the additionalInformation property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAdditionalInformation(String value) {
        this.additionalInformation = value;
    }

    /**
     * Gets the value of the lineItemPartyNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLineItemPartyNumber() {
        return lineItemPartyNumber;
    }

    /**
     * Sets the value of the lineItemPartyNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLineItemPartyNumber(String value) {
        this.lineItemPartyNumber = value;
    }

    /**
     * Gets the value of the lineItemProductDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLineItemProductDate() {
        return lineItemProductDate;
    }

    /**
     * Sets the value of the lineItemProductDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLineItemProductDate(String value) {
        this.lineItemProductDate = value;
    }

    /**
     * Gets the value of the lineItemAmountWithoutCharges property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getLineItemAmountWithoutCharges() {
        return lineItemAmountWithoutCharges;
    }

    /**
     * Sets the value of the lineItemAmountWithoutCharges property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setLineItemAmountWithoutCharges(BigDecimal value) {
        this.lineItemAmountWithoutCharges = value;
    }

    /**
     * Gets the value of the lineItemAmountCharges property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getLineItemAmountCharges() {
        return lineItemAmountCharges;
    }

    /**
     * Sets the value of the lineItemAmountCharges property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setLineItemAmountCharges(BigDecimal value) {
        this.lineItemAmountCharges = value;
    }

    /**
     * Gets the value of the lineItemAmount property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getLineItemAmount() {
        return lineItemAmount;
    }

    /**
     * Sets the value of the lineItemAmount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setLineItemAmount(BigDecimal value) {
        this.lineItemAmount = value;
    }

    /**
     * Gets the value of the lineItemPrice property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getLineItemPrice() {
        return lineItemPrice;
    }

    /**
     * Sets the value of the lineItemPrice property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setLineItemPrice(BigDecimal value) {
        this.lineItemPrice = value;
    }
    /**
     * Gets the value of the lineItemPriceSPT property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getLineItemPriceSPT() {
        return lineItemPriceSPT;
    }
    /**
     * Sets the value of the lineItemPriceSPT property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setLineItemPriceSPT(BigDecimal lineItemPriceSPT) {
        this.lineItemPriceSPT = lineItemPriceSPT;
    }

    /**
     * Gets the value of the lineItemManufacturerPrice property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getLineItemManufacturerPrice() {
        return lineItemManufacturerPrice;
    }

    /**
     * Sets the value of the lineItemManufacturerPrice property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setLineItemManufacturerPrice(BigDecimal value) {
        this.lineItemManufacturerPrice = value;
    }

    /**
     * Gets the value of the bulkDiscountRate property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getBulkDiscountRate() {
        return bulkDiscountRate;
    }

    /**
     * Sets the value of the bulkDiscountRate property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setBulkDiscountRate(BigDecimal value) {
        this.bulkDiscountRate = value;
    }

    /**
     * Gets the value of the discountRate property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    /**
     * Sets the value of the discountRate property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDiscountRate(BigDecimal value) {
        this.discountRate = value;
    }

    /**
     * Gets the value of the lineItemAmountExcise property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getLineItemAmountExcise() {
        return lineItemAmountExcise;
    }

    /**
     * Sets the value of the lineItemAmountExcise property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setLineItemAmountExcise(BigDecimal value) {
        this.lineItemAmountExcise = value;
    }

    /**
     * Gets the value of the sgby01 property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sgby01 property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSGBY01().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SGBY01 }
     */
    public SGBY01 getSGBY01() {
        return this.sgby01;
    }

    /**
     * Gets the value of the lineItemExtraField property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineItemExtraField property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineItemExtraField().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineItemExtraField }
     */
    public LineItemExtraField getLineItemExtraField() {
        return this.lineItemExtraField;
    }

}
