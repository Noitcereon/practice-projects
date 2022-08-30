package com.noitcereon.movieapispringboot.repositories;

import com.noitcereon.movieapispringboot.models.ActorEntity;
import com.noitcereon.movieapispringboot.models.MovieCreate;
import com.noitcereon.movieapispringboot.models.MovieEntity;
import com.noitcereon.movieapispringboot.util.DatabaseModelMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Repository
public class MovieRepository implements ICrudRepository<MovieEntity, Long, MovieCreate> {

    private final Logger logger = LoggerFactory.getLogger(MovieRepository.class);
    private final DataSource dataSource;
    private Connection conn;

    public MovieRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public MovieEntity create(MovieCreate model) {
        return null;
    }

    @Override
    public ArrayList<MovieEntity> getAll() {
        try {
            conn = dataSource.getConnection();
            String sql = "SELECT * FROM Movie";
            PreparedStatement query = conn.prepareStatement(sql);
            ResultSet result = query.executeQuery();
            ArrayList<MovieEntity> movies = new ArrayList<>();
            while (result.next()) {
                MovieEntity movie = DatabaseModelMapping.movieEntityMapping(result);
                movies.add(movie);
            }
            return movies;
        } catch (SQLException e) {
            logger.error("Something went wrong during the retrieval of all movies.");
            throw new RuntimeException(e);
        }
        finally {
            JdbcUtils.closeConnection(conn);
        }
    }


    @Override
    public MovieEntity getById(Long id) {
        try {
            conn = dataSource.getConnection();
            // Get the specific movie
            String sql = "SELECT id, title, releaseYear FROM Movie WHERE Movie.id = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet result = preparedStatement.executeQuery();
            MovieEntity movie;
            if (result.next()) {
                movie = DatabaseModelMapping.movieEntityMapping(result);
                // Get the actors for that movie
                String getActorsSql =
                        "SELECT fkActorId, firstName, lastName, birthYear " +
                                "FROM MovieActor " +
                                "INNER JOIN Actor A on MovieActor.fkActorId = A.id " +
                                "WHERE fkMovieId = ?";
                PreparedStatement preparedStatementActors = conn.prepareStatement(getActorsSql);
                preparedStatementActors.setLong(1, id);
                ResultSet resultActors = preparedStatementActors.executeQuery();
                while(resultActors.next()){
                    movie.getActors().add(
                            DatabaseModelMapping.actorEntityMapping(resultActors)
                    );
                }
                return movie;
            }
            else{
                return new MovieEntity(-1L, "", 0, new ArrayList<>());
            }
        } catch (SQLException e) {
            logger.error("getById(): {}", e.getMessage());
        }
        finally {
            JdbcUtils.closeConnection(conn);
        }

        // It shouldn't make it here
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