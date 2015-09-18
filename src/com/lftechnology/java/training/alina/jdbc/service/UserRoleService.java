package com.lftechnology.java.training.alina.jdbc.service;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.lftechnology.java.training.alina.jdbc.constants.Constants;
import com.lftechnology.java.training.alina.jdbc.controller.EmployeeController;
import com.lftechnology.java.training.alina.jdbc.controller.LoginController;
import com.lftechnology.java.training.alina.jdbc.domain.Employee;

public class UserRoleService {

    private static final Logger LOGGER = Logger.getLogger(UserRoleService.class.getName());

    private UserRoleService() {

    }

    /**
     * Adds new employee
     * 
     * @param scanner
     *            {@link Scanner}
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void addEmployee(Scanner scanner) throws SQLException {
        LOGGER.log(Level.INFO, Constants.ADD_NEW_EMPLOYEE);
        EmployeeController.addNewEmployee(scanner);
    }

    /**
     * Deletes an employee
     * 
     * @param scanner
     *            {@link Scanner}
     * @author Alina Shakya <alinashakya@lftechnology.com>
     * @throws SQLException
     */
    public static void deleteEmployee(Scanner scanner) throws SQLException {
        LOGGER.log(Level.INFO, Constants.DELETE_EMPLOYEE);
        EmployeeController.deleteExistingEmployee(scanner);
    }

    /**
     * Terminates an employee
     * 
     * @param scanner
     *            {@link Scanner}
     * @author Alina Shakya <alinashakya@lftechnology.com>
     * @throws SQLException
     */
    public static void terminateEmployee(Scanner scanner) throws SQLException {
        LOGGER.log(Level.INFO, Constants.TERMINATE_EMPLOYEE);
        EmployeeController.terminateExistingEmployee(scanner);
    }

    /**
     * Gets employee list
     * 
     * @author Alina Shakya <alinashakya@lftechnology.com>
     * @throws SQLException
     */
    public static void getEmployeeList() throws SQLException {
        LOGGER.log(Level.INFO, Constants.VIEW_EMPLOYEE_LIST);
        EmployeeController.getEmployeeList();
    }

    /**
     * Searches an employee
     * 
     * @param scanner
     *            {@link Scanner}
     * @author Alina Shakya <alinashakya@lftechnology.com>
     * @throws SQLException
     */
    public static void searchEmployee(Scanner scanner) throws SQLException {
        LOGGER.log(Level.INFO, Constants.SEARCH_EMPLOYEE);
        EmployeeController.searchExistingEmployee(scanner);
    }

    /**
     * Logout employee
     * 
     * @param scanner
     *            {@link Scanner}
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    // public static void employeeLogout(Scanner scanner) throws SQLException {
    // LOGGER.log(Level.INFO, Constants.USER_LOGOUT_SUCCESS);
    // UserDaoImpl userDao = new UserDaoImpl();
    // userDao.checkEmployeeLogin(scanner);
    // }

    /**
     * Updates employee name
     * 
     * @param scanner
     *            {@link Scanner}
     * @param employee
     *            {@link Employee}
     * @author Alina Shakya <alinashakya@lftechnology.com>
     * @throws SQLException
     */
    public static void updateEmployeeName(Scanner scanner, Employee employee) throws SQLException {
        LOGGER.log(Level.INFO, Constants.EDIT_FULLNAME);
        employee.setFullname(UtilityService.getInputData(scanner, Constants.ENTER_EDIT_FULLNAME));
        EmployeeController.updateEmployeeInfo(Constants.FULLNAME, employee.getFullname(), employee.getEmployeeId());
    }

    /**
     * Updates employee department
     * 
     * @param scanner
     *            {@link Scanner}
     * @param employee
     *            {@link Employee}
     * @author Alina Shakya <alinashakya@lftechnology.com>
     * @throws SQLException
     */
    public static void updateEmployeeDepartment(Scanner scanner, Employee employee) throws SQLException {
        LOGGER.log(Level.INFO, Constants.EDIT_DEPARTMENT);
        employee.setDepartment(UtilityService.getInputData(scanner, Constants.ENTER_EDIT_DEPARTMENT));
        EmployeeController.updateEmployeeInfo(Constants.DEPARTMENT, employee.getDepartment(), employee.getEmployeeId());
    }

    /**
     * Updates employee address
     * 
     * @param scanner
     *            {@link Scanner}
     * @param employee
     *            {@link Employee}
     * @author Alina Shakya <alinashakya@lftechnology.com>
     * @throws SQLException
     */
    public static void updateEmployeeAddress(Scanner scanner, Employee employee) throws SQLException {
        LOGGER.log(Level.INFO, Constants.EDIT_ADDRESS);
        employee.setAddress(UtilityService.getInputData(scanner, Constants.ENTER_EDIT_ADDRESS));
        EmployeeController.updateEmployeeInfo(Constants.ADDRESS, employee.getAddress(), employee.getEmployeeId());
    }

    /**
     * Gets back to the normal user
     * 
     * @param scanner
     *            {@link Scanner}
     * @param employee
     *            {@link Employee}
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void backToNormalUser(Scanner scanner, Employee employee) throws SQLException {
        LOGGER.log(Level.INFO, Constants.BACK);
        LoginController.getNormalUserRole(scanner, employee);
    }

    /**
     * Get details of user password, changes user password functionality
     * 
     * @param scanner
     *            {@link Scanner}
     * @param employee
     *            {@link Employee}
     * @author Alina Shakya <alinashakya@lftechnology.com>
     * @throws SQLException
     */
    public static void getUserPasswordChangeInfo(Scanner scanner, Employee employee) throws SQLException {
        LOGGER.log(Level.INFO, Constants.CHANGE_PASSWORD);
        employee.setPassword(UtilityService.getInputData(scanner, Constants.ENTER_NEW_PASSWORD));
        String newPassword = employee.getPassword();
        employee.setPassword(UtilityService.getInputData(scanner, Constants.CONFIRM_PASSWORD));
        String confirmPassword = employee.getPassword();
        EmployeeController.changeUserPassword(newPassword, confirmPassword, employee.getUserId());
    }
}
