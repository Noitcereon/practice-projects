package com.noitcereon.movieapispringboot.controllers;

import com.noitcereon.movieapispringboot.models.ActorCreateUpdate;
import com.noitcereon.movieapispringboot.models.ActorEntity;
import com.noitcereon.movieapispringboot.repositories.ActorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ActorController implements ICrudController<ActorEntity, Long, ActorCreateUpdate> {
    private final ActorRepository actorRepo;
    public ActorController(ActorRepository actorRepo){
        this.actorRepo = actorRepo;
    }


    @Override
    public ResponseEntity<ArrayList<ActorEntity>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<ActorEntity> getById(@PathVariable Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ActorEntity> add(@RequestBody ActorCreateUpdate creationModel) {
        return null;
    }

    @Override
    public ResponseEntity<ActorEntity> update(@RequestBody ActorCreateUpdate updatedModel, @PathVariable Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Long> deleteById(@PathVariable Long aLong) {
        return null;
    }
}
