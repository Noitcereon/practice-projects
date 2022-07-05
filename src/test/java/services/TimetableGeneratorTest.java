package services;

import models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
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
        Assertions.fail();
//        Timetable actual = _generator.generateTimetable();
    }
}