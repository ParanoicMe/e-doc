package e.doc.domain.providerctt.blrwbl;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DVCS {
    @JsonProperty("DVCSInfo")
    protected DVCSInfo dvcsInfo;
    @JsonProperty("SignatureInfo")
    protected SignatureInfo signatureInfo;

    /**
     * Gets the value of the dvcsInfo property.
     *
     * @return possible object is
     * {@link DVCSInfo }
     */
    public DVCSInfo getDVCSInfo() {
        return dvcsInfo;
    }

    /**
     * Sets the value of the dvcsInfo property.
     *
     * @param value allowed object is
     *              {@link DVCSInfo }
     */
    public void setDVCSInfo(DVCSInfo value) {
        this.dvcsInfo = value;
    }

    /**
     * Gets the value of the signatureInfo property.
     *
     * @return possible object is
     * {@link SignatureInfo }
     */
    public SignatureInfo getSignatureInfo() {
        return signatureInfo;
    }

    /**
     * Sets the value of the signatureInfo property.
     *
     * @param value allowed object is
     *              {@link SignatureInfo }
     */
    public void setSignatureInfo(SignatureInfo value) {
        this.signatureInfo = value;
    }
}
