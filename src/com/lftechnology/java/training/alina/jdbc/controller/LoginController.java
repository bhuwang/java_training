package com.lftechnology.java.training.alina.jdbc.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.lftechnology.java.training.alina.jdbc.constants.Constants;
import com.lftechnology.java.training.alina.jdbc.dao.DbUtils;
import com.lftechnology.java.training.alina.jdbc.demo.EmployeeManagement;
import com.lftechnology.java.training.alina.jdbc.domain.Employee;
import com.lftechnology.java.training.alina.jdbc.domain.User;
import com.lftechnology.java.training.alina.jdbc.routes.UserRoutes;
import com.lftechnology.java.training.alina.jdbc.service.UserService;
import com.lftechnology.java.training.alina.jdbc.service.UtilityService;
import com.lftechnology.java.training.alina.jdbc.views.AdminView;
import com.lftechnology.java.training.alina.jdbc.views.EmployeeView;
import com.lftechnology.java.training.alina.jdbc.views.LoginView;

/**
 * LoginController consists of login,logout functionals
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 *
 */
public class LoginController {

    private static final Logger LOGGER = Logger.getLogger(EmployeeManagement.class.getName());

    /**
     * User login functionality
     * 
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public void userLogin() throws SQLException {
        Boolean isLogin = false;
        try (Scanner scanner = new Scanner(System.in)) {
            UserService userService = new UserService();
            do {
                User user = LoginView.displayLoginHeader(scanner);
                isLogin = userService.checkEmployeeLogin(scanner, user);
            } while (!checkNotLogin(isLogin));
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Exception Message : {0}", new Object[] { e });
        } finally {
            DbUtils.closeDbConnection();
        }
    }

    /**
     * Checks and displays message when user fails to log in
     * 
     * @param isLogin
     *            {@link Boolean}
     * @return {@link Boolean} status of login
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static boolean checkNotLogin(Boolean isLogin) {
        if (!isLogin) {
            LOGGER.log(Level.INFO, Constants.INVALID_USERNAME_PASSWORD);
            return false;
        } else {
            return true;
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
    public static void getAdminRole(Scanner scanner, Employee employee) throws SQLException {
        UserRoutes userRoutes = new UserRoutes();
        char choice = ' ';
        while (choice != Constants.ADMIN_EXIT) {
            AdminView.displayAdminRoleMenu(employee);
            choice = UtilityService.getSelectedMenu(scanner, Constants.SELECT_ADMIN_OPTION);
            userRoutes.getAdminRoleOptions(scanner, choice);
        }
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
    public static void getNormalUserRole(Scanner scanner, Employee employee) throws SQLException {
        UserRoutes userRoutes = new UserRoutes();
        char choice = ' ';
        while (choice != Constants.EMPLOYEE_EXIT) {
            EmployeeView.displayEmployeeRoleMenu(employee);
            choice = UtilityService.getSelectedMenu(scanner, Constants.SELECT_NORMAL_USER_ROLE);
            userRoutes.getEmployeeRoleOptions(scanner, choice, employee);
        }
    }

    /**
     * Logouts user
     * 
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void logout() throws SQLException {
        LoginController login = new LoginController();
        login.userLogin();
    }
}
