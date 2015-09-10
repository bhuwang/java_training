package com.lftechnology.java.training.sanish.application.view.employee;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Employee listing page view
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class EmployeeListingPage {
    private static final Logger LOGGER = Logger.getLogger(EmployeeListingPage.class.getName());

    /**
     * Render employee listing page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void renderPage() {
        String pageContent = "\n============================= Employee Listing Page =========================\n";

        LOGGER.log(Level.INFO, pageContent, new Object[] {});
    }
}
