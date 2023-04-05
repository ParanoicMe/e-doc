package e.doc.domain.smoracle;

import java.io.Serializable;

public class SMCardtPropertiesPK implements Serializable {
    protected String article;
    protected String propId;

    public SMCardtPropertiesPK() {
    }

    public SMCardtPropertiesPK(String article, String propId) {
        this.article = article;
        this.propId = propId;
    }
    // equals, hashCode
}
