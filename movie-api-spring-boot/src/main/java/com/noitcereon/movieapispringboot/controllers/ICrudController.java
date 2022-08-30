package com.noitcereon.movieapispringboot.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

// This interface is related to ICrudRepository
public interface ICrudController<T, ID, TCreate> {
    ResponseEntity<ArrayList<T>> getAll();
    ResponseEntity<T> getById(@PathVariable ID id);
    ResponseEntity<T> update(T updatedModel);
    ResponseEntity<T> add(TCreate creationModel);
    ResponseEntity<T> deleteById(ID id);
}
