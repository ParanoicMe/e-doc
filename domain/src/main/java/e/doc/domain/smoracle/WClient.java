package e.doc.domain.smoracle;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: zarubaiko
 * Date: 26.08.14
 * Time: 18:36
 * To change this template use File | Settings | File Templates.
 */
public class WClient implements Serializable {
    private int id;
    private String name;
    private String unn;
    public WClient(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnn() {
        return unn;
    }

    public void setUnn(String unn) {
        this.unn = unn;
    }
}
