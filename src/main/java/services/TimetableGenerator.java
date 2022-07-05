package services;

import models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class TimetableGenerator {
    public Timetable generateTimetable(School school, Set<Person> teachers, Curriculum curriculum){
        // Retrieve lessons that need to be scheduled (required no. of hours, name)
        // TODO: implement TimetableGenerator
        Collection<ScheduleItemInfo> scheduleItems = new ArrayList<>();

        TimeSlot timeSlot = new TimeSlot(LocalDateTime.now(), LocalDateTime.now().plusHours(2));

        scheduleItems.add(new ScheduleItemInfo("101", "Math", teachers.stream().findFirst().get(), timeSlot));

        return new Timetable(scheduleItems);
    }
}
