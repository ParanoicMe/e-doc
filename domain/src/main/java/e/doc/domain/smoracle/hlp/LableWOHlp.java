package e.doc.domain.smoracle.hlp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LableWOHlp {
    String otpuskRazreshil;
    String driver;
    String modelCar;
    String numCar;
    String dover;
    String doverDate;
    String doverPut;

    public String getOtpuskRazreshil() {
        return otpuskRazreshil;
    }

    public void setOtpuskRazreshil(String otpuskRazreshil) {
        this.otpuskRazreshil = otpuskRazreshil;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getNumCar() {
        return numCar;
    }

    public void setNumCar(String numCar) {
        this.numCar = numCar;
    }

    public String getDover() {
        return dover;
    }

    public void setDover(String dover) {
        this.dover = dover;
    }

    public String getDoverDate() {

        return doverDate;
    }

    public void setDoverDate(String doverDate) {
        Date d = new Date();
        try {
            d = new SimpleDateFormat("ddMMyyyy").parse(doverDate);
            SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
            String newD = sf.format(d);
            this.doverDate = newD;

        } catch (ParseException e) {

        }
        this.doverDate = doverDate;
    }

    public String getDoverPut() {
        return doverPut;
    }

    public void setDoverPut(String doverPut) {
        this.doverPut = doverPut;
    }
}
