package e.doc.domain.providerctt.blrwbl;

import com.fasterxml.jackson.annotation.JsonProperty;
public class MessageHeader {
    @JsonProperty("MessageID")
    protected String messageID;
    @JsonProperty("MsgDateTime")
    protected String msgDateTime;
    @JsonProperty("MessageType")
    protected String messageType;
    @JsonProperty("MsgSenderID")
    protected String msgSenderID;
    @JsonProperty("MsgReceiverID")
    protected String msgReceiverID;
    @JsonProperty("TestIndicator")
    protected String testIndicator;
    @JsonProperty("UserID")
    protected String userID;

    /**
     * Gets the value of the messageID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageID() {
        return messageID;
    }

    /**
     * Sets the value of the messageID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageID(String value) {
        this.messageID = value;
    }

    /**
     * Gets the value of the msgDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgDateTime() {
        return msgDateTime;
    }

    /**
     * Sets the value of the msgDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgDateTime(String value) {
        this.msgDateTime = value;
    }

    /**
     * Gets the value of the messageType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageType() {
        return messageType;
    }

    /**
     * Sets the value of the messageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageType(String value) {
        this.messageType = value;
    }

    /**
     * Gets the value of the msgSenderID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgSenderID() {
        return msgSenderID;
    }

    /**
     * Sets the value of the msgSenderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgSenderID(String value) {
        this.msgSenderID = value;
    }

    /**
     * Gets the value of the msgReceiverID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgReceiverID() {
        return msgReceiverID;
    }

    /**
     * Sets the value of the msgReceiverID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgReceiverID(String value) {
        this.msgReceiverID = value;
    }

    /**
     * Gets the value of the testIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTestIndicator() {
        return testIndicator;
    }

    /**
     * Sets the value of the testIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTestIndicator(String value) {
        this.testIndicator = value;
    }

    /**
     * Gets the value of the userID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserID(String value) {
        this.userID = value;
    }

}
