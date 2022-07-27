package services;

import enums.CustomDayOfWeek;

import java.util.Calendar;
import java.util.Date;

public class TimeHelper {

    // The 3 "timeUnit_InMs" variables are here to avoid double code in case of needing the value multiple times.
    private static final long dayInMs = 86400000;
    private static final long hourInMs = 360000;
    private static final long minuteInMs = 6000;

    public static long dayInMs() {
        return dayInMs;
    }

    public static long hourInMs() {
        return hourInMs;
    }

    public static long minuteInMs() {
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
    public static Date createDate(int year, int month, int dayOfMonth, int hourOfDay, int minute){
        Calendar calendar = Calendar.getInstance();
        if(month > 12) throw new IllegalArgumentException("Month invalid. Select month between 1-12");
        if(month == 0) throw new IllegalArgumentException("Month invalid. Select month between 1-12");
        int calendarMonth;
        switch (month){
            case 1: calendarMonth = Calendar.JANUARY; break;
            case 2: calendarMonth = Calendar.FEBRUARY; break;
            case 3: calendarMonth = Calendar.MARCH; break;
            case 4: calendarMonth = Calendar.APRIL; break;
            case 5: calendarMonth = Calendar.MAY; break;
            case 6: calendarMonth = Calendar.JUNE; break;
            case 7: calendarMonth = Calendar.JULY; break;
            case 8: calendarMonth = Calendar.AUGUST;break;
            case 9: calendarMonth = Calendar.SEPTEMBER; break;
            case 10: calendarMonth = Calendar.OCTOBER; break;
            case 11: calendarMonth = Calendar.NOVEMBER; break;
            case 12: calendarMonth = Calendar.DECEMBER; break;
            default:
                try {
                    throw new Exception("Something went wrong in TimeHelper.createDate()");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        }

        calendar.set(year, calendarMonth, dayOfMonth, hourOfDay, minute);
        Date output = calendar.getTime();
        return output;
    }
    public static Date addYearsToDate(Date date, int years){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years);
        return cal.getTime();
    }
    public static Date addMonthsToDate(Date date, int months){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }
    public static Date addDaysToDate(Date date, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, days);
        return cal.getTime();
    }
    public static Date addHoursToDate(Date date, int hours){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hours);
        return cal.getTime();
    }
    public static Date addMinutesToDate(Date date, int minutes){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minutes);
        return cal.getTime();
    }
    public static Date addSecondsToDate(Date date, int seconds){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, seconds);
        return cal.getTime();
    }
}
