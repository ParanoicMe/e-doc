package e.doc.domain.providerctt.blrwbl;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShipFrom {

    @JsonProperty("GLN")
    protected String gln;
    @JsonProperty("Address")
    protected String address;
    @JsonProperty("Contact")
    protected String contact;

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

    /**
     * Gets the value of the contact property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setContact(String value) {
        this.contact = value;
    }

}
