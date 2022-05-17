package noitcereon.mydemojavaapi.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Actor {
    @Id
    private String uid;
    private String firstName;
    private String lastName;
    private int age;

    public Actor() {
    }

    public Actor(String firstName, String lastName, int age) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
        }
    }
}
