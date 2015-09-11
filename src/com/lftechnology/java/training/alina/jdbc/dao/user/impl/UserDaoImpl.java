package com.lftechnology.java.training.alina.jdbc.dao.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.alina.jdbc.dao.employee.impl.EmployeeDaoImpl;
import com.lftechnology.java.training.alina.jdbc.dao.user.UserDao;
import com.lftechnology.java.training.alina.jdbc.dbutils.DbFacade;
import com.lftechnology.java.training.alina.jdbc.domain.Employee;
import com.lftechnology.java.training.alina.jdbc.domain.User;
import com.lftechnology.java.training.alina.jdbc.service.DateTimeService;
import com.lftechnology.java.training.alina.jdbc.service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDaoImpl implements UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class.getName());
    private static User user = new User();
    private static Employee employee = new Employee();
    private static UserDaoImpl userDao = new UserDaoImpl();
    private static EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
    private static List<User> userList = new ArrayList<User>();

    @Override
    public User findByPk(String id) {
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
    public Integer addNew(User user) {
        int employeeId = 0;
        String sql = "Insert into user (username,password,is_terminated,created_at) values (?,?,?,?)";
        try {
            Connection connection = DbFacade.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setBoolean(3, true);
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
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Checks whether employee username and password matches. Logins to the system if password matches.
     * 
     * @param scanner
     *            {@link Scanner}
     * @return loginStatus {@link Boolean} login status
     * @author Alina Shakya <alinashakya@lftechnology.com>
     * @throws SQLException
     */
    public boolean checkEmployeeLogin(Scanner scanner) throws SQLException {
        user = UserService.setLoginInfo(scanner);
        Boolean loginStatus = false;
        String sql = "SELECT * FROM user where username=? and password=? and is_terminated=?";
        Connection connection = DbFacade.getDbConnection();
        PreparedStatement preparedStatement = DbFacade.getPreparedStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setBoolean(3, true);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            loginStatus = true;
            checkEmployeeUser(scanner, result.getInt("user_id"), connection);
        } else {
            loginStatus = false;
        }
        return loginStatus;
    }

    /**
     * Checks employee role and assigns role
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
    private void checkEmployeeUser(Scanner scanner, int userId, Connection connection) throws SQLException {
        String sql = "SELECT * FROM employee where user_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, userId);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            UserService.getEmployeeRole(scanner, result);
        } else {
            LOGGER.log(Level.INFO, "Employee Role not found");
        }
    }

    public static void addNewEmployee(Scanner scanner) throws SQLException {
        Connection connection = DbFacade.getDbConnection();
        connection.setAutoCommit(false);
        user = UserService.setLoginInfo(scanner);
        int userId = userDao.addNew(user);
        if (userId != 0) {
            employee = UserService.setEmployeeInfo(scanner, userId);
            int employeeId = employeeDao.addNew(employee);
            if (employeeId != 0) {
                connection.commit();
                LOGGER.log(Level.INFO, "Successfully added new employee.");
            } else {
                LOGGER.log(Level.INFO, "Failed to add new employee.");
            }
        }
    }

    @Override
    public void searchEmployee(String username) {
        String sql = "select * from employee where fullname=?";
        try {
            Connection connection = DbFacade.getDbConnection();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                System.out.println(result.getString("fullname"));
                System.out.println(result.getString("department"));
                System.out.println(result.getString("address"));
            }
        } catch (SQLException sqe) {
            LOGGER.log(Level.WARNING, "SQLException : {0}", new Object[] { sqe });
        }
    }

    @Override
    public Boolean delete(Integer userId) {
        boolean isDeleted = false;
        String sql = "update user set is_terminated=?,modified_at=? where user_id=?";
        try {
            Connection connection = DbFacade.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setTimestamp(2, DateTimeService.getCurrentTimeStamp());
            preparedStatement.setInt(3, userId);
            int result = preparedStatement.executeUpdate();
            isDeleted = (result != 0) ? true : false;
        } catch (SQLException sqe) {
            LOGGER.log(Level.WARNING, "SQLException : {0}", new Object[] { sqe });
        }
        return isDeleted;
    }

    @Override
    public void searchEmployee() {
        // TODO Auto-generated method stub
        
    }
}
