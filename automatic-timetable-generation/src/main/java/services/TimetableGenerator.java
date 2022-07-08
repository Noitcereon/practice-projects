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
     * @param curriculum The subjects taught, allotted time per subject & the time period the generator has available.
     * @return A <code>Timetable</code>
     */
    public Timetable generateTimetable(School school, Set<Teacher> teachers, Curriculum curriculum) {
        TimeRange timetableDateRange = curriculum.getTimePeriod();
        Collection<ScheduleItemInfo> itinerary = new ArrayList<>();
        int workHoursPerDay = 6;
        Map<Subject, Integer> subjectsAndAssociatedHours = curriculum.getAllotedTimePerSubject();
        int totalHoursInCurriculum = subjectsAndAssociatedHours.values().stream().mapToInt(hoursAllottedToSubject -> hoursAllottedToSubject).sum();
        int totalHoursAvailable = timetableDateRange.getHoursBetweenStartAndEnd(HardcodedData.CreateCollectionOfWeekDays(), workHoursPerDay);
        if (totalHoursInCurriculum > totalHoursAvailable)
            throw new IllegalArgumentException("Insufficient time available. " + String.format("Hours available: %s Hours in Curriculum: %s", totalHoursAvailable, totalHoursInCurriculum));

        int teachersIndex = 0;
        int roomIndex = 0;
        ArrayList<Room> rooms = new ArrayList<>(school.getRooms());
        ArrayList<Teacher> teachersArray = new ArrayList<>(teachers);
        LocalDateTime nextEntryStart = timetableDateRange.getStart();
        // Generate itinerary
        while (totalHoursInCurriculum > 0) {
            // While there are hours left in any subject

            for (Map.Entry<Subject, Integer> curriculumEntry : subjectsAndAssociatedHours.entrySet()) {
                Subject subject = curriculumEntry.getKey();
                Integer hoursLeft = curriculumEntry.getValue();
                if (hoursLeft <= 0) continue;
                TimeRange nextEntryDuration = createTimeRange(nextEntryStart, hoursLeft, HardcodedData.CreateCollectionOfWeekDays(), workHoursPerDay);

                int nextEntryDurationHours = nextEntryDuration.getHoursBetweenStartAndEnd();
                if(nextEntryDurationHours < workHoursPerDay){
                    // TODO: Use different subject for remaining time period (make method that does this)
                    System.out.println("Simulating making edge-case entry");
                }
                ScheduleItemInfo nextEntry;
                nextEntry = new ScheduleItemInfo(rooms.get(roomIndex).getId(), subject.getName(), teachersArray.get(teachersIndex), nextEntryDuration);
                roomIndex++;
                teachersIndex++;
                nextEntryStart = nextEntryDuration.getStart().plusDays(1);
                // Avoid IndexOutOfBounds error (next 2 lines)
                if(roomIndex >= rooms.size()) roomIndex = 0;
                if(teachersIndex >= teachersArray.size()) teachersIndex = 0;
                System.out.println("Adding itinerary entry");
                itinerary.add(nextEntry);
                totalHoursInCurriculum -= 6;
                curriculumEntry.setValue(curriculumEntry.getValue()-nextEntryDurationHours);
            }
        }

        // Generate ScheduleItemInfo
        // If nextDate is a part of the weekdays
        // Use one of the subjects with time left (Extra: prioritise having subjects on the same day)
        // Fill day with subject
        // If subject hours allotted runs out, fill remaining with next subject or stop early if no hours left

        return new Timetable(itinerary);
    }

    /**
     *
     * @param nextEntryStart The LocalDateTime on which this entry starts.
     * @param hoursLeft The hours left in the curriculum for a specific subject.
     * @param daysToUse The specific days of the week that should be used when making the itinerary.
     * @return A TimeRange of 6 hours
     */
    private TimeRange createTimeRange(LocalDateTime nextEntryStart, Integer hoursLeft, Collection<DayOfWeek> daysToUse, int workHoursPerDay) {
        TimeRange nextEntryDuration;
        if(hoursLeft < workHoursPerDay){
            nextEntryDuration = new TimeRange(nextEntryStart, nextEntryStart.plusHours(hoursLeft));
        }else{
             nextEntryDuration = new TimeRange(nextEntryStart, nextEntryStart.plusHours(6));
        }
        if(!daysToUse.contains(nextEntryDuration.getStart().getDayOfWeek())) {
            nextEntryDuration = createTimeRange(nextEntryDuration.getStart().plusDays(1), hoursLeft, daysToUse, workHoursPerDay);
        }
        return nextEntryDuration;
    }

    /**
     * Generates a timetable with an itinerary. Defaults to hoursPerDay = 6
     *
     * @param school     A representation of a school, which contains rooms to use in timetable generation.
     * @param teachers   The teachers to be used in the itinerary.
     * @param curriculum The subjects taught, allotted time per subject & the time period the generator has available.
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
     * @param curriculum  The subjects taught, allotted time per subject & the time period the generator has available.
     * @param daysToUse   The days of the week used when generating the itinerary of the timetable.
     * @param hoursPerDay The amount of hours used per day in the itinerary.
     * @return A <code>Timetable</code>
     */
    public Timetable generateTimetable(School school, Set<Teacher> teachers, Curriculum curriculum, Collection<DayOfWeek> daysToUse, int hoursPerDay) {
        // TODO: implement TimetableGenerator
        throw new NotImplementedException();
    }
}
