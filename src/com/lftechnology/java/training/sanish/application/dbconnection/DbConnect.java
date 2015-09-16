package com.lftechnology.java.training.sanish.application.dbconnection;

import com.lftechnology.java.training.sanish.application.component.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
                    LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
                }
            } catch (ClassNotFoundException e) {
                LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
            }

            return null;
        }
    }

    /**
     * Close database connection
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void dbClose() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
        }
    }
}
