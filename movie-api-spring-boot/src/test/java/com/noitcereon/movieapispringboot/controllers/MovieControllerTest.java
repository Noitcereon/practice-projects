package com.noitcereon.movieapispringboot.controllers;

import com.noitcereon.movieapispringboot.factories.MovieMockFactory;
import com.noitcereon.movieapispringboot.models.MovieEntity;
import com.noitcereon.movieapispringboot.services.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class MovieControllerTest {

    private MovieController movieController;
    private final MovieMockFactory mocksFactory = new MovieMockFactory();
    @BeforeEach
    void setUp() {
        movieController = new MovieController(new MovieRepository());
    }

    @Test
    void getAll() {
        HttpStatus expected = HttpStatus.OK;
        HttpStatus statusCode = movieController.getAll().getStatusCode();
        assertEquals(expected, statusCode);
    }

    @Test
    void getById() {
        HttpStatus expected = HttpStatus.OK;
        HttpStatus statusCode = movieController.getById(1L).getStatusCode();
        assertEquals(expected, statusCode);
    }

    @Test
    void update() {
        HttpStatus expected = HttpStatus.OK;
        HttpStatus statusCode = movieController.update(mocksFactory.createMinimalMovieEntity()).getStatusCode();
        assertEquals(expected, statusCode);
    }

    @Test
    void add() {
        HttpStatus expected = HttpStatus.CREATED;
        HttpStatus statusCode = movieController.add(mocksFactory.createMinimalMovieCreate()).getStatusCode();
        assertEquals(expected, statusCode);
    }

    @Test
    void deleteById() {
        HttpStatus expected = HttpStatus.OK;
        HttpStatus statusCode = movieController.deleteById(1L).getStatusCode();
        assertEquals(expected, statusCode);
    }
}