package e.doc.domain.providerctt.blrwbl;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Carrier {
    @JsonProperty("TransportContact")
    protected String transportContact;
    @JsonProperty("DeliveryContact")
    protected String deliveryContact;
    @JsonProperty("ProxyID")
    protected String proxyID;
    @JsonProperty("ProxyDate")
    protected String proxyDate;
    @JsonProperty("PartyIssuingProxyName")
    protected String partyIssuingProxyName;

    /**
     * Gets the value of the transportContact property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransportContact() {
        return transportContact;
    }

    /**
     * Sets the value of the transportContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransportContact(String value) {
        this.transportContact = value;
    }

    /**
     * Gets the value of the deliveryContact property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryContact() {
        return deliveryContact;
    }

    /**
     * Sets the value of the deliveryContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryContact(String value) {
        this.deliveryContact = value;
    }

    /**
     * Gets the value of the proxyID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProxyID() {
        return proxyID;
    }

    /**
     * Sets the value of the proxyID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProxyID(String value) {
        this.proxyID = value;
    }

    /**
     * Gets the value of the proxyDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProxyDate() {
        return proxyDate;
    }

    /**
     * Sets the value of the proxyDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProxyDate(String value) {
        this.proxyDate = value;
    }

    /**
     * Gets the value of the partyIssuingProxyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartyIssuingProxyName() {
        return partyIssuingProxyName;
    }

    /**
     * Sets the value of the partyIssuingProxyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartyIssuingProxyName(String value) {
        this.partyIssuingProxyName = value;
    }

}
