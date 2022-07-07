package services;

import models.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.*;

public class TimetableGenerator {
    /**
     * Generates a timetable with an itinerary. Defaults to monday-friday, 6 hours a day.
     *
     * @param school     A representation of a school, which contains rooms to use in timetable generation.
     * @param teachers   The teachers to be used in the itinerary.
     * @param curriculum The subjects taught, allotted time per subject &
     * @return A <code>Timetable</code>
     */
    public Timetable generateTimetable(School school, Set<Teacher> teachers, Curriculum curriculum) {
        // Retrieve lessons that need to be scheduled (required no. of hours, name)
        TimeRange timetableDateRange = curriculum.getTimePeriod();
        Collection<ScheduleItemInfo> itinerary = new HashSet<>();
        int totalHoursInCurriculum = curriculum.getAllotedTimePerSubject().values().stream().mapToInt(hoursAllottedToSubject -> hoursAllottedToSubject).sum();

        int totalHoursAvailable = timetableDateRange.getHoursBetweenStartAndEnd(); // Invalid.


        if(totalHoursInCurriculum > totalHoursAvailable) throw new IllegalArgumentException("Insufficient time available");
        int hoursPerDay = 6;

        // Generate itinerary
        return new Timetable(itinerary);
    }

    /**
     * Generates a timetable with an itinerary. Defaults to hoursPerDay = 6
     *
     * @param school     A representation of a school, which contains rooms to use in timetable generation.
     * @param teachers   The teachers to be used in the itinerary.
     * @param curriculum The subjects taught, allotted time per subject &
     * @param daysToUse  The days of the week used when generating the itinerary of the timetable.
     * @return A <code>Timetable</code>
     */
    public Timetable generateTimetable(School school, Set<Teacher> teachers, Curriculum curriculum, Collection<DayOfWeek> daysToUse) {
        // TODO: implement TimetableGenerator
        throw new NotImplementedException();
    }

    /**
     * Generates a timetable, which contains an itinerary with configurable daysToUse & hoursPerDay
     *
     * @param school      A representation of a school, which contains rooms to use in timetable generation.
     * @param teachers    The teachers to be used in the itinerary.
     * @param curriculum  The subjects taught, allotted time per subject &
     * @param daysToUse   The days of the week used when generating the itinerary of the timetable.
     * @param hoursPerDay The amount of hours used per day in the itinerary.
     * @return A <code>Timetable</code>
     */
    public Timetable generateTimetable(School school, Set<Teacher> teachers, Curriculum curriculum, Collection<DayOfWeek> daysToUse, int hoursPerDay) {
        // TODO: implement TimetableGenerator
        throw new NotImplementedException();
    }
}
