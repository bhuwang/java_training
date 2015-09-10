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
import com.lftechnology.java.training.niraj.utils.DbFacade;

public abstract class AbstractDao<T extends Pojo, S> implements CrudService<T, S> {

    protected List<Map<String, String>> findQuery(T t, S s) throws SQLException {
        String[] attributes = {};

        List<Map<String, String>> resultList = null;
        Map<String, String> conditions = new LinkedHashMap<String, String>();
        conditions.put(t.getPrimaryKey(), (String) s);
        try (Connection connection = DbFacade.getConnection();
                PreparedStatement stmt = DbFacade.createSelectStatement(connection, t.getTable(), attributes, conditions);) {
            ResultSet result = null;
            result = stmt.executeQuery();
            int count = getRowCount(connection, t.getTable(), conditions);
            resultList = parseResult(t, result, count);
        } catch (SQLException se) {
            throw new SQLException(se);
        }
        return resultList;
    }

    protected int insertQuery(T t) throws SQLException {
        Map<String, String> info = t.getInfo();
        int insertedId = 0;
        try (Connection connection = DbFacade.getConnection();
                PreparedStatement stmt = DbFacade.createInsertStatement(connection, t.getTable(), info)) {
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

    private List<Map<String, String>> parseResult(T t, ResultSet result, int count) throws SQLException {
        List<String> attributes = t.getAttributes();
        List<Map<String, String>> parsedResultList = new ArrayList<Map<String, String>>();
        Map<String, String> parsedResultMap;
        for (int i = 0; i < count; i++) {
            parsedResultMap = new LinkedHashMap<String, String>();
            for (String attribute : attributes) {
                while (result.next()) {
                    parsedResultMap.put(attribute, result.getString(attribute));
                }
            }
            parsedResultList.add(parsedResultMap);

        }

        return parsedResultList;
    }

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

    public int count(String table, Map<String, String> conditions) throws SQLException {
        int count = 0;
        try (Connection connection = DbFacade.getConnection()) {
            count = getRowCount(connection, table, conditions);
        } catch (SQLException se) {
            throw new SQLException(se);
        }
        return count;

    }

    protected int updateQuery(T t) throws SQLException {
        int affectedRows = 0;
        Map<String, String> condition = new LinkedHashMap<String, String>();
        condition.put("id", t.getId());
        try (Connection connection = DbFacade.getConnection();
                PreparedStatement stmt = DbFacade.createUpdateStatement(connection, t.getTable(), t.getInfo(), condition)) {
            affectedRows = stmt.executeUpdate();
        } catch (SQLException se) {
            throw new SQLException(se);
        }
        return affectedRows;
    }

    protected int updateQuery(T t, Map<String, String> conditions) throws SQLException {
        int affectedRows = 0;
        try (Connection connection = DbFacade.getConnection();
                PreparedStatement stmt = DbFacade.createUpdateStatement(connection, t.getTable(), t.getInfo(), conditions);) {
            affectedRows = stmt.executeUpdate();
        } catch (SQLException se) {
            throw new SQLException(se);
        }
        return affectedRows;
    }

}
