package e.doc.domain.providerctt.blrwbl;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecurityShipper {
    @JsonProperty("SecurityID")
    protected String securityID;
    @JsonProperty("CertificateID")
    protected String certificateID;
    @JsonProperty("SecurityPartyID")
    protected String securityPartyID;
    @JsonProperty("CreationSignatureDate")
    protected String creationSignatureDate;
    @JsonProperty("CreationSignatureTime")
    protected String creationSignatureTime;
    @JsonProperty("SignatureValue")
    protected String signatureValue;
    @JsonProperty("DVCS")
    protected DVCS dvcs;

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

    /**
     * Gets the value of the certificateID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCertificateID() {
        return certificateID;
    }

    /**
     * Sets the value of the certificateID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCertificateID(String value) {
        this.certificateID = value;
    }

    /**
     * Gets the value of the securityPartyID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSecurityPartyID() {
        return securityPartyID;
    }

    /**
     * Sets the value of the securityPartyID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSecurityPartyID(String value) {
        this.securityPartyID = value;
    }

    /**
     * Gets the value of the creationSignatureDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCreationSignatureDate() {
        return creationSignatureDate;
    }

    /**
     * Sets the value of the creationSignatureDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCreationSignatureDate(String value) {
        this.creationSignatureDate = value;
    }

    /**
     * Gets the value of the creationSignatureTime property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCreationSignatureTime() {
        return creationSignatureTime;
    }

    /**
     * Sets the value of the creationSignatureTime property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCreationSignatureTime(String value) {
        this.creationSignatureTime = value;
    }

    /**
     * Gets the value of the signatureValue property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSignatureValue() {
        return signatureValue;
    }

    /**
     * Sets the value of the signatureValue property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSignatureValue(String value) {
        this.signatureValue = value;
    }

    /**
     * Gets the value of the dvcs property.
     *
     * @return possible object is
     * {@link DVCS }
     */
    public DVCS getDVCS() {
        return dvcs;
    }

    /**
     * Sets the value of the dvcs property.
     *
     * @param value allowed object is
     *              {@link DVCS }
     */
    public void setDVCS(DVCS value) {
        this.dvcs = value;
    }
}
