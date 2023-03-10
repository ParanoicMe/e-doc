package e.doc.domain.providertopby;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

public class BLRWBLDeliveryNote implements ProviderDomain {
    @JsonProperty("DeliveryNoteType")
    String deliveryNoteType;
    @JsonProperty("DocumentID")
    String documentID;
    @JsonProperty("CreationDateTime")
    String creationDateTime;
    @JsonProperty("FunctionCode")
    String functionCode;
    @JsonProperty("DeliveryNoteID")
    String deliveryNoteID;
    @JsonProperty("DeliveryNoteDate")
    String deliveryNoteDate;
    @JsonProperty("ContractName")
    String contractName;
    @JsonProperty("ContractID")
    String contractID;
    @JsonProperty("ContractDate")
    String contractDate;
    @JsonProperty("WaybillID")
    String waybillID;
    @JsonProperty("Document")
    BLRWBLDocument blrwblDocument;
    @JsonProperty("Shipper")
    BLRWBLShipper blrwblShipper;
    @JsonProperty("Receiver")
    BLRWBLReceiver blrwblReceiver;
    @JsonProperty("FreightPayer")
    BLRWBLFreightPayer blrwblFreightPayer;
    @JsonProperty("ShipFrom")
    BLRWBLShipFrom blrwblShipFrom;
    @JsonProperty("ShipTo")
    BLRWBLShipTo blrwblShipTo;
    @JsonProperty("Carrier")
    BLRWBLCarrier blrwblCarrier;
    @JsonProperty("QuantityTrip")
    String quantityTrip;
    @JsonProperty("TransportOwnerName")
    String transportOwnerName;
    @JsonProperty("TransportID")
    String transportID;
    @JsonProperty("TrailerID")
    String trailerID;
    @JsonProperty("SealID")
    String sealID;
    @JsonProperty("OrderID")
    String orderID;
    @JsonProperty("Currency")
    String currency;
    @JsonProperty("ExtraField")
    BLRWBLExtraField blrwblExtraField;
    @JacksonXmlElementWrapper(localName = "DespatchAdviceLogisticUnitLineItem")
    List<BLRWBLLineItem> lineItem;
    @JsonProperty("Total")
    BLRWBLTotal blrwblTotal ;

    public String getDeliveryNoteType() {
        return deliveryNoteType;
    }

    public void setDeliveryNoteType(String deliveryNoteType) {
        this.deliveryNoteType = deliveryNoteType;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public String getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(String creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public String getDeliveryNoteID() {
        return deliveryNoteID;
    }

    public void setDeliveryNoteID(String deliveryNoteID) {
        this.deliveryNoteID = deliveryNoteID;
    }

    public String getDeliveryNoteDate() {
        return deliveryNoteDate;
    }

    public void setDeliveryNoteDate(String deliveryNoteDate) {
        this.deliveryNoteDate = deliveryNoteDate;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getWaybillID() {
        return waybillID;
    }

    public void setWaybillID(String waybillID) {
        this.waybillID = waybillID;
    }

    public BLRWBLDocument getBlrwblDocument() {
        return blrwblDocument;
    }

    public void setBlrwblDocument(BLRWBLDocument blrwblDocument) {
        this.blrwblDocument = blrwblDocument;
    }

    public BLRWBLShipper getBlrwblShipper() {
        return blrwblShipper;
    }

    public void setBlrwblShipper(BLRWBLShipper blrwblShipper) {
        this.blrwblShipper = blrwblShipper;
    }

    public BLRWBLReceiver getBlrwblReceiver() {
        return blrwblReceiver;
    }

    public void setBlrwblReceiver(BLRWBLReceiver blrwblReceiver) {
        this.blrwblReceiver = blrwblReceiver;
    }

    public BLRWBLFreightPayer getBlrwblFreightPayer() {
        return blrwblFreightPayer;
    }

    public void setBlrwblFreightPayer(BLRWBLFreightPayer blrwblFreightPayer) {
        this.blrwblFreightPayer = blrwblFreightPayer;
    }

    public BLRWBLShipFrom getBlrwblShipFrom() {
        return blrwblShipFrom;
    }

    public void setBlrwblShipFrom(BLRWBLShipFrom blrwblShipFrom) {
        this.blrwblShipFrom = blrwblShipFrom;
    }

    public BLRWBLShipTo getBlrwblShipTo() {
        return blrwblShipTo;
    }

    public void setBlrwblShipTo(BLRWBLShipTo blrwblShipTo) {
        this.blrwblShipTo = blrwblShipTo;
    }

    public BLRWBLCarrier getBlrwblCarrier() {
        return blrwblCarrier;
    }

    public void setBlrwblCarrier(BLRWBLCarrier blrwblCarrier) {
        this.blrwblCarrier = blrwblCarrier;
    }

    public String getQuantityTrip() {
        return quantityTrip;
    }

    public void setQuantityTrip(String quantityTrip) {
        this.quantityTrip = quantityTrip;
    }

    public String getTransportOwnerName() {
        return transportOwnerName;
    }

    public void setTransportOwnerName(String transportOwnerName) {
        this.transportOwnerName = transportOwnerName;
    }

    public String getTransportID() {
        return transportID;
    }

    public void setTransportID(String transportID) {
        this.transportID = transportID;
    }

    public String getTrailerID() {
        return trailerID;
    }

    public void setTrailerID(String trailerID) {
        this.trailerID = trailerID;
    }

    public String getSealID() {
        return sealID;
    }

    public void setSealID(String sealID) {
        this.sealID = sealID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BLRWBLExtraField getBlrwblExtraField() {
        return blrwblExtraField;
    }

    public void setBlrwblExtraField(BLRWBLExtraField blrwblExtraField) {
        this.blrwblExtraField = blrwblExtraField;
    }

    public List<BLRWBLLineItem> getLineItem() {
        return lineItem;
    }

    public void setLineItem(List<BLRWBLLineItem> lineItem) {
        this.lineItem = lineItem;
    }

    public BLRWBLTotal getBlrwblTotal() {
        return blrwblTotal;
    }

    public void setBlrwblTotal(BLRWBLTotal blrwblTotal) {
        this.blrwblTotal = blrwblTotal;
    }
}
