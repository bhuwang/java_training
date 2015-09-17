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
    private static User currentUser = null;

    private UserLogin() {
    }

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
        if (user != null && validateUser(user)) {
            isLogin = true;
            currentUser = user;
            return true;
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
        LOGGER.log(Level.INFO, Constants.TYPE_USER_NAME_LABEL);
        userName = UserInput.getString(inputScanner);
        LOGGER.log(Level.INFO, Constants.TYPE_PASSWORD_LABEL);
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
        String md5Password = md5(password);
        if (userName.equals(user.getUserName()) && md5Password.equals(user.getPassword())) {
            return true;
        }

        return false;
    }

    /**
     * Encrypt string into md5
     *
     * @param str {@link String}
     * @return {@link String}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static String md5(String str) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(str.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
        }
        return null;
    }

}
