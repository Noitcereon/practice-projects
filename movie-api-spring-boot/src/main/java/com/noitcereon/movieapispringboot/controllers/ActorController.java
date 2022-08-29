package com.noitcereon.movieapispringboot.controllers;

import com.noitcereon.movieapispringboot.services.ActorRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController {
    private final ActorRepository actorRepo;
    public ActorController(ActorRepository actorRepo){
        this.actorRepo = actorRepo;
    }
}
