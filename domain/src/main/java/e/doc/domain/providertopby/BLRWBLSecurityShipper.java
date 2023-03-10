package e.doc.domain.providertopby;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BLRWBLSecurityShipper implements ProviderDomain {
    @JsonProperty("SecurityID")
    String securityID;
    @JsonProperty("CertificateID")
    String certificateID;
    @JsonProperty("SecurityPartyID")
    String securityPartyID;
    @JsonProperty("CreationSignatureDate")
    String creationSignatureDate;
    @JsonProperty("CreationSignatureTime")
    String creationSignatureTime;
    @JsonProperty("SignatureValue")
    String signatureValue;
}
