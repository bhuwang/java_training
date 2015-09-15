package com.lftechnology.java.training.sanish.application.view.employee;

import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.model.domain.UserEmployee;
import com.lftechnology.java.training.sanish.application.utility.OutputFormatter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Add employee page
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class AddEmployeePage {
    private static final Logger LOGGER = Logger.getLogger(AddEmployeePage.class.getName());

    /**
     * Render add employee page
     *
     * @param showMenu {@link Boolean}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void renderPage(Boolean showMenu, UserEmployee userEmployee, String message) {
        String pageContent = OutputFormatter.getFormattedPageTitle("Add Employee Page");
        if (showMenu) {
            pageContent += "\nMessage : " + message;
            pageContent += "Details: :\n" + " User Id : " + userEmployee.getUser().getUserId() + "\n User Name : " +
                    userEmployee.getUser().getUserName() + "\n Full Name : " + userEmployee.getEmployee().getFullName() +
                    "\n Email : " + userEmployee.getUser().getEmail() + "\n Address : " + userEmployee.getEmployee().getAddress() +
                    "\n Department : " + userEmployee.getEmployee().getDepartment() + "\n Role : " + userEmployee.getEmployee().getRole()
                    + "\n";
            pageContent += "\n\n Page Menu :\n" + " 1. Add Employee\n" + " 2. Back To Employee Dashboard\n" + " 2. Logout";
            pageContent += "\n >> type option";
        }
        LOGGER.log(Level.INFO, pageContent);
    }
}
