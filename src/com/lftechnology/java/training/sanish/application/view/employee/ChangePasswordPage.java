package com.lftechnology.java.training.sanish.application.view.employee;

import com.lftechnology.java.training.sanish.application.view.login.LoginPage;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Change password page
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class ChangePasswordPage {
    private static final Logger LOGGER = Logger.getLogger(LoginPage.class.getName());

    /**
     * Render change password page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void renderPage(Boolean showMenu) {
        String pageContent = "\n============================= Change Password Page =========================\n";
        if (showMenu) {
            pageContent += "\n\n Options :\n"
                    + " 1. Back To Employee Dashboard\n"
                    + " 2. Logout";
            pageContent += "\n >> type option";
        }
        LOGGER.log(Level.INFO, pageContent);
    }
}
