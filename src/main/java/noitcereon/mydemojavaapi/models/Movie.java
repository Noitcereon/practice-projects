package noitcereon.mydemojavaapi.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Duration;
import java.util.*;

@Entity
public class Movie {
    @Id
    private String uuid;
    private String title;
    private Calendar releaseYear;
    private Duration duration;

//    @ManyToMany()
//    private ArrayList<Actor> actors;

    public Movie() {
    }

    public Movie(String uuid, String title, int releaseYear, int durationInMinutes) {
        setUuid(uuid);
        setTitle(title);
        setReleaseYear(releaseYear);
        setDuration(durationInMinutes);
//         setActors(actors);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        // TODO: Add UUID validation
        this.uuid = uuid;
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
        Calendar specificCalendarYear = Calendar.getInstance();
        specificCalendarYear.set(Calendar.YEAR, releaseYear);
        this.releaseYear = specificCalendarYear;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(int durationInMinutes) {
        this.duration = Duration.ofMinutes(durationInMinutes);
    }

//    public ArrayList<Actor> getActors() {
//        return actors;
//    }
//
//    public void setActors(ArrayList<Actor> actors) {
//        this.actors = actors;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return getUuid().equals(movie.getUuid()) && getTitle().equals(movie.getTitle()) && getReleaseYear().equals(movie.getReleaseYear()) && getDuration().equals(movie.getDuration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getTitle(), getReleaseYear(), getDuration());
    }
}
