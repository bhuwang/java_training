package com.lftechnology.java.training.sanish.application.model.dao;

import com.lftechnology.java.training.sanish.application.dbconnection.DbConnect;
import com.lftechnology.java.training.sanish.application.model.domain.Employee;
import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.model.service.impl.EmployeeService;

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
 * Created by sanish on 9/14/15.
 */
public class EmployeeDao implements EmployeeService {
    private static final Logger LOGGER = Logger.getLogger(EmployeeDao.class.getName());
    private static PreparedStatement preparedStatement;

    @Override public boolean isAdmin(Employee employee) {
        if (employee.getRole() == "Admin") {
            return true;
        }
        return false;
    }

    @Override public boolean isUser(Employee employee) {
        if (employee.getRole() == "User") {
            return true;
        }
        return false;
    }

    @Override public User getEmployee(Employee employee) {
        try {
            String query = "SELECT * FROM employees WHERE userId=?";
            PreparedStatement preparedStatement = DbConnect.getDbConnection().prepareStatement(query);
            preparedStatement.setInt(1, employee.getUserId());
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
            LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] { e });
            DbConnect.dbClose();
        }
        return null;
    }

    @Override public int addNew(Employee employee) {
        int lastInsertedId = -1;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String query = "INSERT INTO employees(userId, fullName, address, department, role, createdAt) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = DbConnect.getDbConnection().prepareStatement(query);
            preparedStatement.setInt(1, employee.getUserId());
            preparedStatement.setString(2, employee.getFullName());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getDepartment());
            preparedStatement.setString(5, employee.getRole());
            preparedStatement.setString(6, dateFormat.format(date));

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
            LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] { e });
            DbConnect.dbClose();
        }
        return lastInsertedId;
    }

    @Override public Employee findById(Integer pk) {
        try {
            String query = "SELECT * FROM employees WHERE employeeId=?";
            PreparedStatement preparedStatement = DbConnect.getDbConnection().prepareStatement(query);
            preparedStatement.setInt(1, pk);
            ResultSet rs = preparedStatement.executeQuery();
            Employee employee = null;
            if (rs.next()) {
                employee = new Employee();
                employee.setResultSetAttributes(rs);
            }

            rs.close();
            preparedStatement.close();
            return employee;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] { e });
            DbConnect.dbClose();
        }
        return null;
    }

    @Override public List<Employee> getAll() {
        List<Employee> employeesList = new ArrayList<Employee>();
        try {
            String query = "SELECT * FROM employees";
            PreparedStatement preparedStatement = DbConnect.getDbConnection().prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setResultSetAttributes(rs);
                employeesList.add(employee);
            }

            rs.close();
            preparedStatement.close();
            return employeesList;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] { e });
            DbConnect.dbClose();
        }

        return employeesList;
    }

    @Override public <V> List<Employee> getAll(String condition, V... parameters) {
        List<Employee> employeesList = new ArrayList<Employee>();
        try {
            String query = "SELECT * FROM employees WHERE " + condition;
            PreparedStatement preparedStatement = DbConnect.getDbConnection().prepareStatement(query);
            try {
                for (int i = 0; i < parameters.length; i++) {
                    preparedStatement.setString(i + 1, parameters[i].toString());
                }
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] { e });
            }

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setResultSetAttributes(rs);
                employeesList.add(employee);
            }

            rs.close();
            preparedStatement.close();
            return employeesList;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] { e });
            DbConnect.dbClose();
        }

        return employeesList;
    }

    @Override public <V> int update(String condition, String setString, V... parameters) {
        try {
            String query = "UPDATE employees SET " + setString + " WHERE " + condition;
            PreparedStatement preparedStatement = DbConnect.getDbConnection().prepareStatement(query);
            try {
                for (int i = 0; i < parameters.length; i++) {
                    preparedStatement.setString(i + 1, parameters[i].toString());
                }
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] { e });
            }

            int effectedRow = preparedStatement.executeUpdate();
            preparedStatement.close();
            return effectedRow;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] { e });
            DbConnect.dbClose();
        }

        return 0;
    }
}
