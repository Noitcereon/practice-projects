package services;

import enums.CustomDayOfWeek;

import java.util.Calendar;
import java.util.Date;

public class TimeHelper {

    // The 3 "timeUnit_InMs" variables are here to avoid double code in case of needing the value multiple times.
    private static final long dayInMs = 8640000;
    private static final long hourInMs = 360000;
    private static final long minuteInMs = 6000;

    public static long day() {
        return dayInMs;
    }

    public static long hour() {
        return hourInMs;
    }

    public static long minute() {
        return minuteInMs;
    }

    /**
     *
     * @param date A date.
     * @return The day of the week, the date holds.
     */
    public static CustomDayOfWeek getDayOfTheWeek(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int calendarDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        // The Calendar class's DAY_OF_WEEK starts on a Sunday. Thus, Sunday = 1, Monday = 2 etc.
        switch (calendarDayOfWeek){
            case 1: return CustomDayOfWeek.SUNDAY;
            case 2: return CustomDayOfWeek.MONDAY;
            case 3: return CustomDayOfWeek.TUESDAY;
            case 4: return CustomDayOfWeek.WEDNESDAY;
            case 5: return CustomDayOfWeek.THURSDAY;
            case 6: return CustomDayOfWeek.FRIDAY;
            case 7: return CustomDayOfWeek.SATURDAY;
            default:
                throw new IllegalArgumentException("Date does not have a valid DAY_OF_WEEK");
        }
    }
}
