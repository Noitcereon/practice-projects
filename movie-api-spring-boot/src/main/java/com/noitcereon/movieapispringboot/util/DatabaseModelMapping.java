package com.noitcereon.movieapispringboot.util;

import com.noitcereon.movieapispringboot.models.ActorEntity;
import com.noitcereon.movieapispringboot.models.MovieCreateUpdate;
import com.noitcereon.movieapispringboot.models.MovieEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseModelMapping {

    public static MovieEntity movieEntityMapping(ResultSet result) throws SQLException {
        return new MovieEntity(
                result.getLong("id"),
                result.getString("title"),
                result.getInt("releaseYear"),
                new ArrayList<ActorEntity>()
        );
    }

    public static ActorEntity actorEntityMapping(ResultSet result) throws SQLException {
        return new ActorEntity(
                result.getLong("fkActorId"),
                result.getString("firstName"),
                result.getString("lastName"),
                result.getInt("birthYear"),
                new ArrayList<>()
        );
    }

    public static MovieEntity modelToEntity(MovieCreateUpdate model, Long id) {
        MovieEntity output;
        if(model.getActorIds() == null){
            output = new MovieEntity(id, model.getTitle(), model.getReleaseYear(), new ArrayList<>());
            return output;
        }
        // TODO: 31-08-2022 There is currently a quiet bug here (doesn't handle adding actors)
        output = new MovieEntity(id, model.getTitle(), model.getReleaseYear(), new ArrayList<>());
        return output;
    }
}
