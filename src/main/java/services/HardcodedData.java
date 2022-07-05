package services;

import enums.Role;
import models.*;

import java.time.LocalDateTime;
import java.util.*;

public class HardcodedData {

    public static Curriculum CreateCurriculum() {
        Subject math1 = new Subject("Mathematics A");
        Subject math2 = new Subject("Mathematics C");
        Subject subject3 = new Subject("Software Development");
        Subject subject4 = new Subject("English");
        Subject subject5 = new Subject("Geography");
        Subject subject6 = new Subject("Software Design");
        Subject subject7 = new Subject("Business Analysis");

        LocalDateTime startOfCurriculumPeriod = LocalDateTime.of(2022, 8, 1, 8, 0);
        LocalDateTime endOfCurriculumPeriod = LocalDateTime.of(2022, 12, 15, 15, 30);
        TimeRange curriculumTimePeriod = new TimeRange(startOfCurriculumPeriod, endOfCurriculumPeriod);

        Curriculum curriculum = new Curriculum(curriculumTimePeriod);
        curriculum
                .addSubject(math1, 420)
                .addSubject(math2, 390)
                .addSubject(subject3, 40)
                .addSubject(subject4, 210)
                .addSubject(subject5, 245)
                .addSubject(subject6, 320)
                .addSubject(subject7, 135);

        return curriculum;
    }

    public static Set<Person> CreateListOfPeople() {
        Set<Person> teachers = new HashSet<>();
        teachers.add(new Teacher("Abigail", Role.TEACHER));
        teachers.add(new Teacher("Donald", Role.TEACHER));
        teachers.add(new Teacher("Donald Twice", Role.TEACHER));
        teachers.add(new Teacher("Orion", Role.TEACHER));
        teachers.add(new Teacher("Cleopatra", Role.TEACHER));
        teachers.add(new Teacher("Mark Markinsson", Role.TEACHER));
        teachers.add(new Teacher("Olaf Larsen", Role.TEACHER));
        return teachers;
    }

    public static School CreateSchool() {

        Room room1 = new Room("101", "Class Room 1");
        Room room2 = new Room("102", "Class Room 2");
        Room room3 = new Room("103", "Class Room 3");
        Room room4 = new Room("104", "Class Room 4");
        Room room5 = new Room("105", "Class Room 5");
        Room room6 = new Room("106", "Class Room 6");
        Room room7 = new Room("201", "Class Room 7");
        Room room8 = new Room("202", "Class Room 8");
        Room room9 = new Room("203", "Class Room 9");

        Collection<Room> rooms = new HashSet<>();
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        rooms.add(room5);
        rooms.add(room6);
        rooms.add(room7);
        rooms.add(room8);
        rooms.add(room9);

        return new School(rooms);
    }
}
