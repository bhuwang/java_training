package com.lftechnology.java.training.sanish.application.view.employee;

import com.lftechnology.java.training.sanish.application.model.domain.UserEmployee;
import com.lftechnology.java.training.sanish.application.utility.OutputFormatter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by sanish on 9/15/15.
 */
public class TerminateEmployeePage {
    private static final Logger LOGGER = Logger.getLogger(TerminateEmployeePage.class.getName());
    /**
     * Render edit employee page
     *
     * @param showMessage {@link Boolean}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void renderPage(Boolean showMessage, String message) {
        String pageContent = OutputFormatter.getFormattedPageTitle("Terminate Employee Page");
        if (showMessage) {
           pageContent +="\n Message : "+ message;

            pageContent += "\n\n Page Menu :\n 1. List Employees\n 2. Back To Employee Dashboard\n 3. Logout";
            pageContent += "\n >> type option";
        }
        LOGGER.log(Level.INFO, pageContent);
    }
}
