package com.noitcereon.movieapispringboot.controllers;

import com.noitcereon.movieapispringboot.models.ActorCreate;
import com.noitcereon.movieapispringboot.models.ActorEntity;
import com.noitcereon.movieapispringboot.services.ActorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ActorController implements ICrudController<ActorEntity, Long, ActorCreate> {
    private final ActorRepository actorRepo;
    public ActorController(ActorRepository actorRepo){
        this.actorRepo = actorRepo;
    }

    @Override
    public ResponseEntity<ArrayList<ActorEntity>> getAll() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @Override
    public ResponseEntity<ActorEntity> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ActorEntity> update(ActorEntity updatedModel) {
        return null;
    }

    @Override
    public ResponseEntity<ActorEntity> add(ActorCreate creationModel) {
        return null;
    }

    @Override
    public ResponseEntity<ActorEntity> deleteById(Long aLong) {
        return null;
    }
}
