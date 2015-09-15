package com.lftechnology.java.training.sanish.application.utility;

import com.lftechnology.java.training.sanish.application.component.UserLogin;
import com.lftechnology.java.training.sanish.application.model.dao.UserDao;
import com.lftechnology.java.training.sanish.application.model.domain.User;

/**
 * Output formatter helper
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class OutputFormatter {
    private OutputFormatter() {
    }

    /**
     * Set page title
     *
     * @param title {@link String }
     * @return {@link String}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static String getFormattedPageTitle(String title) {
        User currentUser = UserLogin.getCurrentUser();
        String pageTitle = "\n==========================================================================================  " + title
                + "  ================================================================================== \n";
        if (currentUser != null) {
            UserDao userDao = new UserDao();
            String role = userDao.getEmployee(currentUser).getRole();
            pageTitle += "Login as > " + currentUser.getUserName() + " (" + role + ")\n\n";
        }

        return pageTitle;
    }

    /**
     * Return table column text
     *
     * @param value
     * @param colSize {@link Integer}
     * @param <V>
     * @return {@link String }
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static <V> String getStringForListCol(V value, int colSize) {
        String colValue = value.toString();
        int colValueLength = colValue.length();
        if (colValueLength > colSize) {
            return colValue.substring(colSize) + "\t";
        }
        int diffInLength = colSize - colValueLength;
        for (int i = 0; i < diffInLength; i++) {
            colValue += " ";
        }

        return colValue + "\t";
    }
}
