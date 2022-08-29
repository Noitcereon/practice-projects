package com.noitcereon.movieapispringboot.repositories;

import com.noitcereon.movieapispringboot.models.MovieCreate;
import com.noitcereon.movieapispringboot.models.MovieEntity;
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
            String sql = "SELECT * FROM Movies";
            PreparedStatement query = connection.prepareStatement(sql);
            ResultSet result = query.executeQuery();

            while(result.next()){
                System.out.println("I'm in the result set");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Long getById() {
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
