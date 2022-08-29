package com.noitcereon.movieapispringboot.models;

import java.util.ArrayList;

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

    public long id() {
        return id;
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
