package com.noitcereon.movieapispringboot.unittests.controllers;

import com.noitcereon.movieapispringboot.controllers.MovieController;
import com.noitcereon.movieapispringboot.models.MovieCreateUpdate;
import com.noitcereon.movieapispringboot.models.MovieEntity;
import com.noitcereon.movieapispringboot.repositories.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieControllerTest {

    private MovieController movieController;
    private final MovieRepository mockedMovieRepo = Mockito.mock(MovieRepository.class);

    @BeforeEach
    void setUp() {
        movieController = new MovieController(mockedMovieRepo);
    }

    @Test
    void getAll_IfThereIsData() {
        ArrayList<MovieEntity> movies = new ArrayList<>();
        movies.add(Mockito.mock(MovieEntity.class));
        movies.add(Mockito.mock(MovieEntity.class));
        Mockito.when(mockedMovieRepo.getAll()).thenReturn(movies);
        HttpStatus expected = HttpStatus.OK;
        HttpStatus statusCode = movieController.getAll().getStatusCode();
        assertEquals(expected, statusCode);
    }

    @Test
    void getAll_IfThereIsNoContent() {
        HttpStatus expected = HttpStatus.NO_CONTENT;
        HttpStatus statusCode = movieController.getAll().getStatusCode();
        assertEquals(expected, statusCode);
    }

    @Test
    void getById() {
        MovieEntity movie = Mockito.mock(MovieEntity.class);
        Mockito.when(mockedMovieRepo.getById(1L)).thenReturn(movie);
        HttpStatus expected = HttpStatus.OK;
        HttpStatus statusCode = movieController.getById(1L).getStatusCode();
        assertEquals(expected, statusCode);
    }

    @Test
    void update() {
        MovieCreateUpdate mockedMovieCreateUpdate = Mockito.mock(MovieCreateUpdate.class);
        MovieEntity mockedMovieEntity = Mockito.mock(MovieEntity.class);
        Long mockId = 1L;
        Mockito.when(mockedMovieRepo.update(mockedMovieCreateUpdate, mockId)).thenReturn(mockedMovieEntity);
        HttpStatus expected = HttpStatus.OK;
        HttpStatus statusCode = movieController.update(mockedMovieCreateUpdate, mockId).getStatusCode();
        assertEquals(expected, statusCode);
    }

    @Test
    void add() {
        MovieEntity mockedMovie = Mockito.mock(MovieEntity.class);
        MovieCreateUpdate mockedCreate = Mockito.mock(MovieCreateUpdate.class);
        Mockito.when(mockedMovieRepo.create(mockedCreate)).thenReturn(mockedMovie);
        Mockito.when(mockedMovie.getId()).thenReturn(1L);
        HttpStatus expected = HttpStatus.CREATED;
        ResponseEntity<MovieEntity> response = movieController.add(mockedCreate);
        HttpStatus statusCode = response.getStatusCode();
        assertEquals(expected, statusCode);
    }

    @Test
    void deleteById() {
        HttpStatus expected = HttpStatus.OK;
        HttpStatus statusCode = movieController.deleteById(1L).getStatusCode();
        assertEquals(expected, statusCode);
    }
}