package e.doc.domain.providerctt.blrwbl;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Document {
    @JsonProperty("DocumentID")
    protected String documentID;
    @JsonProperty("DocumentDate")
    protected String documentDate;
    @JsonProperty("DocumentName")
    protected String documentName;

    /**
     * Gets the value of the documentID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDocumentID() {
        return documentID;
    }

    /**
     * Sets the value of the documentID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDocumentID(String value) {
        this.documentID = value;
    }

    /**
     * Gets the value of the documentDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDocumentDate() {
        return documentDate;
    }

    /**
     * Sets the value of the documentDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDocumentDate(String value) {
        this.documentDate = value;
    }

    /**
     * Gets the value of the documentName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDocumentName() {
        return documentName;
    }

    /**
     * Sets the value of the documentName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDocumentName(String value) {
        this.documentName = value;
    }
}
