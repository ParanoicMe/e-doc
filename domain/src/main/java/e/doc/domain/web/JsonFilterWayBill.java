package e.doc.domain.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class JsonFilterWayBill implements Serializable {

    String dateUpdateFrom;
    String dateUpdateTo;
    String documentDateEnd;
    String documentDateStart;
    String documentNumber;
    String documentType;
    String partnerId;
    List<JsonProcessingStatus> jsonProcessingStatuses;
    int receiverId;
    int shipperId;
    String storageId;

    public String getDateUpdateFrom() {
        return dateUpdateFrom;
    }

    public void setDateUpdateFrom(String dateUpdateFrom) {
        this.dateUpdateFrom = dateUpdateFrom;
    }

    public String getDateUpdateTo() {
        return dateUpdateTo;
    }

    public void setDateUpdateTo(String dateUpdateTo) {
        this.dateUpdateTo = dateUpdateTo;
    }

    public List<JsonProcessingStatus> getJsonProcessingStatuses() {
        return jsonProcessingStatuses;
    }

    public void setJsonProcessingStatuses(List<JsonProcessingStatus> jsonProcessingStatuses) {
        this.jsonProcessingStatuses = jsonProcessingStatuses;
    }

    public String getDocumentDateEnd() {
        return documentDateEnd;
    }

    public void setDocumentDateEnd(String documentDateEnd) {
        this.documentDateEnd = documentDateEnd;
    }

    public String getDocumentDateStart() {
        return documentDateStart;
    }

    public void setDocumentDateStart(String documentDateStart) {
        this.documentDateStart = documentDateStart;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public int getShipperId() {
        return shipperId;
    }

    public void setShipperId(int shipperId) {
        this.shipperId = shipperId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    @Override
    public String toString() {
        return "{" +
                "\"dateUpdateFrom\":\"" + (dateUpdateFrom == null ? "" : dateUpdateFrom) + "\"" +
                ", \"dateUpdateTo\":\"" + (dateUpdateTo == null ? "" : dateUpdateTo) + "\"" +
                ", \"documentDateEnd\":\"" + (documentDateEnd == null ? "" : documentDateEnd) + "\"" +
                ", \"documentDateStart\":\"" + (documentDateStart == null ? "" : documentDateStart) + "\"" +
                ", \"documentNumber\":\"" + (documentNumber == null ? "" : documentNumber) + "\"" +
                ", \"documentType\":\"" + (documentType == null ? "" : documentType) + "\"" +
                ", \"partnerId\":\"" + (partnerId == null ? "" : partnerId) + "\"" +
                ", \"processingStatusList\":" + (jsonProcessingStatuses == null ? new ArrayList<JsonProcessingStatus>() : jsonProcessingStatuses) +
                ", \"receiverId\":" + receiverId +
                ", \"shipperId\":" + shipperId +
                ", \"storageId\":\"" + (storageId == null ? "" : storageId) + "\"" +
                "}";
    }

    /* @Override
    public String toString() {
        return "{" +
                "\"documentDateEnd\":\"" + documentDateEnd + "\"" +
                ", \"documentDateStart\":\"" + documentDateStart + "\"" +
                ", \"documentNumber\":\"" + (documentNumber == null ? "" : documentNumber) + "\"" +
                ", \"documentType\":\"" + documentType + "\"" +
                ", \"partnerId\":\"" + (partnerId == null ? "" : partnerId) + "\"" +
                ", \"processingStatusId\":\"" + (processingStatusId == null ? "" : processingStatusId) + "\"" +
                ", \"receiverId\":" + receiverId + "" +
                ", \"shipperId\":" + shipperId + "" +
                ", \"storageId\":\"" + (storageId == null ? "" : storageId) + "\"" +
                "}";
    }*/
}
