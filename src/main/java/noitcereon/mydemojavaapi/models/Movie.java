package noitcereon.mydemojavaapi.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

@Entity
public class Movie {
    @Id
    private String uid;
    private String title;
    private Date releaseYear;
    private LocalTime duration;

//    @ManyToMany()
//    private ArrayList<Actor> actors;

    public Movie(){
    }

    public Movie(String uid, String title, Date releaseYear, LocalTime duration, ArrayList<Actor> actors) {
        this.uid = uid;
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
//        this.actors = actors;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
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
        return getUid().equals(movie.getUid()) && getTitle().equals(movie.getTitle()) && getReleaseYear().equals(movie.getReleaseYear()) && getDuration().equals(movie.getDuration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid(), getTitle(), getReleaseYear(), getDuration());
    }
}
