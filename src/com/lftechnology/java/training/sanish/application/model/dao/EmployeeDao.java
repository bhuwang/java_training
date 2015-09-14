package com.lftechnology.java.training.sanish.application.model.dao;

import com.lftechnology.java.training.sanish.application.dbconnection.DbConnect;
import com.lftechnology.java.training.sanish.application.model.domain.Employee;
import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.model.service.impl.EmployeeService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sanish on 9/14/15.
 */
public class EmployeeDao implements EmployeeService {
    private static final Logger LOGGER = Logger.getLogger(EmployeeDao.class.getName());
    private static PreparedStatement preparedStatement;
    @Override public boolean isAdmin(Employee employee) {
        if(employee.getRole() == "Admin"){
            return  true;
        }
        return false;
    }

    @Override public boolean isUser(Employee employee) {
        if(employee.getRole() == "User"){
            return  true;
        }
        return false;
    }

    @Override public User getUser(Employee employee) {
        try {
            String query = "SELECT * FROM users WHERE userId=?";
            preparedStatement = DbConnect.getPreparedStatement(query, employee.getUserId());
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

    @Override public Employee addNew(Employee employee) {
        // TODO add new employee
        return null;
    }

    @Override public Employee findById(Integer pk) {
        try {
            String query = "SELECT * FROM employees WHERE employeeId=?";
            preparedStatement = DbConnect.getPreparedStatement(query, pk, 0);
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

    @Override public List<Employee> getAll() {
        List<Employee> employeesList = new ArrayList<Employee>();
        try {
            String query = "SELECT * FROM employees";
            preparedStatement = DbConnect.getPreparedStatement(query, 0);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setResultSetAttributes(rs);
                employeesList.add(employee);
            }
            DbConnect.closePreparedStatement();
            return employeesList;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] { e });
            DbConnect.closePreparedStatement();
        }
        return null;
    }

    @Override public <V> List<Employee> getAll(String condition, V... parameters) {
        List<Employee> employeesList = new ArrayList<Employee>();
        try {
            String query = "SELECT * FROM users WHERE " + condition;
            preparedStatement = DbConnect.getPreparedStatement(query, parameters);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setResultSetAttributes(rs);
                employeesList.add(employee);
            }
            DbConnect.closePreparedStatement();
            return employeesList;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] { e });
            DbConnect.closePreparedStatement();
        }
        return null;
    }

    @Override public <V> int update(String condition, String setString, V... parameters) {
        try {
            String query = "UPDATE employees SET " + setString + " WHERE " + condition;
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
