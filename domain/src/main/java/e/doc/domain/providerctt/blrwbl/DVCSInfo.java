package e.doc.domain.providerctt.blrwbl;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DVCSInfo {
    @JsonProperty("DVCSData")
    protected byte[] dvcsData;
    @JsonProperty("DVCSDateTime")
    protected String dvcsDateTime;
    @JsonProperty("DVCSCertificateID")
    protected String dvcsCertificateID;
    @JsonProperty("DVCSResult")
    protected String dvcsResult;
    @JsonProperty("DVCSResultDesc")
    protected String dvcsResultDesc;

    /**
     * Gets the value of the dvcsData property.
     *
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getDVCSData() {
        return dvcsData;
    }

    /**
     * Sets the value of the dvcsData property.
     *
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setDVCSData(byte[] value) {
        this.dvcsData = value;
    }

    /**
     * Gets the value of the dvcsDateTime property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDVCSDateTime() {
        return dvcsDateTime;
    }

    /**
     * Sets the value of the dvcsDateTime property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDVCSDateTime(String value) {
        this.dvcsDateTime = value;
    }

    /**
     * Gets the value of the dvcsCertificateID property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDVCSCertificateID() {
        return dvcsCertificateID;
    }

    /**
     * Sets the value of the dvcsCertificateID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDVCSCertificateID(String value) {
        this.dvcsCertificateID = value;
    }

    /**
     * Gets the value of the dvcsResult property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDVCSResult() {
        return dvcsResult;
    }

    /**
     * Sets the value of the dvcsResult property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDVCSResult(String value) {
        this.dvcsResult = value;
    }

    /**
     * Gets the value of the dvcsResultDesc property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDVCSResultDesc() {
        return dvcsResultDesc;
    }

    /**
     * Sets the value of the dvcsResultDesc property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDVCSResultDesc(String value) {
        this.dvcsResultDesc = value;
    }
}
