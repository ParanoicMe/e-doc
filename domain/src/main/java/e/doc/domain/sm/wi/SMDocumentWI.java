package e.doc.domain.sm.wi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SMDocumentWI implements SupermagDomain {
    @JsonProperty("ID")
    String id;
    @JsonProperty("DOCTYPE")
    String docType;
    @JsonProperty("BORNIN")
    String bornin;
    @JsonIgnoreProperties
    @JsonProperty("CLIENTINDEX")
    String clientIndex;
    @JsonIgnoreProperties
    @JsonProperty("COMMENTARY")
    String comment;
    @JsonProperty("CREATEDAT")
    String createDate;
    @JsonProperty("CURRENCYMULTORDER")
    String currencyMultOrder;
    @JsonProperty("CURRENCYRATE")
    String currencyRate;
    @JsonProperty("CURRENCYTYPE")
    String currencyType;
    @JsonProperty("DOCSTATE")
    String docState;
    @JsonProperty("ISROUBLES")
    String isRoubles;
    @JsonProperty("LOCATION")
    String location;
    @JsonProperty("LOCATIONFROM")
    String locationFrom;
    @JsonProperty("LOCATIONTO")
    String locationTo;
    @JsonProperty("OPCODE")
    String opCode;
    @JsonProperty("PRICEROUNDMODE")
    String priceRoundMode;
    @JsonProperty("TOTALSUM")
    Float totalSum;
    @JsonProperty("TOTALSUMCUR")
    Float totalSumCur;
    @JsonProperty("USEROP")
    Float userOp;
    @JsonProperty("SUPPLIERGLN")
    String supplierGln;
    @JsonProperty("DESTINATIONGLN")
    String destinationGln;
    @JsonProperty("BUYERGLN")
    String buyergln;

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

    public String getBornin() {
        return bornin;
    }

    public void setBornin(String bornin) {
        this.bornin = bornin;
    }

    public String getClientIndex() {
        return clientIndex;
    }

    public void setClientIndex(String clientIndex) {
        this.clientIndex = clientIndex;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCurrencyMultOrder() {
        return currencyMultOrder;
    }

    public void setCurrencyMultOrder(String currencyMultOrder) {
        this.currencyMultOrder = currencyMultOrder;
    }

    public String getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(String currencyRate) {
        this.currencyRate = currencyRate;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public String getDocState() {
        return docState;
    }

    public void setDocState(String docState) {
        this.docState = docState;
    }

    public String getIsRoubles() {
        return isRoubles;
    }

    public void setIsRoubles(String isRoubles) {
        this.isRoubles = isRoubles;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationFrom() {
        return locationFrom;
    }

    public void setLocationFrom(String locationFrom) {
        this.locationFrom = locationFrom;
    }

    public String getLocationTo() {
        return locationTo;
    }

    public void setLocationTo(String locationTo) {
        this.locationTo = locationTo;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }

    public String getPriceRoundMode() {
        return priceRoundMode;
    }

    public void setPriceRoundMode(String priceRoundMode) {
        this.priceRoundMode = priceRoundMode;
    }

    public Float getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Float totalSum) {
        this.totalSum = totalSum;
    }

    public Float getTotalSumCur() {
        return totalSumCur;
    }

    public void setTotalSumCur(Float totalSumCur) {
        this.totalSumCur = totalSumCur;
    }

    public Float getUserOp() {
        return userOp;
    }

    public void setUserOp(Float userOp) {
        this.userOp = userOp;
    }

    public String getSupplierGln() {
        return supplierGln;
    }

    public void setSupplierGln(String supplierGln) {
        this.supplierGln = supplierGln;
    }

    public String getDestinationGln() {
        return destinationGln;
    }

    public void setDestinationGln(String destinationGln) {
        this.destinationGln = destinationGln;
    }

    public String getBuyergln() {
        return buyergln;
    }

    public void setBuyergln(String buyergln) {
        this.buyergln = buyergln;
    }
}
