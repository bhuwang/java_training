package com.lftechnology.java.training.sanish.application.model.dao;

import com.lftechnology.java.training.sanish.application.dbconnection.DbConnect;
import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.model.service.impl.UserImpl;

import java.sql.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class UserDao implements UserImpl {
    private static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());
    private static PreparedStatement preparedStatement;
    @Override public User getUserByUserName(String userName) {
        try {
            String query = "SELECT * FROM users WHERE userName=? AND isTerminated=? LIMIT 1";
            preparedStatement = DbConnect.getPreparedStatement(query, userName, 0);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                User user = new User();
                setResultSetAttributes(user, rs);
                DbConnect.closePreparedStatement();
                return user;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] { e });
            DbConnect.closePreparedStatement();
        }

        return null;
    }

    public void setResultSetAttributes(User user, ResultSet rs){
        String[] colWithStringDataType = {"userName", "password", "email", "createdAt", "modifiedAt"};
        String[] colWithIntDataType = {"userId"};
        String[] colWithBooleanDataType = {"isTerminated"};
        try {
            ResultSetMetaData metadata = rs.getMetaData();
            int colCount = metadata.getColumnCount();
            String column;
            for(int i=1; i<=colCount; i++){
                column = metadata.getColumnName(i);
                if (Arrays.asList(colWithStringDataType).contains(column)) {
                    user.setAttribute(column, rs.getString(i));
                }else if (Arrays.asList(colWithIntDataType).contains(column)) {
                    user.setAttribute(column, rs.getInt(i));
                }else if (Arrays.asList(colWithBooleanDataType).contains(column)) {
                    user.setAttribute(column, rs.getBoolean(i));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override public User addNew(User user) {
        return null;
    }

    @Override public User findById(Integer pk) {
        return null;
    }

    @Override public ResultSet getAll() {
        return null;
    }

    @Override public ResultSet getAll(String condition) {
        return null;
    }
}
