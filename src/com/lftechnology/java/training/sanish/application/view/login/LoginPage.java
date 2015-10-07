package com.lftechnology.java.training.sanish.application.view.login;

import com.lftechnology.java.training.sanish.application.component.Constants;
import com.lftechnology.java.training.sanish.application.utility.OutputFormatter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Login page view
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class LoginPage {
    private static final Logger LOGGER = Logger.getLogger(LoginPage.class.getName());

    private LoginPage() {
    }

    /**
     * Render employee login page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void renderPage(int loginAttempt) {
        String pageContent = OutputFormatter.getFormattedPageTitle(Constants.LOGIN_PAGE);
        if (loginAttempt > 0) {
            pageContent += Constants.ERROR_MSG_LABEL + Constants.INVALID_EMAIL_PASSWORD_MSG;
        }

        LOGGER.log(Level.INFO, pageContent);
    }
}
