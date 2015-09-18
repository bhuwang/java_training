package com.lftechnology.java.training.alina.jdbc.routes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.lftechnology.java.training.alina.jdbc.constants.Constants;
import com.lftechnology.java.training.alina.jdbc.controller.EmployeeController;
import com.lftechnology.java.training.alina.jdbc.controller.LoginController;
import com.lftechnology.java.training.alina.jdbc.domain.Employee;
import com.lftechnology.java.training.alina.jdbc.service.UserRoleService;

public class UserRoutes {

    private static final Logger LOGGER = Logger.getLogger(UserRoutes.class.getName());

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
    public void getAdminRoleOptions(Scanner scanner, char option) throws SQLException {
        switch (option) {
        case 'a':
            UserRoleService.addEmployee(scanner);
            break;
        case 'b':
            UserRoleService.deleteEmployee(scanner);
            break;
        case 'c':
            UserRoleService.terminateEmployee(scanner);
            break;
        case 'd':
            UserRoleService.getEmployeeList();
            break;
        case 'e':
            UserRoleService.searchEmployee(scanner);
            break;
        case 'f':
            LoginController.logout();
            break;
        default:
            LOGGER.log(Level.INFO, Constants.INVALID_ENTRY);
            break;
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
    public void getEmployeeRoleOptions(Scanner scanner, char choice, Employee employee) throws SQLException {
        switch (choice) {
        case 'a':
            LOGGER.log(Level.INFO, Constants.VIEW_EMPLOYEE_LIST);
            EmployeeController.getEmployeeList();
            break;
        case 'b':
            LOGGER.log(Level.INFO, Constants.SEARCH_EMPLOYEE);
            EmployeeController.searchExistingEmployee(scanner);
            break;
        case 'c':
            LOGGER.log(Level.INFO, Constants.EDIT_OWN_INFORMATION);
            EmployeeController.getEditInfo(scanner, employee);
            break;
        case 'd':
            LOGGER.log(Level.INFO, Constants.USER_LOGOUT_SUCCESS);
            LoginController.logout();
            break;
        default:
            LOGGER.log(Level.INFO, Constants.INVALID_ENTRY);
            break;
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
    public void getEmployeeEditOptions(Scanner scanner, char choice, Employee employee) throws SQLException {
        switch (choice) {
        case 'a':
            UserRoleService.updateEmployeeName(scanner, employee);
            break;
        case 'b':
            UserRoleService.updateEmployeeDepartment(scanner, employee);
            break;
        case 'c':
            UserRoleService.updateEmployeeAddress(scanner, employee);
            break;
        case 'd':
            UserRoleService.getUserPasswordChangeInfo(scanner, employee);
            break;
        case 'e':
            UserRoleService.backToNormalUser(scanner, employee);
            break;
        default:
            LOGGER.log(Level.INFO, Constants.INVALID_ENTRY);
            break;
        }
    }

}
