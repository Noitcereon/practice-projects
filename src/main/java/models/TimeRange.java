package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
                "start=" + start.format(DateTimeFormatter.ofPattern("EEEE HH:mm")) +
                ", end=" + end.format(DateTimeFormatter.ofPattern("EEEE HH:mm")) +
                '}';
    }
}
