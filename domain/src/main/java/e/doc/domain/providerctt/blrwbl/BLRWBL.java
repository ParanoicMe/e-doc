package e.doc.domain.providerctt.blrwbl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(value = { "SpecialPart" })
public class BLRWBL {

    @JsonProperty("MessageHeader")
    protected MessageHeader messageHeader;
    @JsonProperty("SecurityShipper")
    protected List<SecurityShipper> securityShipper;
    @JsonProperty("DeliveryNote")
    protected DeliveryNote deliveryNote;
    @JsonProperty("SecurityEnd")
    protected List<SecurityEnd> securityEnd;
    /*@JsonProperty("SpecialPart")
    protected String specialPart;*/
    @JacksonXmlProperty(isAttribute = true)
    protected String version;

    /**
     * Gets the value of the messageHeader property.
     *
     * @return possible object is
     * {@link MessageHeader }
     */
    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    /**
     * Sets the value of the messageHeader property.
     *
     * @param value allowed object is
     *              {@link MessageHeader }
     */
    public void setMessageHeader(MessageHeader value) {
        this.messageHeader = value;
    }

    /**
     * Gets the value of the securityShipper property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the securityShipper property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSecurityShipper().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SecurityShipper }
     */
    public List<SecurityShipper> getSecurityShipper() {
        if (securityShipper == null) {
            securityShipper = new ArrayList<SecurityShipper>();
        }
        return this.securityShipper;
    }

    /**
     * Gets the value of the deliveryNote property.
     *
     * @return possible object is
     * {@link DeliveryNote }
     */
    public DeliveryNote getDeliveryNote() {
        return deliveryNote;
    }

    /**
     * Sets the value of the deliveryNote property.
     *
     * @param value allowed object is
     *              {@link DeliveryNote }
     */
    public void setDeliveryNote(DeliveryNote value) {
        this.deliveryNote = value;
    }

    /**
     * Gets the value of the securityEnd property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the securityEnd property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSecurityEnd().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SecurityEnd }
     */
    public List<SecurityEnd> getSecurityEnd() {
        if (securityEnd == null) {
            securityEnd = new ArrayList<SecurityEnd>();
        }
        return this.securityEnd;
    }

    /**
     * Gets the value of the version property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVersion() {
        if (version == null) {
            return "0.1";
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVersion(String value) {
        this.version = value;
    }

    public static class SecurityEnd {

        @JsonProperty("SecurityID")
        protected String securityID;

        /**
         * Gets the value of the securityID property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getSecurityID() {
            return securityID;
        }

        /**
         * Sets the value of the securityID property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setSecurityID(String value) {
            this.securityID = value;
        }
    }
}
