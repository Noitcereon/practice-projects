package com.noitcereon.movieapispringboot.factories;

import com.noitcereon.movieapispringboot.models.ActorCreate;
import com.noitcereon.movieapispringboot.models.ActorEntity;

import java.util.ArrayList;

public class ActorMockFactory {
    public ActorEntity createMinimalActor(){
        return new ActorEntity(1L, "nameNotImportant", "lastNameNotImportant", 1999, new ArrayList<>());
    }
    public ActorCreate createMinimalActorCreate(){
        return new ActorCreate("nameNotImportant", "lastNameNotImportant", 2000, new ArrayList<>());
    }
}
