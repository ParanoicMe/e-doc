package e.doc.domain.smoracle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity()
@Table(name = "SMStoreUnits")
public class SMStoreUnit implements Serializable {
    @Id
    @Column(name = "BARCODE")
    String barcode;
    @Column(name = "ARTICLE")
    String article;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
