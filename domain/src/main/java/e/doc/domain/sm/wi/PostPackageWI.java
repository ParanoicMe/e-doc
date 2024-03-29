package e.doc.domain.sm.wi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "PACKAGE")
public class PostPackageWI implements SupermagDomain {
    @JacksonXmlProperty(isAttribute = true)
    String name;
    @JsonProperty("POSTOBJECT")
    PostObjectWI postObjectWI;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PostObjectWI getPostObjectWI() {
        return postObjectWI;
    }

    public void setPostObjectWI(PostObjectWI postObjectWI) {
        this.postObjectWI = postObjectWI;
    }
}
