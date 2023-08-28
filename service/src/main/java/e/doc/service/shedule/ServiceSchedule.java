package e.doc.service.shedule;

import e.doc.service.Service;
import e.doc.service.ServiceImpl;
import e.doc.service.ServiceUtils;
import e.doc.service.config.PropertiesImpl;
import e.doc.service.config.PropertyE;
import e.doc.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class ServiceSchedule {
    private static Logger logger = LogManager.getLogger(ServiceSchedule.class);
    Properties properties = getApplicationProperty(PropertyE.APP);
    int startTimeH = Integer.parseInt(properties.getProperty("schedule.start.time.hours"));
    int startTimeM = Integer.parseInt(properties.getProperty("schedule.start.time.minutes"));
    int finishTimeH = Integer.parseInt(properties.getProperty("schedule.finish.time.hours"));
    int finishTimeM = Integer.parseInt(properties.getProperty("schedule.finish.time.minutes"));

    public ServiceSchedule() throws ServiceException {
    }

    public boolean checkSchedule() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.AM_PM) == 0 ? calendar.get(Calendar.HOUR) : calendar.get(Calendar.HOUR) + 12;
        int minut = calendar.get(Calendar.MINUTE);
        double startTime = startTimeH + startTimeM / 60d;
        double finishTime = finishTimeH + finishTimeM / 60d;
        double nowTime = hour + (minut / 60d);
        //logger.debug("Scheduler parameter - startTime: " + startTime + " finishTime: " + finishTime + " minut / 60: " + minut / 60d);
        //logger.debug("Scheduler parameter - hour: " + hour + " minut: " + minut + " nowTime: " + nowTime);
        if (nowTime > startTime && nowTime < finishTime)
            return true;
        else
            return false;
    }
    Properties getApplicationProperty(PropertyE p) {
        return new PropertiesImpl().getProperty(p);
    }
}
