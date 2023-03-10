package e.doc.domain.providertopby;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class BLRWBL implements ProviderDomain {
    @JacksonXmlProperty(isAttribute = true)
    String version;
    public BLRWBL() {
    }
    @JsonProperty("MessageHeader")
    BLRWBLMessageHeader messageHeader;
    @JsonProperty("SecurityShipper")
    BLRWBLSecurityShipper blrwblSecurityShipper;
    @JsonProperty("DeliveryNote")
    BLRWBLDeliveryNote blrwblDeliveryNote;
    @JsonProperty("SecurityEnd")
    BLRWBLSecurityEnd blrwblSecurityEnd;

    public BLRWBLMessageHeader getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(BLRWBLMessageHeader messageHeader) {
        this.messageHeader = messageHeader;
    }

    public BLRWBLSecurityShipper getBlrwblSecurityShipper() {
        return blrwblSecurityShipper;
    }

    public void setBlrwblSecurityShipper(BLRWBLSecurityShipper blrwblSecurityShipper) {
        this.blrwblSecurityShipper = blrwblSecurityShipper;
    }

    public BLRWBLDeliveryNote getBlrwblDeliveryNote() {
        return blrwblDeliveryNote;
    }

    public void setBlrwblDeliveryNote(BLRWBLDeliveryNote blrwblDeliveryNote) {
        this.blrwblDeliveryNote = blrwblDeliveryNote;
    }

    public BLRWBLSecurityEnd getBlrwblSecurityEnd() {
        return blrwblSecurityEnd;
    }

    public void setBlrwblSecurityEnd(BLRWBLSecurityEnd blrwblSecurityEnd) {
        this.blrwblSecurityEnd = blrwblSecurityEnd;
    }
}