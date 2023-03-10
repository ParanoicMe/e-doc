package e.doc.domain.sm.wo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SMWayBillsOut implements SupermagDomain {
    @JsonProperty("ID")
    String id;
    @JsonProperty("DOCTYPE")
    String docType;
    @JsonProperty("INVOICE")
    String invoice;
    @JsonProperty("OURSELFCLIENT")
    String selfClient;
    @JsonProperty("PAYCASH")
    String payCash;
    @JsonProperty("OURSELFCLIENTGLN")
    String clientGln;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getSelfClient() {
        return selfClient;
    }

    public void setSelfClient(String selfClient) {
        this.selfClient = selfClient;
    }

    public String getPayCash() {
        return payCash;
    }

    public void setPayCash(String payCash) {
        this.payCash = payCash;
    }

    public String getClientGln() {
        return clientGln;
    }

    public void setClientGln(String clientGln) {
        this.clientGln = clientGln;
    }
}
