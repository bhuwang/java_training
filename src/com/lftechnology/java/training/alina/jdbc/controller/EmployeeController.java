package com.lftechnology.java.training.alina.jdbc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.alina.jdbc.constants.Constants;
import com.lftechnology.java.training.alina.jdbc.dao.employee.impl.EmployeeDaoImpl;
import com.lftechnology.java.training.alina.jdbc.dao.user.impl.UserDaoImpl;
import com.lftechnology.java.training.alina.jdbc.dbutils.DbFacade;
import com.lftechnology.java.training.alina.jdbc.domain.Database;
import com.lftechnology.java.training.alina.jdbc.domain.Employee;
import com.lftechnology.java.training.alina.jdbc.domain.EmployeeRole;
import com.lftechnology.java.training.alina.jdbc.domain.User;
import com.lftechnology.java.training.alina.jdbc.service.DateTimeService;
import com.lftechnology.java.training.alina.jdbc.service.UserService;
import com.lftechnology.java.training.alina.jdbc.service.UtilityService;

/**
 * Employee controller consists of functionalities regarding employee add, list, view ,delete
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class EmployeeController {

    private static final Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());
    private static UserDaoImpl userDao = new UserDaoImpl();
    private static EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
    private static String sqlQuery = null;

    /**
     * Adds new employee
     * 
     * @param scanner
     *            {@link Scanner}
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void addNewEmployee(Scanner scanner) throws SQLException {
        User user = new User();
        Employee employee = new Employee();
        Connection connection = DbFacade.getDbConnection();
        connection.setAutoCommit(false);
        user = UserService.setLoginInfo(scanner, Constants.USER_ADD);
        userDao.addNew(user);
        if (user.getUserId() != 0) {
            employee = UserService.setEmployeeInfo(scanner, user.getUserId());
            employeeDao.addNew(employee);
            if (employee.getEmployeeId() != 0) {
                connection.commit();
                LOGGER.log(Level.INFO, "\n=====>\nSuccessfully added new employee of ID : {0}.\n=====>\n",
                        new Object[] { employee.getEmployeeId() });
            } else {
                LOGGER.log(Level.INFO, "\n=====>\nFailed to add new employee.\n=====>\n");
            }
        }
    }

    /**
     * Check if the role is either admin/user
     * 
     * @param scanner
     *            {@link Scanner}
     * @param roleStatus
     *            {@link Boolean}
     * @param role
     *            {@link String}
     * @return roleStatus {@link Boolean} role status as admin/user
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static boolean checkMatchedRole(Boolean roleStatus, String role) {
        boolean employeeRoleStatus = roleStatus;
        if (role.equals(EmployeeRole.ADMIN.role) || role.equals(EmployeeRole.USER.role)) {
            employeeRoleStatus = true;
        } else {
            LOGGER.log(Level.INFO, "\n=====>\nRole should be user/admin. Please enter valid role\n=====>\n");
            employeeRoleStatus = false;
        }
        return employeeRoleStatus;
    }

    /**
     * Delete existing employee by username
     * 
     * @param scanner
     *            {@link Scanner}
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void deleteExistingEmployee(Scanner scanner) {
        Employee employee = new Employee();
        employee.setFullname(UtilityService.getInputData(scanner, "Enter fullname to delete : "));
        boolean isDeleted = employeeDao.delete(employee.getFullname());
        if (isDeleted) {
            LOGGER.log(Level.INFO, "\n=====>\nSuccessfully deleted employee with Name {0}.\n=====>\n",
                    new Object[] { employee.getFullname() });
        } else {
            LOGGER.log(Level.WARNING, "\n=====>\nFailed to delete an employee with Name {0}.\n=====>\n",
                    new Object[] { employee.getFullname() });
        }
    }

    /**
     * Terminate existing employee
     * 
     * @param scanner
     *            {@link Scanner}
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void terminateExistingEmployee(Scanner scanner) {
        Employee employee = new Employee();
        employee.setFullname(UtilityService.getInputData(scanner, "Enter fullname : "));
        boolean isDeleted = userDao.delete(employee.getFullname());
        if (isDeleted) {
            LOGGER.log(Level.INFO, "\n=====>\nSuccessfully terminated employee with Name {0}.\n=====>\n",
                    new Object[] { employee.getFullname() });
        } else {
            LOGGER.log(Level.WARNING, "\n=====>\nFailed to terminate an employee with Name {0}.\n=====>\n",
                    new Object[] { employee.getFullname() });
        }
    }

    /**
     * Gets Employee lists soreted by alphabetical order
     * 
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void getEmployeeList() {
        List<Employee> list = employeeDao.findAll();
        Collections.sort(list);
        if (list.size() > 0) {
            LOGGER.log(
                    Level.INFO,
                    "\n<=====>\nNumber of Employee : {0} \n<=====>\n\n-----------------------------------------------------------------------------------------------\n{1}",
                    new Object[] { list.size(), list });
        } else {
            LOGGER.log(Level.INFO, "\n<=====>\nNumber of Employee : {0}\n----------------------\nNo Record Found.\n<=====>\n\n",
                    new Object[] { list.size() });
        }
    }

    /**
     * Search existing employee from the list
     * 
     * @param scanner
     *            {@link Scanner}
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void searchExistingEmployee(Scanner scanner) {
        String searchContent = UtilityService.getInputData(scanner, "Search Employee by fullname, department or address : ");
        List<Employee> list = employeeDao.searchEmployee(searchContent, searchContent, searchContent);
        Collections.sort(list);
        if (list.size() > 0) {
            LOGGER.log(
                    Level.INFO,
                    "\n<=====>\nNumber of Employee : {0} \n<=====>\n\n-----------------------------------------------------------------------------------------------\n{1}",
                    new Object[] { list.size(), list });
        } else {
            LOGGER.log(Level.INFO, "\n<=====>\nNumber of Employee : {0}\n----------------------\nNo Record Found.\n<=====>\n\n",
                    new Object[] { list.size() });
        }
    }

    /**
     * Update employee details
     * 
     * @param keyName
     *            {@link String}
     * @param keyValue
     *            {@link String}
     * @param employeeId
     *            {@link Integer} id of employee
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void updateEmployeeInfo(String keyName, String keyValue, Integer employeeId) {
        Map<Integer, Object> params = new HashMap<>();
        Database database = new Database();
        if (keyName == Constants.FULLNAME) {
            sqlQuery = "update employee set fullname=?,modified_at=? where employee_id=?";
        } else if (keyName == Constants.DEPARTMENT) {
            sqlQuery = "update employee set department=?,modified_at=? where employee_id=?";
        } else if (keyName == Constants.ADDRESS) {
            sqlQuery = "update employee set address=?,modified_at=? where employee_id=?";
        } else if (keyName == Constants.ROLE) {
            sqlQuery = "update employee set role=?,modified_at=? where employee_id=?";
        }
        params.put(1, keyValue);
        params.put(2, DateTimeService.getCurrentTimeStamp());
        params.put(3, employeeId);
        database.setParameters(params);
        database.setSqlQuery(sqlQuery);
        int result = employeeDao.update(database);
        if (result > 0) {
            LOGGER.log(Level.INFO, "\n=====>\nSuccessfully updated employee information of ID : {0}.\n=====>\n",
                    new Object[] { employeeId });
        } else {
            LOGGER.log(Level.INFO, "\n=====>\nFailed to update employee information.\n=====>\n");
        }
    }

    /**
     * Change user password functionality
     * 
     * @param newPassword
     *            {@link String}
     * @param confirmPassword
     *            {@link String}
     * @param userId
     *            {@link Integer} user id
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void changeUserPassword(String newPassword, String confirmPassword, int userId) {
        Map<Integer, Object> params = new HashMap<>();
        Database database = new Database();
        String sqlQuery = "update user set password=?,modified_at=? where user_id=?";
        if (newPassword.equals(confirmPassword)) {
            params.put(1, newPassword);
            params.put(2, DateTimeService.getCurrentTimeStamp());
            params.put(3, userId);
            database.setParameters(params);
            database.setSqlQuery(sqlQuery);
            int result = employeeDao.update(database);
            if (result > 0) {
                LOGGER.log(Level.INFO, "\n=====>\nSuccessfully changed password of User ID : {0}.\n=====>\n", new Object[] { userId });
            } else {
                LOGGER.log(Level.INFO, "\n=====>\nFailed to change password of User ID : {0}.\n=====>\n", new Object[] { userId });
            }
        } else {
            LOGGER.log(Level.INFO, "\n=====>\nPassword not matched.\n=====>\n", new Object[] { userId });
        }
    }
}
