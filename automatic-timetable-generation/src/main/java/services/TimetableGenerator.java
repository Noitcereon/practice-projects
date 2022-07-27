package services;

import enums.CustomDayOfWeek;
import models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class TimetableGenerator {

    private final Logger logger = LoggerFactory.getLogger(TimetableGenerator.class);

    /**
     * Generates a timetable with an itinerary. Defaults to monday-friday, 6 hours a day.
     *
     * @param school     A representation of a school, which contains rooms to use in timetable generation.
     * @param teachers   The teachers to be used in the itinerary.
     * @param curriculum The subjects taught, allotted time per subject & the time period the generator has available.
     * @return A <code>Timetable</code>
     */
    public Timetable generateTimetable(School school, Set<Teacher> teachers, Curriculum curriculum) {
        logger.info("Generating timetable");
        TimeRange timetableDateRange = curriculum.getTimePeriod();
        Collection<ScheduleItemInfo> itinerary = new ArrayList<>();
        int workHoursPerDay = 6;
        Map<Subject, Integer> subjectsAndAssociatedHours = curriculum.getAllotedTimePerSubject();
        int totalHoursInCurriculum = 0;
        for (Integer hoursAllottedToSubject : subjectsAndAssociatedHours.values()) {
            int allottedToSubject = hoursAllottedToSubject;
            totalHoursInCurriculum += allottedToSubject;
        }
        int totalHoursAvailable = timetableDateRange.getHoursBetweenStartAndEnd(HardcodedData.CreateCollectionOfWeekDays(), workHoursPerDay);
        if (totalHoursInCurriculum > totalHoursAvailable) {
            logger.error("IllegalArgumentException was thrown: insufficient time available.");
            throw new IllegalArgumentException("Insufficient time available. " + String.format("Hours available: %s Hours in Curriculum: %s", totalHoursAvailable, totalHoursInCurriculum));
        }

        int teachersIndex = 0;
        int roomIndex = 0;
        ArrayList<Room> rooms = new ArrayList<>(school.getRooms());
        ArrayList<Teacher> teachersArray = new ArrayList<>(teachers);
        Date nextEntryStart = timetableDateRange.getStart();
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


                nextEntryStart = new Date(nextEntryDuration.getStart().getTime() + TimeHelper.dayInMs());
                roomIndex++;
                teachersIndex++;
                // Avoid IndexOutOfBounds error (next 2 lines)
                if (roomIndex >= rooms.size()) roomIndex = 0;
                if (teachersIndex >= teachersArray.size()) teachersIndex = 0;
                itinerary.add(nextEntry);

                if (nextEntryDurationHours < workHoursPerDay) {
                    logger.debug("Handling edge-case part 1: {}", nextEntry);
                    // Handle edge case, where a subject does not have enough time to fill a work day.
                    Map.Entry<Subject, Integer> subjectWithTimeLeft = findSubjectWithTimeLeft(subjectsAndAssociatedHours);
                    if (subjectWithTimeLeft != null) {
                        int timeLeftToFill = workHoursPerDay - nextEntryDurationHours;
                        nextEntry = createEntryToFillRemainingWorkday(subjectWithTimeLeft, nextEntryDuration, timeLeftToFill, teachersArray.get(teachersIndex), rooms.get(roomIndex).getId(), workHoursPerDay);
                        logger.debug("Handling edge-case part 2:  {}", nextEntry);
                        itinerary.add(nextEntry);
                    }
                }
                // workHoursPerDay is not necessarily added to the itinerary (edge-case), but in most cases it is.
                totalHoursInCurriculum -= workHoursPerDay;
            }
        }

        // TODO (extra): prioritise having subjects on the same day, so it is predictable)

        logger.info("Timetable has been generated.");
        return new Timetable(itinerary);
    }

    private Map.Entry<Subject, Integer> findSubjectWithTimeLeft(Map<Subject, Integer> subjectsAndAssociatedHours) {
        List<Map.Entry<Subject, Integer>> subjectsWithTimeLeft = new ArrayList<>();
        for (Map.Entry<Subject, Integer> entry : subjectsAndAssociatedHours.entrySet()) {
            if (entry.getValue() > 0) {
                subjectsWithTimeLeft.add(entry);
            }
        }

        if (subjectsWithTimeLeft.size() == 0) return null;

        Map.Entry<Subject, Integer> subjectWithTimeLeft = subjectsWithTimeLeft.get(0);
        return subjectWithTimeLeft;
    }

    private ScheduleItemInfo createEntryToFillRemainingWorkday(Map.Entry<Subject, Integer> subjectWithTimeLeft, TimeRange previousEntryDuration, int hoursLeftToFill, IPerson host, String roomId, int workHoursPerDay) {
        TimeRange newEntryTimeRange;
        ScheduleItemInfo newEntry;
        if (subjectWithTimeLeft.getValue() >= hoursLeftToFill) {
            // Make a ScheduleItemInfo that fills the remaining time (workHoursPerDay - nextEntryDurationHours)
            Date previousEntryDurationEndPlusOneMinute = new Date(previousEntryDuration.getEnd().getTime() + TimeHelper.minuteInMs());
            newEntryTimeRange = createTimeRangeForItineraryEntry(previousEntryDurationEndPlusOneMinute, hoursLeftToFill, HardcodedData.CreateCollectionOfWeekDays(), workHoursPerDay);
            newEntry = new ScheduleItemInfo(roomId, subjectWithTimeLeft.getKey().getName(), (Person) host, newEntryTimeRange);

            return newEntry;
        }
        Date previousEntryDurationEndPlusOneMinute = new Date(previousEntryDuration.getEnd().getTime() + TimeHelper.minuteInMs());
        newEntryTimeRange = createTimeRangeForItineraryEntry(previousEntryDurationEndPlusOneMinute, subjectWithTimeLeft.getValue(), HardcodedData.CreateCollectionOfWeekDays(), workHoursPerDay);
        newEntry = new ScheduleItemInfo(roomId, subjectWithTimeLeft.getKey().getName(), (Person) host, newEntryTimeRange);
        return newEntry;
    }

    /**
     * @param nextEntryStart The LocalDateTime on which this entry starts.
     * @param hoursLeft      The hours left in the curriculum for a specific subject.
     * @param daysToUse      The specific days of the week that should be used when making the itinerary.
     * @return A TimeRange of 6 hours
     */
    private TimeRange createTimeRangeForItineraryEntry(Date nextEntryStart, Integer hoursLeft, Collection<CustomDayOfWeek> daysToUse, int workHoursPerDay) {
        TimeRange nextEntryDuration;
        Date nextEntryEnd;
        if (hoursLeft < workHoursPerDay) {
            nextEntryEnd = TimeHelper.addHoursToDate(nextEntryStart, hoursLeft);
            nextEntryDuration = new TimeRange(nextEntryStart, nextEntryEnd);
        } else {
            nextEntryEnd = new Date(nextEntryStart.getTime() + TimeHelper.hourInMs() * workHoursPerDay);
            nextEntryDuration = new TimeRange(nextEntryStart, nextEntryEnd);
        }
        if (!daysToUse.contains(TimeHelper.getDayOfTheWeek(nextEntryDuration.getStart()))) {
            Date nextEntryStartPlusOneDay = new Date(nextEntryStart.getTime() + TimeHelper.dayInMs());
            nextEntryDuration = createTimeRangeForItineraryEntry(nextEntryStartPlusOneDay, hoursLeft, daysToUse, workHoursPerDay);
        }
        return nextEntryDuration;
    }

