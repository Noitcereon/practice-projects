package com.noitcereon.movieapispringboot.controllers;

import com.noitcereon.movieapispringboot.models.MovieCreateUpdate;
import com.noitcereon.movieapispringboot.models.MovieEntity;
import com.noitcereon.movieapispringboot.repositories.ICrudRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin
public class MovieController implements ICrudController<MovieEntity, Long, MovieCreateUpdate> {
    private final ICrudRepository<MovieEntity, Long, MovieCreateUpdate> movieRepo;

    public MovieController(ICrudRepository<MovieEntity, Long, MovieCreateUpdate> movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    @GetMapping
    @Operation(summary = "Retrieves all movies with their id, title and release date")
    @Tags(value = {@Tag(name = "Movie Get")})
    public ResponseEntity<ArrayList<MovieEntity>> getAll() {
        ArrayList<MovieEntity> movies = movieRepo.getAll();
        if(movies.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(movies);
    }

    @Override
    @GetMapping("/{id}")
    @Tags(value = {@Tag(name = "Movie Get")})
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
    @PutMapping("/{id}")
    @Operation(summary = "Updates a movie in the database based on the passed in MovieEntity")
    public ResponseEntity<MovieEntity> update(@RequestBody MovieCreateUpdate updatedModel, @PathVariable Long id) {
        MovieEntity movie = movieRepo.update(updatedModel, id);
        if(movie == null) return ResponseEntity.internalServerError().build();

        return ResponseEntity.ok(movie);
    }

    @Override
    @PostMapping
    @Operation(summary = "Adds a new movie to the database")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "204", description = "Tried to delete something that didn't exist")})
    public ResponseEntity<MovieEntity> add(@RequestBody MovieCreateUpdate creationModel) {
        MovieEntity movie = movieRepo.create(creationModel);
        if(movie == null) return ResponseEntity.internalServerError().build();

        return ResponseEntity.created(URI.create(String.format("api/movies/%s", movie.getId()))).build();
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Deletes a movie from the database and returns the id of the deleted movie.")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) {
        Long deletedId = movieRepo.delete(id);
        if(deletedId == null) return ResponseEntity.internalServerError().build();
        if(deletedId == -1) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(deletedId);
    }
}
