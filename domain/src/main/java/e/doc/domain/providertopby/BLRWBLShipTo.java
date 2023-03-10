package e.doc.domain.providertopby;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BLRWBLShipTo implements ProviderDomain {
    @JsonProperty("GLN")
    String gln;
    @JsonProperty("Address")
    String address;

    public String getGln() {
        return gln;
    }

    public void setGln(String gln) {
        this.gln = gln;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