//    /**
//     * Generates a timetable with an itinerary. Defaults to hoursPerDay = 6
//     *
//     * @param school     A representation of a school, which contains rooms to use in timetable generation.
//     * @param teachers   The teachers to be used in the itinerary.
//     * @param curriculum The subjects taught, allotted time per subject & the time period the generator has available.
//     * @param daysToUse  The days of the week used when generating the itinerary of the timetable.
//     * @return A <code>Timetable</code>
//     */
//    public Timetable generateTimetable(School school, Set<Teacher> teachers, Curriculum curriculum, Collection<CustomDayOfWeek> daysToUse) {
//        // TODO: implement TimetableGenerator
//        throw new NotImplementedException();
//    }
//
//    /**
//     * Generates a timetable, which contains an itinerary with configurable daysToUse & hoursPerDay
//     *
//     * @param school      A representation of a school, which contains rooms to use in timetable generation.
//     * @param teachers    The teachers to be used in the itinerary.
//     * @param curriculum  The subjects taught, allotted time per subject & the time period the generator has available.
//     * @param daysToUse   The days of the week used when generating the itinerary of the timetable.
//     * @param hoursPerDay The amount of hours used per day in the itinerary.
//     * @return A <code>Timetable</code>
//     */
//    public Timetable generateTimetable(School school, Set<Teacher> teachers, Curriculum curriculum, Collection<CustomDayOfWeek> daysToUse, int hoursPerDay) {
//        // TODO: implement TimetableGenerator
//        throw new NotImplementedException();
//    }
}
