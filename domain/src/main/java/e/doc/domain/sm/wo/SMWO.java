package e.doc.domain.sm.wo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;


public class SMWO implements SupermagDomain {
    @JsonProperty("SMDOCUMENTS")
    SMDocument smDocument;
    @JsonProperty("SMWAYBILLSOUT")
    SMWayBillsOut smWayBillsOut;
    @JsonProperty("SMDOCPROPS")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<SMDocPropWO> smDocPropWOS;
    @JsonProperty("SMDOCBLOBFILES")
    SMDocBlobFile smDocBlobFiles;
    @JsonProperty("SMSPEC")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<SMSpecWO> specs;
    @JsonProperty("SMSPECIO")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<SMSpecIO> specsIo;
    @JsonProperty("SMSPECNACL")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<SMSpecNacl> specsNacl;
    @JsonProperty("SMSPECSTAT")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<SMSpecStatWO> specsStat;
    @JsonProperty("SMSPECPRODUCERS")
    @JacksonXmlElementWrapper(useWrapping = false)
    SMSpecProducer specsProducer;
    @JsonProperty("SMSPECTAX")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<SMSpecTaxWO> smSpecsTax;
    @JsonProperty("SMSPECBY")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<SMSpecByWO> smSpecsBy;

    public SMDocument getSmDocument() {
        return smDocument;
    }

    public void setSmDocument(SMDocument smDocument) {
        this.smDocument = smDocument;
    }

    public SMWayBillsOut getSmWayBillsOut() {
        return smWayBillsOut;
    }

    public void setSmWayBillsOut(SMWayBillsOut smWayBillsOut) {
        this.smWayBillsOut = smWayBillsOut;
    }

    public List<SMDocPropWO> getSmDocProps() {
        return smDocPropWOS;
    }

    public void setSmDocProps(List<SMDocPropWO> smDocPropWOS) {
        this.smDocPropWOS = smDocPropWOS;
    }

    public SMDocBlobFile getSmDocBlobFiles() {
        return smDocBlobFiles;
    }

    public void setSmDocBlobFiles(SMDocBlobFile smDocBlobFiles) {
        this.smDocBlobFiles = smDocBlobFiles;
    }

    public List<SMSpecWO> getSpecs() {
        return specs;
    }

    public void setSpecs(List<SMSpecWO> specs) {
        this.specs = specs;
    }

    public List<SMSpecIO> getSpecsIo() {
        return specsIo;
    }

    public void setSpecsIo(List<SMSpecIO> specsIo) {
        this.specsIo = specsIo;
    }

    public List<SMSpecNacl> getSpecsNacl() {
        return specsNacl;
    }

    public void setSpecsNacl(List<SMSpecNacl> specsNacl) {
        this.specsNacl = specsNacl;
    }

    public List<SMSpecStatWO> getSpecsStat() {
        return specsStat;
    }

    public void setSpecsStat(List<SMSpecStatWO> specsStat) {
        this.specsStat = specsStat;
    }

    public SMSpecProducer getSpecsProducer() {
        return specsProducer;
    }

    public void setSpecsProducer(SMSpecProducer specsProducer) {
        this.specsProducer = specsProducer;
    }

    public List<SMSpecTaxWO> getSmSpecsTax() {
        return smSpecsTax;
    }

    public void setSmSpecsTax(List<SMSpecTaxWO> smSpecsTax) {
        this.smSpecsTax = smSpecsTax;
    }

    public List<SMSpecByWO> getSmSpecsBy() {
        return smSpecsBy;
    }

    public void setSmSpecsBy(List<SMSpecByWO> smSpecsBy) {
        this.smSpecsBy = smSpecsBy;
    }
}
