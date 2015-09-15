package com.lftechnology.java.training.alina.jdbc.dbutils;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.lftechnology.java.training.alina.jdbc.domain.Database;

/**
 * DbFacade consists of database connection related functionalities
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class DbFacade {

    private static final Logger LOGGER = Logger.getLogger(DbFacade.class.getName());
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/employee_mgmt?rewriteBatchedStatements=true";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection connection;

    private DbFacade() {

    }

    /**
     * Connects to database
     * 
     * @return connection {@link Connection}
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
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

    /*
     * Closes database connections
     */
    public static void closeDbConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    /**
     * Set value on the basis of different instances
     * 
     * @param ps
     * @param args
     * @return
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static PreparedStatement mapParams(PreparedStatement ps, Object... args) throws SQLException {
        int i = 1;
        for (Object arg : args) {
            if (arg instanceof Date) {
                ps.setDate(i++, (Date) arg);
            } else if (arg instanceof Integer) {
                ps.setInt(i++, (Integer) arg);
            } else if (arg instanceof Long) {
                ps.setLong(i++, (Long) arg);
            } else if (arg instanceof Double) {
                ps.setDouble(i++, (Double) arg);
            } else if (arg instanceof Float) {
                ps.setFloat(i++, (Float) arg);
            } else {
                ps.setString(i++, (String) arg);
            }
        }
        return ps;
    }

    /**
     * Count sql parameters
     * 
     * @param {@link PreparedStatement}
     * @return {@link Integer} no. of sql params
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static int countSqlParameters(PreparedStatement preparedStatement) throws SQLException {
        ParameterMetaData paramMetaData = null;
        paramMetaData = preparedStatement.getParameterMetaData();
        return paramMetaData.getParameterCount();
    }

    /**
     * Sets value in prepared statement
     * 
     * @param database
     *            {@link Database}
     * @param preparedStatement
     *            {@link PreparedStatement}
     * @return {@link PreparedStatement} parameterized value
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static PreparedStatement setParameterizedObjects(Database database, PreparedStatement preparedStatement) throws SQLException {
        if (database.getParameters() != null) {
            for (Integer key : database.getParameters().keySet()) {
                preparedStatement.setObject(key, database.getParameters().get(key));
            }
        }
        return preparedStatement;
    }
}
