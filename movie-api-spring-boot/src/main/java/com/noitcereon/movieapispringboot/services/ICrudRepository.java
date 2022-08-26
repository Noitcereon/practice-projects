package com.noitcereon.movieapispringboot.services;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @param <T> A Plain Old Java Object (POJO), which reflects how the object looks in the database.
 * @param <DTOCreate> Data Transfer Object for creation (for ease of creation for users)
 */
public interface ICrudRepository<T, DTOCreate> {
    // Creation
    T create(DTOCreate model);
    // Read
    List<T> read();
    // Update
    T update(T entity);
    // Delete
    boolean delete(T entity);
}
