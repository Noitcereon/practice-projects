package Topics;

import Helpers.ConsoleHelper;
import Models.Human;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime implements Runnable{

    private final DateTimeFormatter defaultDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DateTimeFormatter defaultDateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm");
    @Override
    public void run() {
        ConsoleHelper.printHeadline("Date And Time");
        LocalDate jan1998 = LocalDate.of(1998, 1, 19);
        Human human = new Human("Thomas", jan1998);
        System.out.println(human.getBirthday().format(defaultDateFormat));

        LocalDateTime jan1998At0535 = LocalDateTime.of(jan1998, LocalTime.of(5,35));
        System.out.println(jan1998At0535.format(defaultDateTimeFormat));
    }
}
