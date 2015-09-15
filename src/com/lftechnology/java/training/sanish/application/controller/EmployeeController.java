package com.lftechnology.java.training.sanish.application.controller;

import com.lftechnology.java.training.sanish.application.component.EmployeeHelper;
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
                EmployeeDashboardPage.renderPage(inputScanner, user, employee);
                int menuSelected;
                if (employee.getRole().equals("Admin")) {
                    menuSelected = UserInput.getIntegerNumber(inputScanner, 1, 8);
                } else {
                    menuSelected = UserInput.getIntegerNumber(inputScanner, 1, 5);
                }

                if (menuSelected == 1) {
                    employeeListPage();
                } else if (menuSelected == 2) {
                    employeeSearchPage();
                } else if (menuSelected == 3) {
                    ownInformationEditPage();
                } else if (menuSelected == 4) {
                    changePasswordPage();
                } else if (menuSelected == 5) {
                    if (employee.getRole().equals("Admin")) {
                        addEmployeePage();
                    } else {
                        LoginController.logoutPage();
                    }

                } else if (menuSelected == 6) {
                    editEmployeePage();
                } else if (menuSelected == 7) {
                    terminateEmployeePage();
                } else {
                    LoginController.logoutPage();
                }
            } else {
                LoginController.LoginPage();
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "Exception Message : {0}", e.getMessage());
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
                if (option == 1) {
                    employeeSearchPage();
                } else if (option == 2) {
                    employeeDashboardPage();
                } else {
                    LoginController.logoutPage();
                }
            } else {
                LoginController.LoginPage();
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "Exception Message : {0}", e.getMessage());
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
                LoginController.LoginPage();
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "Exception Message : {0}", e.getMessage());
        } finally {
            DbConnect.dbClose();
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
                UserDao userDao = new UserDao();
                List<UserEmployee> userEmployeeList = userDao.searchEmployee(searchKey);
                EmployeeSearchResultPage.renderPage(userEmployeeList);

                int option;
                option = UserInput.getIntegerNumber(inputScanner, 1, 3);
                if (option == 1) {
                    employeeSearchPage();
                } else if (option == 2) {
                    employeeDashboardPage();
                } else {
                    LoginController.logoutPage();
                }
            } else {
                LoginController.LoginPage();
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "Exception Message : {0}", e.getMessage());
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
                if (option == 1) {
                    ownInformationEditPage();
                } else if (option == 2) {
                    employeeDashboardPage();
                } else {
                    LoginController.logoutPage();
                }
            } else {
                LoginController.LoginPage();
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "Exception Message : {0}", e.getMessage());
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
            DbConnect.dbClose();
        }
    }

    public static void addEmployeePage() {
        try (Scanner inputScanner = new Scanner(System.in)) {
            if (UserLogin.isLogin()) {
                String message = "";
                Boolean showMenu = false;
                AddEmployeePage.renderPage(showMenu, null, message);
                UserEmployee userEmployee = EmployeeHelper.addNewEmployee(inputScanner);
                if(userEmployee != null){
                    message = "Successfully new employee added.";
                    showMenu = true;
                    AddEmployeePage.renderPage(showMenu, userEmployee, message);
                }

                int option;
                option = UserInput.getIntegerNumber(inputScanner, 1, 3);
                if (option == 1) {
                    addEmployeePage();
                } else if (option == 2) {
                    employeeDashboardPage();
                } else {
                    LoginController.logoutPage();
                }
            } else {
                LoginController.LoginPage();
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "Exception Message : {0}", e.getMessage());
        } finally {
            DbConnect.dbClose();
        }
    }

    public static void editEmployeePage() {
        try (Scanner inputScanner = new Scanner(System.in)) {
            if (UserLogin.isLogin()) {
                UserDao userDao = new UserDao();
                UserEmployee userEmployee = new UserEmployee();
                EditEmployeePage.renderPage(userEmployee, false);
                int userId = EmployeeHelper.getUserId(inputScanner);
                if(userId != -1){
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
                if (option == 1) {
                    editEmployeePage();
                } else if (option == 2) {
                    employeeDashboardPage();
                } else {
                    LoginController.logoutPage();
                }
            } else {
                LoginController.LoginPage();
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "Exception Message : {0}", e.getMessage());
        } finally {
            DbConnect.dbClose();
        }
    }

    public static void terminateEmployeePage() {
        try (Scanner inputScanner = new Scanner(System.in)) {
            String message = "";
            if (UserLogin.isLogin()) {
                UserDao userDao = new UserDao();
                TerminateEmployeePage.renderPage(false, message);
                int userId = EmployeeHelper.getUserId(inputScanner);
                if(userId != -1){
                    User user = userDao.findById(userId);
                    if(EmployeeHelper.terminateConformation(inputScanner, user)){
                        if(userDao.terminateUser(user)){
                            message = "User terminate successfully.";
                        }else{
                            message = "Fail to terminate user successfully.";
                        }
                    }else{
                        message = "Cancel terminate user.";
                    }

                    TerminateEmployeePage.renderPage(true, message);
                }

                int option;
                option = UserInput.getIntegerNumber(inputScanner, 1, 3);
                if (option == 1) {
                    employeeListPage();
                } else if (option == 2) {
                    employeeDashboardPage();
                } else {
                    LoginController.logoutPage();
                }
            } else {
                LoginController.LoginPage();
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "Exception Message : {0}", e.getMessage());
        } finally {
            DbConnect.dbClose();
        }
    }

}
