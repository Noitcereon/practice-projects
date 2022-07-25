package services;

import models.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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
                Integer hoursLeftInSubject = curriculumEntry.getValue();
                if (hoursLeftInSubject <= 0) continue;
                TimeRange nextEntryDuration = createTimeRangeForItineraryEntry(nextEntryStart, hoursLeftInSubject, HardcodedData.CreateCollectionOfWeekDays(), workHoursPerDay);

                int nextEntryDurationHours = nextEntryDuration.getHoursBetweenStartAndEnd();
                curriculumEntry.setValue(curriculumEntry.getValue() - nextEntryDurationHours);

                ScheduleItemInfo nextEntry;
                nextEntry = new ScheduleItemInfo(rooms.get(roomIndex).getId(), subject.getName(), teachersArray.get(teachersIndex), nextEntryDuration);


                nextEntryStart = nextEntryDuration.getStart().plusDays(1);
                roomIndex++;
                teachersIndex++;
                // Avoid IndexOutOfBounds error (next 2 lines)
                if (roomIndex >= rooms.size()) roomIndex = 0;
                if (teachersIndex >= teachersArray.size()) teachersIndex = 0;
//                System.out.println("Adding itinerary entry");
                itinerary.add(nextEntry);

                if (nextEntryDurationHours < workHoursPerDay) {
                    System.out.println("Simulating making edge-case entry");
                    Optional<Map.Entry<Subject, Integer>> subjectWithTimeLeftOptional = findSubjectWithTimeLeft(subjectsAndAssociatedHours);
                    if (subjectWithTimeLeftOptional.isPresent()) {
                        int timeLeftToFill = workHoursPerDay - nextEntryDurationHours;
                        nextEntry = createEntryToFillRemainingWorkday(subjectWithTimeLeftOptional.get(), nextEntryDuration, timeLeftToFill, teachersArray.get(teachersIndex), rooms.get(roomIndex).getId(), workHoursPerDay);
                        itinerary.add(nextEntry);
                    }
                }
                // TODO: Handle when workHoursPerDay is NOT added to the curriculum (in case the edge case handling does not have enough time to fill a work day)
                totalHoursInCurriculum -= workHoursPerDay;
            }
        }

        // Generate ScheduleItemInfo
        // If nextDate is a part of the weekdays
        // Use one of the subjects with time left (Extra: prioritise having subjects on the same day)
        // Fill day with subject
        // If subject hours allotted runs out, fill remaining with next subject or stop early if no hours left

        return new Timetable(itinerary);
    }

    private Optional<Map.Entry<Subject, Integer>> findSubjectWithTimeLeft(Map<Subject, Integer> subjectsAndAssociatedHours) {
        List<Map.Entry<Subject, Integer>> subjectsWithTimeLeft = subjectsAndAssociatedHours.entrySet()
                .stream().filter((curriculumEntry2) -> curriculumEntry2.getValue() > 0)
                .collect(Collectors.toList());

        if (subjectsWithTimeLeft.size() == 0) return Optional.empty();

        Map.Entry<Subject, Integer> subjectWithTimeLeft = subjectsWithTimeLeft.get(0);
        return Optional.of(subjectWithTimeLeft);
    }

    private ScheduleItemInfo createEntryToFillRemainingWorkday(Map.Entry<Subject, Integer> subjectWithTimeLeft, TimeRange previousEntryDuration, int hoursLeftToFill, IPerson host, String roomId, int workHoursPerDay) {
        if (subjectWithTimeLeft.getValue() >= hoursLeftToFill) {
            // Make a ScheduleItemInfo that fills the remaining time (workHoursPerDay - nextEntryDurationHours)
            TimeRange newEntryTimeRange = createTimeRangeForItineraryEntry(previousEntryDuration.getEnd().plusSeconds(1), hoursLeftToFill, HardcodedData.CreateCollectionOfWeekDays(), workHoursPerDay);
            ScheduleItemInfo newEntry = new ScheduleItemInfo(roomId, subjectWithTimeLeft.getKey().getName(), (Person) host, newEntryTimeRange);
            // TODO: subtract the new Entry's time used from timeLeftToFill

            return newEntry;
        }
        // This exception is here to show that something is wrong with the code, if this point is reached.
        throw new IllegalArgumentException("Failed to create entry, because subject with time left did not have sufficient time.");
    }

    /**
     * @param nextEntryStart The LocalDateTime on which this entry starts.
     * @param hoursLeft      The hours left in the curriculum for a specific subject.
     * @param daysToUse      The specific days of the week that should be used when making the itinerary.
     * @return A TimeRange of 6 hours
     */
    private TimeRange createTimeRangeForItineraryEntry(LocalDateTime nextEntryStart, Integer hoursLeft, Collection<DayOfWeek> daysToUse, int workHoursPerDay) {
        TimeRange nextEntryDuration;
        if (hoursLeft < workHoursPerDay) {
            nextEntryDuration = new TimeRange(nextEntryStart, nextEntryStart.plusHours(hoursLeft));
        } else {
            nextEntryDuration = new TimeRange(nextEntryStart, nextEntryStart.plusHours(workHoursPerDay));
        }
        if (!daysToUse.contains(nextEntryDuration.getStart().getDayOfWeek())) {
            nextEntryDuration = createTimeRangeForItineraryEntry(nextEntryDuration.getStart().plusDays(1), hoursLeft, daysToUse, workHoursPerDay);
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
