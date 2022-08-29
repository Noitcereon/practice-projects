package com.noitcereon.movieapispringboot.factories;

import com.noitcereon.movieapispringboot.models.MovieCreate;
import com.noitcereon.movieapispringboot.models.MovieEntity;

import java.util.ArrayList;

public class MovieMockFactory {
    public MovieEntity createMinimalMovieEntity(){
        return new MovieEntity(1L, "titleNotImportant", 2000, new ArrayList<>());
    }

    public MovieCreate createMinimalMovieCreate() {
        return new MovieCreate("titleNotImportant", 2000, new ArrayList<>());
    }
}
