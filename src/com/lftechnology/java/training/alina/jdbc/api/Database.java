package com.lftechnology.java.training.alina.jdbc.api;

import java.util.Map;

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
