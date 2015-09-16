
package com.lftechnology.java.training.dipak.employeemanagement.ui;

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
 * This class contains a main method. Hence the execution takes place from that method.
 * </p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */
public class MainClass {

    private static final Logger LOGGER = Logger.getLogger(MainClass.class.getName());

    private MainClass() {
    }

    static {
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.INFO);
        LOGGER.addHandler(ch);
        LOGGER.setUseParentHandlers(false);

        LoggerFormatter myFormat = new LoggerFormatter();

        ch.setFormatter(myFormat);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LoginController lc = new LoginController();
        Employee employee = lc.validateLogin(new User(), sc);

        while (!UserType.INVALID.equals(employee.getRole())) {

            if (employee.getId() == 0) {
                LOGGER.info("Login Failed. Invalid username or password.\n");
            } else if (employee.getId() == -1) {
                LOGGER.info("Invalid username format.");
            } else {
                LOGGER.log(Level.INFO, "Login Successsful. Welcome {0}\n", employee.getFullName());
                if (employee.getRole().equals(UserType.ADMIN)) {
                    AdminPanel ap = new AdminPanel();
                    ap.displayPanel(employee, sc);
                } else {
                    UserPanel up = new UserPanel();
                    up.displayPanel(employee, sc);
                }
            }
            employee = lc.validateLogin(new User(), sc);
        }

    }

}
