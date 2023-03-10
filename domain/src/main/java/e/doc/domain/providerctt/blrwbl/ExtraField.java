package e.doc.domain.providerctt.blrwbl;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExtraField {
    @JsonProperty("FieldName")
    protected String fieldName;
    @JsonProperty("FieldCode")
    protected String fieldCode;
    @JsonProperty("FieldValue")
    protected String fieldValue;

    /**
     * Gets the value of the fieldName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Sets the value of the fieldName property.
     *
     * @param value
     * allowed object is
     *              {@link String }
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Gets the value of the fieldCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFieldCode() {
        return fieldCode;
    }

    /**
     * Sets the value of the fieldCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFieldCode(String value) {
        this.fieldCode = value;
    }

    /**
     * Gets the value of the fieldValue property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFieldValue() {
        return fieldValue;
    }

    /**
     * Sets the value of the fieldValue property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFieldValue(String value) {
        this.fieldValue = value;
    }
}
