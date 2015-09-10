package com.lftechnology.java.training.sanish.application.login;

import com.lftechnology.java.training.sanish.application.Controller;
import com.lftechnology.java.training.sanish.application.model.dao.UserDao;
import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.utility.UserInput;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User login operations
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class UserLogin {
    private static final Logger LOGGER = Logger.getLogger(UserLogin.class.getName());
    private static String userName;
    private static String password;
    private static boolean isLogin = false;
    private static User loginedUser;

    /**
     * Request username & password for login and return true if login success else false.
     * @param inputScanner {@link Scanner}
     * @return {@link Boolean}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static boolean loginUser(Scanner inputScanner){
        getCredential(inputScanner);
        UserDao userDao = new UserDao();
        User user = userDao.getUserByUserName(userName);
        if(user != null){
            if(validateUser(user)){
                isLogin = true;
                loginedUser = user;
                return true;
            }
        }

        return false;
    }

    /**
     * Get user credential for console
     * @param inputScanner {@link Scanner}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void getCredential(Scanner inputScanner){
        LOGGER.log(Level.INFO, "User Name :");
        userName = UserInput.getString(inputScanner);
        LOGGER.log(Level.INFO, "Password :");
        password = UserInput.getString(inputScanner);
    }

    /**
     * Validate username & password
     * @param user {@link User}
     * @return {@link Boolean}
     */
    public static boolean validateUser(User user){
        if(userName.equals(user.getUserName()) && password.equals(user.getPassword())){
            return  true;
        }
        return  false;
    }
}
