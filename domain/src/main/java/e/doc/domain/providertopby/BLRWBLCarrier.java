package e.doc.domain.providertopby;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BLRWBLCarrier implements ProviderDomain {
    @JsonProperty("TransportContact")
    String transportContact;
    @JsonProperty("DeliveryContact")
    String deliveryContact;
    @JsonProperty("ProxyID")
    String proxyID;
    @JsonProperty("ProxyDate")
    String proxyDate;
    @JsonProperty("PartyIssuingProxyName")
    String partyIssuingProxyName;
}
