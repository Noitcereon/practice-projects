package com.noitcereon.movieapispringboot.controllers;

import com.noitcereon.movieapispringboot.services.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    private final MovieRepository movieRepo;
    public MovieController(MovieRepository movieRepo){
        this.movieRepo = movieRepo;
    }
    @GetMapping
    public ResponseEntity<ArrayList<String>> getAll(){
        ArrayList<String> movies = new ArrayList<>();
        movies.add("Planet of the Apes");
        movies.add("Lord of the Rings: Fellowship of the Ring");
        movies.add("Avatar");

        return ResponseEntity.ok(movies);
    }
}
