package com.lftechnology.java.training.sanish.application.utility;

import com.lftechnology.java.training.sanish.application.component.UserLogin;
import com.lftechnology.java.training.sanish.application.model.dao.UserDao;
import com.lftechnology.java.training.sanish.application.model.domain.User;

/**
 * Created by sanish on 9/11/15.
 */
public class OutputFormatter {
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
