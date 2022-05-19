package noitcereon.mydemojavaapi.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import noitcereon.mydemojavaapi.models.Actor;
import noitcereon.mydemojavaapi.repositories.IActorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/actors")
public class ActorController {
    private final IActorRepository actorRepo;

    public ActorController(IActorRepository actorRepository) {
        actorRepo = actorRepository;
    }

    @PostMapping
    public ResponseEntity<Actor> createActor(@RequestBody Actor actor) {
        Actor savedObject = actorRepo.save(actor);
        return ResponseEntity.ok(savedObject);
    }

    @GetMapping
    public ResponseEntity<List<Actor>> getAll() {
        // TODO: figure out how to make a SQL query with Hibernate to not include deleted actors, so a stream filter isn't needed.
        List<Actor> actors = actorRepo.findAll().stream().filter(actor -> !actor.isDeleted()).toList();
        if (actors.size() == 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(actors);
    }

    @GetMapping("{actorId}")
    public ResponseEntity<Actor> getById(@PathVariable String actorId) {
        Actor actor = actorRepo.getById(actorId);
        if(actor.isDeleted()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(actor);
    }

    @PutMapping("{actorId}")
    public ResponseEntity<Actor> updateActor(@RequestBody Actor updatedActor, @PathVariable String actorId) {
        updatedActor.setUuid(actorId);
        Actor savedObject = actorRepo.save(updatedActor);
        return ResponseEntity.ok(savedObject);
    }

    @DeleteMapping("{actorId}")
    public ResponseEntity<Actor> disableActor(@PathVariable String actorId) {
        Optional<Actor> actorOptional = actorRepo.findById(actorId);
        if (actorOptional.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Actor actorToDisable = actorOptional.get();
        actorToDisable.setDeleted(true);
        Actor savedObject = actorRepo.save(actorToDisable);
        return ResponseEntity.ok(savedObject);
    }
}
