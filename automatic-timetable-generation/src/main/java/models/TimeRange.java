package models;

import enums.CustomDayOfWeek;
import services.TimeHelper;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;


public class TimeRange {

    private Date start;
    private Date end;

    public TimeRange(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "TimeRange{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public int getHoursBetweenStartAndEnd() {
        BigInteger epochMsBetweenStartAndEnd = BigInteger.valueOf(end.getTime() - start.getTime());
        BigInteger epochSecondsBetweenStartAndEnd = epochMsBetweenStartAndEnd.divide(BigInteger.valueOf(1000));
        // epochSecondsBetweenStartAndEnd / 60.0 / 60.0
        BigInteger epochSecondsBetweenStartAndEndAsHours = epochSecondsBetweenStartAndEnd.divide(BigInteger.valueOf(60)).divide(BigInteger.valueOf(60));
        int hoursBetweenStartAndEnd = (int) Math.floor(epochSecondsBetweenStartAndEndAsHours.intValue());
        return hoursBetweenStartAndEnd;
    }

    public int getHoursBetweenStartAndEnd(Collection<CustomDayOfWeek> daysToUse, int hoursUsedPerDay) {
        Date dateThatWillBeModifiedByReference = new Date(this.start.getTime());
        int totalHoursToRemove = calculateHoursToRemove(daysToUse, hoursUsedPerDay, dateThatWillBeModifiedByReference);

        int hoursBetweenStartAndEnd = getHoursBetweenStartAndEnd();
        int correctedHoursBetweenStartAndEnd = hoursBetweenStartAndEnd - totalHoursToRemove;
        return correctedHoursBetweenStartAndEnd;
    }

    private int calculateHoursToRemove(Collection<CustomDayOfWeek> daysToUse, int hoursUsedPerDay, Date dateBetweenStartAndEnd) {
        if (hoursUsedPerDay > 24) throw new IllegalArgumentException("hoursUsedPerDay cannot exceed 24.");
        int hoursToRemoveFromWorkDay = 24 - hoursUsedPerDay;
        int totalHoursToRemove = 0;
        while (dateBetweenStartAndEnd.before(end)) {
            if (daysToUse.contains(TimeHelper.getDayOfTheWeek(dateBetweenStartAndEnd))) {
                totalHoursToRemove += hoursToRemoveFromWorkDay;
            } else {
                totalHoursToRemove += 24;
            }
            dateBetweenStartAndEnd.setTime(dateBetweenStartAndEnd.getTime() + TimeHelper.dayInMs());
        }
        return totalHoursToRemove;
    }


}
