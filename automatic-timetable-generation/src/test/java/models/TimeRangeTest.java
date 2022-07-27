package models;

import enums.CustomDayOfWeek;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import services.TimeHelper;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

class TimeRangeTest {
    private static Collection<CustomDayOfWeek> weekDays;

    @BeforeAll
    public static void setup() {
        weekDays = new ArrayList<>();
        weekDays.add(CustomDayOfWeek.MONDAY);
        weekDays.add(CustomDayOfWeek.TUESDAY);
        weekDays.add(CustomDayOfWeek.WEDNESDAY);
        weekDays.add(CustomDayOfWeek.THURSDAY);
        weekDays.add(CustomDayOfWeek.FRIDAY);
    }

    @Test
    void givenStartAndEndDateOneDayFromEachOther_whenGettingHoursBetweenStartAndEnd_thenReturn24Hours() {
        Date firstDayOf2022 = TimeHelper.createDate(2022, 1, 1, 0, 0);
        Date secondDayOf2022 = new Date(firstDayOf2022.getTime() + TimeHelper.dayInMs());
        int expectedHours = 24;
        TimeRange timeRange = new TimeRange(firstDayOf2022, secondDayOf2022);

        int actualHours = timeRange.getHoursBetweenStartAndEnd();

        Assertions.assertEquals(expectedHours, actualHours);
    }

    @Test
    void givenStartAndEndDateOneWeekFromEachOtherWithRestrictions_whenGettingHoursBetweenStartAndEnd_thenReturn30Hours() {
        Date firstDayOf2022 = TimeHelper.createDate(2022, 1, 1, 0, 0);
        Date eighthDayOf2022 = new Date(firstDayOf2022.getTime() + TimeHelper.dayInMs() * 7);
        int expectedHours = 30;
        int hoursUsedPerDay = 6;
        TimeRange timeRange = new TimeRange(firstDayOf2022, eighthDayOf2022);

        int actualHours = timeRange.getHoursBetweenStartAndEnd(weekDays, hoursUsedPerDay);

        Assertions.assertEquals(expectedHours, actualHours);
    }

    @Test
    void givenStartAndEndDateOneYearFromEachOtherWithRestrictions_whenGettingHoursBetweenStartAndEnd_thenReturn30Hours() {
        Date firstDayOf2022 = TimeHelper.createDate(2022, 1, 1, 0, 0);
        Date firstDayOf2023 = TimeHelper.addYearsToDate(firstDayOf2022, 1);
        int weeksInAYear = 52;
        int hoursInAWeek = 30;
        int expectedHours = hoursInAWeek * weeksInAYear;
        int hoursUsedPerDay = 6;
        TimeRange timeRange = new TimeRange(firstDayOf2022, firstDayOf2023);

        int actualHours = timeRange.getHoursBetweenStartAndEnd(weekDays, hoursUsedPerDay);

        Assertions.assertEquals(expectedHours, actualHours);
    }

    @Test
    void givenStartAndEndDateTwoYearsFromEachOtherWithRestrictions_whenGettingHoursBetweenStartAndEnd_thenCompleteWithin300ms() {
        Date firstDayOf2022 = TimeHelper.createDate(2022, 1, 1, 0, 0);
        Date twoYearsAfterFirstDayOf2022 = TimeHelper.addYearsToDate(firstDayOf2022, 2);
        int hoursUsedPerDay = 6;
        int maxTimeTakenMs = 300;
        double nanoSecondsPerMs = 1000000.0;
        TimeRange timeRange = new TimeRange(firstDayOf2022, twoYearsAfterFirstDayOf2022);

        long startTime = System.nanoTime();
        timeRange.getHoursBetweenStartAndEnd(weekDays, hoursUsedPerDay);
        long endTime = System.nanoTime();
        int timeTakenMs = (int) Math.floor((endTime - startTime) / nanoSecondsPerMs);

        Assertions.assertTrue(maxTimeTakenMs > timeTakenMs);
    }
}