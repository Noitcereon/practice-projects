package com.noitcereon.movieapispringboot.repositories;

import com.noitcereon.movieapispringboot.models.ActorCreate;
import com.noitcereon.movieapispringboot.models.ActorEntity;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;

@Repository
public class ActorRepository implements ICrudRepository<ActorEntity, Long, ActorCreate> {

    private final DataSource dataSource;
    private Connection conn;

    public ActorRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public ActorEntity create(ActorCreate model) {
        return null;
    }

    @Override
    public ArrayList<ActorEntity> getAll() {
        return null;
    }

    @Override
    public ActorEntity getById(Long id) {
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
