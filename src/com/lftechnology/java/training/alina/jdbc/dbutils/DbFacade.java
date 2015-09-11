package com.lftechnology.java.training.alina.jdbc.dbutils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

import java.sql.PreparedStatement;

public class DbFacade {

    private static final Logger LOGGER = Logger.getLogger(DbFacade.class.getName());
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1/employee_mgmt?rewriteBatchedStatements=true";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public static Connection getDbConnection() {
        if (connection == null) {
            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Exception Message : {0}", new Object[] { e });
            }
        }
        return connection;
    }

    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        if (preparedStatement == null) {
            preparedStatement = connection.prepareStatement(sql);
        }
        return preparedStatement;
    }

    public static void closeDbConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        //connection.setAutoCommit(true);
    }
}
