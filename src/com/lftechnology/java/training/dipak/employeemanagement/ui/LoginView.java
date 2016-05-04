package com.lftechnology.java.training.dipak.employeemanagement.ui;

import java.io.Console;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.dipak.employeemanagement.LoggerFormatter;
import com.lftechnology.java.training.dipak.employeemanagement.controller.LoginController;
import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;
import com.lftechnology.java.training.dipak.employeemanagement.domain.User;
import com.lftechnology.java.training.dipak.employeemanagement.domain.UserType;

/**
 * <p>
 * This class is the login in view. All the users are prompt to either enter username and password or they can exit the application.
 * </p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 *
 */
public class LoginView {
    private static final Logger LOGGER = Logger.getLogger(LoginView.class.getName());

    static {
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.INFO);
        LOGGER.addHandler(ch);
        LOGGER.setUseParentHandlers(false);

        LoggerFormatter myFormat = new LoggerFormatter();

        ch.setFormatter(myFormat);
    }

    /**
     * <p>
     * This method is used to take input from console whether the user is logging in or logging out of the application. And takes up
     * username and password if user if trying to log in.Else exits the application.
     * </p>
     * 
     * @param u
     * @param sc
     * @return
     */
    public Employee inputLoginData(User u, Scanner sc) {
        Employee employee = new Employee();
        LoginController lc = new LoginController();
        Console cnsl = null;
        do {
            LOGGER.info("\n..................Welcome to Employee Management System.........................\n");
            LOGGER.info("\n 1. Login \n 2. Any key to exit\n");
            LOGGER.info("\nEnter your choice:: ");
            String choice = sc.nextLine();
            try {
                if ("1".equals(choice)) {

                    cnsl = System.console();
                    String userName = "";
                    String password = "";

                    LOGGER.info("\nEnter username::");

                    userName = sc.nextLine();

                    u.setUserName(userName);

                    LOGGER.info("\nEnter password::");
                    char[] pwd = cnsl.readPassword();

                    password = String.valueOf(pwd);

                    u.setPassword(password);

                    lc.validateLogin(u, sc);

                } else {
                    employee.setRole(UserType.INVALID);

                    LOGGER.info("\n Exiting the application.\n\n");

                }

            } catch (Exception e) {
                LOGGER.log(Level.INFO, "{0}", e);
            } finally {
                if (UserType.INVALID.equals(employee.getRole())) {
                    sc.close();
                }
            }
        } while (!UserType.INVALID.equals(employee.getRole()));

        return employee;
    }
}
