import models.ScheduleItemInfo;
import models.Timetable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.HardcodedData;
import services.TimetableGenerator;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String... args){
        TimetableGenerator generator = new TimetableGenerator();

        Timetable timetable = generator.generateTimetable(HardcodedData.CreateSchool(), HardcodedData.CreateSetOfTeachers(), HardcodedData.CreateCurriculum());

        logger.info("Printing timetable entries");
        for (ScheduleItemInfo entry : timetable.getItinerary()) {
            System.out.println(entry.getDuration());
        }
        logger.info("Finished printing timetable entries");
    }
}
