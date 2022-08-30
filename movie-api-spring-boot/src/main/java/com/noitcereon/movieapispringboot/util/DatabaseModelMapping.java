package com.noitcereon.movieapispringboot.util;

import com.noitcereon.movieapispringboot.models.ActorEntity;
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

}
