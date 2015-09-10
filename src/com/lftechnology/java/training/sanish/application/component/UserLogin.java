package com.lftechnology.java.training.sanish.application.component;

import com.lftechnology.java.training.sanish.application.model.dao.UserDao;
import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.utility.UserInput;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User login component
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class UserLogin {
    private static final Logger LOGGER = Logger.getLogger(UserLogin.class.getName());
    private static String userName;
    private static String password;
    private static boolean isLogin = false;
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static boolean isLogin() {
        return isLogin;
    }

    public static void setIsLogin(boolean isLogin) {
        UserLogin.isLogin = isLogin;
    }

    public static void setCurrentUser(User currentUser) {
        UserLogin.currentUser = currentUser;
    }

    /**
     * Request username & password for login and return true if login success else false.
     *
     * @param inputScanner {@link Scanner}
     * @return {@link Boolean}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static boolean loginUser(Scanner inputScanner) {
        getCredential(inputScanner);
        UserDao userDao = new UserDao();
        User user = userDao.getUserByUserName(userName);
        if (user != null) {
            if (validateUser(user)) {
                isLogin = true;
                currentUser = user;
                return true;
            }
        }

        return false;
    }

    /**
     * Get user credential for console
     *
     * @param inputScanner {@link Scanner}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void getCredential(Scanner inputScanner) {
        LOGGER.log(Level.INFO, "User Name :");
        userName = UserInput.getString(inputScanner);
        LOGGER.log(Level.INFO, "Password :");
        password = UserInput.getString(inputScanner);
    }

    /**
     * Validate username & password
     *
     * @param user {@link User}
     * @return {@link Boolean}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static boolean validateUser(User user) {
        if (userName.equals(user.getUserName()) && password.equals(user.getPassword())) {
            return true;
        }
        return false;
    }

}
