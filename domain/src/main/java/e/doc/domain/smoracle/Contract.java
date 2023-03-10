package e.doc.domain.smoracle;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: zarubaiko
 * Date: 26.08.14
 * Time: 7:35
 * To change this template use File | Settings | File Templates.
 */
public class Contract implements Serializable {
    private String date;
    private String client;
    private int countPosition;
    private String fileName;
    public Contract(){

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public int getCountPosition() {
        return countPosition;
    }

    public void setCountPosition(int countPosition) {
        this.countPosition = countPosition;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
