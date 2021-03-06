package com.lftechnology.java.training.sanish.application.component;

import com.lftechnology.java.training.sanish.application.model.dao.EmployeeDao;
import com.lftechnology.java.training.sanish.application.model.dao.UserDao;
import com.lftechnology.java.training.sanish.application.model.domain.Employee;
import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.model.domain.UserEmployee;
import com.lftechnology.java.training.sanish.application.utility.UserInput;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private static final String EMPLOYEE_ID_STATEMENT  = "employeeId=?";
    private EmployeeHelper() {
    }

    /**
     * Change user name of user
     *
     * @param inputScanner {@link Scanner}
     * @param user         {@link User}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void changeUserName(Scanner inputScanner, User user) {
        String message = "\n" + Constants.USER_NAME_LABEL + user.getUserName() + "\n>>" + Constants.CHANGE_USER_NAME_CONFORM_MSG;
        LOGGER.log(Level.INFO, message);
        String edit = UserInput.getString(inputScanner);
        if (edit.equals(Constants.YES_OPTION) || edit.equals(Constants.FULL_YES_OPTION)) {
            int updateRow = 0;
            String userName;
            String setStatement;
            Boolean doChange = true;
            String whereCondition = "userId=?";
            UserDao userDao = new UserDao();
            while (doChange) {
                message = "\n >> " + Constants.TYPE_USER_NAME_LABEL;
                LOGGER.log(Level.INFO, message);
                userName = UserInput.getString(inputScanner);
                setStatement = "userName=?, modifiedAt=?";
                DateFormat dateFormat = new SimpleDateFormat(Constants.DB_DATE_FORMAT);
                Date date = new Date();
                updateRow = userDao.update(whereCondition, setStatement, userName, dateFormat.format(date), user.getUserId());
                if (updateRow == 0) {
                    message = "\n" + Constants.ERROR_MSG_LABEL + Constants.FAIL_UPDATE_USER_NAME_MSG;
                    doChange = conformRetry(inputScanner, message);
                }else{
                    doChange = false;
                }
            }
        }
    }

    /**
     * Conform retry operation
     *
     * @param inputScanner {@link Scanner}
     * @param message      {@link String}
     * @return {@link Boolean}
     */
    public static boolean conformRetry(Scanner inputScanner, String message) {
        LOGGER.log(Level.INFO, message + Constants.TRY_AGAIN_MSG);
        String edit = UserInput.getString(inputScanner);
        return edit.equals(Constants.YES_OPTION) || edit.equals(Constants.FULL_YES_OPTION);
    }

    /**
     * Change email of user
     *
     * @param inputScanner {@link Scanner}
     * @param user         {@link User}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void changeUserEmail(Scanner inputScanner, User user) {
        String message = "\n" + Constants.USER_EMAIL_LABEL + user.getEmail() + "\n>>" + Constants.CHANGE_EMAIL_CONFORM_MSG;
        LOGGER.log(Level.INFO, message);
        String edit = UserInput.getString(inputScanner);
        if (edit.equals(Constants.YES_OPTION) || edit.equals(Constants.FULL_YES_OPTION)) {
            int updateRow = 0;
            String email;
            String setStatement;
            Boolean doChange = true;
            String whereCondition = "userId=?";
            UserDao userDao = new UserDao();
            while (doChange) {
                message = Constants.TYPE_EMAIL_LABEL;
                LOGGER.log(Level.INFO, message);
                email = UserInput.getString(inputScanner);
                DateFormat dateFormat = new SimpleDateFormat(Constants.DB_DATE_FORMAT);
                Date date = new Date();
                setStatement = "email=?, modifiedAt=?";
                updateRow = userDao.update(whereCondition, setStatement, email, dateFormat.format(date), user.getUserId());
                if (updateRow == 0) {
                    message = "\n" + Constants.ERROR_MSG_LABEL + Constants.FAIL_UPDATE_EMAIL_MSG;
                    doChange = conformRetry(inputScanner, message);
                }else{
                    doChange = false;
                }
            }
        }
    }

    /**
     * Change full name of user
     *
     * @param inputScanner {@link Scanner}
     * @param employee     {@link Employee}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void changeFullName(Scanner inputScanner, Employee employee) {
        String message = "\n" + Constants.USER_FULL_NAME_LABEL + employee.getFullName() + "\n>>" + Constants.CHANGE_FULL_NAME_CONFORM_MSG;
        LOGGER.log(Level.INFO, message);
        String edit = UserInput.getString(inputScanner);
        if (edit.equals(Constants.YES_OPTION) || edit.equals(Constants.FULL_YES_OPTION)) {
            int updateRow = 0;
            String fullName;
            String setStatement;
            Boolean doChange = true;
            String whereCondition = EMPLOYEE_ID_STATEMENT;
            EmployeeDao employeeDao = new EmployeeDao();
            while (doChange) {
                message = Constants.TYPE_FULL_NAME_LABEL;
                LOGGER.log(Level.INFO, message);
                fullName = UserInput.getAlphabeticWords(inputScanner);
                DateFormat dateFormat = new SimpleDateFormat(Constants.DB_DATE_FORMAT);
                Date date = new Date();
                setStatement = "fullName=?, modifiedAt=?";
                updateRow = employeeDao.update(whereCondition, setStatement, fullName, dateFormat.format(date), employee.getEmployeeId());
                if (updateRow == 0) {
                    message = "\n" + Constants.ERROR_MSG_LABEL + Constants.FAIL_UPDATE_FULL_NAME_MSG;
                    doChange = conformRetry(inputScanner, message);
                }else{
                    doChange = false;
                }
            }
        }
    }

    /**
     * Change address of user
     *
     * @param inputScanner {@link Scanner}
     * @param employee     {@link Employee}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void changeAddress(Scanner inputScanner, Employee employee) {
        String message = "\n" + Constants.USER_ADDRESS_LABEL + employee.getAddress() + "\n>>" + Constants.CHANGE_ADDRESS_CONFORM_MSG;
        LOGGER.log(Level.INFO, message);
        String edit = UserInput.getString(inputScanner);
        if (edit.equals(Constants.YES_OPTION) || edit.equals(Constants.FULL_YES_OPTION)) {
            int updateRow = 0;
            String address;
            String setStatement;
            Boolean doChange = true;
            String whereCondition = EMPLOYEE_ID_STATEMENT;
            EmployeeDao employeeDao = new EmployeeDao();
            while (doChange) {
                message = Constants.TYPE_ADDRESS_LABEL;
                LOGGER.log(Level.INFO, message);
                address = UserInput.getAlphabeticWords(inputScanner);
                DateFormat dateFormat = new SimpleDateFormat(Constants.DB_DATE_FORMAT);
                Date date = new Date();
                setStatement = "address=?, modifiedAt=?";
                updateRow = employeeDao.update(whereCondition, setStatement, address, dateFormat.format(date), employee.getEmployeeId());
                if (updateRow == 0) {
                    message = "\n" + Constants.ERROR_MSG_LABEL + Constants.FAIL_UPDATE_ADDRESS_MSG;
                    doChange = conformRetry(inputScanner, message);
                }else{
                    doChange = false;
                }
            }
        }
    }

    /**
     * Change department of user
     *
     * @param inputScanner {@link Scanner}
     * @param employee     {@link Employee}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void changeDepartment(Scanner inputScanner, Employee employee) {
        String message =
                "\n" + Constants.USER_DEPARTMENT_LABEL + employee.getDepartment() + "\n>>" + Constants.CHANGE_DEPARTMENT_CONFORM_MSG;
        LOGGER.log(Level.INFO, message);
        String edit = UserInput.getString(inputScanner);
        if (edit.equals(Constants.YES_OPTION) || edit.equals(Constants.FULL_YES_OPTION)) {
            int updateRow = 0;
            String department;
            String setStatement;
            Boolean doChange = true;
            String whereCondition = EMPLOYEE_ID_STATEMENT;
            EmployeeDao employeeDao = new EmployeeDao();
            while (doChange) {
                message = Constants.TYPE_DEPARTMENT_LABEL;
                LOGGER.log(Level.INFO, message);
                department = UserInput.getAlphabeticWords(inputScanner);
                DateFormat dateFormat = new SimpleDateFormat(Constants.DB_DATE_FORMAT);
                Date date = new Date();
                setStatement = "department=?, modifiedAt=?";
                updateRow = employeeDao.update(whereCondition, setStatement, department, dateFormat.format(date), employee.getEmployeeId());
                if (updateRow == 0) {
                    message = "\n" + Constants.ERROR_MSG_LABEL + Constants.FAIL_UPDATE_DEPARTMENT_MSG;
                    doChange = conformRetry(inputScanner, message);
                }else{
                    doChange = false;
                }
            }
        }
    }

    /**
     * Change role of user
     *
     * @param inputScanner {@link Scanner}
     * @param employee     {@link Employee}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void changeRole(Scanner inputScanner, Employee employee) {
        String message = "\n" + Constants.USER_ROLE_LABEL + employee.getRole() + "\n>>" + Constants.CHANGE_ROLE_CONFORM_MSG;
        LOGGER.log(Level.INFO, message);
        String edit = UserInput.getString(inputScanner);
        if (edit.equals(Constants.YES_OPTION) || edit.equals(Constants.FULL_YES_OPTION)) {
            int updateRow = 0;
            String role;
            String setStatement;
            Boolean doChange = true;
            String whereCondition = EMPLOYEE_ID_STATEMENT;
            EmployeeDao employeeDao = new EmployeeDao();
            while (doChange) {
                message = Constants.TYPE_ROLE_LABEL;
                LOGGER.log(Level.INFO, message);
                role = UserInput.getUserRole(inputScanner);
                DateFormat dateFormat = new SimpleDateFormat(Constants.DB_DATE_FORMAT);
                Date date = new Date();
                setStatement = "role=?, modifiedAt=?";
                updateRow = employeeDao.update(whereCondition, setStatement, role, dateFormat.format(date), employee.getEmployeeId());
                if (updateRow == 0) {
                    message = "\n" + Constants.ERROR_MSG_LABEL + Constants.FAIL_UPDATE_ROLE_MSG;
                    doChange = conformRetry(inputScanner, message);
                }else{
                    doChange = false;
                }

            }
        }
    }

    /**
     * Change password of user
     *
     * @param inputScanner {@link Scanner}
     * @param user         {@link User}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void changePassword(Scanner inputScanner, User user) {
        Boolean doChange = true;
        UserDao userDao = new UserDao();
        while (doChange) {
            String message = Constants.TYPE_OLD_PASSWORD_LABEL;
            LOGGER.log(Level.INFO, message);
            String oldPassword = UserInput.getString(inputScanner);
            message = Constants.TYPE_NEW_PASSWORD_LABEL;
            LOGGER.log(Level.INFO, message);
            String newPassword = UserInput.getString(inputScanner);
            message = Constants.TYPE_RE_PASSWORD_LABEL;
            LOGGER.log(Level.INFO, message);
            String confirmPassword = UserInput.getString(inputScanner);
            Boolean valid = false;
            if (newPassword.equals(confirmPassword)) {
                if (user.getPassword().equals(UserLogin.md5(oldPassword))) {
                    valid = true;
                } else {
                    message = Constants.OLD_PASSWORD_NOT_MATCH_MSG + Constants.TRY_AGAIN_MSG;
                    LOGGER.log(Level.WARNING, message);
                }
            } else {
                message = Constants.PASSWORD_NOT_MATCH_MSG + Constants.TRY_AGAIN_MSG;
                LOGGER.log(Level.WARNING, message);
            }

            if(valid){
                if (userDao.setPassword(user, newPassword)) {
                    doChange = false;
                    LOGGER.log(Level.INFO, Constants.SUCCESS_PASSWORD_CHANGE_MSG);
                } else {
                    doChange = conformRetry(inputScanner, Constants.FAIL_CHANGE_PASSWORD_MSG);
                }
            }
        }
    }

    /**
     * Get user id & check user exist, if user exit return userId else return -1
     *
     * @param inputScanner {@link Scanner}
     * @return {@link Integer}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static int getUserId(Scanner inputScanner) {
        User user;
        int userId;
        String message;
        UserDao userDao = new UserDao();
        Boolean scanUserId = true;
        while (scanUserId) {
            message = Constants.TYPE_USER_ID_LABEL;
            LOGGER.log(Level.INFO, message);
            userId = UserInput.getIntegerNumber(inputScanner, -1, -1);
            user = userDao.findById(userId);
            if (user != null) {
                return userId;
            } else {
                message = Constants.USER_NOT_EXIST_MSG;
                scanUserId = conformRetry(inputScanner, message);
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
        String message = Constants.TYPE_USER_NAME_LABEL;
        LOGGER.log(Level.INFO, message);
        String userName = UserInput.getString(inputScanner);
        user.setUserName(userName);

        message = Constants.TYPE_PASSWORD_LABEL;
        LOGGER.log(Level.INFO, message);
        String password = UserInput.getString(inputScanner);
        user.setPassword(password);

        message = Constants.TYPE_FULL_NAME_LABEL;
        LOGGER.log(Level.INFO, message);
        String fullName = UserInput.getAlphabeticWords(inputScanner);
        employee.setFullName(fullName);

        message = Constants.TYPE_EMAIL_LABEL;
        LOGGER.log(Level.INFO, message);
        String email = UserInput.getEmail(inputScanner);
        user.setEmail(email);

        message = Constants.TYPE_ADDRESS_LABEL;
        LOGGER.log(Level.INFO, message);
        String address = UserInput.getAlphabeticWords(inputScanner);
        employee.setAddress(address);

        message = Constants.TYPE_DEPARTMENT_LABEL;
        LOGGER.log(Level.INFO, message);
        String department = UserInput.getAlphabeticWords(inputScanner);
        employee.setDepartment(department);

        message = Constants.TYPE_ROLE_LABEL;
        LOGGER.log(Level.INFO, message);
        String role = UserInput.getUserRole(inputScanner);
        employee.setRole(role);

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

    public static String terminateUser(Scanner inputScanner, User user) {
        if (EmployeeHelper.terminateConformation(inputScanner, user)) {
            UserDao userDao = new UserDao();
            if (userDao.terminateUser(user)) {
                return Constants.SUCCESS_TERMINATE_MSG;
            } else {
                return Constants.FAIL_TERMINATE_MSG;
            }
        } else {
            return Constants.CANCEL_TERMINATE_MSG;
        }
    }
}
