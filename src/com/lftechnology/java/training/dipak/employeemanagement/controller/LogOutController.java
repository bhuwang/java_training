
package com.lftechnology.java.training.dipak.employeemanagement.controller;

import java.util.Scanner;
import java.util.logging.Logger;

import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;
import com.lftechnology.java.training.dipak.employeemanagement.domain.UserType;
import com.lftechnology.java.training.dipak.employeemanagement.ui.MainClass;

/**
 * <p>
 * This class is used to provide logout functionality.
 * </p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */

public class LogOutController {
    private static final Logger LOGGER = Logger.getLogger(LogOutController.class.getName());

    private LogOutController() {

    }

    /**
     * <p>
     * This method changes the values of the employee object by emptying the fields or placing random values.
     * </p>
     * 
     * @param e
     * @return e
     */
    public static Employee logOut(Employee e, Scanner sc) {
        LOGGER.info("Are you sure you want to log out?\n");
        LOGGER.info("yes-->1\t\tno-->2\n");

        int check = Integer.parseInt(sc.nextLine());
        if (check == 1) {
            e.setId(0);
            e.setUserName("");
            e.setPassword("");
            e.setAddress("");
            e.setDepartment("");
            e.setRole(UserType.INVALID);
            e.setFullName("");
            e.setIsTerminated(true);
            LOGGER.info("Logout Successful...");
            MainClass.isLoggedIn = false;
        }

        return e;
    }
}
