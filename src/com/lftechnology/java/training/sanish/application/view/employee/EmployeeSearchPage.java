package com.lftechnology.java.training.sanish.application.view.employee;

import com.lftechnology.java.training.sanish.application.component.Constants;
import com.lftechnology.java.training.sanish.application.utility.OutputFormatter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Employee search page view
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class EmployeeSearchPage {
    private static final Logger LOGGER = Logger.getLogger(EmployeeSearchPage.class.getName());

    private EmployeeSearchPage() {
    }

    /**
     * Render employee search page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void renderPage() {
        String pageContent = OutputFormatter.getFormattedPageTitle(Constants.EMPLOYEE_SEARCH_PAGE);
        pageContent += ">>" + Constants.TYPE_SEARCH_KEY;
        LOGGER.log(Level.INFO, pageContent);
    }
}
