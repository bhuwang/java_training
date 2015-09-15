package com.lftechnology.java.training.niraj.ems.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility class related to database
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public class DbFacade {
    private static final Logger LOGGER = Logger.getLogger(DbFacade.class.getName());
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/employee_management";
    private static final String USER = "root";
    private static final String PASS = "";

    private DbFacade() {

    }

    /**
     * Get the connection
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException ce) {
            LOGGER.log(Level.SEVERE, "Class not found exception: \n {0}", ce);
        } catch (SQLException se) {
            LOGGER.log(Level.SEVERE, "SQL Exception:\n{0}", se);
        }

        return connection;
    }

    /**
     * Create select statement
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param connection
     * @param table
     * @param attributes
     * @param conditions
     * @return
     * @throws SQLException
     */
    public static PreparedStatement createSelectStatement(Connection connection, String table, String[] attributes,
            Map<String, String> conditions) throws SQLException {

        StringBuilder query = new StringBuilder();
        query.append(DbFacade.addSelectClause(attributes, table));
        query.append(DbFacade.addWhereClause(conditions));
        PreparedStatement stmt = connection.prepareStatement(query.toString());
        return setStatementParameters(stmt, conditions);

    }

    /**
     * Creates count statement with condition
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param connection
     * @param table
     * @param conditions
     * @return
     * @throws SQLException
     */
    public static PreparedStatement createCountStatement(Connection connection, String table, Map<String, String> conditions)
            throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append(Constants.SELECT_COUNT_QUERY);
        query.append(table);
        query.append(DbFacade.addWhereClause(conditions));

        PreparedStatement stmt = connection.prepareStatement(query.toString());
        return setStatementParameters(stmt, conditions);
    }

    /**
     * Creates count statement with condition
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param connection
     * @param table
     * @param conditions
     * @return
     * @throws SQLException
     */
    public static PreparedStatement createCountStatement(Connection connection, String table) throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append(Constants.SELECT_COUNT_QUERY);
        query.append(table);

        PreparedStatement stmt = connection.prepareStatement(query.toString());
        return stmt;
    }

    /**
     * Create select statement
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param connection
     * @param table
     * @param attributes
     * @return
     * @throws SQLException
     */
    public static PreparedStatement createSelectStatement(Connection connection, String table, String[] attributes) throws SQLException {
        return connection.prepareStatement(addSelectClause(attributes, table));
    }

    /**
     * Create update statement
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param connection
     * @param table
     * @param values
     * @return
     * @throws SQLException
     */
    public static PreparedStatement createUpdateStatement(Connection connection, String table, Map<String, String> values)
            throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(addUpdateClause(table, values));
        return setStatementParameters(stmt, values);
    }

    /**
     * Creates update statement with conditions
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param connection
     * @param table
     * @param values
     * @param conditions
     * @return
     * @throws SQLException
     */
    public static PreparedStatement createUpdateStatement(Connection connection, String table, Map<String, String> values,
            Map<String, String> conditions) throws SQLException {
        StringBuilder query = new StringBuilder();
        if (values.containsKey("id")) {
            values.remove("id");
        }
        query.append(addUpdateClause(table, values));
        query.append(addWhereClause(conditions));
        PreparedStatement stmt = connection.prepareStatement(query.toString());
        return setStatementParametersWithWhereClause(stmt, values, conditions);

    }

    /**
     * Adds update clause
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param table
     * @param values
     * @return
     */
    private static String addUpdateClause(String table, Map<String, String> values) {
        StringBuilder query = new StringBuilder();
        query.append("UPDATE ");
        query.append(table);
        query.append(" SET ");
        for (Entry<String, String> entry : values.entrySet()) {
            String key = entry.getKey();
            if (!key.equals("id")) {
                query.append(key);
                query.append("=?, ");
            }

        }
        return Utils.trimEnd(query.toString(), ", ");
    }

    /**
     * Adds select clause
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param attributes
     * @param table
     * @return
     */
    private static String addSelectClause(String[] attributes, String table) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ");
        String selectAttrs = attributes.length > 0 ? Utils.implode(attributes, ", ") : "*";
        query.append(selectAttrs);

        query.append(" FROM ");
        query.append(table);
        return query.toString();
    }

    /**
     * Adds where clause
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param conditions
     * @return
     */
    private static String addWhereClause(Map<String, String> conditions) {
        StringBuilder query = new StringBuilder();
        query.append(" WHERE ");

        for (Map.Entry<String, String> entry : conditions.entrySet()) {
            query.append(entry.getKey());
            query.append("=? AND ");
        }
        return Utils.trimEnd(query.toString(), "AND ");
    }

    /**
     * Create statement for insert query
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param connection
     * @param table
     * @param values
     * @return
     * @throws SQLException
     */
    public static PreparedStatement createInsertStatement(Connection connection, String table, Map<String, String> values)
            throws SQLException {
        String insertStmt;
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO ");
        query.append(table);
        query.append("(");
        String insertAttributes = Utils.implode(Utils.getKeysArray(values), ", ");
        query.append(insertAttributes);
        query.append(")");
        query.append("VALUES(");
        for (int i = 0; i < values.size(); i++) {
            query.append("?,");
        }
        insertStmt = Utils.trimEnd(query.toString(), ",");
        StringBuilder insertQuery = new StringBuilder(insertStmt);
        insertQuery.append(")");
        PreparedStatement stmt = connection.prepareStatement(insertQuery.toString(), Statement.RETURN_GENERATED_KEYS);
        return setStatementParameters(stmt, values);
    }

    /**
     * Create prepared statement without conditions
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param statement
     * @param parameters
     * @return
     * @throws SQLException
     */
    private static PreparedStatement setStatementParameters(PreparedStatement statement, Map<String, String> parameters)
            throws SQLException {

        int i = 1;
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            statement.setString(i, entry.getValue());
            i++;
        }
        return statement;
    }

    /**
     * Create prepared statement with where clause
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param statement
     * @param parameters
     * @param conditions
     * @return
     * @throws SQLException
     */
    private static PreparedStatement setStatementParametersWithWhereClause(PreparedStatement statement, Map<String, String> parameters,
            Map<String, String> conditions) throws SQLException {
        int i = 1;
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            statement.setString(i, entry.getValue());
            i++;
        }
        for (Map.Entry<String, String> condition : conditions.entrySet()) {
            statement.setString(i, condition.getValue());
            i++;
        }
        return statement;
    }
}
