package e.doc.domain.sm.wi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class SMDocTransport implements SupermagDomain {
    @JsonProperty("DOCID")
    String docId;
    @JsonProperty("DOCTYPE")
    String docType;
    @JsonProperty("ADDRESSLOADING")
    String addressLoad;
    @JsonProperty("ADDRESSUNLOADING")
    String addressUnload;
    @JsonProperty("CARRIER")
    String carrier;
    @JsonProperty("CUSTOMER")
    String customer;
    @JsonProperty("DELIVERYDATE")
    String deliveryDate;
    @JsonProperty("DRIVER")
    String driver;
    @JsonProperty("DRIVERLICENCE")
    String driverLicense;
    @JsonProperty("EXPEDITOR")
    String expedotior;
    @JsonProperty("TRAILER")
    String trailer;
    @JsonProperty("TRAINTYPE")
    String trainType;
    @JsonProperty("TRUCKNUMBER")
    String truckNum;
    @JsonProperty("TRUCKTYPE")
    String truckType;

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

    public String getAddressLoad() {
        return addressLoad;
    }

    public void setAddressLoad(String addressLoad) {
        this.addressLoad = addressLoad;
    }

    public String getAddressUnload() {
        return addressUnload;
    }

    public void setAddressUnload(String addressUnload) {
        this.addressUnload = addressUnload;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getExpedotior() {
        return expedotior;
    }

    public void setExpedotior(String expedotior) {
        this.expedotior = expedotior;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public String getTruckNum() {
        return truckNum;
    }

    public void setTruckNum(String truckNum) {
        this.truckNum = truckNum;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }
}
