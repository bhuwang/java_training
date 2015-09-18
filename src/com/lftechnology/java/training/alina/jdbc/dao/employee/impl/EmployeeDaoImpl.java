package com.lftechnology.java.training.alina.jdbc.dao.employee.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Override
    public List<Employee> findByPk(Integer userId) throws SQLException {
        List<Employee> employeeList = new ArrayList<Employee>();
        Map<Integer, Object> params = new HashMap<Integer, Object>();
        params.put(1, userId);
        params.put(2, Constants.NOT_TERMINATED);
        params.put(3, Constants.NOT_DELETED);
        Database database = UserService.setDatabaseParams(params);
        String sql =
                "Select * from user as u inner join employee as e on (u.user_id=e.user_id) where (u.user_id=? and u.is_terminated=? and e.is_deleted=?) ";
        try {
            Connection connection = DbFacade.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement = DbFacade.setParameterizedObjects(database, preparedStatement);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                UserService userService = new UserService();
                employeeList.add(userService.map(result));
            }
            preparedStatement.close();
            result.close();
        } catch (SQLException sqe) {
            LOGGER.log(Level.WARNING, Constants.SQLEXCEPTION_LOG, new Object[] { sqe });
            DbFacade.closeDbConnection();
        }
        return employeeList;
    }

    @Override
    public List<Employee> findAll() throws SQLException {
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
            preparedStatement.close();
            result.close();
        } catch (SQLException sqe) {
            LOGGER.log(Level.WARNING, Constants.SQLEXCEPTION_LOG, new Object[] { sqe });
            DbFacade.closeDbConnection();
        }
        return employeeList;
    }

    @Override
    public Employee addNew(Employee employee) throws SQLException {
        String sql = "Insert into employee (fullname,department,address,role,user_id,created_at) values (?,?,?,?,?,?)";
        try {
            Connection connection = DbFacade.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employee.getFullname());
            preparedStatement.setString(2, employee.getDepartment());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getRole());
            preparedStatement.setInt(5, employee.getUserId());
            preparedStatement.setTimestamp(6, employee.getCreatedAt());
            int result = preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (result > 0 && rs.next()) {
                employee.setEmployeeId(rs.getInt(1));
            }
            preparedStatement.close();
            rs.close();
        } catch (SQLException sqe) {
            LOGGER.log(Level.WARNING, Constants.SQLEXCEPTION_LOG, new Object[] { sqe });
            DbFacade.closeDbConnection();
        }
        return employee;
    }

    @Override
    public Integer update(Database database) throws SQLException {
        int resultSet = 0;
        try {
            Connection connection = DbFacade.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(database.getSqlQuery());
            preparedStatement = DbFacade.setParameterizedObjects(database, preparedStatement);
            resultSet = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException sqe) {
            LOGGER.log(Level.WARNING, Constants.SQLEXCEPTION_LOG, new Object[] { sqe });
            DbFacade.closeDbConnection();
        }
        return resultSet;
    }

    @Override
    public Boolean delete(String username) throws SQLException {
        boolean isDeleted = false;
        String sql = "update employee set is_deleted=?,modified_at=? where (fullname=? and is_deleted=?)";
        try {
            Connection connection = DbFacade.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, Constants.DELETED);
            preparedStatement.setTimestamp(2, DateTimeService.getCurrentTimeStamp());
            preparedStatement.setString(3, username);
            preparedStatement.setBoolean(4, Constants.NOT_DELETED);
            int result = preparedStatement.executeUpdate();
            isDeleted = (result != 0) ? true : false;
            preparedStatement.close();
        } catch (SQLException sqe) {
            LOGGER.log(Level.WARNING, Constants.SQLEXCEPTION_LOG, new Object[] { sqe });
            DbFacade.closeDbConnection();
        }
        return isDeleted;
    }

    @Override
    public List<Employee> searchEmployee(String... searchContent) throws SQLException {
        List<Employee> employeeList = new ArrayList<Employee>();
        String sql =
                "select * from employee e inner join user u on e.user_id=u.user_id where (e.fullname like ? or e.department like ? or e.address like ?) and (u.is_terminated=? or e.is_deleted=?)";
        try {
            Connection connection = DbFacade.getDbConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (String content : searchContent) {
                preparedStatement.setString(1, content + "%");
                preparedStatement.setString(2, content + "%");
                preparedStatement.setString(3, content + "%");
                preparedStatement.setBoolean(4, Constants.NOT_TERMINATED);
                preparedStatement.setBoolean(5, Constants.NOT_DELETED);
            }
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                UserService userService = new UserService();
                employeeList.add(userService.map(result));
            }
            preparedStatement.close();
            result.close();
        } catch (SQLException sqe) {
            LOGGER.log(Level.WARNING, Constants.SQLEXCEPTION_LOG, new Object[] { sqe });
            DbFacade.closeDbConnection();
        }
        return employeeList;
    }
}
