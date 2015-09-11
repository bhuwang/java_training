package com.lftechnology.java.training.sanish.application.dbconnection;

import java.sql.*;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provide database connection and close static functions
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public abstract class DbConnect {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/service_db?rewriteBatchedStatements=true";
    static final String USER = "root";
    static final String PASS = "";
    private static final Logger LOGGER = Logger.getLogger(DbConnect.class.getName());
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    public DbConnect() {
    }

    /**
     * Return database connection object
     *
     * @return {@link Connection}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static Connection getDbConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try {
                    connection = DriverManager.getConnection(DB_URL, USER, PASS);
                    return connection;
                } catch (SQLException e) {
                    LOGGER.log(Level.WARNING, "Exception : {1}", new Object[] { e });
                }
            } catch (ClassNotFoundException e) {
                LOGGER.log(Level.WARNING, "Exception : {1}", new Object[] { e });
            }

            return null;
        }
    }

    /**
     * Return database statement object
     *
     * @return {@link Statement}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static Statement getStatement() {
        try {
            statement = getDbConnection().createStatement();
            return statement;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Exception : {1}", new Object[] { e });
        }
        return null;
    }

    /**
     * Close database statement
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void closeStatement() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "Exception : {1}", new Object[] { e });
            }
        }
    }

    /**
     * Get database preparedStatement
     *
     * @param queryString {@link String} prepared statement query
     * @param attributes  attributes of prepared statement
     * @param <T>
     * @return {@link PreparedStatement}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static <T> PreparedStatement getPreparedStatement(String queryString, T... attributes) {
        try {
            preparedStatement = getDbConnection().prepareStatement(queryString);
            for (int i = 0; i < attributes.length; i++) {
                preparedStatement.setString(i + 1, attributes[i].toString());
            }
            return preparedStatement;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] { e });
        }
        return null;
    }

    /**
     * Close prepared statement
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void closePreparedStatement() {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "Exception : {1}", new Object[] { e });
            }
        }
    }

    /**
     * Close database connection
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void DbClose() {
        try {
            if (statement != null) {
                statement.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Exception : {1}", new Object[] { e });
        }
    }
}
