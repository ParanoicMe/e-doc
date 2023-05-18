package e.doc.domain.sm.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.io.Serializable;
import java.util.List;

public class PostObjectReply implements Serializable {
    @JsonProperty("Id")
    String id;
    @JsonProperty("ERROR")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<String> error;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getError() {
        return error;
    }

    public void setError(List<String> error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "PostObjectReply{" +
                "id='" + id + '\'' +
                ", error=" + error +
                '}';
    }
}
