package e.doc.domain.smoracle.hlp;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientInfoHlp implements Serializable {
    String num;
    String date;
    String address;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        Date d = new Date();
        try {
            d = new SimpleDateFormat("ddMMyyyy").parse(date);
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
            String newD = sf.format(d);
            this.date = newD;

        } catch (ParseException e) {

        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
