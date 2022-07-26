package services;

import models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

class TimetableGeneratorTest {

    private TimetableGenerator _generator;
    private School _school;
    private Curriculum _curriculum;
    private Set<Teacher> _teachers;

    @BeforeEach
    void init() {
        _generator = new TimetableGenerator();
        _school = HardcodedData.CreateSchool();
        _teachers = HardcodedData.CreateSetOfTeachers();
        _curriculum = HardcodedData.CreateCurriculum();
    }

    @Test
    void givenValidInput_whenGeneratingTimetable_thenTimetableIsGenerated() {
        Type expected = Timetable.class;

        Timetable actual = _generator.generateTimetable(_school, _teachers, _curriculum);

        Assertions.assertEquals(expected, actual.getClass());
    }

    @Test
    void givenValidInput_whenGeneratingTimetable_thenGeneratedTimetableDoesNotHaveOverlaps() {
        // TODO: rework this, so it takes rooms and teachers into account.
        Timetable timetable = _generator.generateTimetable(_school, _teachers, _curriculum);

        ArrayList<ScheduleItemInfo> itinerary = new ArrayList<>(timetable.getItinerary());
        for (int itineraryIndex = 0; itineraryIndex < itinerary.size(); itineraryIndex++) {
            ScheduleItemInfo item = itinerary.get(itineraryIndex);
            LocalDateTime start1 = item.getDuration().getStart();
            LocalDateTime end1 = item.getDuration().getEnd();
            for (int itineraryIndexCompare = 0; itineraryIndexCompare < itinerary.size(); itineraryIndexCompare++) {
                ScheduleItemInfo comparisonItem = itinerary.get(itineraryIndexCompare);
                LocalDateTime start2 = comparisonItem.getDuration().getStart();
                LocalDateTime end2 = comparisonItem.getDuration().getEnd();

                assertItineraryDoesNotOverlap(itineraryIndex, start1, end1, itineraryIndexCompare, start2, end2);
            }
        }
    }
    @Test
    void givenValidInput_whenGeneratingTimetable_thenGeneratedTimetableItineraryIsLargerOrEqualTheAmountOfCurriculumSubjects(){
        Timetable timetable = _generator.generateTimetable(_school, _teachers, _curriculum);
        int curriculumSubjectsSize = _curriculum.getAllotedTimePerSubject().size();
        int itinerarySize = timetable.getItinerary().size();
        boolean expected = true;
        boolean actual = itinerarySize >= curriculumSubjectsSize;
        System.out.printf("\nitinerarySize: %s, curriculumSubjectSize: %s%n", itinerarySize, curriculumSubjectsSize);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void givenValidInput_whenGeneratingTimetable_thenItineraryDoesNotContainInvalidDayOfWeek(){
        Timetable timetable = _generator.generateTimetable(_school, _teachers, _curriculum);
        Collection<DayOfWeek> weekDays = HardcodedData.CreateCollectionOfWeekDays();
        boolean containsInvalidDayOfWeek = false;
        for (ScheduleItemInfo itineraryEntry: timetable.getItinerary()) {
            boolean isWeekendDay = !weekDays.contains(itineraryEntry.getDuration().getStart().getDayOfWeek());
            Assertions.assertEquals(containsInvalidDayOfWeek, isWeekendDay);
        }
    }

    private void assertItineraryDoesNotOverlap(int itineraryIndex, LocalDateTime start1, LocalDateTime end1, int itineraryCompareIndex, LocalDateTime start2, LocalDateTime end2) {
        int isEarlier = -1;
        int isSameTime = 0;
        int isLater = 1;
        System.out.printf("\nitenaryIndex: %s, itineraryCompareIndex %s, start1 %s, end1 %s, start2 %s, end2 %s%n", itineraryIndex, itineraryCompareIndex, start1, end1, start2, end2);
        if (start1.compareTo(start2) == isSameTime && itineraryIndex != itineraryCompareIndex) {
            Assertions.fail("Overlap occurred");
        } else if (start1.compareTo(start2) == isLater) {
            Assertions.assertTrue(end1.isAfter(start2));
            Assertions.assertTrue(end1.isAfter(end2));
        } else if (start1.compareTo(start2) == isEarlier) {
            Assertions.assertTrue(end1.isBefore(start2));
            Assertions.assertTrue(end1.isBefore(end2));
        }
    }
}