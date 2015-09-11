package com.lftechnology.java.training.alina.jdbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.lftechnology.java.training.alina.jdbc.constants.Constants;
import com.lftechnology.java.training.alina.jdbc.controller.EmployeeController;
import com.lftechnology.java.training.alina.jdbc.dao.user.impl.UserDaoImpl;
import com.lftechnology.java.training.alina.jdbc.domain.Employee;
import com.lftechnology.java.training.alina.jdbc.domain.User;
import com.lftechnology.java.training.alina.jdbc.views.LoginView;

public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());
    private static User user = new User();
    private static UserDaoImpl userDao = new UserDaoImpl();
    private static Employee employee = new Employee();

    /**
     * Gets login info
     * 
     * @param scanner
     *            {@link Scanner}
     * @return user {@link User} user info
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static User setLoginInfo(Scanner scanner) {
        user.setUsername(UtilityService.getInputData(scanner, "Enter Username : "));
        user.setPassword(UtilityService.getInputData(scanner, "Enter Password : "));
        user.setTerminated(true);
        user.setCreatedAt(DateTimeService.getCurrentTimeStamp());
        user.setModifiedAt(DateTimeService.getCurrentTimeStamp());
        return user;
    }

    /**
     * Used to get Role of an employee
     * 
     * @param scanner
     *            {@link Scanner}
     * @param result
     *            {@link ResultSet}
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void getEmployeeRole(Scanner scanner, ResultSet result) throws SQLException {
        if (result.getString("role").equals(Employee.EmployeeRole.ADMIN.role)) {
            getAdminRole(scanner, result);
        } else {
            getNormalUserRole(scanner, result);
        }
    }

    /**
     * Gets Admin role functionalities
     * 
     * @param scanner
     *            {@link Scanner}
     * @param result
     *            {@link ResultSet}
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static void getAdminRole(Scanner scanner, ResultSet result) throws SQLException {
        char choice = ' ';
        while (choice != Constants.EXIT) {
            LoginView.displayAdminRoleMenu(result);
            choice = getSelectedMenu(scanner);
            getAdminRoleOptions(scanner, choice);
        }
    }

    /**
     * Gets the user selected menu options
     * 
     * @param scanner
     *            {@link Scanner}
     * @return str {@link Character} menu choice
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static char getSelectedMenu(Scanner scanner) {
        String str = UtilityService.getInputData(scanner, "Select an option (a-f) : ");
        return str.toLowerCase().charAt(0);
    }

    /**
     * Gets option menu for Admin Role
     * 
     * @param scanner
     *            {@link Scanner}
     * @param option
     *            {@link Character}
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static void getAdminRoleOptions(Scanner scanner, char option) throws SQLException {
        switch (option) {
        case 'a':
            LOGGER.log(Level.INFO, "\n========================\nAdd New Employee : \n========================\n");
            EmployeeController.addNewEmployee(scanner);
            break;
        case 'b':
            LOGGER.log(Level.INFO, "\n========================\nDelete an Employee : \n========================\n");
            EmployeeController.deleteExistingEmployee(scanner);
            return;
        case 'c':
            LOGGER.log(Level.INFO, "\n========================\nTerminate an Employee : \n========================\n");
            EmployeeController.terminateExistingEmployee(scanner);
            return;
        case 'd':
            LOGGER.log(Level.INFO, "\n========================\nEmployee List : \n========================\n");
            EmployeeController.getEmployeeList();
            return;
        case 'e':
            LOGGER.log(Level.INFO, "\n========================\nSearch an Employee : \n========================\n");
            EmployeeController.searchExistingEmployee(scanner);
            return;
        case 'f':
            LOGGER.log(Level.INFO, "\n========================\nUser successfully logged out from the system.\n========================\n");
            userDao.checkEmployeeLogin(scanner);
        default:
            System.out.println("\n========================\nInvalid entry, Please choose from menu option.\n========================\n");
            return;
        }
    }

    /**
     * Gets employee info
     * 
     * @param scanner
     *            {@link Scanner}
     * @param userId
     *            {@link Integer}
     * @return employee {@link Employee} employee info
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static Employee setEmployeeInfo(Scanner scanner, int userId) {
        employee.setFullname(UtilityService.getInputData(scanner, "Enter Fullname : "));
        employee.setDepartment(UtilityService.getInputData(scanner, "Enter department : "));
        employee.setAddress(UtilityService.getInputData(scanner, "Enter address : "));
        Boolean roleStatus = false;
        do {
            roleStatus = EmployeeController.checkMatchedRole(scanner, roleStatus);
        } while (!roleStatus);
        employee.setUserId(userId);
        System.out.println(DateTimeService.getCurrentTimeStamp());
        employee.setCreatedAt(DateTimeService.getCurrentTimeStamp());
        employee.setModifiedAt(DateTimeService.getCurrentTimeStamp());
        return employee;
    }

    private static void getNormalUserRole(Scanner scanner, ResultSet result) {
    }

    /**
     * Sets employee data
     * 
     * @param result
     *            {@link ResultSet}
     * @return employee {@link Employee} employee details
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static Employee map(ResultSet result) throws SQLException {
        Employee employee = new Employee();
        employee.setUsername(result.getString("username"));
        employee.setTerminated(result.getBoolean("is_terminated"));
        employee.setCreatedAt(result.getTimestamp("created_at"));
        employee.setFullname(result.getString("fullname"));
        employee.setDepartment(result.getString("department"));
        employee.setRole(result.getString("role"));
        employee.setAddress(result.getString("address"));
        employee.setCreatedAt(result.getTimestamp("created_at"));
        return employee;
    }
}
