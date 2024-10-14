package com.noitcereon.movieapispringboot.unittests.controllers;

import com.noitcereon.movieapispringboot.controllers.ActorController;
import com.noitcereon.movieapispringboot.models.ActorCreateUpdate;
import com.noitcereon.movieapispringboot.models.ActorEntity;
import com.noitcereon.movieapispringboot.repositories.ActorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ActorControllerTest {

    ActorController actorController;
    @BeforeEach
    void setUp() {
        actorController = new ActorController(Mockito.mock(ActorRepository.class));
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
        ActorEntity updatedActor = actorController.update(Mockito.mock(ActorCreateUpdate.class), 1L).getBody();
        assertNotNull(updatedActor);
    }

    @Test
    void creatingAnActorShouldReturnAnActor() {
        ActorEntity actor = actorController.add(Mockito.mock(ActorCreateUpdate.class)).getBody();
        assertNotNull(actor);
    }

    @Test
    void deletingAnActorShouldReturnALongId() {
        Long actor = actorController.deleteById(1L).getBody();
        assertNotNull(actor);
    }
}