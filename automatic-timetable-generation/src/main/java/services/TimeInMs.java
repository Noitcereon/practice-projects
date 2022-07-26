package services;

public class TimeInMs {
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
}
