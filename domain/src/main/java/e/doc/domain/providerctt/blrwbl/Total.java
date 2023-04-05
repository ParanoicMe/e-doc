package e.doc.domain.providerctt.blrwbl;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Total {
    @JsonProperty("TotalAmountWithoutCharges")
    protected BigDecimal totalAmountWithoutCharges;
    @JsonProperty("TotalAmountCharges")
    protected BigDecimal totalAmountCharges;
    @JsonProperty("TotalAmount")
    protected BigDecimal totalAmount;
    @JsonProperty("TotalLineItem")
    protected Long totalLineItem;
    @JsonProperty("TotalLineItemQuantity")
    protected BigDecimal totalLineItemQuantity;
    @JsonProperty("TotalGrossWeight")
    protected BigDecimal totalGrossWeight;
    @JsonProperty("TotalDespatchUnitQuantity")
    protected BigDecimal totalDespatchUnitQuantity;
    @JsonProperty("TotalAmountExcise")
    protected BigDecimal totalAmountExcise;

    /**
     * Gets the value of the totalAmountWithoutCharges property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getTotalAmountWithoutCharges() {
        return totalAmountWithoutCharges;
    }

    /**
     * Sets the value of the totalAmountWithoutCharges property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTotalAmountWithoutCharges(BigDecimal value) {
        this.totalAmountWithoutCharges = value;
    }

    /**
     * Gets the value of the totalAmountCharges property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getTotalAmountCharges() {
        return totalAmountCharges;
    }

    /**
     * Sets the value of the totalAmountCharges property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTotalAmountCharges(BigDecimal value) {
        this.totalAmountCharges = value;
    }

    /**
     * Gets the value of the totalAmount property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the value of the totalAmount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTotalAmount(BigDecimal value) {
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
     * {@link BigDecimal }
     */
    public BigDecimal getTotalLineItemQuantity() {
        return totalLineItemQuantity;
    }

    /**
     * Sets the value of the totalLineItemQuantity property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTotalLineItemQuantity(BigDecimal value) {
        this.totalLineItemQuantity = value;
    }

    /**
     * Gets the value of the totalGrossWeight property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getTotalGrossWeight() {
        return totalGrossWeight;
    }

    /**
     * Sets the value of the totalGrossWeight property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTotalGrossWeight(BigDecimal value) {
        this.totalGrossWeight = value;
    }

    /**
     * Gets the value of the totalDespatchUnitQuantity property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getTotalDespatchUnitQuantity() {
        return totalDespatchUnitQuantity;
    }

    /**
     * Sets the value of the totalDespatchUnitQuantity property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTotalDespatchUnitQuantity(BigDecimal value) {
        this.totalDespatchUnitQuantity = value;
    }

    /**
     * Gets the value of the totalAmountExcise property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getTotalAmountExcise() {
        return totalAmountExcise;
    }

    /**
     * Sets the value of the totalAmountExcise property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTotalAmountExcise(BigDecimal value) {
        this.totalAmountExcise = value;
    }
}
