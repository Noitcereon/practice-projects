package services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeHelperTest {

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
    void getDayOfTheWeek() {
        Assertions.fail();
    }

    @Test
    void createDate() {
        Assertions.fail();
    }

    @Test
    void addYearsToDate() {
        Assertions.fail();
    }

    @Test
    void addMonthsToDate() {
        Assertions.fail();
    }

    @Test
    void addDaysToDate() {
        Assertions.fail();
    }

    @Test
    void addHoursToDate() {
        Assertions.fail();
    }

    @Test
    void addMinutesToDate() {
        Assertions.fail();
    }

    @Test
    void addSecondsToDate() {
        Assertions.fail();
    }
}