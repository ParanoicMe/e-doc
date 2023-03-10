package e.doc.domain.providerctt.blrwbl;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Security {

    @JsonProperty("SecurityID")
    protected Object securityID;

    /**
     * Gets the value of the securityID property.
     *
     * @return possible object is
     * {@link Object }
     */
    public Object getSecurityID() {
        return securityID;
    }

    /**
     * Sets the value of the securityID property.
     *
     * @param value allowed object is
     *              {@link Object }
     */
    public void setSecurityID(Object value) {
        this.securityID = value;
    }

}
