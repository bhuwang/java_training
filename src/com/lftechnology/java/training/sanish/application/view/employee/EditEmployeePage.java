package com.lftechnology.java.training.sanish.application.view.employee;

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
     * @param showMenu {@link Boolean}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void renderPage(Boolean showMenu) {
        String pageContent = OutputFormatter.getFormattedPageTitle("Edit Employee Page");
        if (showMenu) {
            pageContent += "\n\n Page Menu :\n"
                    + " 1. Add Employee\n"
                    + " 2. Back To Employee Dashboard\n"
                    + " 3. Logout";
            pageContent += "\n >> type option";
        }
        LOGGER.log(Level.INFO, pageContent);
    }
}
