package models;

import enums.CustomDayOfWeek;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;


public class TimeRange {
    private final long dayInMs = 8640000;
    private final long hourInMs = 360000;
    private final long minuteInMs = 6000;
    private Date start;
    private Date end;

    public TimeRange(Date start, Date end){
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
//        return "TimeSlot{" +
//                "start=" + start.format(DateTimeFormatter.ofPattern("dd-MM-yyyy EEEE HH:mm")) +
//                ", end=" + end.format(DateTimeFormatter.ofPattern("dd-MM-yyyy EEEE HH:mm")) +
//                '}';
        return super.toString();
    }

    public int getHoursBetweenStartAndEnd(){
        long epochSecondsBetweenStartAndEnd = end.getTime() - start.getTime();
        int hoursBetweenStartAndEnd = (int)Math.floor((epochSecondsBetweenStartAndEnd / 60.0 / 60.0));
        return hoursBetweenStartAndEnd;
    }
    public int getHoursBetweenStartAndEnd(Collection<CustomDayOfWeek> daysToUse, int hoursUsedPerDay){
        Date dateBetweenStartAndEnd = start;
        int totalHoursToRemove = calculateHoursToRemove(daysToUse, hoursUsedPerDay, dateBetweenStartAndEnd);

        long epochSecondsBetweenStartAndEnd = end.getTime() - start.getTime();
        int hoursBetweenStartAndEnd = (int)Math.floor((epochSecondsBetweenStartAndEnd / 60.0 / 60.0));
        int correctedHoursBetweenStartAndEnd = hoursBetweenStartAndEnd - totalHoursToRemove;
        return correctedHoursBetweenStartAndEnd;
    }

    private int calculateHoursToRemove(Collection<CustomDayOfWeek> daysToUse, int hoursUsedPerDay, Date dateBetweenStartAndEnd) {
        if(hoursUsedPerDay > 24) throw new IllegalArgumentException("hoursUsedPerDay cannot exceed 24.");
        int hoursToRemoveFromWorkDay = 24 - hoursUsedPerDay;
        int totalHoursToRemove = 0;
        while(dateBetweenStartAndEnd.before(end)){
            if(daysToUse.contains(getDayOfTheWeek(dateBetweenStartAndEnd))){
                totalHoursToRemove += hoursToRemoveFromWorkDay;
            }
            else{
                totalHoursToRemove += 24;
            }
            dateBetweenStartAndEnd.setTime(dateBetweenStartAndEnd.getTime() + dayInMs);
        }
        return totalHoursToRemove;
    }

    /**
     *
     * @param date A date.
     * @return The day of the week, the date holds.
     */
    private CustomDayOfWeek getDayOfTheWeek(Date date){
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
