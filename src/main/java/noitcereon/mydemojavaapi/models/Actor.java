package noitcereon.mydemojavaapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;
import java.util.UUID;

@Entity
public class Actor {

    @Id
//    @Column(length = 36)
    private String uuid;
    private String firstName;
    private String lastName;
    private int age;

    // The "mappedBy" tells Hibernate, which private field to use in ORM mapping (exists in the related model).
    // In this case the private field variable name is actors (see Movie model)
    @ManyToMany(mappedBy = "actors")
    private Set<Movie> movies;

    public Actor() {
    }

    public Actor(String uuid, String firstName, String lastName, int age, Set<Movie> movies) {
        setUuid(uuid);
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setMovies(movies);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        if (uuid.length() == 36) {
            this.uuid = uuid;
        } else {
            this.uuid = UUID.randomUUID().toString();
        }
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

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
