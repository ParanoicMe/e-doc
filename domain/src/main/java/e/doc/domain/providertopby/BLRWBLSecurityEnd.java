package e.doc.domain.providertopby;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BLRWBLSecurityEnd implements ProviderDomain {
    @JsonProperty("SecurityID")
    String securityID;
}
