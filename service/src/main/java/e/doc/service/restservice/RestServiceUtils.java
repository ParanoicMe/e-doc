package e.doc.service.restservice;

import e.doc.domain.web.JsonBLRWBL;
import e.doc.service.ServiceImpl;
import e.doc.service.exception.ServiceException;
import e.doc.service.sqllite.ServiceSQLLite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RestServiceUtils {
    private static Logger logger = LogManager.getLogger(RestServiceUtils.class);
    static final String PARSTARTTIME = "start.time";
    ServiceSQLLite serviceSQLLite = new ServiceSQLLite();

    public int[] convertEWayBill(JsonBLRWBL[] jsonBLRWBLS) {
        //logger.debug(" convertEWayBill jsonBLRWBLS.length --- " + jsonBLRWBLS.length);
        int[] ids = new int[jsonBLRWBLS.length];
        //logger.debug(" convertEWayBill jsonBLRWBLS.length --- " + jsonBLRWBLS.length + "ids.length ---" + ids.length);
        //int k = 0;
        //logger.debug(" i <= jsonBLRWBLS.length --- " + (k <= jsonBLRWBLS.length-1) + "ids.length ---" + ids.length);

        for (int i = 0; i <= jsonBLRWBLS.length-1; i++) {
            //logger.debug("JsonBLRWBL.toString() --- " + jsonBLRWBLS[i].toString());

            JsonBLRWBL blrwbl = jsonBLRWBLS[i];
            //logger.debug("blrwbl.getDocumentType() ---" + blrwbl.getDocumentType());
            //logger.debug("blrwbl.getDocumentType().equals(\"ТТН\") ---" + blrwbl.getDocumentType().equals("ТТН"));
            if (blrwbl.getDocumentType().equals("ТТН")) {
                logger.debug("ТТН");
                ids[i] = blrwbl.getId();
            }
        }
        return ids;
    }

    String getStartTime() throws ServiceException {
        String startTime = serviceSQLLite.getStartTime(PARSTARTTIME);
        if (startTime != null && !startTime.equals("null") && startTime.length() > 0) {
            //logger.debug("if start time NOT empty return startDate - " + startTime);
            return startTime;
        } else {
            //System.out.println("Calendar");
            Calendar calendar = Calendar.getInstance();
            //System.out.println("Current Hour in 12 hour format is : " + calendar.get(Calendar.HOUR));
            //System.out.println("Current Minute is : " + calendar.get(Calendar.AM_PM));
            calendar.get(Calendar.AM_PM);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DATE);
            int hour = calendar.get(Calendar.AM_PM) == 0 ? calendar.get(Calendar.HOUR) : calendar.get(Calendar.HOUR) + 12;
            int minut = calendar.get(Calendar.MINUTE);
            calendar.set(year, month, day, hour, minut-5, 0);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss");
            //logger.debug("if start time empty return calendar time " + dateFormat.format(date));
            startTime = dateFormat.format(date);
            return startTime;
        }
    }

    public String getTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss");
        return dateFormat.format(new Date());
    }

    public void updateStartTime(String newTime) throws ServiceException {
        serviceSQLLite.updateStartTime(PARSTARTTIME, newTime);
    }
}
