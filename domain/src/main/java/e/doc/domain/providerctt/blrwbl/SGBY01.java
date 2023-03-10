package e.doc.domain.providerctt.blrwbl;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SGBY01 {
    @JsonProperty("SertificateType")
    protected String sertificateType;
    @JsonProperty("SertificateID")
    protected String sertificateID;
    @JsonProperty("BeginSertifDate")
    protected String beginSertifDate;
    @JsonProperty("EndSertifDate")
    protected String endSertifDate;
    @JsonProperty("SertifPartyNumber")
    protected String sertifPartyNumber;
    @JsonProperty("SertifProductDate")
    protected String sertifProductDate;
    @JsonProperty("Name")
    protected String name;


    /**
     * Gets the value of the sertificateType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSertificateType() {
        return sertificateType;
    }

    /**
     * Sets the value of the sertificateType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSertificateType(String value) {
        this.sertificateType = value;
    }

    /**
     * Gets the value of the sertificateID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSertificateID() {
        return sertificateID;
    }

    /**
     * Sets the value of the sertificateID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSertificateID(String value) {
        this.sertificateID = value;
    }

    /**
     * Gets the value of the beginSertifDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBeginSertifDate() {
        return beginSertifDate;
    }

    /**
     * Sets the value of the beginSertifDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBeginSertifDate(String value) {
        this.beginSertifDate = value;
    }

    /**
     * Gets the value of the endSertifDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEndSertifDate() {
        return endSertifDate;
    }

    /**
     * Sets the value of the endSertifDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEndSertifDate(String value) {
        this.endSertifDate = value;
    }

    /**
     * Gets the value of the sertifPartyNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSertifPartyNumber() {
        return sertifPartyNumber;
    }

    /**
     * Sets the value of the sertifPartyNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSertifPartyNumber(String value) {
        this.sertifPartyNumber = value;
    }

    /**
     * Gets the value of the sertifProductDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSertifProductDate() {
        return sertifProductDate;
    }

    /**
     * Sets the value of the sertifProductDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSertifProductDate(String value) {
        this.sertifProductDate = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }
}
