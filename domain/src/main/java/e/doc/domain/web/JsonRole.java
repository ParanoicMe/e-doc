package e.doc.domain.web;

import java.io.Serializable;

public class JsonRole implements Serializable {
    String id;
    String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
