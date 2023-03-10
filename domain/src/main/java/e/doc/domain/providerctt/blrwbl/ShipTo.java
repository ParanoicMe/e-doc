package e.doc.domain.providerctt.blrwbl;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShipTo {

    @JsonProperty("GLN")
    protected String gln;
    @JsonProperty("Address")
    protected String address;

    /**
     * Gets the value of the gln property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGLN() {
        return gln;
    }

    /**
     * Sets the value of the gln property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGLN(String value) {
        this.gln = value;
    }

    /**
     * Gets the value of the address property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAddress(String value) {
        this.address = value;
    }

}
