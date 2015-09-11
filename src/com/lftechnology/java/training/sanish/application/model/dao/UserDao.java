package com.lftechnology.java.training.sanish.application.model.dao;

import com.lftechnology.java.training.sanish.application.dbconnection.DbConnect;
import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.model.service.impl.UserImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User data access object
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
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

    @Override public void setResultSetAttributes(User user, ResultSet rs) {
        String[] colWithStringDataType = { "userName", "password", "email", "createdAt", "modifiedAt" };
        String[] colWithIntDataType = { "userId" };
        String[] colWithBooleanDataType = { "isTerminated" };
        try {
            ResultSetMetaData metadata = rs.getMetaData();
            int colCount = metadata.getColumnCount();
            String column;
            for (int i = 1; i <= colCount; i++) {
                column = metadata.getColumnName(i);
                if (Arrays.asList(colWithStringDataType).contains(column)) {
                    user.setAttribute(column, rs.getString(i));
                } else if (Arrays.asList(colWithIntDataType).contains(column)) {
                    user.setAttribute(column, rs.getInt(i));
                } else if (Arrays.asList(colWithBooleanDataType).contains(column)) {
                    user.setAttribute(column, rs.getBoolean(i));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override public User addNew(User user) {
        // TODO add new user
        return null;
    }

    @Override public User findById(Integer pk) {
        try {
            String query = "SELECT * FROM users WHERE userId=? AND isTerminated=?";
            preparedStatement = DbConnect.getPreparedStatement(query, pk, 0);
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

    @Override public List<User> getAll() {
        List<User> userList = new ArrayList<User>();
        try {
            String query = "SELECT * FROM users WHERE isTerminated=?";
            preparedStatement = DbConnect.getPreparedStatement(query, 0);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                setResultSetAttributes(user, rs);
                userList.add(user);
            }
            DbConnect.closePreparedStatement();
            return userList;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] { e });
            DbConnect.closePreparedStatement();
        }
        return null;
    }

    @Override public <V> List<User> getAll(String condition, V... parameters) {
        List<User> userList = new ArrayList<User>();
        try {
            String query = "SELECT * FROM users WHERE " + condition;
            preparedStatement = DbConnect.getPreparedStatement(query, parameters);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                setResultSetAttributes(user, rs);
                userList.add(user);
            }
            DbConnect.closePreparedStatement();
            return userList;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] { e });
            DbConnect.closePreparedStatement();
        }
        return null;
    }

    @Override public <V> int update(String condition, String setString, V... parameters) {
        try {
            String query = "UPDATE users SET " + setString + " WHERE " + condition;
            preparedStatement = DbConnect.getPreparedStatement(query, parameters);
            int effectedRow = preparedStatement.executeUpdate();
            DbConnect.closePreparedStatement();
            return effectedRow;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] { e });
            DbConnect.closePreparedStatement();
        }
        return 0;
    }
}
