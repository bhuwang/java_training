package com.lftechnology.java.training.alina.jdbc.dao.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.lftechnology.java.training.alina.jdbc.constants.Constants;
import com.lftechnology.java.training.alina.jdbc.dao.user.UserDao;
import com.lftechnology.java.training.alina.jdbc.dbutils.DbFacade;
import com.lftechnology.java.training.alina.jdbc.domain.Employee;
import com.lftechnology.java.training.alina.jdbc.domain.User;
import com.lftechnology.java.training.alina.jdbc.service.DateTimeService;
import com.lftechnology.java.training.alina.jdbc.service.UserService;
import com.lftechnology.java.training.alina.jdbc.views.LoginView;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDaoImpl implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class.getName());
    private static Employee employee = new Employee();
    private static List<User> userList = new ArrayList<User>();
    private static List<Employee> employeeList = new ArrayList<Employee>();

    /**
     * Checks whether employee username or password matches. Logins to the system if password matches.
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
        user = UserService.setLoginInfo(scanner);
        Boolean loginStatus = false;
        String sql =
                "SELECT * FROM user u inner join employee e where u.username=? and u.password=? and u.is_terminated=? and e.is_deleted=?";
        Connection connection = DbFacade.getDbConnection();
        PreparedStatement preparedStatement = DbFacade.getPreparedStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setBoolean(3, Constants.NOT_TERMINATED);
        preparedStatement.setBoolean(4, Constants.NOT_DELETED);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            loginStatus = true;
            checkValidUser(scanner, result.getInt("user_id"), connection);
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
    private void checkValidUser(Scanner scanner, int userId, Connection connection) throws SQLException {
        String sql = "SELECT * FROM employee where user_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, userId);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            UserService.getEmployeeRole(scanner, result);
        } else {
            LOGGER.log(Level.INFO, "Employee not found");
        }
    }

    @Override
    public User findByPk(Integer id) {
        Connection connection = DbFacade.getDbConnection();
        Statement statement = null;
        ResultSet rs = null;

        User user = new User();
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM user where id= " + id;
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                user.setUsername(rs.getString("username"));
            }
        } catch (SQLException e) {
            System.err.println("Exception while creating statement.");
        } finally {
            try {
                connection.close();
            } catch (SQLException se) {
                System.err.println("Error closing connection.");
            }
        }
        return user;
    }

    @Override
    public List<User> findAll() {
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
                userList.add(employee);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "SQLException : {0}", new Object[] { e });
        }
        return userList;
    }

    @Override
    public int addNew(User user) {
        int employeeId = 0;
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
            if (result > 0) {
                if (rs.next()) {
                    employeeId = rs.getInt(1);
                }
            }
        } catch (SQLException sqe) {
            LOGGER.log(Level.WARNING, "SQLException : {0}", new Object[] { sqe });
        }
        return employeeId;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean delete(String username) {
        boolean isDeleted = false;
        String sql =
                "update user u inner join employee e on u.user_id=e.user_id set u.is_terminated=?,u.modified_at=?,e.modified_at=? where e.fullname=?";
        try {
            Connection connection = DbFacade.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, Constants.TERMINATED);
            preparedStatement.setTimestamp(2, DateTimeService.getCurrentTimeStamp());
            preparedStatement.setTimestamp(3, DateTimeService.getCurrentTimeStamp());
            preparedStatement.setString(4, username);
            int result = preparedStatement.executeUpdate();
            isDeleted = (result != 0) ? true : false;
        } catch (SQLException sqe) {
            LOGGER.log(Level.WARNING, "SQLException : {0}", new Object[] { sqe });
        }
        return isDeleted;
    }

    @Override
    public List<Employee> searchEmployee(String sql, String... searchContent) {
        try {
            Connection connection = DbFacade.getDbConnection();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            for (String content : searchContent) {
                preparedStatement.setString(1, content);
                preparedStatement.setString(2, content);
                preparedStatement.setString(3, content);
            }
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                employeeList.add(UserService.map(result));
            }

        } catch (SQLException sqe) {
            LOGGER.log(Level.WARNING, "SQLException : {0}", new Object[] { sqe });
        }
        return employeeList;
    }
}
