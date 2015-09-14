package com.lftechnology.java.training.sanish.application.view.employee;

import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.model.domain.UserEmployee;
import com.lftechnology.java.training.sanish.application.utility.OutputFormatter;
import com.lftechnology.java.training.sanish.application.utility.UserInput;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Employee edit own information page view
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class OwnInformationEditPage {
    private static final Logger LOGGER = Logger.getLogger(OwnInformationEditPage.class.getName());

    /**
     * Render employee edit own information page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void renderPage(UserEmployee userEmployee, Boolean showUserInfo) {
        String pageContent = OutputFormatter.getFormattedPageTitle("Employee Edit Own Information Page");
        if (showUserInfo) {
            pageContent += "Own information :\n" + " User Id : " + userEmployee.getUser().getUserId() + "\n User Name : " +
                    userEmployee.getUser().getUserName() + "\n Full Name : " + userEmployee.getEmployee().getFullName() +
                    "\n Email : " + userEmployee.getUser().getEmail() + "\n Address : " + userEmployee.getEmployee().getAddress() +
                    "\n Department : " + userEmployee.getEmployee().getDepartment() + "\n Role : " + userEmployee.getEmployee().getRole()
                    + "\n";

            pageContent += "\n\n Page Menu :\n 1. Edit Own Information\n 2. Back To Employee Dashboard\n 3. Logout";
            pageContent += "\n >> type option";
        }
        LOGGER.log(Level.INFO, pageContent);
    }
}
