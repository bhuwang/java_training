package com.lftechnology.java.training.alina.jdbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.alina.jdbc.constants.Constants;
import com.lftechnology.java.training.alina.jdbc.controller.EmployeeController;
import com.lftechnology.java.training.alina.jdbc.controller.LoginController;
import com.lftechnology.java.training.alina.jdbc.dao.user.impl.UserDaoImpl;
import com.lftechnology.java.training.alina.jdbc.domain.Database;
import com.lftechnology.java.training.alina.jdbc.domain.Employee;
import com.lftechnology.java.training.alina.jdbc.domain.EmployeeRole;
import com.lftechnology.java.training.alina.jdbc.domain.User;
import com.lftechnology.java.training.alina.jdbc.views.AdminView;
import com.lftechnology.java.training.alina.jdbc.views.EmployeeEditView;
import com.lftechnology.java.training.alina.jdbc.views.EmployeeView;

/**
 * UserService consists of all functionalities of user
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    /**
     * Gets login info
     * 
     * @param scanner
     *            {@link Scanner}
     * @return user {@link User} user info
     * @author Alina Shakya <alinashakya@lftechnology.com>
     * @throws SQLException
     */
    public static User setLoginInfo(Scanner scanner, String actionType) throws SQLException {
        User user = new User();
        boolean userExist = false;
        if (actionType == Constants.USER_LOGIN) {
            user.setUsername(UtilityService.getInputData(scanner, Constants.ENTER_USERNAME));
        } else {
            do {
                String username = UtilityService.getInputData(scanner, Constants.ENTER_USERNAME);
                userExist = LoginController.checkExistUsername(username);
                if (!userExist) {
                    user.setUsername(username);
                }
            } while (userExist);
        }
        user.setPassword(UtilityService.getInputData(scanner, Constants.ENTER_PASSWORD));
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
    public void getEmployeeRole(Scanner scanner, Employee employee) throws SQLException {
        if (employee.getRole().equals(EmployeeRole.ADMIN.getRole())) {
            getAdminRole(scanner, employee);
        } else {
            getNormalUserRole(scanner, employee);
        }
    }

    /**
     * Gets Admin role functions
     * 
     * @param scanner
     *            {@link Scanner}
     * @param result
     *            {@link ResultSet}
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private void getAdminRole(Scanner scanner, Employee employee) throws SQLException {
        char choice = ' ';
        while (choice != Constants.ADMIN_EXIT) {
            AdminView.displayAdminRoleMenu(employee);
            choice = UtilityService.getSelectedMenu(scanner, Constants.SELECT_ADMIN_OPTION);
            getAdminRoleOptions(scanner, choice);
        }
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
    private void getAdminRoleOptions(Scanner scanner, char option) throws SQLException {
        switch (option) {
        case 'a':
            UserRoleService.addEmployee(scanner);
            return;
        case 'b':
            UserRoleService.deleteEmployee(scanner);
            return;
        case 'c':
            UserRoleService.terminateEmployee(scanner);
            return;
        case 'd':
            UserRoleService.getEmployeeList();
            return;
        case 'e':
            UserRoleService.searchEmployee(scanner);
            return;
        case 'f':
            UserRoleService.employeeLogout(scanner);
            return;
        default:
            LOGGER.log(Level.INFO, Constants.INVALID_ENTRY);
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
        Employee employee = new Employee();
        employee.setFullname(UtilityService.getInputData(scanner, Constants.ENTER_FULLNAME));
        employee.setDepartment(UtilityService.getInputData(scanner, Constants.ENTER_DEPARTMENT));
        employee.setAddress(UtilityService.getInputData(scanner, Constants.ENTER_ADDRESS));
        Boolean roleStatus = false;
        do {
            String role = UtilityService.getInputData(scanner, Constants.ENTER_ROLE);
            roleStatus = EmployeeController.checkMatchedRole(roleStatus, role);
            if (roleStatus) {
                employee.setRole(role);
            }
        } while (!roleStatus);
        employee.setUserId(userId);
        employee.setCreatedAt(DateTimeService.getCurrentTimeStamp());
        employee.setModifiedAt(DateTimeService.getCurrentTimeStamp());
        return employee;
    }

    /**
     * Gets role of normal user
     * 
     * @param scanner
     *            {@link Scanner}
     * @param result
     *            {@link ResultSet}
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public void getNormalUserRole(Scanner scanner, Employee employee) throws SQLException {
        char choice = ' ';
        while (choice != Constants.EMPLOYEE_EXIT) {
            EmployeeView.displayEmployeeRoleMenu(employee);
            choice = UtilityService.getSelectedMenu(scanner, Constants.SELECT_NORMAL_USER_ROLE);
            getEmployeeRoleOptions(scanner, choice, employee);
        }
    }

    /**
     * Gets employee role menu options
     * 
     * @param scanner
     *            {@link Scanner}
     * @param choice
     *            {@link Character}
     * @author Alina Shakya <alinashakya@lftechnology.com>
     * @throws SQLException
     */
    private void getEmployeeRoleOptions(Scanner scanner, char choice, Employee employee) throws SQLException {
        switch (choice) {
        case 'a':
            LOGGER.log(Level.INFO, Constants.VIEW_EMPLOYEE_LIST);
            EmployeeController.getEmployeeList();
            return;
        case 'b':
            LOGGER.log(Level.INFO, Constants.SEARCH_EMPLOYEE);
            EmployeeController.searchExistingEmployee(scanner);
            return;
        case 'c':
            LOGGER.log(Level.INFO, Constants.EDIT_OWN_INFORMATION);
            getEditInfo(scanner, employee);
            return;
        case 'd':
            LOGGER.log(Level.INFO, Constants.USER_LOGOUT_SUCCESS);
            UserDaoImpl userDao = new UserDaoImpl();
            userDao.checkEmployeeLogin(scanner);
            return;
        default:
            LOGGER.log(Level.INFO, Constants.INVALID_ENTRY);
            return;
        }
    }

    /**
     * Gets employee edit informations
     * 
     * @param scanner
     *            {@link Scanner}
     * @param result
     *            {@link ResultSet}
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private void getEditInfo(Scanner scanner, Employee employee) throws SQLException {
        char choice = ' ';
        while (choice != Constants.EMPLOYEE_EDIT_EXIT) {
            EmployeeEditView.displayEmployeeEditMenu();
            choice = UtilityService.getSelectedMenu(scanner, Constants.SELECT_EDIT_OPTION);
            getEmployeeEditOptions(scanner, choice, employee);
        }
    }

    /**
     * Gets employee edit options
     * 
     * @param scanner
     *            {@link Scanner}
     * @param choice
     *            {@link Character}
     * @param result
     *            {@link ResultSet}
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private void getEmployeeEditOptions(Scanner scanner, char choice, Employee employee) throws SQLException {
        switch (choice) {
        case 'a':
            UserRoleService.updateEmployeeName(scanner, employee);
            return;
        case 'b':
            UserRoleService.updateEmployeeDepartment(scanner, employee);
            return;
        case 'c':
            UserRoleService.updateEmployeeAddress(scanner, employee);
            return;
        case 'd':
            UserRoleService.getUserPasswordChangeInfo(scanner, employee);
            return;
        case 'e':
            UserRoleService.backToNormalUser(scanner, employee);
            return;
        default:
            LOGGER.log(Level.INFO, Constants.INVALID_ENTRY);
            return;
        }
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
    public Employee map(ResultSet result) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeId(result.getInt("employee_id"));
        employee.setUserId(result.getInt("user_id"));
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

    /**
     * Sets database params
     * 
     * @param params
     *            {@link Map}
     * @return database {@link Database} database parameters
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static Database setDatabaseParams(Map<Integer, Object> params) {
        Database database = new Database();
        database.setParameters(params);
        return database;
    }
}
