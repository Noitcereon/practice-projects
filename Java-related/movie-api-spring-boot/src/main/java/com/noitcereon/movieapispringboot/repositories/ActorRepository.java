package com.noitcereon.movieapispringboot.repositories;

import com.noitcereon.movieapispringboot.models.ActorCreateUpdate;
import com.noitcereon.movieapispringboot.models.ActorEntity;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;

@Repository
public class ActorRepository implements ICrudRepository<ActorEntity, Long, ActorCreateUpdate> {

    private final DataSource dataSource;
    private Connection conn;

    public ActorRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public ActorEntity create(ActorCreateUpdate model) {
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
    public ActorEntity update(ActorCreateUpdate entity, Long id) {
        return null;
    }

    @Override
    public Long delete(Long entityId) {
        return null;
    }

}
