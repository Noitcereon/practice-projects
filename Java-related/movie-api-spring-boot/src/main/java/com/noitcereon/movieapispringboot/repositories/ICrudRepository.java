package com.noitcereon.movieapispringboot.repositories;

import java.util.ArrayList;

/**
 *
 * @param <T> A Plain Old Java Object (POJO), which reflects how the object looks in the database.
 * @param <DTOCreateUpdate> Data Transfer Object for creation or updating existing content (for ease of creation for users)
 */
public interface ICrudRepository<T, ID, DTOCreateUpdate> {
    // Creation
    T create(DTOCreateUpdate model);
    // Read
    ArrayList<T> getAll();

    T getById(ID id);

    // Update
    /**
     *
     * @param model The updated model
     * @return If successful, return the updated entity.
     */
    T update(DTOCreateUpdate model, ID id);
    // Delete
    ID delete(ID entityId);
}
