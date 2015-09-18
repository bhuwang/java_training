
package com.lftechnology.java.training.dipak.employeemanagement.ui;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.dipak.employeemanagement.LoggerFormatter;
import com.lftechnology.java.training.dipak.employeemanagement.controller.LogOutController;
import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;
import com.lftechnology.java.training.dipak.employeemanagement.domain.UserType;

/**
 * <p>
 * This class contains method that contains options for the admin access.
 * </p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */
public class AdminPanel {

    private static final Logger LOGGER = Logger.getLogger(AdminPanel.class.getName());

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
     * This method allows the admin to choose the operations that can be performed by an admin.
     * </p>
     * 
     * @param employee
     * @param sc
     * @throws Throwable
     */
    public void displayPanel(Employee employee1, Scanner sc) {
        Employee e = new Employee();
        e = DuplicateEmployee.duplicateEmployeeObject(employee1, e);
        Employee e2 = new Employee();
        e2 = DuplicateEmployee.duplicateEmployeeObject(e, e2);
        EmployeeView ev = new EmployeeView();
        do {
            try {
                LOGGER.info("\n\t*********************Welcome to the admin panel*******************\n");
                LOGGER.info("\n1.Add User");
                LOGGER.info("\n2.Remove user");
                LOGGER.info("\n3.Search/View user");
                LOGGER.info("\n4.Edit your personal info");
                LOGGER.info("\n5.Exit");
                LOGGER.info("\nPlease Enter your choices::");
                int choice = Math.abs(Integer.parseInt(sc.nextLine()));
                switch (choice) {
                case 1:
                    ev.addEmployee(employee1, sc);
                    break;
                case 2:
                    ev.terminateEmployee(employee1, sc);
                    break;
                case 3:
                    ev.viewEmployee(employee1, sc);
                    break;
                case 4:
                    ev.editEmployeeDetails(e, sc);
                    break;
                case 5:
                    e = LogOutController.logOut(employee1, sc);
                    break;

                default:
                    LOGGER.info("\nIllegal choice. Please re-enter your choice.");
                    break;
                }
            } catch (Exception ex) {
                LOGGER.log(Level.INFO, "\n\t\tException occurred: {0}", ex);
            }

        } while (!UserType.INVALID.equals(e.getRole()));
        LOGGER.info("\nLogout Successful.....\n");
    }
}