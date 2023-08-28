package e.doc.domain.providerctt.blrwbl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;
@JsonPropertyOrder({"DeliveryNoteType", "DocumentID", "CreationDateTime", "FunctionCode", "DeliveryNoteID", "DeliveryNoteDate", "ContractName", "ContractID",
"ContractDate", "Shipper", "Receiver", "FreightPayer", "ShipFrom", "ShipTo", "Carrier", "TransportID", "Currency", "ExtraField", "LineItem", "Total"})
public class DeliveryNote {
    @JsonProperty("DeliveryNoteType")
    protected String deliveryNoteType;
    @JsonProperty("DocumentID")
    protected String documentID;
    @JsonProperty("CreationDateTime")
    protected String creationDateTime;
    @JsonProperty("FunctionCode")
    protected String functionCode;
    @JsonProperty("DeliveryNoteID")
    protected String deliveryNoteID;
    @JsonProperty("DeliveryNoteDate")
    protected String deliveryNoteDate;
    @JsonProperty("ContractName")
    protected String contractName;
    @JsonProperty("ContractID")
    protected String contractID;
    @JsonProperty("ContractDate")
    protected String contractDate;
    /*@JsonProperty("WaybillID")
    protected String waybillID;
    @JsonProperty("Document")
    protected Document document;*/
    @JsonProperty("Shipper")
    protected Shipper shipper;
    @JsonProperty("Receiver")
    protected Receiver receiver;
    @JsonProperty("FreightPayer")
    protected FreightPayer freightPayer;
    @JsonProperty("ShipFrom")
    protected ShipFrom shipFrom;
    @JsonProperty("ShipTo")
    protected ShipTo shipTo;
    @JsonProperty("Carrier")
    protected Carrier carrier;
    /*@JsonProperty("QuantityTrip")
    protected String quantityTrip;
    @JsonProperty("TransportOwnerName")
    protected String transportOwnerName;
    */
    @JsonProperty("TransportID")
    protected String transportID;
    @JsonProperty("TrailerID")
    protected String trailerID;
    /*@JsonProperty("SealID")
    protected String sealID;*/
    @JsonProperty("OrderID")
    protected String orderID;
    @JsonProperty("Currency")
    protected String currency;
    /*@JsonProperty("ExtraField")
    protected List<ExtraField> extraField;*/
    @JsonProperty("ExtraField")
    protected ExtraField extraField;
    @JacksonXmlElementWrapper(localName = "DespatchAdviceLogisticUnitLineItem")
    @JsonProperty("LineItem")
    protected List<LineItem> lineItem;
    @JsonProperty("Total")
    protected Total total;

 /**
     * Gets the value of the deliveryNoteType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryNoteType() {
        return deliveryNoteType;
    }

    /**
     * Sets the value of the deliveryNoteType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryNoteType(String value) {
        this.deliveryNoteType = value;
    }

    /**
     * Gets the value of the documentID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentID() {
        return documentID;
    }

    /**
     * Sets the value of the documentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentID(String value) {
        this.documentID = value;
    }

    /**
     * Gets the value of the creationDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationDateTime() {
        return creationDateTime;
    }

    /**
     * Sets the value of the creationDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationDateTime(String value) {
        this.creationDateTime = value;
    }

    /**
     * Gets the value of the functionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunctionCode() {
        return functionCode;
    }

    /**
     * Sets the value of the functionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunctionCode(String value) {
        this.functionCode = value;
    }

    /**
     * Gets the value of the deliveryNoteID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryNoteID() {
        return deliveryNoteID;
    }

    /**
     * Sets the value of the deliveryNoteID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryNoteID(String value) {
        this.deliveryNoteID = value;
    }

    /**
     * Gets the value of the deliveryNoteDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryNoteDate() {
        return deliveryNoteDate;
    }

    /**
     * Sets the value of the deliveryNoteDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryNoteDate(String value) {
        this.deliveryNoteDate = value;
    }

    /**
     * Gets the value of the contractName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractName() {
        return contractName;
    }

    /**
     * Sets the value of the contractName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractName(String value) {
        this.contractName = value;
    }

    /**
     * Gets the value of the contractID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractID() {
        return contractID;
    }

    /**
     * Sets the value of the contractID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractID(String value) {
        this.contractID = value;
    }

    /**
     * Gets the value of the contractDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContractDate() {
        return contractDate;
    }

    /**
     * Sets the value of the contractDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContractDate(String value) {
        this.contractDate = value;
    }

    /**
     * Gets the value of the waybillID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     *//*
    public String getWaybillID() {
        return waybillID;
    }

    *//**
     * Sets the value of the waybillID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     *//*
    public void setWaybillID(String value) {
        this.waybillID = value;
    }*/

    /**
     * Gets the value of the document property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the document property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Document }
     * 
     * 
     *//*
    public Document getDocument() {
        return this.document;
    }*/

