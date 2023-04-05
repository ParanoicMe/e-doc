package e.doc.domain.smoracle;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "SMCardProperties")
@IdClass(SMCardtPropertiesPK.class)
public class SMCardProperties implements Serializable {
    @Id
    @Column(name = "ARTICLE")
    String article;
    @Id
    @Column(name = "PROPID")
    String propId;
    @Column(name = "PROPVAL")
    String PropVal;

    public SMCardProperties() {
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getPropId() {
        return propId;
    }

    public void setPropId(String propId) {
        this.propId = propId;
    }

    public String getPropVal() {
        return PropVal;
    }

    public void setPropVal(String propVal) {
        PropVal = propVal;
    }
}
