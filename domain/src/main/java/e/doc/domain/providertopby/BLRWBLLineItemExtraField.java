package e.doc.domain.providertopby;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BLRWBLLineItemExtraField implements ProviderDomain {
    @JsonProperty("FieldName")
    String fieldName;
    @JsonProperty("FieldCode")
    String fieldCode;
    @JsonProperty("FieldValue")
    String fieldValue;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
