
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
        ch.setLevel(Level.INFO);
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
        Employee emp2 = new Employee();
        emp2 = DuplicateEmployee.duplicateEmployeeObject(emp, emp2);
        
        Employee e2=new Employee();
        e2=DuplicateEmployee.duplicateEmployeeObject(emp2, e2);
        
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
                    ec.viewEmployee(emp2, sc);
                    break;
                case 2:
                    e2 = ec.editEmployeeDetails(emp2, sc);
                    break;
                case 3:
                    emp2 = LogOutController.logOut(emp, sc);
                    break;
                default:
                    LOGGER.info("Illegal choice. Please re-enter your choice.");
                    break;
                }

            } catch (Exception ex) {
                LOGGER.log(Level.INFO, "Exception::{0}", ex);
            }
            if (UserType.INVALID.equals(emp2.getRole())) {
                return;
            }
        }
    }
}
