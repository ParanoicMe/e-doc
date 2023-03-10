package e.doc.domain.smoracle;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: zarubaiko
 * Date: 17.06.15
 * Time: 17:03
 * To change this template use File | Settings | File Templates.
 */
public class Supplier implements Serializable {
    private Long id;
    private Long idclass;
    private ClientInfo clientInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getIdclass() {
        return idclass;
    }

    public void setIdclass(Long idclass) {
        this.idclass = idclass;
    }


    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }
}
