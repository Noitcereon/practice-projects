package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

class TimeRangeTest {


    private static Collection<DayOfWeek> weekDays;

    @BeforeAll
    public static void setup(){
        weekDays = new ArrayList<>();
        weekDays.add(DayOfWeek.MONDAY);
        weekDays.add(DayOfWeek.TUESDAY);
        weekDays.add(DayOfWeek.WEDNESDAY);
        weekDays.add(DayOfWeek.THURSDAY);
        weekDays.add(DayOfWeek.FRIDAY);
    }

    @Test
    void givenStartAndEndDateOneDayFromEachOther_whenGettingHoursBetweenStartAndEnd_thenReturn24Hours() {
        LocalDateTime firstDayOf2022 = LocalDateTime.of(2022, 1, 1, 0, 0);
        LocalDateTime secondDayOf2022 = firstDayOf2022.plusDays(1);
        int expectedHours = 24;
        TimeRange timeRange = new TimeRange(firstDayOf2022, secondDayOf2022);

        int actualHours = timeRange.getHoursBetweenStartAndEnd();

        Assertions.assertEquals(expectedHours, actualHours);
    }
    @Test
    void givenStartAndEndDateOneWeekFromEachOtherWithRestrictions_whenGettingHoursBetweenStartAndEnd_thenReturn30Hours() {
        LocalDateTime firstDayOf2022 = LocalDateTime.of(2022, 1, 1, 0, 0);
        LocalDateTime eighthDayOf2022 = firstDayOf2022.plusDays(7);
        int expectedHours = 30;
        int hoursUsedPerDay = 6;
        TimeRange timeRange = new TimeRange(firstDayOf2022, eighthDayOf2022);

        int actualHours = timeRange.getHoursBetweenStartAndEnd(weekDays, hoursUsedPerDay);

        Assertions.assertEquals(expectedHours, actualHours);
    }
}