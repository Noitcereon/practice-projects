package com.noitcereon.movieapispringboot.repositories;

import com.noitcereon.movieapispringboot.models.ActorEntity;
import com.noitcereon.movieapispringboot.models.MovieCreateUpdate;
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
public class MovieRepository implements ICrudRepository<MovieEntity, Long, MovieCreateUpdate> {

    private final Logger logger = LoggerFactory.getLogger(MovieRepository.class);
    private final DataSource dataSource;
    private Connection conn;

    public MovieRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public MovieEntity create(MovieCreateUpdate model) {
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
                if(model.getActorIds().isEmpty())
                {
                    movie = new MovieEntity(createdMovieId, model.getTitle(), model.getReleaseYear(), new ArrayList<>());
                    conn.commit();
                }
                else{
                    String sql2 = "SELECT id, firstName, lastName, birthYear FROM Actor WHERE id = ?";
                    StringBuilder sqlStringBuilder = new StringBuilder(sql2);
                    ArrayList<Long> actorsIds = model.getActorIds();
                    for (int index = 1; index < actorsIds.size(); index++) {
                        sqlStringBuilder.append(" OR id = ?");
                    }
                    PreparedStatement getActorInfoQuery = conn.prepareStatement(sqlStringBuilder.toString());
                    getActorInfoQuery.setLong(1, actorsIds.get(0));
                    for (int actorIndex = 1; actorIndex < actorsIds.size(); actorIndex++) {
                        int parameterIndex = actorIndex+1;
                        getActorInfoQuery.setLong(parameterIndex, actorsIds.get(actorIndex));
                    }
                    ResultSet result = getActorInfoQuery.executeQuery();
                    ArrayList<ActorEntity> actors = new ArrayList<>();
                    while(result.next()){
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
                    StringBuilder updateMovieActorSql = new StringBuilder("INSERT INTO MovieActor (fkActorId, fkMovieId) " +
                            "VALUES ");
                    for (int i = 0; i < actorsIds.size(); i++) {
                        updateMovieActorSql.append("(?, ?),");
                    }
                    updateMovieActorSql.deleteCharAt(updateMovieActorSql.length()-1);
                    PreparedStatement updateMovieActorNonQuery = conn.prepareStatement(updateMovieActorSql.toString());
                    int parameterIndex = 1;
                    for (Long actorsId : actorsIds) {
                        updateMovieActorNonQuery.setLong(parameterIndex, actorsId);
                        updateMovieActorNonQuery.setLong(parameterIndex + 1, movie.getId());
                        parameterIndex += 2;
                    }
                    int rowsUpdated2 = updateMovieActorNonQuery.executeUpdate();
                    logger.info("Updated {} rows in MovieActor", rowsUpdated2);
                    // if everything ran without error, commit it.
                    conn.commit();
                }
                return movie;
            }

            return null;

        } catch (SQLException e) {
            try {
                logger.error("Failed during creation of movie, rolling back transaction. Error: {}", e.getMessage());
                conn.rollback();
            } catch (SQLException ex) {
                logger.error("Failed to rollback transaction");
                throw new RuntimeException(ex);
            }
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
            if(rowsAffected != 1) return null;
            conn.commit();

            return DatabaseModelMapping.modelToEntity(model, id);

        } catch (SQLException e) {
            logger.error(e.getMessage());
            try {
                conn.rollback();
            } catch (SQLException ex) {
                logger.error(ex.getMessage());
                throw new RuntimeException(ex);
            }
        } finally {
            JdbcUtils.closeConnection(conn);
        }
        return null;
    }

    @Override
    public Long delete(Long entityId) {
        return null;
    }
}
