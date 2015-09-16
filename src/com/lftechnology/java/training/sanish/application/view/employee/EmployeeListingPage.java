package com.lftechnology.java.training.sanish.application.view.employee;

import com.lftechnology.java.training.sanish.application.component.Constants;
import com.lftechnology.java.training.sanish.application.model.domain.UserEmployee;
import com.lftechnology.java.training.sanish.application.utility.OutputFormatter;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Employee listing page view
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class EmployeeListingPage {
    private static final Logger LOGGER = Logger.getLogger(EmployeeListingPage.class.getName());

    private EmployeeListingPage() {
    }

    /**
     * Render employee listing page
     *
     * @param userEmployeeList {@link List<UserEmployee>}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void renderPage(List<UserEmployee> userEmployeeList) {
        String pageContent = OutputFormatter.getFormattedPageTitle("Employee Listing Page");
        pageContent += "\n Active User list \n";
        if (userEmployeeList.size() > 0) {
            pageContent += "\n " +
                    OutputFormatter.getStringForListCol(Constants.USER_ID, 10) +
                    OutputFormatter.getStringForListCol(Constants.USER_NAME, 30) +
                    OutputFormatter.getStringForListCol(Constants.FULL_NAME, 30) +
                    OutputFormatter.getStringForListCol(Constants.EMAIL, 30) +
                    OutputFormatter.getStringForListCol(Constants.ADDRESS, 30) +
                    OutputFormatter.getStringForListCol(Constants.DEPARTMENT, 30) +
                    OutputFormatter.getStringForListCol(Constants.ROLE, 30) + "\n";
            pageContent += "\n-------------------------------------------------------------------------------------------------------------"
                    + "---------------------------------------------------------------------------------------------------------------\n";
            for (UserEmployee userEmployee : userEmployeeList) {
                pageContent += "\n " +
                        OutputFormatter.getStringForListCol(userEmployee.getUser().getUserId(), 10) +
                        OutputFormatter.getStringForListCol(userEmployee.getUser().getUserName(), 30) +
                        OutputFormatter.getStringForListCol(userEmployee.getEmployee().getFullName(), 30) +
                        OutputFormatter.getStringForListCol(userEmployee.getUser().getEmail(), 30) +
                        OutputFormatter.getStringForListCol(userEmployee.getEmployee().getAddress(), 30) +
                        OutputFormatter.getStringForListCol(userEmployee.getEmployee().getDepartment(), 30) +
                        OutputFormatter.getStringForListCol(userEmployee.getEmployee().getRole(), 30) + "\n";
            }
        } else {
            pageContent += "\n " + Constants.ACTIVE_USER_NOT_EXIST_MSG;
        }

        pageContent +=
                "\n\n" + Constants.PAGE_MENU_LABEL + "\n 1." + Constants.SEARCH_EMPLOYEE_MENU + "\n 2." + Constants.BACK_DASHBOARD_MENU
                        + "\n 3." + Constants.LOGOUT_MENU;
        pageContent += "\n >>" + Constants.TYPE_OPTION_LABEL;

        LOGGER.log(Level.INFO, pageContent);
    }
}
