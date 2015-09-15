package com.lftechnology.java.training.sanish.application.component;

import com.lftechnology.java.training.sanish.application.dbconnection.DbConnect;
import com.lftechnology.java.training.sanish.application.model.dao.EmployeeDao;
import com.lftechnology.java.training.sanish.application.model.dao.UserDao;
import com.lftechnology.java.training.sanish.application.model.domain.Employee;
import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.model.domain.UserEmployee;
import com.lftechnology.java.training.sanish.application.utility.UserInput;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provide functions of employee related
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class EmployeeHelper {
    private static final Logger LOGGER = Logger.getLogger(EmployeeHelper.class.getName());

    /**
     * Change user name of user
     *
     * @param inputScanner {@link Scanner}
     * @param user         {@link User}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void changeUserName(Scanner inputScanner, User user) {
        String message = "\n UserName : " + user.getUserName() + "\n" + ">> Change userName ? n/y :";
        LOGGER.log(Level.INFO, message);
        String edit = UserInput.getString(inputScanner);
        if (edit.equals("yes") || edit.equals("y")) {
            int updateRow = 0;
            String userName;
            String SetStatement;
            String whereCondition = "userId=?";
            UserDao userDao = new UserDao();
            while (updateRow == 0) {
                message = "\n >> Type new userName : ";
                LOGGER.log(Level.INFO, message);
                userName = UserInput.getString(inputScanner);
                SetStatement = "userName=?";
                updateRow = userDao.update(whereCondition, SetStatement, userName, user.getUserId());
                if (updateRow == 0) {
                    message = "\n Error Message: Fail to update userName. Try again? n/y";
                    LOGGER.log(Level.INFO, message);
                    edit = UserInput.getString(inputScanner);
                    if (!edit.equals("y") && !edit.equals("yes")) {
                        break;
                    }
                }
            }
        }
    }

    /**
     * Change email of user
     *
     * @param inputScanner {@link Scanner}
     * @param user         {@link User}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void changeUserEmail(Scanner inputScanner, User user) {
        String message = "\n User Email : " + user.getEmail() + "\n" + ">> Change user email ? n/y :";
        LOGGER.log(Level.INFO, message);
        String edit = UserInput.getString(inputScanner);
        if (edit.equals("y") || edit.equals("yes")) {
            int updateRow = 0;
            String email;
            String SetStatement;
            String whereCondition = "userId=?";
            UserDao userDao = new UserDao();
            while (updateRow == 0) {
                message = "\n >> Type new email : ";
                LOGGER.log(Level.INFO, message);
                email = UserInput.getString(inputScanner);
                SetStatement = "email=?";
                updateRow = userDao.update(whereCondition, SetStatement, email, user.getUserId());
                if (updateRow == 0) {
                    message = "\n Error Message: Fail to update user email. Try again? n/y";
                    LOGGER.log(Level.INFO, message);
                    edit = UserInput.getString(inputScanner);
                    if (!edit.equals("y") && !edit.equals("yes")) {
                        break;
                    }
                }
            }
        }
    }

    /**
     * Change email of user
     *
     * @param inputScanner {@link Scanner}
     * @param employee     {@link Employee}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void changeFullName(Scanner inputScanner, Employee employee) {
        String message = "\n User Full Name : " + employee.getFullName() + "\n" + ">> Change full name ? n/y :";
        LOGGER.log(Level.INFO, message);
        String edit = UserInput.getString(inputScanner);
        if (edit.equals("y") || edit.equals("yes")) {
            int updateRow = 0;
            String fullName;
            String SetStatement;
            String whereCondition = "employeeId=?";
            EmployeeDao employeeDao = new EmployeeDao();
            while (updateRow == 0) {
                message = "\n >> Type new full name : ";
                LOGGER.log(Level.INFO, message);
                fullName = UserInput.getAlphabeticWords(inputScanner);
                SetStatement = "fullName=?";
                updateRow = employeeDao.update(whereCondition, SetStatement, fullName, employee.getEmployeeId());
                if (updateRow == 0) {
                    message = "\n Error Message: Fail to update user full name. Try again? n/y";
                    LOGGER.log(Level.INFO, message);
                    edit = UserInput.getString(inputScanner);
                    if (!edit.equals("y") && !edit.equals("yes")) {
                        break;
                    }
                }
            }
        }
    }

    /**
     * Change email of user
     *
     * @param inputScanner {@link Scanner}
     * @param employee     {@link Employee}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void changeAddress(Scanner inputScanner, Employee employee) {
        String message = "\n User Address : " + employee.getAddress() + "\n" + ">> Change user address ? n/y :";
        LOGGER.log(Level.INFO, message);
        String edit = UserInput.getString(inputScanner);
        if (edit.equals("y") || edit.equals("yes")) {
            int updateRow = 0;
            String address;
            String SetStatement;
            String whereCondition = "employeeId=?";
            EmployeeDao employeeDao = new EmployeeDao();
            while (updateRow == 0) {
                message = "\n >> Type new address : ";
                LOGGER.log(Level.INFO, message);
                address = UserInput.getAlphabeticWords(inputScanner);
                SetStatement = "address=?";
                updateRow = employeeDao.update(whereCondition, SetStatement, address, employee.getEmployeeId());
                if (updateRow == 0) {
                    message = "\n Error Message: Fail to update user address. Try again? n/y";
                    LOGGER.log(Level.INFO, message);
                    edit = UserInput.getString(inputScanner);
                    if (!edit.equals("y") && !edit.equals("yes")) {
                        break;
                    }
                }
            }
        }
    }

    /**
     * Change email of user
     *
     * @param inputScanner {@link Scanner}
     * @param employee     {@link Employee}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void changeDepartment(Scanner inputScanner, Employee employee) {
        String message = "\n User Department : " + employee.getDepartment() + "\n" + ">> Change user department ? n/y :";
        LOGGER.log(Level.INFO, message);
        String edit = UserInput.getString(inputScanner);
        if (edit.equals("y") || edit.equals("yes")) {
            int updateRow = 0;
            String department;
            String SetStatement;
            String whereCondition = "employeeId=?";
            EmployeeDao employeeDao = new EmployeeDao();
            while (updateRow == 0) {
                message = "\n >> Type new department : ";
                LOGGER.log(Level.INFO, message);
                department = UserInput.getAlphabeticWords(inputScanner);
                SetStatement = "department=?";
                updateRow = employeeDao.update(whereCondition, SetStatement, department, employee.getEmployeeId());
                if (updateRow == 0) {
                    message = "\n Error Message: Fail to update user department. Try again? n/y";
                    LOGGER.log(Level.INFO, message);
                    edit = UserInput.getString(inputScanner);
                    if (!edit.equals("y") && !edit.equals("yes")) {
                        break;
                    }
                }
            }
        }
    }

    /**
     * Change email of user
     *
     * @param inputScanner {@link Scanner}
     * @param employee     {@link Employee}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void changeRole(Scanner inputScanner, Employee employee) {
        String message = "\n User Role : " + employee.getRole() + "\n" + ">> Change user role ? n/y :";
        LOGGER.log(Level.INFO, message);
        String edit = UserInput.getString(inputScanner);
        if (edit.equals("y") || edit.equals("yes")) {
            int updateRow = 0;
            String role;
            String SetStatement;
            String whereCondition = "employeeId=?";
            EmployeeDao employeeDao = new EmployeeDao();
            while (updateRow == 0) {
                message = "\n >> Type new role : ";
                LOGGER.log(Level.INFO, message);
                role = UserInput.getString(inputScanner);
                if (role.equals("Admin") || role.equals("User")) {
                    SetStatement = "role=?";
                    updateRow = employeeDao.update(whereCondition, SetStatement, role, employee.getEmployeeId());
                    if (updateRow == 0) {
                        message = "\n Error Message: Fail to update user role. Try again? n/y";
                        LOGGER.log(Level.INFO, message);
                        edit = UserInput.getString(inputScanner);
                        if (!edit.equals("y") && !edit.equals("yes")) {
                            break;
                        }
                    }
                } else {
                    message = "\n Error Message: Invalid role, role should be Admin or User. Try again? n/y";
                    LOGGER.log(Level.INFO, message);
                    edit = UserInput.getString(inputScanner);
                    if (!edit.equals("y") && !edit.equals("yes")) {
                        break;
                    }
                }

            }
        }
    }

    /**
     * Change email of user
     *
     * @param inputScanner {@link Scanner}
     * @param user         {@link User}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void changePassword(Scanner inputScanner, User user) {
        Boolean changePassword = true;
        UserDao userDao = new UserDao();
        while (changePassword) {
            String message = "\n >> Type Old Password : ";
            LOGGER.log(Level.INFO, message);
            String oldPassword = UserInput.getString(inputScanner);
            message = "\n >> Type New Password : ";
            LOGGER.log(Level.INFO, message);
            String newPassword = UserInput.getString(inputScanner);
            message = "\n >> Retype New Password : ";
            LOGGER.log(Level.INFO, message);
            String confirmPassword = UserInput.getString(inputScanner);
            if (newPassword.equals(confirmPassword)) {
                if (user.getPassword().equals(oldPassword)) {
                    if (oldPassword.equals(user.getPassword())) {
                        if (userDao.setPassword(user, newPassword)) {
                            changePassword = false;
                            message = "Successfully password change.";
                            LOGGER.log(Level.INFO, message);
                        } else {
                            message = "Fail to change password. Try again? n/y";
                            LOGGER.log(Level.WARNING, message);
                        }
                    }
                } else {
                    message = "Old password not match. Try again? n/y";
                    LOGGER.log(Level.WARNING, message);
                }
            } else {
                message = "New password & confirm password not match. Try again? n/y";
                LOGGER.log(Level.WARNING, message);
            }

            if (changePassword) {
                String edit = UserInput.getString(inputScanner);
                if (!edit.equals("y") && !edit.equals("yes")) {
                    changePassword = false;
                }
            }
        }
    }

    /**
     * Get user id & check user exist
     *
     * @param inputScanner {@link Scanner}
     * @return {@link Boolean}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static int getUserId(Scanner inputScanner) {
        User user;
        int userId;
        String message;
        UserDao userDao = new UserDao();
        while (true) {
            message = "\n >> Type User Id : ";
            LOGGER.log(Level.INFO, message);
            userId = UserInput.getIntegerNumber(inputScanner, -1, -1);
            user = userDao.findById(userId);
            if (user != null) {
                return userId;
            } else {
                message = "User not exist. Try again? n/y";
                LOGGER.log(Level.WARNING, message);
                String edit = UserInput.getString(inputScanner);
                if (!edit.equals("y") && !edit.equals("yes")) {
                    break;
                }
            }
        }

        return -1;
    }

    /**
     * Add new Employee
     *
     * @param inputScanner {@link Scanner}
     * @return {@link UserEmployee}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static UserEmployee addNewEmployee(Scanner inputScanner) {
        User user = new User();
        Employee employee = new Employee();
        String message = "\n >> Type user name : ";
        LOGGER.log(Level.INFO, message);
        String userName = UserInput.getString(inputScanner);
        user.setAttribute("userName", userName);

        message = "\n >> Type password : ";
        LOGGER.log(Level.INFO, message);
        String password = UserInput.getString(inputScanner);
        user.setAttribute("password", password);

        message = "\n >> Type employee full name : ";
        LOGGER.log(Level.INFO, message);
        String fullName = UserInput.getAlphabeticWords(inputScanner);
        employee.setAttribute("fullName", fullName);

        message = "\n >> Type email : ";
        LOGGER.log(Level.INFO, message);
        String email = UserInput.getEmail(inputScanner);
        user.setAttribute("email", email);

        message = "\n >> Type address : ";
        LOGGER.log(Level.INFO, message);
        String address = UserInput.getAlphabeticWords(inputScanner);
        employee.setAttribute("address", address);

        message = "\n >> Type department : ";
        LOGGER.log(Level.INFO, message);
        String department = UserInput.getAlphabeticWords(inputScanner);
        employee.setAttribute("department", department);

        message = "\n >> Type role 1:User 2:Admin : ";
        LOGGER.log(Level.INFO, message);
        String role = UserInput.getUserRole(inputScanner);
        employee.setAttribute("role", role);

        UserEmployee userEmployee = new UserEmployee();
        userEmployee.setUser(user);
        userEmployee.setEmployee(employee);

        if (userEmployee.saveUserEmployee()) {
            return userEmployee;
        }

        return null;
    }

    /**
     * Ask conformation before terminate user
     *
     * @param inputScanner {@link Scanner}
     * @param user         {@link User} user for terminate
     * @return {@link Boolean}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static boolean terminateConformation(Scanner inputScanner, User user) {
        String message = "\n>>" + Constants.TERMINATE_USER_CONFORM_MSG + user.getUserName() + Constants.YES_NO_MSG;
        LOGGER.log(Level.WARNING, message);
        String edit = UserInput.getString(inputScanner);
        if (edit.equals(Constants.YES_OPTION) || edit.equals(Constants.FULL_YES_OPTION)) {
            return true;
        }

        return false;
    }
}