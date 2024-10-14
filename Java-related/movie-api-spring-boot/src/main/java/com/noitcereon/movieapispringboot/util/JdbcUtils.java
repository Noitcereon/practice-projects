package com.noitcereon.movieapispringboot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtils {

    private static final Logger logger = LoggerFactory.getLogger(JdbcUtils.class);
    public static void closeConnection(Connection conn){
        org.springframework.jdbc.support.JdbcUtils.closeConnection(conn);
    }
    public static void rollbackTransaction(Connection conn){
        try{
            conn.rollback();
        } catch (SQLException e) {
            logger.debug(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
