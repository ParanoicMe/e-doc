package e.doc.domain.providerctt.blrwbl;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SignatureInfo {
    @JsonProperty("SignatureDateTime")
    protected String signatureDateTime;
    @JsonProperty("UserName")
    protected String userName;
    @JsonProperty("PartyCode")
    protected String partyCode;

    /**
     * Gets the value of the signatureDateTime property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSignatureDateTime() {
        return signatureDateTime;
    }

    /**
     * Sets the value of the signatureDateTime property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSignatureDateTime(String value) {
        this.signatureDateTime = value;
    }

    /**
     * Gets the value of the userName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the partyCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPartyCode() {
        return partyCode;
    }

    /**
     * Sets the value of the partyCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPartyCode(String value) {
        this.partyCode = value;
    }

}
