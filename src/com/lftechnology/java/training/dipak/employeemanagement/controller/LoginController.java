
package com.lftechnology.java.training.dipak.employeemanagement.controller;

import java.io.Console;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;
import com.lftechnology.java.training.dipak.employeemanagement.domain.User;
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

        Employee employee = new Employee();
        Console cnsl = null;

        try {
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

        } catch (Exception e) {
            LOGGER.log(Level.INFO, "{0}", e);
        }
        return employee;
    }

}
