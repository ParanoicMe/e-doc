package e.doc.domain.sm.wo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class PostObjectWO implements SupermagDomain {
    @JacksonXmlProperty(isAttribute = true)
    String description;
    @JacksonXmlProperty(isAttribute = true)
    String action;
    @JsonProperty("Id")
    String id;
    @JsonProperty("WO")
    SMWO wo;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SMWO getWo() {
        return wo;
    }

    public void setWo(SMWO wo) {
        this.wo = wo;
    }
}
