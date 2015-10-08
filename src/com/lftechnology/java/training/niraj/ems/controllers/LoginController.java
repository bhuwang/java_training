package com.lftechnology.java.training.niraj.ems.controllers;

import java.io.Console;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.niraj.ems.domains.Employee;
import com.lftechnology.java.training.niraj.ems.services.implementations.RouteServices;
import com.lftechnology.java.training.niraj.ems.services.implementations.UserServiceImpl;
import com.lftechnology.java.training.niraj.ems.utils.Constants;

public class LoginController {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());

    private UserServiceImpl userService;

    public LoginController() {
        userService = new UserServiceImpl();
    }

    public void login() {
        int attempt = 0;
        boolean isAuthenticated = false;
        Map<String, String> credentials;
        Employee employee = null;
        try (Scanner scanner = new Scanner(System.in)) {
            Console console = System.console();
            do {
                if (attempt != 0) {
                    int attemptLeft = 3 - attempt;
                    LOGGER.log(Level.WARNING, Constants.LOGIN_ATTEMPTS, attemptLeft);
                }
                credentials = userService.getUserCredentials(scanner, console);
                employee = userService.login(credentials.get(Constants.USERNAME), credentials.get(Constants.PASSWORD));
                isAuthenticated = employee.getId() != null ? true : false;
                attempt++;
            } while (attempt < 3 && !isAuthenticated);
            if (isAuthenticated) {
                RouteServices.routeAfterLogin(employee);
            } else {
                LOGGER.severe(Constants.INVALID_CREDENTIALS);
            }
        } catch (InputMismatchException | SQLException se) {

            LOGGER.severe(Constants.UNHANDLED_EXCEPTION);
            LOGGER.log(Level.SEVERE, Constants.EXCEPTION_LOG, se);
            RouteServices.routeLandingPage();
        }

    }

    public void register() {
        try (Scanner scanner = new Scanner(System.in)) {
            Console console = System.console();
            Employee employee = null;
            Map<String, String> userRegistrationInfo = userService.getUserRegistrationInfo(scanner, console);
            userRegistrationInfo = userService.registerUser(userRegistrationInfo);
            if (userRegistrationInfo != null) {
                employee = userService.login(userRegistrationInfo.get(Constants.USERNAME), userRegistrationInfo.get(Constants.PASSWORD));
            }
            if (employee != null) {
                RouteServices.routeAfterLogin(employee);
            } else {
                LOGGER.severe(Constants.REGISTER_USER_FAIL);
                RouteServices.routeLandingPage();
            }
        } catch (InputMismatchException | SQLException se) {
            LOGGER.severe(Constants.UNHANDLED_EXCEPTION);
            LOGGER.log(Level.SEVERE, Constants.EXCEPTION_LOG, se);
        }
    }

}
