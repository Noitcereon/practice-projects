package com.noitcereon.movieapispringboot.services;

import com.noitcereon.movieapispringboot.models.ActorCreate;
import com.noitcereon.movieapispringboot.models.ActorEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ActorRepository implements ICrudRepository<ActorEntity, Long, ActorCreate> {
    @Override
    public ActorEntity create(ActorCreate model) {
        return null;
    }

    @Override
    public ArrayList<ActorEntity> getAll() {
        return null;
    }

    @Override
    public Long getById() {
        return null;
    }

    @Override
    public ActorEntity update(ActorEntity entity) {
        return null;
    }

    @Override
    public ActorEntity delete(Long entityId) {
        return null;
    }

}
