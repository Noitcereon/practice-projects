import models.ScheduleItemInfo;
import models.Timetable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.HardcodedData;
import services.TimetableGenerator;

import java.util.*;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String... args){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        TimetableGenerator generator = new TimetableGenerator();

        Timetable timetable = generator.generateTimetable(HardcodedData.CreateSchool(), HardcodedData.CreateSetOfTeachers(), HardcodedData.CreateCurriculum());

        logger.info("Printing timetable entries");
        for (ScheduleItemInfo entry : timetable.getItinerary()) {
            System.out.println(entry.getDuration());
        }
        logger.info("Printing timetable entries completed");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter 'y' to generate timetable. Anything else will exit the application.");
            String input = scanner.nextLine();
            if(input.equals("y")){
                generator.generateTimetable(HardcodedData.CreateSchool(), HardcodedData.CreateSetOfTeachers(), HardcodedData.CreateCurriculum());
            }
            else{
                break;
            }
        }
    }
}
