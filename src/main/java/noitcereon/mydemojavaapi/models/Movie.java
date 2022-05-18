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


//    @ManyToMany()
//    private ArrayList<Actor> actors;

    public Movie() {
    }

    public Movie(String uuid, String title, int releaseYear, int durationInMinutes) {
        setUuid(uuid);
        setTitle(title);
        setReleaseYear(releaseYear);
        setDurationInMinutes(durationInMinutes);
//         setActors(actors);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        // TODO: Add UUID validation
        if(uuid.length() == 36){
            this.uuid = uuid;
        }
        else{
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
        if(releaseYear > 9999){
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
        return getDurationInMinutes() == movie.getDurationInMinutes() && getUuid().equals(movie.getUuid()) && getTitle().equals(movie.getTitle()) && getReleaseYear().equals(movie.getReleaseYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getTitle(), getReleaseYear(), getDurationInMinutes());
    }
}
