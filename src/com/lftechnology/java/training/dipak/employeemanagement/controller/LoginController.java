
package com.lftechnology.java.training.dipak.employeemanagement.controller;

import java.io.Console;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.dipak.employeemanagement.LoggerFormatter;
import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;
import com.lftechnology.java.training.dipak.employeemanagement.domain.User;
import com.lftechnology.java.training.dipak.employeemanagement.domain.UserType;
import com.lftechnology.java.training.dipak.employeemanagement.service.LoginService;
import com.lftechnology.java.training.dipak.employeemanagement.service.ServiceFactory;

/**
 * <p>
 * This class take the username and password from the console.
 * </p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */
public class LoginController {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());

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
     * This method takes up the username and password and calls the validateLogin method in the service layer.
     * </p>
     * 
     * @param u
     * @param sc
     * @return employee
     */
    public Employee validateLogin(User u, Scanner sc) {
        LOGGER.info("\n..................Welcome to Employee Management System.........................\n");
        Employee employee = new Employee();
        Console cnsl = null;
        LOGGER.info("\n 1. Login \n 2. Any key to exit\n");
        LOGGER.info("Enter your choice:: ");
        String choice = sc.nextLine();
        try {
            if ("1".equals(choice)) {

                cnsl = System.console();
                String userName = "";
                String password = "";
                LoginService ls = ServiceFactory.getLoginService();

                LOGGER.info("Enter username::");

                userName = sc.nextLine();

                u.setUserName(userName);

                LOGGER.info("Enter password::");
                char[] pwd = cnsl.readPassword();

                password = String.valueOf(pwd);

                u.setPassword(password);

                employee = ls.validateLogin(u);

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

        return employee;
    }

}
