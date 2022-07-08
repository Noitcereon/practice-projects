import models.ScheduleItemInfo;
import models.Timetable;
import services.HardcodedData;
import services.TimetableGenerator;

public class Main {
    public static void main(String... args){
        TimetableGenerator generator = new TimetableGenerator();

        Timetable timetable = generator.generateTimetable(HardcodedData.CreateSchool(), HardcodedData.CreateSetOfTeachers(), HardcodedData.CreateCurriculum());

        for (ScheduleItemInfo entry : timetable.getItinerary()) {
            System.out.println(entry.getDuration());
        }
    }
}
