package com.noitcereon.movieapispringboot.controllers;

import com.noitcereon.movieapispringboot.models.MovieCreate;
import com.noitcereon.movieapispringboot.models.MovieEntity;
import com.noitcereon.movieapispringboot.services.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/movie")
public class MovieController implements ICrudController<MovieEntity, Long, MovieCreate> {
    private final MovieRepository movieRepo;
    public MovieController(MovieRepository movieRepo){
        this.movieRepo = movieRepo;
    }
    @GetMapping
    public ResponseEntity<ArrayList<MovieEntity>> getAll(){
       return null;
    }

    @Override
    public ResponseEntity<MovieEntity> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<MovieEntity> update(MovieEntity updatedModel) {
        return null;
    }

    @Override
    public ResponseEntity<MovieEntity> add(MovieCreate creationModel) {
        return null;
    }

    @Override
    public ResponseEntity<MovieEntity> deleteById(Long aLong) {
        return null;
    }


}
