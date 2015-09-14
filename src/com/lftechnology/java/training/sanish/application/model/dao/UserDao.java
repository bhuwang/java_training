package com.lftechnology.java.training.sanish.application.model.dao;

import com.lftechnology.java.training.sanish.application.dbconnection.DbConnect;
import com.lftechnology.java.training.sanish.application.model.domain.Employee;
import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.model.domain.UserEmployee;
import com.lftechnology.java.training.sanish.application.model.service.impl.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User data access object
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class UserDao implements UserService {
    private static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());
    private static PreparedStatement preparedStatement;

    @Override public User getUserByUserName(String userName) {
        try {
            String query = "SELECT * FROM users WHERE userName=? AND isTerminated=? LIMIT 1";
            preparedStatement = DbConnect.getPreparedStatement(query, userName, 0);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setResultSetAttributes(rs);
                DbConnect.closePreparedStatement();
                return user;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] { e });
            DbConnect.closePreparedStatement();
        }

        return null;
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
                user.setResultSetAttributes(rs);
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
                user.setResultSetAttributes(rs);
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
                user.setResultSetAttributes(rs);
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

    @Override public boolean setPassword(User user, String password) {
        try {
            String query = "UPDATE users SET password=? WHERE userId=?";
            preparedStatement = DbConnect.getPreparedStatement(query, password, user.getUserId());
            int effectedRow = preparedStatement.executeUpdate();
            DbConnect.closePreparedStatement();
            if (effectedRow != 0) {
                return true;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] { e });
            DbConnect.closePreparedStatement();
        }
        return false;
    }

    @Override public Employee getEmployee(User user) {
        try {
            String query = "SELECT * FROM employees WHERE userId=?";
            preparedStatement = DbConnect.getPreparedStatement(query, user.getUserId());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee();
                employee.setResultSetAttributes(rs);
                DbConnect.closePreparedStatement();
                return employee;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] { e });
            DbConnect.closePreparedStatement();
        }
        return null;
    }

    @Override public List<UserEmployee> searchEmployee(String searchKey) {
        searchKey += "%";
        List<UserEmployee> userEmployeeList = new ArrayList<UserEmployee>();
        String query = "SELECT u.userId, u.userName, u.email, u.isTerminated, e.employeeId, e.fullName, e.address, e.department, e.role "
                + "FROM users AS u LEFT JOIN employees AS e " + "ON (u.userId=e.userId)";
        try {
            query +=
                    " WHERE e.fullName LIKE ? || e.address LIKE ? || e.department LIKE ? || e.role LIKE ? || u.userName LIKE ? || u.email LIKE ?";
            preparedStatement = DbConnect.getPreparedStatement(query, searchKey, searchKey, searchKey, searchKey, searchKey, searchKey);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                UserEmployee userEmployee = new UserEmployee();
                User user = new User();
                user.setResultSetAttributes(rs);
                Employee employee = new Employee();
                employee.setResultSetAttributes(rs);
                userEmployee.setUser(user);
                userEmployee.setEmployee(employee);
                userEmployeeList.add(userEmployee);
            }
            DbConnect.closePreparedStatement();
            return userEmployeeList;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] { e });
            DbConnect.closePreparedStatement();
        }
        return null;
    }
}
