package com.lftechnology.java.training.alina.jdbc.constants;

/**
 * Common constants
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 *
 */
public class Constants {

    public static final char ADMIN_EXIT = 'g';
    public static final char EMPLOYEE_EXIT = 'e';
    public static final char EMPLOYEE_EDIT_EXIT = 'f';
    public static final String FULLNAME = "fullname";
    public static final String DEPARTMENT = "department";
    public static final String ADDRESS = "address";
    public static final String ROLE = "role";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String USER_LOGIN = "login";
    public static final String USER_ADD = "insert";
    public static final String SQLEXCEPTION_LOG = "SQLException : {0}";
    public static final String INVALID_ENTRY =
            "\n========================\nInvalid entry, Please choose from menu option.\n========================\n";
    public static final boolean TERMINATED = true;
    public static final boolean NOT_TERMINATED = false;
    public static final boolean DELETED = true;
    public static final boolean NOT_DELETED = false;
    public static final String INVALID_USERNAME_PASSWORD = "\n=====>\nInvalid Username or Password. Please try again.\n=====>\n";
    public static final String USERNAME_ALREADY_EXISTS = "\n=====>\nUsername already exists.\n=====>";
    public static final String ADD_NEW_EMPLOYEE = "\n========================\nAdd New Employee : \n========================\n";
    public static final String DELETE_EMPLOYEE = "\n========================\nDelete an Employee : \n========================\n";
    public static final String TERMINATE_EMPLOYEE = "\n========================\nTerminate an Employee : \n========================\n";
    public static final String VIEW_EMPLOYEE_LIST = "\n========================\nView Employee List : \n========================\n";
    public static final String SEARCH_EMPLOYEE = "\n========================\nView Employee List : \n========================\n";
    public static final String USER_LOGOUT_SUCCESS =
            "\n========================\nUser successfully logged out.\n========================\n";
    public static final String ROLE_USER_ADMIN = "\n=====>\nRole should be user/admin. Please enter valid role\n=====>\n";
    public static final String ENTER_USERNAME = "Enter Username : ";
    public static final String ENTER_PASSWORD = "Enter Password : ";
    public static final String SELECT_ADMIN_OPTION = "Select an option (a-f) : ";
    public static final String ENTER_FULLNAME = "Enter Fullname : ";
    public static final String ENTER_DEPARTMENT = "Enter department : ";
    public static final String ENTER_ADDRESS = "Enter address : ";
    public static final String ENTER_ROLE = "Enter role (user/admin): ";
    public static final String SELECT_NORMAL_USER_ROLE = "Select an option (a-d) : ";
    public static final String EDIT_OWN_INFORMATION = "\n========================\nEdit own Information\n========================\n";
    public static final String SELECT_EDIT_OPTION = "Select an option (a-e) : ";
    public static final String EDIT_FULLNAME = "\n========================\nEdit fullname\n========================\n";
    public static final String ENTER_EDIT_FULLNAME = "Enter new Fullname to Edit : ";
    public static final String EDIT_DEPARTMENT = "\n========================\nEdit Department\n========================\n";
    public static final String ENTER_EDIT_DEPARTMENT = "Enter new Department to Edit : ";
    public static final String EDIT_ADDRESS = "\n========================\nEdit Address\n========================\n";
    public static final String ENTER_EDIT_ADDRESS = "Enter new Address to Edit : ";
    public static final String BACK = "\n========================\nBack\n========================\n";
    public static final String CHANGE_PASSWORD = "\n========================\nChange Password\n========================\n";
    public static final String ENTER_NEW_PASSWORD = "Enter new password : ";
    public static final String CONFIRM_PASSWORD = "Confirm password : ";
    public static final String SUCCESS_ADD_EMPLOYEE = "\n=====>\nSuccessfully added new employee of ID : {0}.\n=====>\n";
    public static final String FAIL_ADD_EMPLOYEE = "\n=====>\nSuccessfully added new employee of ID : {0}.\n=====>\n";
    public static final String SUCCESS_DELETE_EMPLOYEE = "\n=====>\nSuccessfully deleted employee with Name {0}.\n=====>\n";
    public static final String FAIL_DELETE_EMPLOYEE = "\n=====>\nFailed to delete an employee with Name {0}.\n=====>\n";
    public static final String SUCCESS_TERMINATE_USER = "\n=====>\nSuccessfully terminated employee with Name {0}.\n=====>\n";
    public static final String FAIL_TERMINATE_USER = "\n=====>\nFailed to terminate an employee with Name {0}.\n=====>\n";
    public static final String EMPLOYEE_NUMBER =
            "\n<=====>\nNumber of Employee : {0} \n<=====>\n\n-----------------------------------------------------------------------------------------------\n{1}";
    public static final String EMPTY_EMPLOYEE_NUMBER =
            "\n<=====>\nNumber of Employee : {0}\n----------------------\nNo Record Found.\n<=====>\n\n";
    public static final String SEARCH_EMPLOYEE_CRITERIA = "Search Employee by fullname, department or address : ";
    public static final String EMPLOYEE_UPDATE_SUCCESS = "\n=====>\nSuccessfully updated employee information of ID : {0}.\n=====>\n";
    public static final String EMPLOYEE_FAIL_SUCCESS = "\n=====>\nFailed to update employee information.\n=====>\n";
    public static final String SUCCESS_CHANGE_PASSWORD = "\n=====>\nSuccessfully changed password of User ID : {0}.\n=====>\n";
    public static final String FAIL_CHANGE_PASSWORD = "\n=====>\nFailed to change password of User ID : {0}.\n=====>\n";
    public static final String PASSWORD_MISSMATCH = "\n=====>\nPassword not matched.\n=====>\n";
    public static final String ENTER_VALID_USERNAME = "Please provide a valid username.";
    public static final String ENTER_VALID_NUMBER = "Please enter valid number : ";
    public static final String NUMBER_LIMIT = "Please enter number greater than 0 : ";
    public static final String FIELD_NOT_EMPTY = "Field cannot be empty.";
    public static final String EXCEPTION_MESSAGE = "Exception Message : {0}";

    private Constants() {

    }
}
