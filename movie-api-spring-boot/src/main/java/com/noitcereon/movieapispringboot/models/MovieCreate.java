package com.noitcereon.movieapispringboot.models;

import java.util.ArrayList;

public class MovieCreate {
    private final String title;
    private final int releaseYear;
    private final ArrayList<ActorEntity> actors;

    public MovieCreate(String title, int releaseYear, ArrayList<ActorEntity> actors) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.actors = actors;
    }

    public String title() {
        return title;
    }

    public int releaseYear() {
        return releaseYear;
    }

    public ArrayList<ActorEntity> actors() {
        return actors;
    }
}
