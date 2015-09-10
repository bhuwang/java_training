package com.lftechnology.java.training.sanish.application.controller;

import com.lftechnology.java.training.sanish.application.dbconnection.DbConnect;
import com.lftechnology.java.training.sanish.application.component.UserLogin;
import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.view.employee.EmployeeDashboardPage;
import com.lftechnology.java.training.sanish.application.view.employee.EmployeeListingPage;
import com.lftechnology.java.training.sanish.application.view.employee.EmployeeSearchPage;
import com.lftechnology.java.training.sanish.application.view.employee.OwnInformationEditPage;
import com.lftechnology.java.training.sanish.student.UserInput;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Employee controller
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class EmployeeController {
    private static final Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());

    private EmployeeController() {
    }

    /**
     * Employee dashboard page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void employeeDashboardPage() {
        try (Scanner inputScanner = new Scanner(System.in)) {
            if (UserLogin.isLogin()) {
                User user = UserLogin.getCurrentUser();
                EmployeeDashboardPage.renderPage(inputScanner, user);
                int menuSelected = UserInput.getNumber(inputScanner, 1, 5);
                if (menuSelected == 1) {
                    employeeListPage();
                }else if (menuSelected == 2) {
                    employeeSearchPage();
                }else if (menuSelected == 3) {
                    ownInformationEditPage();
                }else if (menuSelected == 4) {
                    // TODO change password
                }else{
                    LoginController.logoutPage();
                }
            } else {
                LoginController.LoginPage();
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "Exception Message : {0}", e.getMessage());
        } finally {
            DbConnect.DbClose();
        }
    }

    /**
     * Employee list page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void employeeListPage() {
        if (UserLogin.isLogin()) {
            EmployeeListingPage.renderPage();
        } else {
            LoginController.LoginPage();
        }
    }

    /**
     * Employee search page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void employeeSearchPage() {
        if (UserLogin.isLogin()) {
            EmployeeSearchPage.renderPage();
        } else {
            LoginController.LoginPage();
        }
    }

    /**
     * Employee edit own information page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void ownInformationEditPage() {
        if (UserLogin.isLogin()) {
            OwnInformationEditPage.renderPage();
        } else {
            LoginController.LoginPage();
        }
    }

}
