package com.lftechnology.java.training.sanish.application.view.employee;

import com.lftechnology.java.training.sanish.application.model.domain.Employee;
import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.utility.OutputFormatter;

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
    public static void renderPage(Scanner inputScanner, User user, Employee employee) {
        String pageContent = OutputFormatter.getFormattedPageTitle("Employee Dashboard Page");
        pageContent += "Page Menu \n";
        pageContent += " 1. List All Employee\n" +
                " 2. Search Employee\n" +
                " 3. Edit Own Information\n" +
                " 4. Change Password\n";

        if (employee.getRole().equals("Admin")) {
            pageContent += " 5. Add Employee\n" +
                    " 6. Edit Employee\n" +
                    " 7. Terminate Employee \n" +
                    " 8. Logout\n";
        } else {
            pageContent += " 5. Logout\n";
        }

        pageContent += "\n\n >> type option";
        LOGGER.log(Level.INFO, pageContent, new Object[] { user.getUserName() });
    }
}
