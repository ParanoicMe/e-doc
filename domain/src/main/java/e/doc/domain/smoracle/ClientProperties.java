package e.doc.domain.smoracle;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SMClientProperties")
@IdClass(ClientPropertiesPK.class)
public class ClientProperties implements Serializable {
    @ManyToOne(fetch=FetchType.LAZY)
            @JoinColumn(name = "IDCLIENT", insertable = false, updatable = false)
            //@JoinColumn(name = "ID", insertable = false, updatable = false)
            /*@JoinTable(name = "SMClientInfo",
            joinColumns = @JoinColumn(name="IDCLIENT"),
            inverseJoinColumns = @JoinColumn(name="ID")*/
    private ClientInfo clientInfo;
    @Id
    @Column(name = "IDCLIENT")
    Long clientId;
    @Id
    @Column(name = "PROPID")
    String propId;
    @Column(name = "PROPVAL")
    String propVal;


    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    public String getPropId() {
        return propId;
    }

    public void setPropId(String propId) {
        this.propId = propId;
    }

    public String getPropVal() {
        return propVal;
    }

    public void setPropVal(String propVal) {
        this.propVal = propVal;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }
}
