package com.lftechnology.java.training.niraj.ems.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.lftechnology.java.training.niraj.ems.domains.Pojo;
import com.lftechnology.java.training.niraj.ems.utils.DbFacade;

public abstract class AbstractDao<T extends Pojo, S> implements CrudService<T, S> {

    /**
     * Find record by attributes
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param conditions
     *            {@link Map}
     * @return T {@link Object} of found record
     * @throws SQLException
     */
    public abstract T findByAttributes(Map<String, String> conditions) throws SQLException;

    /**
     * Find all the records for a particular condition
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param conditions
     *            {@link Map} of conditions
     * @return {@link List} of {@link Object} of the found records
     * @throws SQLException
     */
    public abstract List<T> findAll(Map<String, String> conditions) throws SQLException;

    /**
     * Find all records of a table
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @return
     * @throws SQLException
     */
    public abstract List<T> findAll() throws SQLException;

    /**
     * Get count of records for the given condition
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param conditions
     *            {@link Map} of condition
     * @return int count of the records in the database
     * @throws SQLException
     */
    public abstract int getCount(Map<String, String> conditions) throws SQLException;

    /**
     * Checks if a record exists in the database
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param conditions
     *            {@link Map} of condition
     * @return {@link Boolean}
     * @throws SQLException
     */
    public abstract boolean exists(Map<String, String> conditions) throws SQLException;

    /**
     * Queries the database to find the records
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari2@lftechnology.com>
     * @param t
     * @param s
     * @return {@link List} of {@link Map} of found records
     * @throws SQLException
     */
    protected List<Map<String, String>> findQuery(Connection connection, T t, S s) throws SQLException {
        String[] attributes = {};

        List<Map<String, String>> resultList = null;
        Map<String, String> conditions = new LinkedHashMap<String, String>();
        conditions.put(t.getPrimaryKey(), (String) s);
        try (PreparedStatement stmt = DbFacade.createSelectStatement(connection, t.getTable(), attributes, conditions);) {
            ResultSet result = null;
            result = stmt.executeQuery();
            resultList = parseResult(t, result);
        } catch (SQLException se) {
            throw new SQLException(se);
        }
        return resultList;
    }

    /**
     * Get all the records from a table
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param t
     * @return
     * @throws SQLException
     */
    protected List<Map<String, String>> findQuery(Connection connection, T t) throws SQLException {
        String[] attributes = {};

        List<Map<String, String>> resultList = null;
        try (PreparedStatement stmt = DbFacade.createSelectStatement(connection, t.getTable(), attributes);) {
            ResultSet result = null;
            result = stmt.executeQuery();
            resultList = parseResult(t, result);
        } catch (SQLException se) {
            throw new SQLException(se);
        }
        return resultList;
    }

    /**
     * Queries the database to find the records satisfying the condition
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param t
     * @param conditions
     *            {@link Map} of condition
     * @return {@link List} of {@link Map} of found records
     * @throws SQLException
     */
    protected List<Map<String, String>> findQuery(Connection connection, T t, Map<String, String> conditions) throws SQLException {
        String[] attributes = {};
        List<Map<String, String>> resultList = null;
        try (PreparedStatement stmt = DbFacade.createSelectStatement(connection, t.getTable(), attributes, conditions);) {
            ResultSet result = null;
            result = stmt.executeQuery();

            resultList = parseResult(t, result);
        } catch (SQLException se) {
            throw new SQLException(se);
        }
        return resultList;
    }

