package com.lftechnology.java.training.sanish.application.view.employee;

import com.lftechnology.java.training.sanish.application.model.domain.User;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Employee dashboard page view
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class EmployeeDashboardPage {
    private static final Logger LOGGER = Logger.getLogger(EmployeeDashboardPage.class.getName());

    /**
     * Render employee dashboard page
     *
     * @param inputScanner {@link Scanner}
     * @param user         {@link User} current login user
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void renderPage(Scanner inputScanner, User user) {
        String pageContent = "\n============================= Employee Dashboard Page =========================\n";
        pageContent += "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Welcome {0}\n";
        pageContent += "1. List All Employee\n" + "2. Search Employee\n" + "3. Edit Own Information\n" + "4. Change Password\n";
        pageContent += "5. Logout\n";
        pageContent += "\n\n\n Enter menu number:";
        LOGGER.log(Level.INFO, pageContent, new Object[] { user.getUserName() });
    }
}
