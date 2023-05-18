package e.doc.domain.sm.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
@JacksonXmlRootElement(localName = "REPLY")
public class ReplyError implements Serializable {
    @JacksonXmlProperty(isAttribute = true)
    String name;
    @JacksonXmlProperty(isAttribute = true)
    String packageType;
    @JsonProperty("POSTOBJECT")
    PostObjectReply postobjectReply;
    @JsonProperty("TOTALPACKAGE")
    TotalPackage totalPackage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public PostObjectReply getPostobjectReply() {
        return postobjectReply;
    }

    public void setPostobjectReply(PostObjectReply postobjectReply) {
        this.postobjectReply = postobjectReply;
    }

    public TotalPackage getTotalPackage() {
        return totalPackage;
    }

    public void setTotalPackage(TotalPackage totalPackage) {
        this.totalPackage = totalPackage;
    }

    @Override
    public String toString() {
        return "ReplyError{" +
                "name='" + name + '\'' +
                ", packageType='" + packageType + '\'' +
                ", postobjectReply=" + postobjectReply +
                ", totalPackage=" + totalPackage +
                '}';
    }
}
