package com.noitcereon.movieapispringboot.repositories;

import com.noitcereon.movieapispringboot.models.ActorEntity;
import com.noitcereon.movieapispringboot.models.MovieCreate;
import com.noitcereon.movieapispringboot.models.MovieEntity;
import com.noitcereon.movieapispringboot.util.DatabaseModelMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class MovieRepository implements ICrudRepository<MovieEntity, Long, MovieCreate> {

    private final Logger logger = LoggerFactory.getLogger(MovieRepository.class);
    private final Connection connection;

    public MovieRepository(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            logger.error("Fatal error: couldn't connect to the database.");
            throw new RuntimeException(e);
        }
    }

    @Override
    public MovieEntity create(MovieCreate model) {
        return null;
    }

    @Override
    public ArrayList<MovieEntity> getAll() {
        try {
            String sql = "SELECT * FROM Movie";
            PreparedStatement query = connection.prepareStatement(sql);
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
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("Error during closing of connection");
            }
        }
    }


    @Override
    public MovieEntity getById(Long id) {
        try {
            // Get the specific movie
            String sql = "SELECT title, releaseYear FROM Movie WHERE Movie.id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
                PreparedStatement preparedStatementActors = connection.prepareStatement(getActorsSql);
                preparedStatementActors.setLong(1, id);
                ResultSet resultActors = preparedStatementActors.executeQuery();
                while(resultActors.next()){
                    movie.getActors().add(
                            DatabaseModelMapping.actorEntityMapping(result)
                    );
                }
                return movie;
            }
        } catch (SQLException e) {
            logger.error("Something went wrong during movie getById()");
        }
        // It shouldn't make it here (unless there is no data associated with the id)
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
