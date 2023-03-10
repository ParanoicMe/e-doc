package e.doc.domain.smoracle;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "SMWayBillsIn")
public class SMWayBillsIn {
    @Id
    @Column(name = "ID")
    String id;
    @Column(name = "DOCTYPE")
    String doctype;
    @JsonProperty("SUPPLIERDOC")
    String supplierDoc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }

    public String getSupplierDoc() {
        return supplierDoc;
    }

    public void setSupplierDoc(String supplierDoc) {
        this.supplierDoc = supplierDoc;
    }
}
