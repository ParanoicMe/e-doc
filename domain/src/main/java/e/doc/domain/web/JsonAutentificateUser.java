package e.doc.domain.web;

import java.io.Serializable;
import java.util.List;

public class JsonAutentificateUser implements Serializable {
    String uuid;
    List<JsonRole> userRoles;
    String userType;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<JsonRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<JsonRole> userRoles) {
        this.userRoles = userRoles;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "JsonAutentificateUser{" +
                "uuid='" + uuid + '\'' +
                ", userRoles=" + userRoles +
                ", userType='" + userType + '\'' +
                '}';
    }
}
