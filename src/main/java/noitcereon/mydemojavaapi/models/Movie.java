package noitcereon.mydemojavaapi.models;

import javax.persistence.*;
import java.time.Duration;
import java.util.*;

@Entity
public class Movie {
    @Id
    @Column
    private String uuid;
    @Column
    private String title;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar releaseYear;

    @Column
    private int durationInMinutes;


    // When using ManyToMany you use @JoinTable to specify both the name of the table and
    // the columns in the joined table (inverseJoinColumns is taken from the one where mappedBy is present)
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "movie_actor",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")}
    )
    private Set<Actor> actors;

    public Movie() {
    }

    public Movie(String uuid, String title, int releaseYear, int durationInMinutes, Set<Actor> actors) {
        setUuid(uuid);
        setTitle(title);
        setReleaseYear(releaseYear);
        setDurationInMinutes(durationInMinutes);
        setActors(actors);
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        if (releaseYear > 9999) {
            this.releaseYear = Calendar.getInstance();
            this.releaseYear.set(Calendar.YEAR, 0);
            return;
        }
        Calendar specificCalendarYear = Calendar.getInstance();
        specificCalendarYear.set(Calendar.YEAR, releaseYear);
        this.releaseYear = specificCalendarYear;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return getDurationInMinutes() == movie.getDurationInMinutes() && getUuid().equals(movie.getUuid()) && getTitle().equals(movie.getTitle()) && getReleaseYear().equals(movie.getReleaseYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getTitle(), getReleaseYear(), getDurationInMinutes());
    }
}
