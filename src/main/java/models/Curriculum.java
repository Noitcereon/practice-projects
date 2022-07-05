package models;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents the entire curriculum of a school. Note: Not thread safe
 */
public class Curriculum {
    // Integer = hours allocated to a specific subject
    private final Map<Subject, Integer> allotedTimePerSubject;
    private final TimeRange timePeriod;

    public Curriculum(TimeRange timePeriod){
        this.timePeriod = timePeriod;
        allotedTimePerSubject = new HashMap<>();
    }

    public Curriculum addSubject(Subject subject, int allotedHours){
        allotedTimePerSubject.putIfAbsent(subject, allotedHours);
        return this;
    }

    public Map<Subject, Integer> getAllotedTimePerSubject() {
        return allotedTimePerSubject;
    }

    public TimeRange getTimePeriod() {
        return timePeriod;
    }
}
