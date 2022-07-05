package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TimeRangeTest {

    @Test
    void givenStartAndEndDateOneDayFromEachOther_whenGettingHoursBetweenStartAndEnd_thenReturn24Hours() {
        LocalDateTime firstDayOf2022 = LocalDateTime.of(2022, 1, 1, 0, 0);
        LocalDateTime secondDayOf2022 = firstDayOf2022.plusDays(1);
        int expectedHours = 24;
        TimeRange timeRange = new TimeRange(firstDayOf2022, secondDayOf2022);

        int actualHours = timeRange.getHoursBetweenStartAndEnd();

        Assertions.assertEquals(expectedHours, actualHours);
    }
}