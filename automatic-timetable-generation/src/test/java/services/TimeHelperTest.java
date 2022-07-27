package services;

import enums.CustomDayOfWeek;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TimeHelperTest {

    private final Calendar calendar = Calendar.getInstance();
    @Test
    void dayInMs_IsCorrectMs() {
        long actual = TimeHelper.dayInMs();
        long expected = 86400000;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void hourInMs_IsCorrectMs() {
        long actual = TimeHelper.hourInMs();
        long expected = 3600000;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void minuteInMs_IsCorrectMs() {
        long actual = TimeHelper.minuteInMs();
        long expected = 60000;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenTheFirstDayOf2022_whenUsingTimeHelperToGetDayOfWeek_thenReturnSaturday() {
        Date date = TimeHelper.createDate(2022, 1, 1, 0, 0);
        CustomDayOfWeek expected = CustomDayOfWeek.SATURDAY;
        CustomDayOfWeek actual = TimeHelper.getDayOfTheWeek(date);
        assertEquals(expected, actual);
    }

    @Test
    void givenAYearMonthHourAndMinute_whenCreatingDateWithTimeHelper_thenADateIsCreatedWithGivenValues() {
        int expectedYear = 2000;
        int expectedMonth = 1;
        int expectedDayOfMonth = 24;
        int expectedHourOfDay = 9;
        int expectedMinute = 3;
        Date date = TimeHelper.createDate(expectedYear, expectedMonth, expectedDayOfMonth, expectedHourOfDay, expectedMinute);
        calendar.setTime(date);
        int actualMonth = calendar.get(Calendar.MONTH)+1; // +1 because Calendar months starts from 0.
        Assertions.assertEquals(expectedYear, calendar.get(Calendar.YEAR));
        Assertions.assertEquals(expectedMonth, actualMonth);
        Assertions.assertEquals(expectedDayOfMonth, calendar.get(Calendar.DAY_OF_MONTH));
        Assertions.assertEquals(expectedHourOfDay, calendar.get(Calendar.HOUR_OF_DAY));
        Assertions.assertEquals(expectedMinute, calendar.get(Calendar.MINUTE));

    }

    @Test
    void givenADate_whenUsingTimeHelperToAddYearToDate_thenItAddsOnYear() {
        Date date = TimeHelper.createDate(2000, 12, 31, 22, 0);
        int expectedYear = 2001;
        Date dateOneYearLater = TimeHelper.addYearsToDate(date, 1);
        calendar.setTime(dateOneYearLater);
        int actualYear = calendar.get(Calendar.YEAR);
        Assertions.assertEquals(expectedYear, actualYear);
    }

    @Test
    void givenADate_whenUsingTimeHelperToAddMonthToDate_thenItAddsOneMonth() {
        Date date = TimeHelper.createDate(2000, 12, 31, 22, 0);
        int expected = 0; // 0 = JANUARY in Calendar
        Date dateOneMonthLater = TimeHelper.addMonthsToDate(date, 1);
        calendar.setTime(dateOneMonthLater);
        int actual = calendar.get(Calendar.MONTH);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenADate_whenUsingTimeHelperToAddDayToDate_thenItAddsOneDay() {
        Date date = TimeHelper.createDate(2000, 12, 2, 22, 0);
        int expected = 3;
        Date dateOneDayLater = TimeHelper.addDaysToDate(date, 1);
        calendar.setTime(dateOneDayLater);
        int actual = calendar.get(Calendar.DAY_OF_MONTH);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenADate_whenUsingTimeHelperToAddHourToDate_thenItAddsOneHour() {
        Date date = TimeHelper.createDate(2000, 12, 2, 16, 0);
        int expected = 17;
        Date dateOneHourLater = TimeHelper.addHoursToDate(date, 1);
        calendar.setTime(dateOneHourLater);
        int actual = calendar.get(Calendar.HOUR_OF_DAY);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenADate_whenUsingTimeHelperToAddMinuteToDate_thenItAddsOneMinute() {
        Date date = TimeHelper.createDate(2000, 12, 2, 16, 5);
        int expected = 6;
        Date dateOneMinuteLater = TimeHelper.addMinutesToDate(date, 1);
        calendar.setTime(dateOneMinuteLater);
        int actual = calendar.get(Calendar.MINUTE);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void givenADate_whenUsingTimeHelperToAddSecondToDate_thenItAddsOneSecond() {
        Date date = TimeHelper.createDate(2000, 12, 2, 16, 5);
        calendar.setTime(date);
        int expected = calendar.get(Calendar.SECOND)+1;
        Date dateOneSecondLater = TimeHelper.addSecondsToDate(date, 1);
        calendar.setTime(dateOneSecondLater);
        int actual = calendar.get(Calendar.SECOND);
        Assertions.assertEquals(expected, actual);
    }
}