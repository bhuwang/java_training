package com.lftechnology.java.training.sanish.application.view.employee;

import com.lftechnology.java.training.sanish.application.component.Constants;
import com.lftechnology.java.training.sanish.application.utility.OutputFormatter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Terminate employee page
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class TerminateEmployeePage {
    private static final Logger LOGGER = Logger.getLogger(TerminateEmployeePage.class.getName());

    private TerminateEmployeePage() {
    }

    /**
     * Render terminate employee page
     *
     * @param showMessage {@link Boolean}
     * @param message     {@link String }
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void renderPage(Boolean showMessage, String message) {
        String pageContent = OutputFormatter.getFormattedPageTitle(Constants.TERMINATE_EMPLOYEE_PAGE);
        if (showMessage) {
            pageContent += "\n " + Constants.MSG_LABEL + message;
            pageContent += "\n\n" + Constants.PAGE_MENU_LABEL + "\n 1." + Constants.LIST_ALL_EMPLOYEE_MENU + "\n 2."
                    + Constants.BACK_DASHBOARD_MENU + "\n 3." + Constants.LOGOUT_MENU;
            pageContent += "\n >>" + Constants.TYPE_OPTION_LABEL;
        }

        LOGGER.log(Level.INFO, pageContent);
    }
}