    /**
     * Грузоотправитель
     * 
     * @return
     *     possible object is
     *     {@link Shipper }
     *     
     */
    public Shipper getShipper() {
        return shipper;
    }

    /**
     * Sets the value of the shipper property.
     * 
     * @param value
     *     allowed object is
     *     {@link Shipper }
     *     
     */
    public void setShipper(Shipper value) {
        this.shipper = value;
    }

    /**
     * Грузополучатель
     * 
     * @return
     *     possible object is
     *     {@link Receiver }
     *     
     */
    public Receiver getReceiver() {
        return receiver;
    }

    /**
     * Sets the value of the receiver property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receiver }
     *     
     */
    public void setReceiver(Receiver value) {
        this.receiver = value;
    }

    /**
     * Заказчик автомобильной перевозки (плательщик)
     * 
     * @return
     *     possible object is
     *     {@link FreightPayer }
     *     
     */
    public FreightPayer getFreightPayer() {
        return freightPayer;
    }

    /**
     * Sets the value of the freightPayer property.
     * 
     * @param value
     *     allowed object is
     *     {@link FreightPayer }
     *     
     */
    public void setFreightPayer(FreightPayer value) {
        this.freightPayer = value;
    }

    /**
     * Gets the value of the shipFrom property.
     * 
     * @return
     *     possible object is
     *     {@link ShipFrom }
     *     
     */
    public ShipFrom getShipFrom() {
        return shipFrom;
    }

    /**
     * Sets the value of the shipFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipFrom }
     *     
     */
    public void setShipFrom(ShipFrom value) {
        this.shipFrom = value;
    }

    /**
     * Пункт разгрузки
     * 
     * @return
     *     possible object is
     *     {@link ShipTo }
     *     
     */
    public ShipTo getShipTo() {
        return shipTo;
    }

    /**
     * Sets the value of the shipTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipTo }
     *     
     */
    public void setShipTo(ShipTo value) {
        this.shipTo = value;
    }

    /**
     * Gets the value of the carrier property.
     * 
     * @return
     *     possible object is
     *     {@link Carrier }
     *     
     */
    public Carrier getCarrier() {
        return carrier;
    }

    /**
     * Sets the value of the carrier property.
     * 
     * @param value
     *     allowed object is
     *     {@link Carrier }
     *     
     */
    public void setCarrier(Carrier value) {
        this.carrier = value;
    }

    /**
     * Gets the value of the quantityTrip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     *//*
    public String getQuantityTrip() {
        return quantityTrip;
    }

    *//**
     * Sets the value of the quantityTrip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     *//*
    public void setQuantityTrip(String value) {
        this.quantityTrip = value;
    }

    *//**
     * Gets the value of the transportOwnerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     *//*
    public String getTransportOwnerName() {
        return transportOwnerName;
    }

    *//**
     * Sets the value of the transportOwnerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     *//*
    public void setTransportOwnerName(String value) {
        this.transportOwnerName = value;
    }*/

    /**
     * Gets the value of the transportID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransportID() {
        return transportID;
    }

    /**
     * Sets the value of the transportID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransportID(String value) {
        this.transportID = value;
    }

    /**
     * Gets the value of the trailerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrailerID() {
        return trailerID;
    }

    /**
     * Sets the value of the trailerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrailerID(String value) {
        this.trailerID = value;
    }

    /**
     * Gets the value of the sealID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     *//*
    public String getSealID() {
        return sealID;
    }

    *//**
     * Sets the value of the sealID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     *//*
    public void setSealID(String value) {
        this.sealID = value;
    }*/

    /**
     * Gets the value of the orderID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * Sets the value of the orderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderID(String value) {
        this.orderID = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    public ExtraField getExtraField() {
        return extraField;
    }

    public void setExtraField(ExtraField extraField) {
        this.extraField = extraField;
    }
/*
    *//**
     * Gets the value of the extraField property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extraField property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtraField().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtraField }
     * 
     * 
     *//*
    public List<ExtraField> getExtraField() {
        if (extraField == null) {
            extraField = new ArrayList<ExtraField>();
        }
        return this.extraField;
    }

    public void setExtraField(List<ExtraField> extraField) {
        this.extraField = extraField;
    }*/



    public List<LineItem> getLineItem() {
        if (lineItem == null) {
            lineItem = new ArrayList<LineItem>();
        }
        return this.lineItem;
    }

    public void setLineItem(List<LineItem> lineItem) {
        this.lineItem = lineItem;
    }

    /**
     * Gets the value of the total property.
     * 
     * @return
     *     possible object is
     *     {@link Total }
     *     
     */
    public Total getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     * @param value
     *     allowed object is
     *     {@link Total }
     *     
     */
    public void setTotal(Total value) {
        this.total = value;
    }

    
}
