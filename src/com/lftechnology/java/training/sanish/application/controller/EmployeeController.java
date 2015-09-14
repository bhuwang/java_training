package com.lftechnology.java.training.sanish.application.controller;

import com.lftechnology.java.training.sanish.application.component.EmployeeHelper;
import com.lftechnology.java.training.sanish.application.dbconnection.DbConnect;
import com.lftechnology.java.training.sanish.application.component.UserLogin;
import com.lftechnology.java.training.sanish.application.model.dao.UserDao;
import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.utility.UserInput;
import com.lftechnology.java.training.sanish.application.view.employee.*;

import java.util.List;
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
                int menuSelected = UserInput.getIntegerNumber(inputScanner, 1, 5);
                if (menuSelected == 1) {
                    employeeListPage();
                } else if (menuSelected == 2) {
                    employeeSearchPage();
                } else if (menuSelected == 3) {
                    ownInformationEditPage();
                } else if (menuSelected == 4) {
                    changePasswordPage();
                } else {
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
        try (Scanner inputScanner = new Scanner(System.in)) {
            if (UserLogin.isLogin()) {
                UserDao userData = new UserDao();
                List<User> userList = userData.getAll();
                EmployeeListingPage.renderPage(userList);
                int option;
                option = UserInput.getIntegerNumber(inputScanner, 1, 2);
                if (option == 1) {
                    employeeSearchPage();
                } else if (option == 2) {
                    employeeDashboardPage();
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
     * Employee search page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void employeeSearchPage() {
        try (Scanner inputScanner = new Scanner(System.in)) {
            if (UserLogin.isLogin()) {
                EmployeeSearchPage.renderPage();
                String searchKey = UserInput.getString(inputScanner);
                employeeSearchResultPage(searchKey);
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
     * Employee search result page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void employeeSearchResultPage(String searchKey) {
        try (Scanner inputScanner = new Scanner(System.in)) {
            if (UserLogin.isLogin()) {
                String condition = "userName=? || email=?";
                UserDao userDao = new UserDao();
                List<User> userList = userDao.getAll(condition, searchKey, searchKey);
                EmployeeSearchResultPage.renderPage(userList);

                int option;
                option = UserInput.getIntegerNumber(inputScanner, 1, 2);
                if (option == 1) {
                    employeeSearchPage();
                } else if (option == 2) {
                    employeeDashboardPage();
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
     * Employee edit own information page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void ownInformationEditPage() {
        try (Scanner inputScanner = new Scanner(System.in)) {
            if (UserLogin.isLogin()) {
                User user = UserLogin.getCurrentUser();
                OwnInformationEditPage.renderPage(user, false);
                EmployeeHelper.changeUserName(inputScanner, user);
                EmployeeHelper.changeUserEmail(inputScanner, user);

                UserDao userDao = new UserDao();
                UserLogin.setCurrentUser(userDao.findById(user.getUserId()));
                user = UserLogin.getCurrentUser();
                OwnInformationEditPage.renderPage(user, true);

                int option;
                option = UserInput.getIntegerNumber(inputScanner, 1, 2);
                if (option == 1) {
                    ownInformationEditPage();
                } else if (option == 2) {
                    employeeDashboardPage();
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
     * Change password page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void changePasswordPage() {
        try (Scanner inputScanner = new Scanner(System.in)) {
            if (UserLogin.isLogin()) {
                User user = UserLogin.getCurrentUser();
                ChangePasswordPage.renderPage(false);
                EmployeeHelper.changePassword(inputScanner, user);
                ChangePasswordPage.renderPage(true);
                int option;
                option = UserInput.getIntegerNumber(inputScanner, 1, 2);
                if (option == 1) {
                    employeeDashboardPage();
                } else if (option == 2) {
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

}
