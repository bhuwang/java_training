package com.lftechnology.java.training.sanish.application.view.employee;

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

    /**
     * Render employee search page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void renderPage() {
        String pageContent = OutputFormatter.getFormattedPageTitle("Employee Search Page");
        pageContent +=">> Type search key to search employee:";
        LOGGER.log(Level.INFO, pageContent, new Object[] {});
    }
}
