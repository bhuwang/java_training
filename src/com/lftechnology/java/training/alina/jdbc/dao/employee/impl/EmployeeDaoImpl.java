package com.lftechnology.java.training.alina.jdbc.dao.employee.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.alina.jdbc.constants.Constants;
import com.lftechnology.java.training.alina.jdbc.dao.employee.EmployeeDao;
import com.lftechnology.java.training.alina.jdbc.dbutils.DbFacade;
import com.lftechnology.java.training.alina.jdbc.domain.Database;
import com.lftechnology.java.training.alina.jdbc.domain.Employee;
import com.lftechnology.java.training.alina.jdbc.service.DateTimeService;
import com.lftechnology.java.training.alina.jdbc.service.UserService;

public class EmployeeDaoImpl implements EmployeeDao {

    private static final Logger LOGGER = Logger.getLogger(EmployeeDaoImpl.class.getName());
    private static int employeeId = 0;

    @Override
    public Employee findByPk(Integer id) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<Employee>();
        String sql =
                "Select * from user as u inner join employee as e on (u.user_id=e.user_id) where (u.is_terminated=? and e.is_deleted=?)";
        try {
            Connection connection = DbFacade.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, Constants.NOT_TERMINATED);
            preparedStatement.setBoolean(2, Constants.NOT_DELETED);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                UserService userService = new UserService();
                employeeList.add(userService.map(result));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "SQLException : {0}", new Object[] { e });
        }
        return employeeList;
    }

    @Override
    public Integer addNew(Employee employee) {
        String sql = "Insert into employee (fullname,department,address,role,user_id,created_at) values (?,?,?,?,?,?)";
        try {
            Connection connection = DbFacade.getDbConnection();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employee.getFullname());
            preparedStatement.setString(2, employee.getDepartment());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getRole());
            preparedStatement.setInt(5, employee.getUserId());
            preparedStatement.setTimestamp(6, employee.getCreatedAt());
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
    public Integer update(Database database) {
        int resultSet = 0;
        try {
            Connection connection = DbFacade.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(database.getSqlQuery());
            preparedStatement = DbFacade.setParameterizedObjects(database, preparedStatement);
            resultSet = preparedStatement.executeUpdate();
        } catch (SQLException sqe) {
            LOGGER.log(Level.WARNING, "SQLException : {0}", new Object[] { sqe });
        }
        return resultSet;
    }

    @Override
    public Boolean delete(String username) {
        boolean isDeleted = false;
        String sql = "update employee set is_deleted=?,modified_at=? where fullname=?";
        try {
            Connection connection = DbFacade.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, Constants.DELETED);
            preparedStatement.setTimestamp(2, DateTimeService.getCurrentTimeStamp());
            preparedStatement.setString(3, username);
            int result = preparedStatement.executeUpdate();
            isDeleted = (result != 0) ? true : false;
        } catch (SQLException sqe) {
            LOGGER.log(Level.WARNING, "SQLException : {0}", new Object[] { sqe });
        }
        return isDeleted;
    }

    @Override
    public List<Employee> searchEmployee(String sql, String... searchContent) {
        List<Employee> employeeList = new ArrayList<Employee>();
        try {
            Connection connection = DbFacade.getDbConnection();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            for (String content : searchContent) {
                preparedStatement.setString(1, content + "%");
                preparedStatement.setString(2, content + "%");
                preparedStatement.setString(3, content + "%");
            }
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                UserService userService = new UserService();
                employeeList.add(userService.map(result));
            }

        } catch (SQLException sqe) {
            LOGGER.log(Level.WARNING, "SQLException : {0}", new Object[] { sqe });
        }
        return employeeList;
    }
}
