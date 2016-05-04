
package com.lftechnology.java.training.dipak.employeemanagement.controller;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;
import com.lftechnology.java.training.dipak.employeemanagement.domain.User;
import com.lftechnology.java.training.dipak.employeemanagement.domain.UserType;
import com.lftechnology.java.training.dipak.employeemanagement.service.LoginService;
import com.lftechnology.java.training.dipak.employeemanagement.service.ServiceFactory;
import com.lftechnology.java.training.dipak.employeemanagement.ui.AdminPanel;
import com.lftechnology.java.training.dipak.employeemanagement.ui.UserPanel;

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
    public void validateLogin(User u, Scanner sc) {
        Employee employee = new Employee();
        LoginService ls = ServiceFactory.getLoginService();

        employee = ls.validateLogin(u);

        if (employee.getId() == 0) {
            LOGGER.info("\n\t\tLogin Failed. Invalid username or password.\n");
        } else if (employee.getId() == -1) {
            LOGGER.info("\n\t\tInvalid username format.");
        } else {
            LOGGER.log(Level.INFO, "\n\n\t\tLogin Successsful. Welcome {0}\n", employee.getFullName());
            if (employee.getRole().equals(UserType.ADMIN)) {
                AdminPanel ap = new AdminPanel();
                ap.displayPanel(employee, sc);
            } else {
                UserPanel up = new UserPanel();
                up.displayPanel(employee, sc);
            }
        }

    }

}
