package e.doc.domain.smoracle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zarubaiko
 * Date: 23.06.15
 * Time: 18:24
 * To change this template use File | Settings | File Templates.
 */
@Entity()
@Table(name = "SMClientInfo")
public class ClientInfo implements Serializable {
    @Id
    @Column(name = "ID")
    private Long id;
    /*@Column(name = "SUPPLIER")
    private Supplier supplier;*/
    @Column(name = "ACCEPTED")
    private int accepted;
    @Column(name = "NAME")
    private String name;
    @Column(name = "INN")
    private String inn;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "OKPO")
    private String okpo;
    @Column(name = "COMMENTARY")
    private String comment;
    @Column(name = "GLN")
    private String gln;
    @OneToMany(mappedBy="clientInfo")
    private Set<ClientProperties> propertiesList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAccepted() {
        return accepted;
    }

    public void setAccepted(int accepted) {
        this.accepted = accepted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOkpo() {
        return okpo;
    }

    public void setOkpo(String okpo) {
        this.okpo = okpo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getGln() {
        return gln;
    }

    public void setGln(String gln) {
        this.gln = gln;
    }

    public Set<ClientProperties> getPropertiesList() {
        return propertiesList;
    }

    public void setPropertiesList(Set<ClientProperties> propertiesList) {
        this.propertiesList = propertiesList;
    }
}
