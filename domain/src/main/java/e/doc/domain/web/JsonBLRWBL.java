package e.doc.domain.web;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class JsonBLRWBL implements Serializable {
    @JsonProperty("id")
    int id;
    @JsonProperty("processingStatus")
    JsonProcessingStatus jsonProcessingStatus;
    String dateTime;
    @JsonProperty("documentNumber")
    String documentNumber;
    String documentDate;
    String sender;
    String receiver;
    String deliveryPlace;
    String shipmentPlace;
    String isResponseExist;
    @JsonProperty("messageType")
    String messageType;
    String signatureDate;
    String signatureTime;
    @JsonProperty("documentType")
    String documentType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JsonProcessingStatus getJsonProcessingStatus() {
        return jsonProcessingStatus;
    }

    public void setJsonProcessingStatus(JsonProcessingStatus jsonProcessingStatus) {
        this.jsonProcessingStatus = jsonProcessingStatus;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(String documentDate) {
        this.documentDate = documentDate;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }

    public String getShipmentPlace() {
        return shipmentPlace;
    }

    public void setShipmentPlace(String shipmentPlace) {
        this.shipmentPlace = shipmentPlace;
    }

    public String getIsResponseExist() {
        return isResponseExist;
    }

    public void setIsResponseExist(String isResponseExist) {
        this.isResponseExist = isResponseExist;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getSignatureDate() {
        return signatureDate;
    }

    public void setSignatureDate(String signatureDate) {
        this.signatureDate = signatureDate;
    }

    public String getSignatureTime() {
        return signatureTime;
    }

    public void setSignatureTime(String signatureTime) {
        this.signatureTime = signatureTime;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    @Override
    public String toString() {
        return "JsonBLRWBL{" +
                "id=" + id +
                ", jsonProcessingStatus=" + jsonProcessingStatus +
                ", dateTime='" + dateTime + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", documentDate='" + documentDate + '\'' +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", deliveryPlace='" + deliveryPlace + '\'' +
                ", shipmentPlace='" + shipmentPlace + '\'' +
                ", isResponseExist='" + isResponseExist + '\'' +
                ", messageType='" + messageType + '\'' +
                ", signatureDate='" + signatureDate + '\'' +
                ", signatureTime='" + signatureTime + '\'' +
                ", documentType='" + documentType + '\'' +
                '}';
    }
}
