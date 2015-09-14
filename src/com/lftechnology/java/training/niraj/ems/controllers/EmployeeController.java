package com.lftechnology.java.training.niraj.ems.controllers;

import java.io.Console;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.niraj.ems.domains.Employee;
import com.lftechnology.java.training.niraj.ems.exceptions.CustomException;
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
                LOGGER.log(Level.INFO, "Successfully added the user {0}", employee.getFullname());
            }
            RouteServices.routeAfterLogin(loggedInUser);
        } catch (InputMismatchException | SQLException se) {
            LOGGER.severe("There was some error. Please try again later.");
            LOGGER.log(Level.SEVERE, "Exception:{0}", se);
        } catch (CustomException ce) {
            LOGGER.log(Level.SEVERE, "Failed to add employee : \n {0}", ce);
            RouteServices.routeAfterLogin(loggedInUser);
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
            LOGGER.log(Level.SEVERE, "Exception: {0}", se);
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
            LOGGER.severe("Failed to retrieve the search results. please try again.");
            LOGGER.log(Level.SEVERE, "Exception:{0}", se);
            RouteServices.routeAfterLogin(employee);
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
            userService.TerminateDeleteUser(scanner, console);
            RouteServices.routeAfterLogin(employee);

        } catch (InputMismatchException | SQLException se) {
            LOGGER.severe("Failed to retrieve the user lists. please try again.");
            LOGGER.log(Level.SEVERE, "Exception:{0}", se);
            RouteServices.routeAfterLogin(employee);
        } catch (CustomException ce) {
            LOGGER.log(Level.SEVERE, "Exception:{0}", ce);
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
        System.exit(0);
    }

}
