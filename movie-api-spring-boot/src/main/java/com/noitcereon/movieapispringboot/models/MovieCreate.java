package com.noitcereon.movieapispringboot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class MovieCreate {
    private final String title;
    private final int releaseYear;
    private final ArrayList<ActorEntity> actors;

    public MovieCreate(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.actors = new ArrayList<>(); // Actors are added post creation.
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
}
