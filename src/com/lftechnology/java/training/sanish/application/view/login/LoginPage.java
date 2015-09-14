package com.lftechnology.java.training.sanish.application.view.login;

import com.lftechnology.java.training.sanish.application.utility.OutputFormatter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Login page view
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class LoginPage {
    private LoginPage() {
    }

    private static final Logger LOGGER = Logger.getLogger(LoginPage.class.getName());

    /**
     * Render employee login page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void renderPage(int loginAttempt) {
        String pageContent = OutputFormatter.getFormattedPageTitle("Employee Login Page");
        if (loginAttempt > 0) {
            pageContent += "Message : Invalid userName or password. Please try again.";
        }
        LOGGER.log(Level.INFO, pageContent);
    }
}
