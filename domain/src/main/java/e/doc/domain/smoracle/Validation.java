package e.doc.domain.smoracle;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: zarubaiko
 * Date: 17.06.15
 * Time: 16:40
 * To change this template use File | Settings | File Templates.
 */
public class Validation implements Serializable {
    private Long id;
    private String name;
    private String template;
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
