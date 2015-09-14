package com.lftechnology.java.training.niraj.ems.controllers;

import java.io.Console;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.niraj.ems.domains.Employee;
import com.lftechnology.java.training.niraj.ems.exceptions.CustomException;
import com.lftechnology.java.training.niraj.ems.services.implementations.RouteServices;
import com.lftechnology.java.training.niraj.ems.services.implementations.UserServiceImpl;

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
                    LOGGER.log(Level.WARNING, "\n\n\nYou have {0} attempts left\n\n", attemptLeft);
                }
                credentials = userService.getUserCredentials(scanner, console);
                employee = userService.login(credentials.get("username"), credentials.get("password"));
                isAuthenticated = employee.getId() != null ? true : false;
                attempt++;
            } while (attempt < 3 && !isAuthenticated);
            if (isAuthenticated) {
                RouteServices.routeAfterLogin(employee);
            } else {
                LOGGER.severe("Incorrect username or password. Exiting the program");
            }
        } catch (InputMismatchException | SQLException se) {
            se.printStackTrace();
            LOGGER.severe("There was some error. Please try again later.");
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
                employee = userService.login(userRegistrationInfo.get("username"), userRegistrationInfo.get("password"));
            }
            if (employee != null) {
                RouteServices.routeAfterLogin(employee);
            } else {
                throw new CustomException("Failed to register employee.");
            }
        } catch (InputMismatchException | SQLException | CustomException se) {
            se.printStackTrace();
            LOGGER.severe("There was some error. Please try again later.");
            RouteServices.routeLandingPage();
        }
    }

}
