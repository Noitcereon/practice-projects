package com.noitcereon.movieapispringboot.repositories;

import com.noitcereon.movieapispringboot.models.ActorEntity;
import com.noitcereon.movieapispringboot.models.MovieCreateUpdate;
import com.noitcereon.movieapispringboot.models.MovieEntity;
import com.noitcereon.movieapispringboot.util.DatabaseModelMapping;
import com.noitcereon.movieapispringboot.util.JdbcUtils;
import com.noitcereon.movieapispringboot.util.ReusableQueries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;


@Repository
public class MovieRepository implements ICrudRepository<MovieEntity, Long, MovieCreateUpdate> {

    private final Logger logger = LoggerFactory.getLogger(MovieRepository.class);
    private final DataSource dataSource;
    private Connection conn;

    public MovieRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public MovieEntity create(MovieCreateUpdate model) {
        // TODO: 31-08-2022 Refactor so the code is less messy
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            String sql = "INSERT INTO Movie(title, releaseYear) " +
                    "VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, model.getTitle());
            statement.setInt(2, model.getReleaseYear());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated != 1) return null; // return null indicates error
            ResultSet generatedKey = statement.getGeneratedKeys();
            MovieEntity movie;

            if (generatedKey.next()) {
                long createdMovieId = generatedKey.getLong(1);
                ArrayList<Long> actorIds = model.getActorIds();
                if (actorIds.isEmpty()) {
                    movie = new MovieEntity(createdMovieId, model.getTitle(), model.getReleaseYear(), new ArrayList<>());
                    conn.commit();
                } else {
                    // Create query to get actors
                    PreparedStatement getActorInfoQuery = ReusableQueries.getActorsByIdStatement(conn, actorIds);
                    // Execute the query and use it in MovieEntity
                    ResultSet result = getActorInfoQuery.executeQuery();
                    ArrayList<ActorEntity> actors = new ArrayList<>();
                    while (result.next()) {
                        ActorEntity actor = new ActorEntity(
                                result.getLong("id"),
                                result.getString("firstName"),
                                result.getString("lastName"),
                                result.getInt("birthYear"),
                                null
                        );
                        actors.add(actor);
                    }
                    movie = new MovieEntity(generatedKey.getLong(1), model.getTitle(), model.getReleaseYear(), actors);

                    // Update MovieActor table
                    // Prepare query
                    try (PreparedStatement updateMovieActorStatement = ReusableQueries.insertIntoMovieActors(conn, movie, actorIds)) {
                        // Execute query
                        int rowsUpdated2 = updateMovieActorStatement.executeUpdate();
                        logger.info("Updated {} rows in MovieActor", rowsUpdated2);
                        // if everything ran without error, commit transaction.
                        conn.commit();
                    }
                }
                return movie;
            }

            return null;

        } catch (SQLException e) {
            logger.error("Failed during creation of movie, rolling back transaction. Error: {}", e.getMessage());
            JdbcUtils.rollbackTransaction(conn);
        } finally {
            JdbcUtils.closeConnection(conn);
        }
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
        } finally {
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
                while (resultActors.next()) {
                    movie.getActors().add(
                            DatabaseModelMapping.actorEntityMapping(resultActors)
                    );
                }
                return movie;
            } else {
                return new MovieEntity(-1L, "", 0, new ArrayList<>());
            }
        } catch (SQLException e) {
            logger.error("getById(): {}", e.getMessage());
        } finally {
            JdbcUtils.closeConnection(conn);
        }

        // It shouldn't make it here
        return null;
    }

    @Override
    public MovieEntity update(MovieCreateUpdate model, Long id) {
        try {
            // TODO: 31-08-2022 Make update also handle actors.
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);

            String sql = "UPDATE Movie " +
                    "SET title = ?, releaseYear = ? " +
                    "WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, model.getTitle());
            statement.setInt(2, model.getReleaseYear());
            statement.setLong(3, id);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected != 1) return null;
            conn.commit();

            return DatabaseModelMapping.modelToEntity(model, id);

        } catch (SQLException e) {
            logger.error(e.getMessage());
            JdbcUtils.rollbackTransaction(conn);
        } finally {
            JdbcUtils.closeConnection(conn);
        }
        return null;
    }

    @Override
    public Long delete(Long movieId) {
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            String sql = "DELETE FROM Movie WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, movieId);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted == 1) {
                conn.commit();
                return movieId;
            }
            if(rowsDeleted == 0){
                return -1L; // indicating that no content was found.
            }
            if(rowsDeleted > 1){
                logger.warn("Tried to delete more than one Movie entry during deletion of single entity.");
                JdbcUtils.rollbackTransaction(conn);
            }
            return null;
        } catch (SQLException e) {
            logger.error("Failed to delete movie with id {}. Error: {}", movieId, e.getMessage());
            JdbcUtils.rollbackTransaction(conn);
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.closeConnection(conn);
        }
    }
}
