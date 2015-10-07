package com.lftechnology.java.training.sanish.application.view.employee;

import com.lftechnology.java.training.sanish.application.component.Constants;
import com.lftechnology.java.training.sanish.application.model.domain.Employee;
import com.lftechnology.java.training.sanish.application.utility.OutputFormatter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Employee dashboard page view
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class EmployeeDashboardPage {
    private static final Logger LOGGER = Logger.getLogger(EmployeeDashboardPage.class.getName());

    private EmployeeDashboardPage() {
    }

    /**
     * Render employee dashboard page
     *
     * @param employee {@link Employee}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void renderPage(Employee employee) {
        String pageContent = OutputFormatter.getFormattedPageTitle(Constants.EMPLOYEE_DASHBOARD_PAGE);
        pageContent +=
                "\n\n" + Constants.PAGE_MENU_LABEL + "\n 1." + Constants.LIST_ALL_EMPLOYEE_MENU + "\n 2." + Constants.SEARCH_EMPLOYEE_MENU
                        + "\n 3." + Constants.EDIT_OWN_INFO_MENU + "\n 4." + Constants.CHANGE_PASSWORD_MENU + "\n";

        if (employee.getRole().equals(Constants.ADMIN_ROLE)) {
            pageContent += " 5." + Constants.ADD_EMPLOYEE_MENU + "\n 6." + Constants.EDIT_EMPLOYEE_MENU + "\n 7."
                    + Constants.TERMINATE_EMPLOYEE_MENU + "\n 8." + Constants.LOGOUT_MENU + "\n";
        } else {
            pageContent += " 5." + Constants.LOGOUT_MENU + "\n";
        }

        pageContent += "\n >>" + Constants.TYPE_OPTION_LABEL;

        LOGGER.log(Level.INFO, pageContent);
    }
}