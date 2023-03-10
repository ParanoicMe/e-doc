package e.doc.domain.providertopby;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BLRWBLSGBY01 implements ProviderDomain {
    @JsonProperty("SertificateType")
    String sertificateType;
    @JsonProperty("SertificateID")
    String sertificateID;
    @JsonProperty("BeginSertifDate")
    String beginSertifDate;
    @JsonProperty("EndSertifDate")
    String endSertifDate;
    @JsonProperty("Name")
    String name;
}
