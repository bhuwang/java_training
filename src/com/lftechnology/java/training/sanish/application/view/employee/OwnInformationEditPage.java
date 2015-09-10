package com.lftechnology.java.training.sanish.application.view.employee;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Employee edit own information page view
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class OwnInformationEditPage {
    private static final Logger LOGGER = Logger.getLogger(OwnInformationEditPage.class.getName());

    /**
     * Render employee edit own information page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void renderPage() {
        String pageContent = "\n============================= Employee Edit Own Information Page =========================\n";
        LOGGER.log(Level.INFO, pageContent, new Object[] {});
    }
}
