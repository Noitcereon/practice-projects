package com.noitcereon.movieapispringboot.services;

import com.noitcereon.movieapispringboot.models.MovieCreate;
import com.noitcereon.movieapispringboot.models.MovieEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository implements ICrudRepository<MovieEntity, Long,  MovieCreate> {
    @Override
    public MovieEntity create(MovieCreate model) {
        return null;
    }

    @Override
    public List<MovieEntity> getAll() {
        return null;
    }

    @Override
    public Long getById() {
        return null;
    }

    @Override
    public MovieEntity update(MovieEntity entity) {
        return null;
    }

    @Override
    public MovieEntity delete(Long entityId) {
        return null;
    }


}
