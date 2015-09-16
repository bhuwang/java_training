package com.lftechnology.java.training.sanish.application.controller;

import com.lftechnology.java.training.sanish.application.component.Constants;
import com.lftechnology.java.training.sanish.application.component.EmployeeHelper;
import com.lftechnology.java.training.sanish.application.component.PageMenu;
import com.lftechnology.java.training.sanish.application.dbconnection.DbConnect;
import com.lftechnology.java.training.sanish.application.component.UserLogin;
import com.lftechnology.java.training.sanish.application.model.dao.UserDao;
import com.lftechnology.java.training.sanish.application.model.domain.Employee;
import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.model.domain.UserEmployee;
import com.lftechnology.java.training.sanish.application.utility.UserInput;
import com.lftechnology.java.training.sanish.application.view.employee.*;

import java.util.ArrayList;
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
                UserDao userDao = new UserDao();
                User user = UserLogin.getCurrentUser();
                Employee employee = userDao.getEmployee(user);
                EmployeeDashboardPage.renderPage(employee);

                int menuSelected;
                if (employee.getRole().equals(Constants.ADMIN_ROLE)) {
                    menuSelected = UserInput.getIntegerNumber(inputScanner, 1, 8);
                } else {
                    menuSelected = UserInput.getIntegerNumber(inputScanner, 1, 5);
                }

                PageMenu.dashboardMenu(menuSelected, employee);
            } else {
                LoginController.loginPage();
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
        } finally {
            DbConnect.dbClose();
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
                List<UserEmployee> userEmployeesList = new ArrayList<UserEmployee>();
                for (User user : userList) {
                    UserEmployee userEmployee = new UserEmployee();
                    Employee employee = userData.getEmployee(user);
                    userEmployee.setUser(user);
                    userEmployee.setEmployee(employee);
                    userEmployeesList.add(userEmployee);
                }
                EmployeeListingPage.renderPage(userEmployeesList);

                int option;
                option = UserInput.getIntegerNumber(inputScanner, 1, 3);
                PageMenu.employeeListPageMenu(option);
            } else {
                LoginController.loginPage();
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
        } finally {
            DbConnect.dbClose();
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
                LoginController.loginPage();
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
        } finally {
            DbConnect.dbClose();
        }
    }

    /**
     * Employee search result page
     *
     * @param searchKey {@link String}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void employeeSearchResultPage(String searchKey) {
        try (Scanner inputScanner = new Scanner(System.in)) {
            if (UserLogin.isLogin()) {
                UserDao userDao = new UserDao();
                List<UserEmployee> userEmployeeList = userDao.searchEmployee(searchKey);
                EmployeeSearchResultPage.renderPage(userEmployeeList);

                int option;
                option = UserInput.getIntegerNumber(inputScanner, 1, 3);
                PageMenu.employeeListPageMenu(option);
            } else {
                LoginController.loginPage();
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
        } finally {
            DbConnect.dbClose();
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
                UserDao userDao = new UserDao();
                UserEmployee userEmployee = new UserEmployee();
                User user = UserLogin.getCurrentUser();
                Employee employee = userDao.getEmployee(user);
                userEmployee.setUser(user);
                userEmployee.setEmployee(employee);
                OwnInformationEditPage.renderPage(userEmployee, false);

                EmployeeHelper.changeUserName(inputScanner, user);
                EmployeeHelper.changeFullName(inputScanner, employee);
                EmployeeHelper.changeUserEmail(inputScanner, user);
                EmployeeHelper.changeAddress(inputScanner, employee);

                UserLogin.setCurrentUser(userDao.findById(user.getUserId()));
                user = UserLogin.getCurrentUser();
                employee = userDao.getEmployee(user);
                userEmployee.setUser(user);
                userEmployee.setEmployee(employee);
                OwnInformationEditPage.renderPage(userEmployee, true);

                int option;
                option = UserInput.getIntegerNumber(inputScanner, 1, 3);
                PageMenu.employeeOwnPageMenu(option);
            } else {
                LoginController.loginPage();
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
        } finally {
            DbConnect.dbClose();
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
                PageMenu.changePasswordPageMenu(option);
            } else {
                LoginController.loginPage();
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
        } finally {
            DbConnect.dbClose();
        }
    }

    /**
     * Add employee page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void addEmployeePage() {
        try (Scanner inputScanner = new Scanner(System.in)) {
            if (UserLogin.isLogin()) {
                String message = "";
                Boolean showMenu = false;
                AddEmployeePage.renderPage(showMenu, null, message);
                UserEmployee userEmployee = EmployeeHelper.addNewEmployee(inputScanner);
                if (userEmployee != null) {
                    showMenu = true;
                    AddEmployeePage.renderPage(showMenu, userEmployee, Constants.SUCCESS_ADD_EMPLOYEE_MSG);
                }

                int option;
                option = UserInput.getIntegerNumber(inputScanner, 1, 3);
                PageMenu.addEmployeePageMenu(option);
            } else {
                LoginController.loginPage();
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
        } finally {
            DbConnect.dbClose();
        }
    }

    /**
     * Edit employee page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void editEmployeePage() {
        try (Scanner inputScanner = new Scanner(System.in)) {
            if (UserLogin.isLogin()) {
                UserDao userDao = new UserDao();
                UserEmployee userEmployee = new UserEmployee();
                EditEmployeePage.renderPage(userEmployee, false);
                int userId = EmployeeHelper.getUserId(inputScanner);
                if (userId != -1) {
                    User user = userDao.findById(userId);
                    Employee employee = userDao.getEmployee(user);
                    userEmployee.setUser(user);
                    userEmployee.setEmployee(employee);

                    EmployeeHelper.changeUserName(inputScanner, user);
                    EmployeeHelper.changeFullName(inputScanner, employee);
                    EmployeeHelper.changeUserEmail(inputScanner, user);
                    EmployeeHelper.changeAddress(inputScanner, employee);
                    EmployeeHelper.changeDepartment(inputScanner, employee);
                    EmployeeHelper.changeRole(inputScanner, employee);

                    user = userDao.findById(userId);
                    employee = userDao.getEmployee(user);
                    userEmployee.setUser(user);
                    userEmployee.setEmployee(employee);
                    EditEmployeePage.renderPage(userEmployee, true);
                }

                int option;
                option = UserInput.getIntegerNumber(inputScanner, 1, 3);
                PageMenu.editEmployeePageMenu(option);
            } else {
                LoginController.loginPage();
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
        } finally {
            DbConnect.dbClose();
        }
    }

    /**
     * Terminate user page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void terminateEmployeePage() {
        try (Scanner inputScanner = new Scanner(System.in)) {
            String message = "";
            if (UserLogin.isLogin()) {
                TerminateEmployeePage.renderPage(false, message);
                int userId = EmployeeHelper.getUserId(inputScanner);
                if (userId != -1) {
                    UserDao userDao = new UserDao();
                    User user = userDao.findById(userId);
                    EmployeeHelper.terminateUser(inputScanner, user);

                    TerminateEmployeePage.renderPage(true, message);
                }

                int option;
                option = UserInput.getIntegerNumber(inputScanner, 1, 3);
                PageMenu.terminatePageMenu(option);
            } else {
                LoginController.loginPage();
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
        } finally {
            DbConnect.dbClose();
        }
    }

}
