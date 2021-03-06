package com.lftechnology.java.training.sanish.application.controller;

import com.lftechnology.java.training.sanish.application.component.Constants;
import com.lftechnology.java.training.sanish.application.dbconnection.DbConnect;
import com.lftechnology.java.training.sanish.application.component.UserLogin;
import com.lftechnology.java.training.sanish.application.view.login.LoginPage;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Login controller
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class LoginController {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());

    private LoginController() {
    }

    /**
     * Login page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void loginPage() {
        try (Scanner inputScanner = new Scanner(System.in)) {
            int loginAttempt = 0;
            boolean isLogin = UserLogin.isLogin();
            while (!isLogin) {
                LoginPage.renderPage(loginAttempt);
                isLogin = UserLogin.loginUser(inputScanner);
                loginAttempt++;
            }
            if (isLogin) {
                EmployeeController.employeeDashboardPage();
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
        } finally {
            DbConnect.dbClose();
        }
    }

    /**
     * Logout Page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void logoutPage() {
        if (UserLogin.isLogin()) {
            UserLogin.setIsLogin(false);
            UserLogin.setCurrentUser(null);
        }

        loginPage();
    }
}
