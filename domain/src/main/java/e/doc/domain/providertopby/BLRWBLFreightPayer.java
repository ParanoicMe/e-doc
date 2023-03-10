package e.doc.domain.providertopby;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BLRWBLFreightPayer implements ProviderDomain {
    @JsonProperty("GLN")
    String gln;
    @JsonProperty("Name")
    String name;
    @JsonProperty("Address")
    String address;
    @JsonProperty("VATRegistrationNumber")
    String vatRegistrationNumber;
}
