package noitcereon.mydemojavaapi.controllers;

import noitcereon.mydemojavaapi.models.Actor;
import noitcereon.mydemojavaapi.models.Movie;
import noitcereon.mydemojavaapi.repositories.IActorRepository;
import noitcereon.mydemojavaapi.repositories.IMovieRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final IMovieRepository movieRepo;
    private final IActorRepository actorRepo;

    public MovieController(IMovieRepository movieRepo, IActorRepository actorRepo) {
        this.movieRepo = movieRepo;
        this.actorRepo = actorRepo;
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        movie.setUuid(UUID.randomUUID().toString());
        Movie savedMovie = movieRepo.save(movie);
        return ResponseEntity.ok(savedMovie);
    }

    @GetMapping
    public ResponseEntity<Set<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieRepo.findAllByIsDeletedIsFalse());
    }

    @GetMapping("{movieId}")
    public ResponseEntity<Movie> getById(@PathVariable String movieId) {
        Movie movie = movieRepo.findByUuidAndIsDeletedIsFalse(movieId);
        return ResponseEntity.ok(movie);
    }

    @PatchMapping("/{movieId}/actors")
    public ResponseEntity<Movie> addActors(@PathVariable String movieId, @RequestBody ArrayList<String> actorIds) {
        // TODO: make method to add actors to a movie
        if (!movieRepo.existsById(movieId)) {
            return ResponseEntity.notFound().build();
        }
        Movie movie = movieRepo.findByUuidAndIsDeletedIsFalse(movieId);
        Set<Actor> actors = movie.getActors();
        for (String actorId : actorIds) {
            Actor actorToAdd = actorRepo.findByUuidAndIsDeletedIsFalse(actorId);
            actors.add(actorToAdd);
        }
        movie.setActors(actors);
        Movie savedObject = movieRepo.save(movie);
        return ResponseEntity.ok(savedObject);
    }

    @PutMapping("{movieId}")
    public ResponseEntity<Movie> updateMovie(@PathVariable String movieId, @RequestBody Movie updatedMovie) {
        updatedMovie.setUuid(movieId);
        Movie savedObject = movieRepo.save(updatedMovie);
        return ResponseEntity.ok(savedObject);
    }

    @DeleteMapping("{movieId}")
    public ResponseEntity<Movie> disableMovie(@PathVariable String movieId) {
        Optional<Movie> movieOptional = movieRepo.findById(movieId);
        if (movieOptional.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Movie movieToDisable = movieOptional.get();
        movieToDisable.setDeleted(true);
        Movie savedObject = movieRepo.save(movieToDisable);
        return ResponseEntity.ok(savedObject);
    }
}
