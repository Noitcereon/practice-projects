package com.noitcereon.movieapispringboot.controllers;

import com.noitcereon.movieapispringboot.models.MovieCreate;
import com.noitcereon.movieapispringboot.models.MovieEntity;
import com.noitcereon.movieapispringboot.repositories.MovieRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/movies")
public class MovieController implements ICrudController<MovieEntity, Long, MovieCreate> {
    private final MovieRepository movieRepo;

    public MovieController(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    @GetMapping
    @Operation(summary = "Retrieves all movies with their id, title and release date")
    public ResponseEntity<ArrayList<MovieEntity>> getAll() {
        ArrayList<MovieEntity> movies = movieRepo.getAll();
        if(movies.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(movies);
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Retrieves a movie with all its data, including actors in the movie.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "204")})
    public ResponseEntity<MovieEntity> getById(@PathVariable Long id) {
        MovieEntity movie = movieRepo.getById(id);
        if(movie == null){
            return ResponseEntity.internalServerError().build();
        }
        if(movie.getId() == -1){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(movie);
    }

    @Override
    @Operation(summary = "Updates a movie in the database based on the passed in MovieEntity")
    public ResponseEntity<MovieEntity> update(MovieEntity updatedModel) {
        return null;
    }

    @Override
    @Operation(summary = "Adds a new movie to the database and returns the added movie")
    public ResponseEntity<MovieEntity> add(MovieCreate creationModel) {
        return null;
    }

    @Operation(summary = "Deletes a movie from the database and returns the deleted movie.")
    @Override
    public ResponseEntity<MovieEntity> deleteById(Long aLong) {
        return null;
    }


}
