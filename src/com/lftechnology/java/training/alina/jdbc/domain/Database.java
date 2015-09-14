package com.lftechnology.java.training.alina.jdbc.domain;

import java.util.Map;

/**
 * Database class consists of parameters sqlQuery and parameters
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 *
 */
public class Database {
    private String sqlQuery;
    private Map<Integer, Object> parameters;

    public String getSqlQuery() {
        return sqlQuery;
    }

    public void setSqlQuery(String sql) {
        sqlQuery = sql;
    }

    public Map<Integer, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<Integer, Object> param) {
        parameters = param;
    }
}
