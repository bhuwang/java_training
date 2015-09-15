package com.lftechnology.java.training.alina.jdbc.dao.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.alina.jdbc.constants.Constants;
import com.lftechnology.java.training.alina.jdbc.dao.employee.impl.EmployeeDaoImpl;
import com.lftechnology.java.training.alina.jdbc.dao.user.UserDao;
import com.lftechnology.java.training.alina.jdbc.dbutils.DbFacade;
import com.lftechnology.java.training.alina.jdbc.domain.Database;
import com.lftechnology.java.training.alina.jdbc.domain.Employee;
import com.lftechnology.java.training.alina.jdbc.domain.User;
import com.lftechnology.java.training.alina.jdbc.service.DateTimeService;
import com.lftechnology.java.training.alina.jdbc.service.UserService;
import com.lftechnology.java.training.alina.jdbc.views.LoginView;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDaoImpl implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class.getName());

    /**
     * Checks whether employee username/password matches. Logins to the system if password matches.
     * 
     * @param scanner
     *            {@link Scanner}
     * @return loginStatus {@link Boolean} login status
     * @author Alina Shakya <alinashakya@lftechnology.com>
     * @throws SQLException
     */
    public boolean checkEmployeeLogin(Scanner scanner) throws SQLException {
        User user = new User();
        LoginView.displayLoginHeader();
        user = UserService.setLoginInfo(scanner, Constants.USER_LOGIN);
        Boolean loginStatus = false;
        Map<Integer, Object> params = new HashMap<Integer, Object>();
        params.put(1, user.getUsername());
        params.put(2, user.getPassword());
        params.put(3, Constants.NOT_TERMINATED);
        params.put(4, Constants.NOT_DELETED);
        Database database = UserService.setDatabaseParams(params);
        String sql =
                "SELECT * FROM user u inner join employee e on (u.user_id = e.user_id) where u.username=? and u.password=? and u.is_terminated=? and e.is_deleted=?";
        Connection connection = DbFacade.getDbConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement = DbFacade.setParameterizedObjects(database, preparedStatement);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            loginStatus = true;
            checkValidUser(scanner, result.getInt("user_id"));
        } else {
            loginStatus = false;
        }
        return loginStatus;
    }

    /**
     * Checks if user is valid
     * 
     * @param scanner
     *            {@link Scanner}
     * @param userId
     *            {@link Integer}
     * @param connection
     *            {@link Connection}
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private void checkValidUser(Scanner scanner, int userId) throws SQLException {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        UserService userService = new UserService();
        List<Employee> employeeDetails = employeeDao.findByPk(userId);
        for (Employee employee : employeeDetails) {
            userService.getEmployeeRole(scanner, employee);
        }
    }

    @Override
    public List<User> findByPk(Integer userId) {
        List<User> userList = new ArrayList<User>();
        Map<Integer, Object> params = new HashMap<Integer, Object>();
        params.put(1, userId);
        Database database = UserService.setDatabaseParams(params);
        String sql = "Select * from user where user_id=?) ";
        try {
            Connection connection = DbFacade.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement = DbFacade.setParameterizedObjects(database, preparedStatement);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                UserService userService = new UserService();
                userList.add(userService.map(result));
            }
            preparedStatement.close();
        } catch (SQLException sqe) {
            LOGGER.log(Level.WARNING, Constants.SQLEXCEPTION_LOG, new Object[] { sqe });
        }
        return userList;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<User>();
        User user = new User();
        String sql = "Select * from user";
        try {
            Connection connection = DbFacade.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                user.setUsername(result.getString("username"));
                user.setTerminated(result.getBoolean("is_terminated"));
                user.setCreatedAt(result.getTimestamp("created_at"));
                userList.add(user);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, Constants.SQLEXCEPTION_LOG, new Object[] { e });
        }
        return userList;
    }

    @Override
    public User addNew(User user) {
        String sql = "Insert into user (username,password,is_terminated,created_at) values (?,?,?,?)";
        try {
            Connection connection = DbFacade.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setBoolean(3, Constants.NOT_TERMINATED);
            preparedStatement.setTimestamp(4, user.getCreatedAt());
            int result = preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (result > 0 && rs.next()) {
                user.setUserId(rs.getInt(1));
            }
            preparedStatement.close();
        } catch (SQLException sqe) {
            LOGGER.log(Level.WARNING, Constants.SQLEXCEPTION_LOG, new Object[] { sqe });
        }
        return user;
    }

    @Override
    public Boolean delete(String fullname) {
        boolean isDeleted = false;
        String sql =
                "update user u inner join employee e on u.user_id=e.user_id set u.is_terminated=?,u.modified_at=?,e.modified_at=? where (e.fullname=? and u.is_terminated=?)";
        try {
            Connection connection = DbFacade.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, Constants.TERMINATED);
            preparedStatement.setTimestamp(2, DateTimeService.getCurrentTimeStamp());
            preparedStatement.setTimestamp(3, DateTimeService.getCurrentTimeStamp());
            preparedStatement.setString(4, fullname);
            preparedStatement.setBoolean(5, Constants.NOT_TERMINATED);
            int result = preparedStatement.executeUpdate();
            isDeleted = (result != 0) ? true : false;
            preparedStatement.close();
        } catch (SQLException sqe) {
            LOGGER.log(Level.WARNING, Constants.SQLEXCEPTION_LOG, new Object[] { sqe });
        }
        return isDeleted;
    }

    @Override
    public List<User> searchUser(String sql, String... searchContent) {
        return null;
    }

    @Override
    public Integer update(Database db) {
        return null;
    }

    /**
     * Checks valid user by username
     * 
     * @param username
     *            {@link String}
     * @return existUser {@link Boolean} users status
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public boolean checkValidUserByUsername(String username) throws SQLException {
        boolean existUser;
        Map<Integer, Object> params = new HashMap<Integer, Object>();
        params.put(1, username);
        params.put(2, Constants.NOT_TERMINATED);
        params.put(3, Constants.NOT_DELETED);
        Database database = UserService.setDatabaseParams(params);
        Connection connection = DbFacade.getDbConnection();
        String sql =
                "SELECT * FROM user u inner join employee e on (e.user_id = u.user_id) where u.username=? and u.is_terminated=? and e.is_deleted=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement = DbFacade.setParameterizedObjects(database, preparedStatement);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            existUser = true;
        } else {
            existUser = false;
        }
        preparedStatement.close();
        return existUser;
    }
}
