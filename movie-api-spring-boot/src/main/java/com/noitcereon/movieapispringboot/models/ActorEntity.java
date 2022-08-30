package com.noitcereon.movieapispringboot.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class ActorEntity {
    private final long id;
    private final String firstName;
    private final String lastName;
    private final int birthYear;
    private final ArrayList<MovieEntity> relatedMovies;

    public ActorEntity(Long id, String firstName, String lastName, int birthYear, ArrayList<MovieEntity> relatedMovies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.relatedMovies = relatedMovies;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @JsonIgnore
    public ArrayList<MovieEntity> getRelatedMovies() {
        return relatedMovies;
    }

    // TODO: 30-08-2022 Add a JsonGetter for relatedMovies
}
