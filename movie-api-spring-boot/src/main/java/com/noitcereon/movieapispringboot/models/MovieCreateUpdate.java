package com.noitcereon.movieapispringboot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class MovieCreateUpdate {
    private final String title;
    private final int releaseYear;
    private final ArrayList<ActorEntity> actors;

    public MovieCreateUpdate(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.actors = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public ArrayList<ActorEntity> getActors() {
        return actors;
    }
}
