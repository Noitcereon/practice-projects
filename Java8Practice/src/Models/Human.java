package Models;

import java.time.LocalDate;

public class Human {
    private String name;
    private final LocalDate birthday;

    public Human(String name, LocalDate birthday) {
        this.birthday = birthday;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
