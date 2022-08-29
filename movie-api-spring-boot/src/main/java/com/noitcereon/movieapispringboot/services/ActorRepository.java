package com.noitcereon.movieapispringboot.services;

import com.noitcereon.movieapispringboot.models.ActorCreate;
import com.noitcereon.movieapispringboot.models.ActorEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActorRepository implements ICrudRepository<ActorEntity, ActorCreate> {
    @Override
    public ActorEntity create(ActorCreate model) {
        return null;
    }

    @Override
    public List<ActorEntity> read() {
        return null;
    }

    @Override
    public ActorEntity update(ActorEntity entity) {
        return null;
    }

    @Override
    public boolean delete(ActorEntity entity) {
        return false;
    }
}
