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
        int[] ids = new int[jsonBLRWBLS.length];
        for (int i = 0; i <= jsonBLRWBLS.length - 1; i++) {
            JsonBLRWBL blrwbl = jsonBLRWBLS[i];
            System.out.println("blrwbl.toString()" + blrwbl.toString());
            if (blrwbl.getDocumentType().equals("ТТН")) {
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
            calendar.set(year, month, day, hour-1, minut-30, 0);
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
