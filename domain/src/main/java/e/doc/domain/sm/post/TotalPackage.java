package e.doc.domain.sm.post;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TotalPackage implements Serializable {
    @JsonProperty("ERROR")
    String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "TotalPackage{" +
                "error='" + error + '\'' +
                '}';
    }
}
