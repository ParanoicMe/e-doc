package e.doc.domain.sm.wi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SMWayBillsIn implements SupermagDomain {
    @JsonProperty("ID")
    String id;
    @JsonProperty("DOCTYPE")
    String docType;
    @JsonProperty("DELIVERYTOTALSUM")
    String deliveryTotalSum;
    @JsonProperty("EXTRAEXPENSESCURRMULTORDER")
    String extraExpMultiOrder;
    @JsonProperty("EXTRAEXPENSESCURRRATE")
    String extraExpCurRate;
    @JsonProperty("GOODSOWNER")
    String goodsOwner;
    @JsonProperty("OURSELFCLIENT")
    String ourSelfClient;
    @JsonProperty("PAYCASH")
    String payCash;
    @JsonProperty("SUPPLDOCSUM")
    String supplierDocSum;
    @JsonProperty("SUPPLIERDOC")
    String supplierDoc;
    @JsonProperty("SUPPLIERDOCCREATE")
    String supplierDocCreate;
    @JsonProperty("SUPPLIERINVOICE")
    String supInvoice;
    @JsonProperty("SUPPLINVOICECREATE")
    String supInvoiceCreate;
    @JsonProperty("BUYERGLN")
    String buyerGln;

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

    public String getDeliveryTotalSum() {
        return deliveryTotalSum;
    }

    public void setDeliveryTotalSum(String deliveryTotalSum) {
        this.deliveryTotalSum = deliveryTotalSum;
    }

    public String getExtraExpMultiOrder() {
        return extraExpMultiOrder;
    }

    public void setExtraExpMultiOrder(String extraExpMultiOrder) {
        this.extraExpMultiOrder = extraExpMultiOrder;
    }

    public String getExtraExpCurRate() {
        return extraExpCurRate;
    }

    public void setExtraExpCurRate(String extraExpCurRate) {
        this.extraExpCurRate = extraExpCurRate;
    }

    public String getGoodsOwner() {
        return goodsOwner;
    }

    public void setGoodsOwner(String goodsOwner) {
        this.goodsOwner = goodsOwner;
    }

    public String getOurSelfClient() {
        return ourSelfClient;
    }

    public void setOurSelfClient(String ourSelfClient) {
        this.ourSelfClient = ourSelfClient;
    }

    public String getPayCash() {
        return payCash;
    }

    public void setPayCash(String payCash) {
        this.payCash = payCash;
    }

    public String getSupplierDocSum() {
        return supplierDocSum;
    }

    public void setSupplierDocSum(String supplierDocSum) {
        this.supplierDocSum = supplierDocSum;
    }

    public String getSupplierDoc() {
        return supplierDoc;
    }

    public void setSupplierDoc(String supplierDoc) {
        this.supplierDoc = supplierDoc;
    }

    public String getSupplierDocCreate() {
        return supplierDocCreate;
    }

    public void setSupplierDocCreate(String supplierDocCreate) {
        this.supplierDocCreate = supplierDocCreate;
    }

    public String getSupInvoice() {
        return supInvoice;
    }

    public void setSupInvoice(String supInvoice) {
        this.supInvoice = supInvoice;
    }

    public String getSupInvoiceCreate() {
        return supInvoiceCreate;
    }

    public void setSupInvoiceCreate(String supInvoiceCreate) {
        this.supInvoiceCreate = supInvoiceCreate;
    }

    public String getBuyerGln() {
        return buyerGln;
    }

    public void setBuyerGln(String buyerGln) {
        this.buyerGln = buyerGln;
    }
}
