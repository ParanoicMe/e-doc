package e.doc.domain.sm.wi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class PostObjectWI implements SupermagDomain {
    @JacksonXmlProperty(isAttribute = true)
    String description;
    @JacksonXmlProperty(isAttribute = true)
    String action;
    @JsonProperty("Id")
    String id;
    @JsonProperty("WI")
    SMWI wi;

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

    public SMWI getWi() {
        return wi;
    }

    public void setWi(SMWI wi) {
        this.wi = wi;
    }
}
