package com.noitcereon.movieapispringboot.controllers;

import com.noitcereon.movieapispringboot.models.ActorCreate;
import com.noitcereon.movieapispringboot.models.ActorEntity;
import com.noitcereon.movieapispringboot.repositories.ActorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
        return null;
    }

    @Override
    public ResponseEntity<ActorEntity> getById(@PathVariable Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<ActorEntity> update(@RequestBody ActorEntity updatedModel) {
        return null;
    }

    @Override
    public ResponseEntity<ActorEntity> add(@RequestBody ActorCreate creationModel) {
        return null;
    }

    @Override
    public ResponseEntity<ActorEntity> deleteById(@PathVariable Long aLong) {
        return null;
    }
}
