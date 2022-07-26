package models;

import enums.CustomDayOfWeek;
import services.TimeHelper;

import java.util.Collection;
import java.util.Date;


public class TimeRange {

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
            if(daysToUse.contains(TimeHelper.getDayOfTheWeek(dateBetweenStartAndEnd))){
                totalHoursToRemove += hoursToRemoveFromWorkDay;
            }
            else{
                totalHoursToRemove += 24;
            }
            dateBetweenStartAndEnd.setTime(dateBetweenStartAndEnd.getTime() + TimeHelper.dayInMs());
        }
        return totalHoursToRemove;
    }


}
