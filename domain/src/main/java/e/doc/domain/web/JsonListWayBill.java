package e.doc.domain.web;

import java.io.Serializable;

public class JsonListWayBill implements Serializable {
    String documentDateEnd;
    String documentDateStart;
    String documentNumber;
    String documentStage;
    String documentType;
    String partnerId;
    String processingStatusId;
    int receiverId;
    int shipperId;
    String storageId;

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

    public String getDocumentStage() {
        return documentStage;
    }

    public void setDocumentStage(String documentStage) {
        this.documentStage = documentStage;
    }

    public String getProcessingStatusId() {
        return processingStatusId;
    }

    public void setProcessingStatusId(String processingStatusId) {
        this.processingStatusId = processingStatusId;
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
                "\"documentDateEnd\":\"" + documentDateEnd + "\"" +
                ", \"documentDateStart\":\"" + documentDateStart + "\"" +
                /*", \"documentNumber\":\"" + (documentNumber == null ? "" : documentNumber) + "\"" +*/
                ", \"documentStage\":\"" + documentStage + "\"" +
                ", \"documentType\":\"" + documentType + "\"" +
                /*", \"partnerId\":\"" + (partnerId == null ? "" : partnerId) + "\"" +*/
                /*", \"processingStatusId\":\"" + (processingStatusId == null ? "" : processingStatusId) + "\"" +*/
                /*", \"receiverId\":" + receiverId + "" +
                ", \"shipperId\":" + shipperId + "" +
                ", \"storageId\":\"" + (storageId == null ? "" : storageId) + "\"" +*/
                "}";
    }
}
