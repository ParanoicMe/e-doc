package e.doc.domain.smoracle;

import java.io.Serializable;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zarubaiko
 * Date: 25.09.14
 * Time: 12:12
 * To change this template use File | Settings | File Templates.
 */
public class User implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Map<Long, String> roles;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<Long, String> getRoles() {
        return roles;
    }

    public void setRoles(Map<Long, String> roles) {
        this.roles = roles;
    }
}
