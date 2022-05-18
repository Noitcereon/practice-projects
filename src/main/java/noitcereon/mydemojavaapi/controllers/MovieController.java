package noitcereon.mydemojavaapi.controllers;

import noitcereon.mydemojavaapi.models.Actor;
import noitcereon.mydemojavaapi.models.Movie;
import noitcereon.mydemojavaapi.repositories.IMovieRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final IMovieRepository movieRepo;

    public MovieController(IMovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieRepo.findAll());
    }
    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        movie.setUuid(UUID.randomUUID().toString());
        Movie savedMovie = movieRepo.save(movie);
        return ResponseEntity.ok(savedMovie);
    }
    @PatchMapping("/{movieId}/actors")
    public ResponseEntity<Actor> addActors(@PathVariable String movieId, ArrayList<String> actorIds){
        return null;
    }
}
