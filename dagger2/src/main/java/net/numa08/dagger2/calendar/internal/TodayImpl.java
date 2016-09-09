package net.numa08.dagger2.calendar.internal;

import net.numa08.dagger2.calendar.Today;

import java.util.Calendar;
import java.util.Date;

public class TodayImpl implements Today {
    @Override
    public int getHour() {
        final Date today = new Date();
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        return calendar.get(Calendar.HOUR);
    }
}
