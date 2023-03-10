package e.doc.domain.providertopby;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BLRWBLDocument implements ProviderDomain {
    @JsonProperty("DocumentID")
    String documentID;
    @JsonProperty("DocumentDate")
    String documentDate;
    @JsonProperty("DocumentName")
    String documentName;
}
