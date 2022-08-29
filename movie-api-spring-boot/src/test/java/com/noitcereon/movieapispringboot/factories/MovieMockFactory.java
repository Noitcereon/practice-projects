package com.noitcereon.movieapispringboot.factories;

import com.noitcereon.movieapispringboot.models.MovieCreate;
import com.noitcereon.movieapispringboot.models.MovieEntity;

public class MovieMockFactory {
    public MovieEntity createMinimalMovieEntity(){
        return new MovieEntity();
    }

    public MovieCreate createMinimalMovieCreate() {
        return new MovieCreate();
    }
}
