package com.lftechnology.java.training.sanish.application.view.employee;

import com.lftechnology.java.training.sanish.application.model.domain.UserEmployee;
import com.lftechnology.java.training.sanish.application.utility.OutputFormatter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Edit employee page
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class EditEmployeePage {
    private static final Logger LOGGER = Logger.getLogger(EditEmployeePage.class.getName());
    /**
     * Render edit employee page
     *
     * @param showUserInfo {@link Boolean}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void renderPage(UserEmployee userEmployee,Boolean showUserInfo) {
        String pageContent = OutputFormatter.getFormattedPageTitle("Edit Employee Page");
        if (showUserInfo) {
            pageContent += "Employee information :\n" + " User Id : " + userEmployee.getUser().getUserId() + "\n User Name : " +
                    userEmployee.getUser().getUserName() + "\n Full Name : " + userEmployee.getEmployee().getFullName() +
                    "\n Email : " + userEmployee.getUser().getEmail() + "\n Address : " + userEmployee.getEmployee().getAddress() +
                    "\n Department : " + userEmployee.getEmployee().getDepartment() + "\n Role : " + userEmployee.getEmployee().getRole()
                    + "\n";

            pageContent += "\n\n Page Menu :\n 1. Add Employee\n 2. Back To Employee Dashboard\n 3. Logout";
            pageContent += "\n >> type option";
        }else{
            pageContent += "\n >> Type userId :";
        }
        LOGGER.log(Level.INFO, pageContent);
    }
}
