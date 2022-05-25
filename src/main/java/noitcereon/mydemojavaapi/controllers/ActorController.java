package noitcereon.mydemojavaapi.controllers;

import noitcereon.mydemojavaapi.models.ActorPostModel;
import noitcereon.mydemojavaapi.models.ActorReadonly;
import noitcereon.mydemojavaapi.models.entities.Actor;
import noitcereon.mydemojavaapi.repositories.IActorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ActorReadonly> createActor(@RequestBody ActorPostModel actor) {
        Actor actorEntity = new Actor(actor);
        Actor savedObject = actorRepo.save(actorEntity);
        ActorReadonly readonlyActor = new ActorReadonly(savedObject);
        return ResponseEntity.ok(readonlyActor);
    }
    @GetMapping
    public ResponseEntity<Set<Actor>> getAll() {
        Set<Actor> actors = actorRepo.findAllByIsDeletedIsFalse();
        if (actors.size() == 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(actors);
    }

    @GetMapping("{actorId}")
    public ResponseEntity<Actor> getById(@PathVariable String actorId) {
        Actor actor = actorRepo.findByUuidAndIsDeletedIsFalse(actorId);
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
