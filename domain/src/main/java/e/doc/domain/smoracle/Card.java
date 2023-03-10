package e.doc.domain.smoracle;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: zarubaiko
 * Date: 19.08.14
 * Time: 8:55
 * To change this template use File | Settings | File Templates.
 */
public class Card implements Serializable {
    private String article;
    private String name;
    private String mesname;
    private String country;
    private int accepted;
    public Card(){

    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMesname() {
        return mesname;
    }

    public void setMesname(String mesname) {
        this.mesname = mesname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAccepted() {
        return accepted;
    }

    public void setAccepted(int accepted) {
        this.accepted = accepted;
    }
}
