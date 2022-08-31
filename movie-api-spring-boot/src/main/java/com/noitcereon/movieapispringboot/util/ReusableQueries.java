package com.noitcereon.movieapispringboot.util;

import com.noitcereon.movieapispringboot.models.MovieEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReusableQueries {
    public static PreparedStatement insertIntoMovieActors(Connection conn, MovieEntity movie, ArrayList<Long> actorsIds) throws SQLException {
        StringBuilder updateMovieActorSql = new StringBuilder("INSERT INTO MovieActor (fkActorId, fkMovieId) " +
                "VALUES ");
        for (int i = 0; i < actorsIds.size(); i++) {
            updateMovieActorSql.append("(?, ?),");
        }
        updateMovieActorSql.deleteCharAt(updateMovieActorSql.length() - 1);
        PreparedStatement updateMovieActorNonQuery = conn.prepareStatement(updateMovieActorSql.toString());
        int parameterIndex = 1;
        for (Long actorsId : actorsIds) {
            updateMovieActorNonQuery.setLong(parameterIndex, actorsId);
            updateMovieActorNonQuery.setLong(parameterIndex + 1, movie.getId());
            parameterIndex += 2;
        }
        return updateMovieActorNonQuery;
    }
    public static PreparedStatement getActorsByIdStatement(Connection conn, ArrayList<Long> actorIds) throws SQLException {
        String sql2 = "SELECT id, firstName, lastName, birthYear FROM Actor WHERE id = ?";
        StringBuilder sqlStringBuilder = new StringBuilder(sql2);

        for (int index = 1; index < actorIds.size(); index++) {
            sqlStringBuilder.append(" OR id = ?");
        }
        PreparedStatement getActorInfoQuery = conn.prepareStatement(sqlStringBuilder.toString());
        getActorInfoQuery.setLong(1, actorIds.get(0));
        for (int actorIndex = 1; actorIndex < actorIds.size(); actorIndex++) {
            int parameterIndex = actorIndex + 1;
            getActorInfoQuery.setLong(parameterIndex, actorIds.get(actorIndex));
        }
        return getActorInfoQuery;
    }
}
