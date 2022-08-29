package com.noitcereon.movieapispringboot.services;

import java.util.ArrayList;

/**
 *
 * @param <T> A Plain Old Java Object (POJO), which reflects how the object looks in the database.
 * @param <DTOCreate> Data Transfer Object for creation (for ease of creation for users)
 */
public interface ICrudRepository<T, ID, DTOCreate> {
    // Creation
    T create(DTOCreate model);
    // Read
    ArrayList<T> getAll();

    ID getById();

    // Update
    /**
     *
     * @param entity The updated entity
     * @return If successful, return the updated entity.
     */
    T update(T entity);
    // Delete
    T delete(ID entityId);
}
