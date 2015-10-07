package com.lftechnology.java.training.sanish.application.view.employee;

import com.lftechnology.java.training.sanish.application.component.Constants;
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

    private AddEmployeePage() {
    }

    /**
     * Render add employee page
     *
     * @param showMenu     {@link Boolean}
     * @param userEmployee {@link UserEmployee}
     * @param message      {@link String }
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void renderPage(Boolean showMenu, UserEmployee userEmployee, String message) {
        String pageContent = OutputFormatter.getFormattedPageTitle(Constants.ADD_EMPLOYEE_PAGE);
        if (showMenu) {
            pageContent += "\n" + Constants.MSG_LABEL + message + "\n";
            pageContent += Constants.DETAIL_LABEL + "\n" + Constants.USER_ID_LABEL + userEmployee.getUser().getUserId() + "\n"
                    + Constants.USER_NAME_LABEL + userEmployee.getUser().getUserName() + "\n" + Constants.USER_FULL_NAME_LABEL
                    + userEmployee.getEmployee().getFullName() + "\n" + Constants.USER_EMAIL_LABEL + userEmployee.getUser().getEmail()
                    + "\n" + Constants.USER_ADDRESS_LABEL + userEmployee.getEmployee().getAddress() + "\n" + Constants.USER_DEPARTMENT_LABEL
                    + userEmployee.getEmployee().getDepartment() + "\n" + Constants.USER_ROLE_LABEL + userEmployee.getEmployee().getRole()
                    + "\n";
            pageContent +=
                    "\n\n" + Constants.PAGE_MENU_LABEL + "\n 1." + Constants.ADD_EMPLOYEE_MENU + "\n 2." + Constants.BACK_DASHBOARD_MENU
                            + "\n 3." + Constants.LOGOUT_MENU;
            pageContent += "\n >>" + Constants.TYPE_OPTION_LABEL;
        }

        LOGGER.log(Level.INFO, pageContent);
    }
}