    /**
     * Inserts the data to the database
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param t
     * @return int insert row id
     * @throws SQLException
     */
    protected int insertQuery(Connection connection, T t) throws SQLException {
        Map<String, String> info = t.getInfo();
        int insertedId = 0;
        try (PreparedStatement stmt = DbFacade.createInsertStatement(connection, t.getTable(), info)) {
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Failed to add information to table:" + t.getTable());
            }
            ResultSet rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                insertedId = rs.getInt(1);
            }

        } catch (SQLException se) {
            throw new SQLException(se);
        }
        return insertedId;
    }

    /**
     * Parses the result from the query to a collection
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param t
     * @param result
     *            {@link ResultSet}
     * @param count
     *            int number of rows of records
     * @return {@link List} of {@link Map} of records
     * @throws SQLException
     */
    private List<Map<String, String>> parseResult(T t, ResultSet result) throws SQLException {
        List<String> attributes = t.getAttributes();
        List<Map<String, String>> parsedResultList = new ArrayList<Map<String, String>>();
        Map<String, String> parsedResultMap;
        while (result.next()) {
            parsedResultMap = new LinkedHashMap<String, String>();
            for (String attribute : attributes) {
                parsedResultMap.put(attribute, result.getString(attribute));
            }
            parsedResultList.add(parsedResultMap);
        }

        return parsedResultList;
    }

    /**
     * Gets row count for a particular condition
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param connection
     *            {@link Connection}
     * @param table
     *            {@link String}
     * @param conditions
     *            {@link Map} of conditions
     * @return int number of rows
     * @throws SQLException
     */
    private int getRowCount(Connection connection, String table, Map<String, String> conditions) throws SQLException {
        try (PreparedStatement stmt = DbFacade.createCountStatement(connection, table, conditions)) {
            int rowCount = 0;
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                rowCount = result.getInt("rowCount");
            }
            return rowCount;
        } catch (SQLException se) {
            throw new SQLException(se);
        }

    }

    /**
     * Gets row count for a particular condition
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param connection
     *            {@link Connection}
     * @param table
     *            {@link String}
     * @param conditions
     *            {@link Map} of conditions
     * @return int number of rows
     * @throws SQLException
     */
    private int getRowCount(Connection connection, String table) throws SQLException {
        try (PreparedStatement stmt = DbFacade.createCountStatement(connection, table)) {
            int rowCount = 0;
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                rowCount = result.getInt("rowCount");
            }
            return rowCount;
        } catch (SQLException se) {
            throw new SQLException(se);
        }

    }

    /**
     * Gets count of records in the table for a particular condition
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param table
     * @param conditions
     * @return
     * @throws SQLException
     */
    public int count(String table, Map<String, String> conditions) throws SQLException {
        int count = 0;

        try (Connection connection = DbFacade.getConnection()) {
            count = getRowCount(connection, table, conditions);
        } catch (SQLException se) {
            throw new SQLException(se);
        }
        return count;

    }

    /**
     * Count records in a table
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param table
     * @return
     * @throws SQLException
     */
    public int count(String table) throws SQLException {
        int count = 0;

        try (Connection connection = DbFacade.getConnection()) {
            count = getRowCount(connection, table);
        } catch (SQLException se) {
            throw new SQLException(se);
        }
        return count;
    }

    /**
     * Updates the table with the updated information
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param t
     * @return
     * @throws SQLException
     */
    protected int updateQuery(Connection connection, T t) throws SQLException {
        int affectedRows = 0;
        Map<String, String> condition = new LinkedHashMap<String, String>();
        condition.put("id", t.getId());
        try (PreparedStatement stmt = DbFacade.createUpdateStatement(connection, t.getTable(), t.getInfo(), condition)) {
            affectedRows = stmt.executeUpdate();
        } catch (SQLException se) {
            throw new SQLException(se);
        }
        return affectedRows;
    }

    /**
     * Updates the table with the updated information for a particular condition
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * 
     * @param connection
     *            {@link Connection}
     * @param t
     * @param conditions
     * @return
     * @throws SQLException
     */
    protected int updateQuery(Connection connection, T t, Map<String, String> conditions) throws SQLException {
        int affectedRows = 0;
        try (PreparedStatement stmt = DbFacade.createUpdateStatement(connection, t.getTable(), t.getInfo(), conditions);) {
            affectedRows = stmt.executeUpdate();
        } catch (SQLException se) {
            throw new SQLException(se);
        }
        return affectedRows;
    }

}
