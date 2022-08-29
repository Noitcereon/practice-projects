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

    public long getId() {
        return id;
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
