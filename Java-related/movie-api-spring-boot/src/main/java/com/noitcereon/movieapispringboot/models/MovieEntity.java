package com.noitcereon.movieapispringboot.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class MovieEntity {
    private final long id;
    private final String title;
    private final int releaseYear;
    private final ArrayList<ActorEntity> actors;

    public MovieEntity(long id, String title, int releaseYear, ArrayList<ActorEntity> actors) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.actors = actors;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @JsonIgnore
    public ArrayList<ActorEntity> getActors() {
        return actors;
    }

    @JsonGetter(value = "actors")
    public Set<String> getActorEndpoints(){
        return actors.stream().map(actor -> String.format("%s %s", actor.getFirstName(), actor.getLastName())).collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", actors=" + actors +
                '}';
    }
}
