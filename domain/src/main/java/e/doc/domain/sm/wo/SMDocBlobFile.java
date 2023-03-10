package e.doc.domain.sm.wo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SMDocBlobFile implements SupermagDomain {
    @JsonProperty("ID")
    String id;
    @JsonProperty("DOCTYPE")
    String docType;
    @JsonProperty("INSERTIONID")
    String insertionId;
    @JsonProperty("FILENAME")
    String fileName;
    @JsonProperty("INSERTEDTYPEID")
    String insertedtTypeId;
    @JsonProperty("THECONTENTS")
    String theContents;
    @JsonProperty("TITLE")
    String title;

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

    public String getInsertionId() {
        return insertionId;
    }

    public void setInsertionId(String insertionId) {
        this.insertionId = insertionId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getInsertedtTypeId() {
        return insertedtTypeId;
    }

    public void setInsertedtTypeId(String insertedtTypeId) {
        this.insertedtTypeId = insertedtTypeId;
    }

    public String getTheContents() {
        return theContents;
    }

    public void setTheContents(String theContents) {
        this.theContents = theContents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
