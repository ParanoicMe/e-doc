package e.doc.domain.sm.wi;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;


public class SMWI implements SupermagDomain {
    @JsonProperty("SMDOCUMENTS")
    SMDocumentWI smDocumentWI;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("SMCOMMONBASES")
    SMCommonBasesWI smCommonBasesWI;
    @JsonProperty("SMWAYBILLSIN")
    SMWayBillsIn smWayBillsIn;
    @JsonProperty("SMDOCPROPS")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<SMDocPropWI> smDocProps;
    @JsonProperty("SMDOCBLOBFILES")
    SMDocBlobFileWI smDocBlobFiles;
    @JsonProperty("SMSPEC")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<SMSpecWI> specs;
    @JsonProperty("SMSPECTAX")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<SMSpecTax> smSpecsTax;
    @JsonProperty("SMSPECBY")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<SMSpecBy> smSpecsBy;
    @JsonProperty("SMDOCTRANSPORT")
    SMDocTransport smDocTransport;
    @JsonProperty("SMSPECSTAT")
    SMSpecStatWI smSpecStatWI;

    public SMDocumentWI getSmDocumentWI() {
        return smDocumentWI;
    }

    public void setSmDocumentWI(SMDocumentWI smDocumentWI) {
        this.smDocumentWI = smDocumentWI;
    }

    public SMCommonBasesWI getSmCommonBasesWI() {
        return smCommonBasesWI;
    }

    public void setSmCommonBasesWI(SMCommonBasesWI smCommonBasesWI) {
        this.smCommonBasesWI = smCommonBasesWI;
    }

    public SMWayBillsIn getSmWayBillsIn() {
        return smWayBillsIn;
    }

    public void setSmWayBillsIn(SMWayBillsIn smWayBillsIn) {
        this.smWayBillsIn = smWayBillsIn;
    }

    public List<SMDocPropWI> getSmDocProps() {
        return smDocProps;
    }

    public void setSmDocProps(List<SMDocPropWI> smDocProps) {
        this.smDocProps = smDocProps;
    }

    public SMDocBlobFileWI getSmDocBlobFiles() {
        return smDocBlobFiles;
    }

    public void setSmDocBlobFiles(SMDocBlobFileWI smDocBlobFiles) {
        this.smDocBlobFiles = smDocBlobFiles;
    }

    public List<SMSpecWI> getSpecs() {
        return specs;
    }

    public void setSpecs(List<SMSpecWI> specs) {
        this.specs = specs;
    }

    public List<SMSpecTax> getSmSpecsTax() {
        return smSpecsTax;
    }

    public void setSmSpecsTax(List<SMSpecTax> smSpecsTax) {
        this.smSpecsTax = smSpecsTax;
    }

    public List<SMSpecBy> getSmSpecsBy() {
        return smSpecsBy;
    }

    public void setSmSpecsBy(List<SMSpecBy> smSpecsBy) {
        this.smSpecsBy = smSpecsBy;
    }

    public SMDocTransport getSmDocTransport() {
        return smDocTransport;
    }

    public void setSmDocTransport(SMDocTransport smDocTransport) {
        this.smDocTransport = smDocTransport;
    }

    public SMSpecStatWI getSmSpecStatWI() {
        return smSpecStatWI;
    }

    public void setSmSpecStatWI(SMSpecStatWI smSpecStatWI) {
        this.smSpecStatWI = smSpecStatWI;
    }
}
