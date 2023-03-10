package e.doc.domain.sm.wo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "PACKAGE")
public class PostPackageWO implements SupermagDomain {
    
    public PostPackageWO() {
    }

    @JacksonXmlProperty(isAttribute = true)
    String name;
    @JsonProperty("POSTOBJECT")
    PostObjectWO postObject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PostObjectWO getPostObject() {
        return postObject;
    }

    public void setPostObject(PostObjectWO postObject) {
        this.postObject = postObject;
    }
}
