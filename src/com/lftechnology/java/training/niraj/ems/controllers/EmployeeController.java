package com.lftechnology.java.training.niraj.ems.controllers;

import java.io.Console;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.niraj.ems.domains.Employee;
import com.lftechnology.java.training.niraj.ems.services.implementations.RouteServices;
import com.lftechnology.java.training.niraj.ems.services.implementations.UserServiceImpl;
import com.lftechnology.java.training.niraj.ems.utils.Constants;

/**
 * Controller related to logged in employee
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public class EmployeeController {
    private static final Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());
    private UserServiceImpl userService;

    public EmployeeController() {
        userService = new UserServiceImpl();
    }

    /**
     * Adds an employee
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param loggedInUser
     *            {@link Employee}
     */
    public void add(Employee loggedInUser) {
        try (Scanner scanner = new Scanner(System.in)) {
            Console console = System.console();
            Employee employee = userService.addUser(scanner, console);
            if (employee.getId() != null) {
                LOGGER.log(Level.INFO, Constants.ADD_USER_SUCCESS, employee.getFullname());
            }
            RouteServices.routeAfterLogin(loggedInUser);
        } catch (InputMismatchException | SQLException se) {
            LOGGER.severe(Constants.UNHANDLED_EXCEPTION);
            LOGGER.log(Level.SEVERE, Constants.EXCEPTION_LOG, se);

        }

    }

    /**
     * Edit profile of the logged in user
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param employee
     *            {@link Employee}
     * 
     */
    public void editProfile(Employee employee) {
        try (Scanner scanner = new Scanner(System.in)) {
            Console console = System.console();
            LOGGER.info(Constants.EDIT_MENU);
            userService.editUserProfile(employee, scanner, console);
            LOGGER.info(Constants.EDIT_SUCCESS);
            RouteServices.routeAfterLogin(employee);
        } catch (InputMismatchException | SQLException se) {
            LOGGER.log(Level.SEVERE, Constants.EXCEPTION_LOG, se);
        }

    }

    /**
     * Search an employee by username
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param employee
     *            {@link Employee}
     */
    public void search(Employee employee) {
        try (Scanner scanner = new Scanner(System.in)) {
            Console console = System.console();
            String searchResult = userService.searchUser(scanner, console);
            LOGGER.info(searchResult);
            RouteServices.routeAfterLogin(employee);
        } catch (InputMismatchException | SQLException se) {
            LOGGER.severe(Constants.FAIL_RETRIEVE_USER_LIST);
            LOGGER.log(Level.SEVERE, Constants.EXCEPTION_LOG, se);
        }

    }

    /**
     * Lists all the active users
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param employee
     */
    public void listUsers(Employee employee) {
        try (Scanner scanner = new Scanner(System.in)) {
            Console console = System.console();
            String userList = userService.getUsersList();
            LOGGER.info(userList);
            userService.TerminateDeleteUser(scanner, console, employee);
            RouteServices.routeAfterLogin(employee);

        } catch (InputMismatchException | SQLException se) {
            LOGGER.severe(Constants.FAIL_RETRIEVE_USER_LIST);
            LOGGER.log(Level.SEVERE, Constants.EXCEPTION_LOG, se);
            RouteServices.routeAfterLogin(employee);
        }
    }

    /**
     * Logs the user out of the system
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     */
    public void logout() {
        LOGGER.info(Constants.GOODBYE_MSG);
    }

}
