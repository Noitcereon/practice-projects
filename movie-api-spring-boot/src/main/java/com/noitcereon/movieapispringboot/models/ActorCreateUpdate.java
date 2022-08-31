package com.noitcereon.movieapispringboot.models;

import java.util.ArrayList;

public class ActorCreateUpdate {
    private final String firstName;
    private final String lastName;
    private final int birthYear;
    private final ArrayList<Long> idsOfRelatedMovies;

    public ActorCreateUpdate(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.idsOfRelatedMovies = new ArrayList<>();
    }
    public ActorCreateUpdate(String firstName, String lastName, int birthYear, ArrayList<Long> idsOfRelatedMovies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.idsOfRelatedMovies = idsOfRelatedMovies;
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

    public ArrayList<Long> getIdsOfRelatedMovies() {
        return idsOfRelatedMovies;
    }
}
