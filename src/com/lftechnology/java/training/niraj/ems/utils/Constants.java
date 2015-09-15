package com.lftechnology.java.training.niraj.ems.utils;

public class Constants {
    public static final String USERNAME_LABEL = "Username :";
    public static final String PASSWORD_LABEL = "Password :";
    public static final String FULLNAME_LABEL = "Full Name :";
    public static final String ADDRESS_LABEL = "Address :";
    public static final String DEPARTMENT_LABEL =
            "Department :\n\n1.JAVA \n2.ROR \n3.PHP \n4.DEVOPS \n5.ANDROID \n6.iOS \n7.ADMINISTRATION \n8.OPERATIONS \n\n";
    public static final String ROLE_LABEL = "Role :\n\n1.Admin \n2.User \n\n ";
    public static final String AFTER_LOGIN_ADMIN_MENU = "\n\n1.Add User \n2.Search User \n3.List Users \n4.Edit Profile \n5.Logout\n\n";
    public static final String AFTER_LOGIN_USER_MENU = "\n\n1.Search User \n2.Edit Profile \n3.Logout\n\n";
    public static final String BEFORE_LOGIN_MENU = "\n\n\t1. Log In \n\t2. Register \n\n";
    public static final String SEARCH_BY_USERNAME = "\n\nSearch Users by username, full name, department or address : \n";
    public static final String SEARCH_RESULT_HEADER =
            "\n\nSearch Results : \n\nFull Name\t\t\tUsername\t\t\tAddress\t\t\tDepartment\t\tRole\t\tIs Terminated?\n";
    public static final String DIVIDER =
            "\n--------------------------------------------------------------------------------------------------------------------------------------------\n";
    public static final String USER_NOT_FOUND = "Users not found";
    public static final String GOODBYE_MSG = "\n\n\t\t Thank you for using our application. Please come back soon !!!";
    public static final String EDIT_MENU =
            "\n\nPlease select fields you want to edit\n\n\t1. Full Name\n\t2. Address\n\t3. Department\n\t4. Password\n\n";
    public static final String EDIT_OPTION_LABEL = "\n Please select numbers between 1-4 separated by , :";
    public static final String LANDING_MENU = "\n\n\t1. Log In \n\t2. Register \n\n";
    public static final String EDIT_SUCCESS = "\n\n\t Successfully updated the profile.\n\n";
    public static final String SELECT_USER_EDIT = "\n\n Select a user by username to terminate / delete : ";
    public static final String DELETE_TERMINATE_MENU = "\n\n\t1. Terminate User\n\t2. Delete User\n\t3. Back\n\n";
    public static final String INVALID_INPUT = "Please provide a valid input";
    public static final String SUCCESS_TERMINATE_USER = "Successfully terminated user";
    public static final String FAIL_TERMINATE_USER = "Failed to terminate user. Please try again.";
    public static final String SUCCESS_DELETE_USER = "Successfully deleted user";
    public static final String FAIL_DELETE_USER = "Failed to delete user. Please try again.";
    public static final String SELECT_COUNT_QUERY = "SELECT COUNT(*) as rowCount FROM ";
    public static final String USER_ALREADY_EXIST = "User already exists";
    public static final String FAIL_USER_REGISTER = "Failed to register user. Please try again";
    public static final String OPERATOR = "operator";
    public static final String ACTIVE = "1";
    public static final String INACTIVE = "0";
    public static final String USERNAME = "username";
    public static final String FULLNAME = "fullname";
    public static final String ADDRESS = "address";
    public static final String DEPARTMENT = "department";
    public static final String PASSWORD = "password";
    public static final String IS_TERMINATED = "isTerminated";
    public static final String STATUS = "status";
    public static final String ID = "id";
    public static final String ROLE = "role";
    public static final String EXCEPTION_LOG = "Exception {0}";
    public static final String UNHANDLED_EXCEPTION = "There was some error. Please try again later.";
    public static final String INVALID_CREDENTIALS = "Incorrect username or password. Exiting the program";
    public static final String REGISTER_USER_FAIL = "Failed to register employee.";
    public static final String LOGIN_ATTEMPTS = "\n\n\nYou have {0} attempts left\n\n";
    public static final String ADD_USER_SUCCESS = "Successfully added the user {0}";
    public static final String FAIL_RETRIEVE_USER_LIST = "Failed to retrieve the search results. please try again.";
    public static final String ROW_COUNT = "rowCount";
    public static final String AND_OPERATOR = "AND";
    public static final String OR_OPERATOR = "OR";
    public static final String EMPLOYEE_NOT_FOUND = "Employee not found";
    public static final String ROR = "ROR";
    public static final String PHP = "PHP";
    public static final String JAVA = "Java";
    public static final String ADMINISTRATION = "Administration";
    public static final String DEVOPS = "Devops";
    public static final String IOS = "iOS";
    public static final String ANDROID = "Android";
    public static final String OPERATIONS = "Operations";

    private Constants() {

    }

}
