
package com.lftechnology.java.training.dipak.employeemanagement.ui;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.dipak.employeemanagement.LoggerFormatter;
import com.lftechnology.java.training.dipak.employeemanagement.controller.EmployeeController;
import com.lftechnology.java.training.dipak.employeemanagement.controller.LogOutController;
import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;
import com.lftechnology.java.training.dipak.employeemanagement.domain.UserType;

/**
 * <p>
 * This class contains method that contains options for the user access.
 * </p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */
public class UserPanel {

    private static final Logger LOGGER = Logger.getLogger(UserPanel.class.getName());

    static {
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.FINEST);
        LOGGER.addHandler(ch);
        LOGGER.setUseParentHandlers(false);

        LoggerFormatter myFormat = new LoggerFormatter();

        ch.setFormatter(myFormat);
    }

    /**
     * <p>
     * This method allows the user to choose the operations that can be performed by an user.
     * </p>
     * 
     * @param employee
     * @param sc
     */
    public void displayPanel(Employee emp, Scanner sc) {

        EmployeeController ec = new EmployeeController();
        Employee e = new Employee();
        e = DuplicateEmployee.duplicateEmployeeObject(emp, e);
        for (;;) {
            try {
                LOGGER.info("Welcome to the user panel...\n");
                LOGGER.info("1.Search/View users\n");
                LOGGER.info("2.Edit personal information\n");
                LOGGER.info("3.Exit\n");
                LOGGER.info("Please Enter your choices::\n");
                int choice = Math.abs(Integer.parseInt(sc.nextLine()));
                switch (choice) {
                case 1:
                    ec.viewEmployee(e, sc);
                    break;
                case 2:
                    LOGGER.info("" + e.getAddress() + " " + e.getDepartment() + " " + e.getFullName());
                    emp = ec.editEmployeeDetails(emp, sc);
                    break;
                case 3:
                    e = LogOutController.logOut(e, sc);
                    break;
                default:
                    LOGGER.info("Illegal choice. Please re-enter your choice.");
                    break;
                }

            } catch (Exception ex) {
                LOGGER.log(Level.INFO, "Exception::{0}", ex);
            }
            if (UserType.INVALID.equals(e.getRole())) {
                return;
            }
        }
    }
}
