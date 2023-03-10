package e.doc.domain.providertopby;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BLRWBLExtraField implements ProviderDomain {
    @JsonProperty("FieldName")
    String fieldName;
    @JsonProperty("FieldCode")
    String fieldCode;
    @JsonProperty("FieldValue")
    String fieldValue;
}
