package e.doc.domain.sm.wi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class SMSpecStatWI implements SupermagDomain {
    @JsonProperty("DOCID")
    String docId;
    @JsonProperty("DOCTYPE")
    String docType;
    @JsonProperty("SPECITEM")
    String specItem;
    @JsonProperty("CASHPRICE")
    String cashPrice;
    @JsonProperty("CASHPRICEFROM")
    String cashPriceFrom;
    @JsonProperty("EVENTTIME")
    String eventTime;
    @JsonProperty("EVENTTIMEFROM")
    String eventTimeFrom;

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getSpecItem() {
        return specItem;
    }

    public void setSpecItem(String specItem) {
        this.specItem = specItem;
    }

    public String getCashPrice() {
        return cashPrice;
    }

    public void setCashPrice(String cashPrice) {
        this.cashPrice = cashPrice;
    }

    public String getCashPriceFrom() {
        return cashPriceFrom;
    }

    public void setCashPriceFrom(String cashPriceFrom) {
        this.cashPriceFrom = cashPriceFrom;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventTimeFrom() {
        return eventTimeFrom;
    }

    public void setEventTimeFrom(String eventTimeFrom) {
        this.eventTimeFrom = eventTimeFrom;
    }
}
