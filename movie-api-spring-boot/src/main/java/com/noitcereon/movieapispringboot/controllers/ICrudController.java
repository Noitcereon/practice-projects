package com.noitcereon.movieapispringboot.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

// This interface is related to ICrudRepository
public interface ICrudController<T, ID, TCreateUpdate> {
    ResponseEntity<ArrayList<T>> getAll();
    ResponseEntity<T> getById(@PathVariable ID id);
    ResponseEntity<T> update(@RequestBody TCreateUpdate updatedModel, @PathVariable ID id);
    ResponseEntity<T> add(@RequestBody TCreateUpdate creationModel);
    ResponseEntity<ID> deleteById(@PathVariable ID id);
}
