package com.noitcereon.movieapispringboot.controllers;

import com.noitcereon.movieapispringboot.models.ActorCreate;
import com.noitcereon.movieapispringboot.models.ActorEntity;
import com.noitcereon.movieapispringboot.services.ActorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActorControllerTest {

    ActorController actorController;
    @BeforeEach
    void setUp() {
        actorController = new ActorController(new ActorRepository());
    }

    @Test
    void whenRetrievingAllActorsItShouldReturnAnIterableOfActors() {
        Iterable<ActorEntity> actors = actorController.getAll().getBody();
        assertNotNull(actors);
    }

    @Test
    void whenRetrievingActorByIdItShouldReturnASingleActor() {
        ActorEntity actor = actorController.getById(1L).getBody();
        assertNotNull(actor);
    }

    @Test
    void whenUpdatingAnActorItShouldReturnAnActor() {
        ActorEntity updatedActor = actorController.update(new ActorEntity()).getBody();
        assertNotNull(updatedActor);
    }

    @Test
    void creatingAnActorShouldReturnAnActor() {
        ActorEntity actor = actorController.add(new ActorCreate()).getBody();
        assertNotNull(actor);
    }

    @Test
    void deletingAnActorShouldReturnAnActor() {
        ActorEntity actor = actorController.deleteById(1L).getBody();
        assertNotNull(actor);
    }
}