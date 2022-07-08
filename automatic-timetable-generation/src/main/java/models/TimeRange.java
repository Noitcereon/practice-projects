package models;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class TimeRange {
    private LocalDateTime start;
    private LocalDateTime end;

    public TimeRange(LocalDateTime start, LocalDateTime end){
        this.start = start;
        this.end = end;
    }

    public LocalDateTime getStart() {
        return start;
    }
    public void setStart(LocalDateTime start) {
        this.start = start;
    }
    public LocalDateTime getEnd() {
        return end;
    }
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "start=" + start.format(DateTimeFormatter.ofPattern("dd-MM-yyyy EEEE HH:mm")) +
                ", end=" + end.format(DateTimeFormatter.ofPattern("dd-MM-yyyy EEEE HH:mm")) +
                '}';
    }

    public int getHoursBetweenStartAndEnd(){
        long epochSecondsBetweenStartAndEnd = end.toEpochSecond(ZoneOffset.UTC) - start.toEpochSecond(ZoneOffset.UTC);
        int hoursBetweenStartAndEnd = (int)Math.floor((epochSecondsBetweenStartAndEnd / 60.0 / 60.0));
        return hoursBetweenStartAndEnd;
    }
    public int getHoursBetweenStartAndEnd(Collection<DayOfWeek> daysToUse, int hoursUsedPerDay){
        LocalDateTime dateBetweenStartAndEnd = start;
        int totalHoursToRemove = calculateHoursToRemove(daysToUse, hoursUsedPerDay, dateBetweenStartAndEnd);

        long epochSecondsBetweenStartAndEnd = end.toEpochSecond(ZoneOffset.UTC) - start.toEpochSecond(ZoneOffset.UTC);
        int hoursBetweenStartAndEnd = (int)Math.floor((epochSecondsBetweenStartAndEnd / 60.0 / 60.0));
        int correctedHoursBetweenStartAndEnd = hoursBetweenStartAndEnd - totalHoursToRemove;
        return correctedHoursBetweenStartAndEnd;
    }

    private int calculateHoursToRemove(Collection<DayOfWeek> daysToUse, int hoursUsedPerDay, LocalDateTime dateBetweenStartAndEnd) {
        if(hoursUsedPerDay > 24) throw new IllegalArgumentException("hoursUsedPerDay cannot exceed 24.");
        int hoursToRemoveFromWorkDay = 24 - hoursUsedPerDay;
        int totalHoursToRemove = 0;
        while(dateBetweenStartAndEnd.isBefore(end)){
            if(daysToUse.contains(dateBetweenStartAndEnd.getDayOfWeek())){
                totalHoursToRemove += hoursToRemoveFromWorkDay;
            }
            else{
                totalHoursToRemove += 24;
            }
            dateBetweenStartAndEnd = dateBetweenStartAndEnd.plusDays(1);
        }
        return totalHoursToRemove;
    }
}
