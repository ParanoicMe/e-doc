package e.doc.domain.sm.wo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SMDocument implements SupermagDomain {
    @JsonProperty("ID")
    String id;
    @JsonProperty("DOCTYPE")
    String docType;
    @JsonProperty("BORNIN")
    String bornin;
    @JsonProperty("CLIENTINDEX")
    String clientIndex;
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
    @JsonProperty("LOCATIONFROM")
    String locationFrom;
    @JsonProperty("OPCODE")
    String opCode;
    @JsonProperty("PRICEROUNDMODE")
    String priceRoundMode;
    @JsonProperty("TOTALSUM")
    Float totalSum;
    @JsonProperty("TOTALSUMCUR")
    Float totalSumCur;
    @JsonProperty("CLIENTGLN")
    String clientGLN;
    @JsonProperty("STGLN")
    String stGLN;
    @JsonProperty("CURRENCYCODEISO")
    String currencyCode;

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

    public String getLocationFrom() {
        return locationFrom;
    }

    public void setLocationFrom(String locationFrom) {
        this.locationFrom = locationFrom;
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

    public String getClientGLN() {
        return clientGLN;
    }

    public void setClientGLN(String clientGLN) {
        this.clientGLN = clientGLN;
    }

    public String getStGLN() {
        return stGLN;
    }

    public void setStGLN(String stGLN) {
        this.stGLN = stGLN;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
