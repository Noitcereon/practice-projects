import enums.Role;
import models.Curriculum;
import models.Subject;
import models.Timetable;
import services.HardcodedData;
import services.TimetableGenerator;

import java.time.LocalTime;

public class Main {
    public static void main(String... args){
        TimetableGenerator generator = new TimetableGenerator();

        Timetable timetable = generator.generateTimetable(HardcodedData.CreateSchool(), HardcodedData.CreateListOfPeople(), HardcodedData.CreateCurriculum());

        System.out.println(timetable.getItinerary());
    }
}
