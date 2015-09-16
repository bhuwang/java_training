package com.lftechnology.java.training.sanish.application.model.dao;

import com.lftechnology.java.training.sanish.application.component.Constants;
import com.lftechnology.java.training.sanish.application.dbconnection.DbConnect;
import com.lftechnology.java.training.sanish.application.model.domain.Employee;
import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.model.domain.UserEmployee;
import com.lftechnology.java.training.sanish.application.model.service.impl.UserService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Override public User getUserByUserName(String userName) {
        try {
            String query = "SELECT * FROM users WHERE userName=? AND isTerminated=? LIMIT 1";
            PreparedStatement preparedStatement = DbConnect.getDbConnection().prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setBoolean(2, false);
            ResultSet rs = preparedStatement.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setResultSetAttributes(rs);
            }

            rs.close();
            preparedStatement.close();
            return user;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
            DbConnect.dbClose();
        }

        return null;
    }

    @Override public int addNew(User user) {
        int lastInsertedId = -1;
        try {
            DateFormat dateFormat = new SimpleDateFormat(Constants.DB_DATE_FORMAT);
            Date date = new Date();
            String query = "INSERT INTO users(userName, password, email, createdAt, isTerminated) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = DbConnect.getDbConnection().prepareStatement(query);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, dateFormat.format(date));
            preparedStatement.setBoolean(5, false);

            int affectedRow = preparedStatement.executeUpdate();
            if (affectedRow > 0) {
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    lastInsertedId = rs.getInt(1);
                }
                rs.close();
            }

            preparedStatement.close();
            return lastInsertedId;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
            DbConnect.dbClose();
        }

        return lastInsertedId;
    }

    @Override public User findById(Integer pk) {
        try {
            String query = "SELECT * FROM users WHERE userId=? AND isTerminated=?";
            PreparedStatement preparedStatement = DbConnect.getDbConnection().prepareStatement(query);
            preparedStatement.setInt(1, pk);
            preparedStatement.setBoolean(2, false);
            ResultSet rs = preparedStatement.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setResultSetAttributes(rs);
            }

            rs.close();
            preparedStatement.close();
            return user;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
            DbConnect.dbClose();
        }

        return null;
    }

    @Override public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        try {
            String query = "SELECT * FROM users WHERE isTerminated=?";
            PreparedStatement preparedStatement = DbConnect.getDbConnection().prepareStatement(query);
            preparedStatement.setBoolean(1, false);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setResultSetAttributes(rs);
                userList.add(user);
            }

            rs.close();
            preparedStatement.close();
            return userList;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
            DbConnect.dbClose();
        }

        return userList;
    }

    @Override public <V> List<User> getAll(String condition, V... parameters) {
        List<User> userList = new ArrayList<User>();
        try {
            String query = "SELECT * FROM users WHERE " + condition;
            PreparedStatement preparedStatement = DbConnect.getDbConnection().prepareStatement(query);
            try {
                for (int i = 0; i < parameters.length; i++) {
                    preparedStatement.setString(i + 1, parameters[i].toString());
                }
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
            }
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setResultSetAttributes(rs);
                userList.add(user);
            }

            rs.close();
            preparedStatement.close();
            return userList;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
            DbConnect.dbClose();
        }

        return userList;
    }

    @Override public <V> int update(String condition, String setString, V... parameters) {
        try {
            String query = "UPDATE users SET " + setString + " WHERE " + condition;
            PreparedStatement preparedStatement = DbConnect.getDbConnection().prepareStatement(query);
            try {
                for (int i = 0; i < parameters.length; i++) {
                    preparedStatement.setString(i + 1, parameters[i].toString());
                }
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
            }

            int effectedRow = preparedStatement.executeUpdate();
            preparedStatement.close();
            return effectedRow;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
            DbConnect.dbClose();
        }

        return 0;
    }

    @Override public boolean setPassword(User user, String password) {
        try {
            DateFormat dateFormat = new SimpleDateFormat(Constants.DB_DATE_FORMAT);
            Date date = new Date();
            String query = "UPDATE users SET password=?, modifiedAt=? WHERE userId=?";
            PreparedStatement preparedStatement = DbConnect.getDbConnection().prepareStatement(query);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, dateFormat.format(date));
            preparedStatement.setInt(3, user.getUserId());
            int effectedRow = preparedStatement.executeUpdate();
            preparedStatement.close();
            if (effectedRow != 0) {
                return true;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
            DbConnect.dbClose();
        }

        return false;
    }

    @Override public Employee getEmployee(User user) {
        try {
            String query = "SELECT * FROM employees WHERE userId=?";
            PreparedStatement preparedStatement = DbConnect.getDbConnection().prepareStatement(query);
            preparedStatement.setInt(1, user.getUserId());
            ResultSet rs = preparedStatement.executeQuery();
            Employee employee = null;
            if (rs.next()) {
                employee = new Employee();
                employee.setResultSetAttributes(rs);
                ;
            }

            rs.close();
            preparedStatement.close();
            return employee;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
            DbConnect.dbClose();
        }

        return null;
    }

    @Override public List<UserEmployee> searchEmployee(String searchKey) {
        List<UserEmployee> userEmployeeList = new ArrayList<UserEmployee>();
        try {
            searchKey += "%";
            String query =
                    "SELECT u.userId, u.userName, u.email, u.isTerminated, e.employeeId, e.fullName, e.address, e.department, e.role "
                            + "FROM users AS u LEFT JOIN employees AS e " + "ON (u.userId=e.userId) " + "WHERE e.fullName LIKE ? || "
                            + "e.address LIKE ? || " + "e.department LIKE ? || " + "e.role LIKE ? || " + "u.userName LIKE ? || "
                            + "u.email LIKE ?";
            PreparedStatement preparedStatement = DbConnect.getDbConnection().prepareStatement(query);
            for (int i = 1; i <= 6; i++) {
                preparedStatement.setString(i, searchKey);
            }

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

            rs.close();
            preparedStatement.close();
            return userEmployeeList;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
            DbConnect.dbClose();
        }

        return userEmployeeList;
    }

    @Override public boolean terminateUser(User user) {
        try {
            DateFormat dateFormat = new SimpleDateFormat(Constants.DB_DATE_FORMAT);
            Date date = new Date();
            String query = "UPDATE users SET isTerminated=?, modifiedAt=? WHERE userId=?";
            PreparedStatement preparedStatement = DbConnect.getDbConnection().prepareStatement(query);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setString(2, dateFormat.format(date));
            preparedStatement.setInt(3, user.getUserId());
            int effectedRow = preparedStatement.executeUpdate();
            preparedStatement.close();
            if (effectedRow > 0) {
                return true;
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
            DbConnect.dbClose();
        }

        return false;
    }
}
