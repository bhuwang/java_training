package com.lftechnology.java.training.sanish.application.view.employee;

import com.lftechnology.java.training.sanish.application.component.Constants;
import com.lftechnology.java.training.sanish.application.utility.OutputFormatter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Change password page
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class ChangePasswordPage {
    private static final Logger LOGGER = Logger.getLogger(ChangePasswordPage.class.getName());

    private ChangePasswordPage() {
    }

    /**
     * Render change password page
     *
     * @param showMenu {@link Boolean}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void renderPage(Boolean showMenu) {
        String pageContent = OutputFormatter.getFormattedPageTitle(Constants.CHANGE_PASSWORD_PAGE);
        if (showMenu) {
            pageContent += "\n\n" + Constants.PAGE_MENU_LABEL + "\n 1." + Constants.BACK_DASHBOARD_MENU + "\n 2." + Constants.LOGOUT_MENU;
            pageContent += "\n >>" + Constants.TYPE_OPTION_LABEL;
        }
        LOGGER.log(Level.INFO, pageContent);
    }
}
