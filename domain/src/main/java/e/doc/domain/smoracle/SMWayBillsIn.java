package e.doc.domain.smoracle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity()
@Table(name = "SMWayBillsIn")
public class SMWayBillsIn implements Serializable {
    @Id
    @Column(name = "ID")
    String id;
    @Column(name = "DOCTYPE")
    String doctype;
    @Column(name = "SUPPLIERDOC")
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

    @Override
    public String toString() {
        return "SMWayBillsIn{" +
                "id='" + id + '\'' +
                ", doctype='" + doctype + '\'' +
                ", supplierDoc='" + supplierDoc + '\'' +
                '}';
    }
}
