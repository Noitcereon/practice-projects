package noitcereon.mydemojavaapi.controllers;

import noitcereon.mydemojavaapi.models.Movie;
import noitcereon.mydemojavaapi.repositories.IMovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/")
public class MovieController {
    private final IMovieRepository movieRepo;

    public MovieController(IMovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    @GetMapping("movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieRepo.findAll());
    }
    @PostMapping("movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        movie.setUuid(UUID.randomUUID().toString());
        Movie savedMovie = movieRepo.save(movie);
        return ResponseEntity.ok(savedMovie);
    }
}
