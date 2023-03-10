package e.doc.domain.providertopby;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BLRWBLMessageHeader implements ProviderDomain {
    @JsonProperty("MessageID")
    String messageID;
    @JsonProperty("MsgDateTime")
    String msgDateTime;
    @JsonProperty("MessageType")
    String messageType;
    @JsonProperty("MsgSenderID")
    String msgSenderID;
    @JsonProperty("MsgReceiverID")
    String msgReceiverID;
    @JsonProperty("TestIndicator")
    String testIndicator;
    @JsonProperty("UserID")
    String userID;

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getMsgDateTime() {
        return msgDateTime;
    }

    public void setMsgDateTime(String msgDateTime) {
        this.msgDateTime = msgDateTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMsgSenderID() {
        return msgSenderID;
    }

    public void setMsgSenderID(String msgSenderID) {
        this.msgSenderID = msgSenderID;
    }

    public String getMsgReceiverID() {
        return msgReceiverID;
    }

    public void setMsgReceiverID(String msgReceiverID) {
        this.msgReceiverID = msgReceiverID;
    }

    public String getTestIndicator() {
        return testIndicator;
    }

    public void setTestIndicator(String testIndicator) {
        this.testIndicator = testIndicator;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
