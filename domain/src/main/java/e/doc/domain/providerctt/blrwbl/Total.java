package e.doc.domain.providerctt.blrwbl;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Total {
    @JsonProperty("TotalAmountWithoutCharges")
    protected Float totalAmountWithoutCharges;
    @JsonProperty("TotalAmountCharges")
    protected Float totalAmountCharges;
    @JsonProperty("TotalAmount")
    protected Float totalAmount;
    @JsonProperty("TotalLineItem")
    protected Long totalLineItem;
    @JsonProperty("TotalLineItemQuantity")
    protected Float totalLineItemQuantity;
    @JsonProperty("TotalGrossWeight")
    protected Float totalGrossWeight;
    @JsonProperty("TotalDespatchUnitQuantity")
    protected Float totalDespatchUnitQuantity;
    @JsonProperty("TotalAmountExcise")
    protected Float totalAmountExcise;

    /**
     * Gets the value of the totalAmountWithoutCharges property.
     *
     * @return possible object is
     * {@link Float }
     */
    public Float getTotalAmountWithoutCharges() {
        return totalAmountWithoutCharges;
    }

    /**
     * Sets the value of the totalAmountWithoutCharges property.
     *
     * @param value allowed object is
     *              {@link Float }
     */
    public void setTotalAmountWithoutCharges(Float value) {
        this.totalAmountWithoutCharges = value;
    }

    /**
     * Gets the value of the totalAmountCharges property.
     *
     * @return possible object is
     * {@link Float }
     */
    public Float getTotalAmountCharges() {
        return totalAmountCharges;
    }

    /**
     * Sets the value of the totalAmountCharges property.
     *
     * @param value allowed object is
     *              {@link Float }
     */
    public void setTotalAmountCharges(Float value) {
        this.totalAmountCharges = value;
    }

    /**
     * Gets the value of the totalAmount property.
     *
     * @return possible object is
     * {@link Float }
     */
    public Float getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the value of the totalAmount property.
     *
     * @param value allowed object is
     *              {@link Float }
     */
    public void setTotalAmount(Float value) {
        this.totalAmount = value;
    }

    /**
     * Gets the value of the totalLineItem property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getTotalLineItem() {
        return totalLineItem;
    }

    /**
     * Sets the value of the totalLineItem property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setTotalLineItem(Long value) {
        this.totalLineItem = value;
    }

    /**
     * Gets the value of the totalLineItemQuantity property.
     *
     * @return possible object is
     * {@link Float }
     */
    public Float getTotalLineItemQuantity() {
        return totalLineItemQuantity;
    }

    /**
     * Sets the value of the totalLineItemQuantity property.
     *
     * @param value allowed object is
     *              {@link Float }
     */
    public void setTotalLineItemQuantity(Float value) {
        this.totalLineItemQuantity = value;
    }

    /**
     * Gets the value of the totalGrossWeight property.
     *
     * @return possible object is
     * {@link Float }
     */
    public Float getTotalGrossWeight() {
        return totalGrossWeight;
    }

    /**
     * Sets the value of the totalGrossWeight property.
     *
     * @param value allowed object is
     *              {@link Float }
     */
    public void setTotalGrossWeight(Float value) {
        this.totalGrossWeight = value;
    }

    /**
     * Gets the value of the totalDespatchUnitQuantity property.
     *
     * @return possible object is
     * {@link Float }
     */
    public Float getTotalDespatchUnitQuantity() {
        return totalDespatchUnitQuantity;
    }

    /**
     * Sets the value of the totalDespatchUnitQuantity property.
     *
     * @param value allowed object is
     *              {@link Float }
     */
    public void setTotalDespatchUnitQuantity(Float value) {
        this.totalDespatchUnitQuantity = value;
    }

    /**
     * Gets the value of the totalAmountExcise property.
     *
     * @return possible object is
     * {@link Float }
     */
    public Float getTotalAmountExcise() {
        return totalAmountExcise;
    }

    /**
     * Sets the value of the totalAmountExcise property.
     *
     * @param value allowed object is
     *              {@link Float }
     */
    public void setTotalAmountExcise(Float value) {
        this.totalAmountExcise = value;
    }
}
