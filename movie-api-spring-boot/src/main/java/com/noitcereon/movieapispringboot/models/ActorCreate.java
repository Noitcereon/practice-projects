package com.noitcereon.movieapispringboot.models;

import java.util.ArrayList;

public class ActorCreate {
    private final String firstName;
    private final String lastName;
    private final int birthYear;
    private final ArrayList<MovieEntity> relatedMovies;

    public ActorCreate(String firstName, String lastName, int birthYear, ArrayList<MovieEntity> relatedMovies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.relatedMovies = relatedMovies;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public int birthYear() {
        return birthYear;
    }

    public ArrayList<MovieEntity> relatedMovies() {
        return relatedMovies;
    }
}
