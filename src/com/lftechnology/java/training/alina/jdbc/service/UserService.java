package com.lftechnology.java.training.alina.jdbc.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Iterator;
import com.lftechnology.java.training.alina.jdbc.constants.Constants;
import com.lftechnology.java.training.alina.jdbc.dao.employee.impl.EmployeeDaoImpl;
import com.lftechnology.java.training.alina.jdbc.dao.user.impl.UserDaoImpl;
import com.lftechnology.java.training.alina.jdbc.domain.Employee;
import com.lftechnology.java.training.alina.jdbc.domain.User;

public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());
    private static User user = new User();
    private static UserDaoImpl userDao = new UserDaoImpl();
    private static EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
    private static Employee employee = new Employee();
    private static List<Employee> employeeList = new ArrayList<Employee>();

    /**
     * Gets login info
     * 
     * @param scanner
     *            {@link Scanner}
     * @return user {@link User} user info
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static User setLoginInfo(Scanner scanner) {
        user.setUsername(CommonService.getInputData(scanner, "Enter Username : "));
        user.setPassword(CommonService.getInputData(scanner, "Enter Password : "));
        user.setTerminated(true);
        user.setCreatedAt(DateTimeService.getCurrentTimeStamp());
        user.setModifiedAt(DateTimeService.getCurrentTimeStamp());
        return user;
    }

    /**
     * Gets employee info
     * 
     * @param scanner
     *            {@link Scanner}
     * @param userId
     *            {@link Integer}
     * @return employee {@link Employee} employee info
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static Employee setEmployeeInfo(Scanner scanner, int userId) {
        employee.setFullname(CommonService.getInputData(scanner, "Enter Fullname : "));
        employee.setDepartment(CommonService.getInputData(scanner, "Enter department : "));
        employee.setAddress(CommonService.getInputData(scanner, "Enter address : "));
        Boolean roleStatus = false;
        do {
            roleStatus = checkMatchedRole(scanner, roleStatus);
        } while (!roleStatus);
        employee.setUserId(userId);
        System.out.println(DateTimeService.getCurrentTimeStamp());
        employee.setCreatedAt(DateTimeService.getCurrentTimeStamp());
        employee.setModifiedAt(DateTimeService.getCurrentTimeStamp());
        return employee;
    }

    /**
     * Check if the role is either admin/user
     * 
     * @param scanner
     *            {@link Scanner}
     * @param roleStatus
     *            {@link Boolean}
     * @return roleStatus {@link Boolean} role status as admin/user
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static boolean checkMatchedRole(Scanner scanner, Boolean roleStatus) {
        String role = CommonService.getInputData(scanner, "Enter role (user/admin): ");
        if (role.equals(Employee.EmployeeRole.ADMIN.role) || role.equals(Employee.EmployeeRole.USER.role)) {
            roleStatus = true;
            employee.setRole(role);
        } else {
            LOGGER.log(Level.INFO, "Role should be user/admin. Please enter valid role");
            roleStatus = false;
        }
        return roleStatus;
    }

    /**
     * Used to get Role of an employee
     * 
     * @param scanner
     *            {@link Scanner}
     * @param result
     *            {@link ResultSet}
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void getEmployeeRole(Scanner scanner, ResultSet result) throws SQLException {
        if (result.getString("role").equals(Employee.EmployeeRole.ADMIN.role)) {
            getAdminRole(scanner, result);
        } else {
            getNormalUserRole(scanner, result);
        }
    }

    /**
     * Gets Admin role functionalities
     * 
     * @param scanner
     *            {@link Scanner}
     * @param result
     *            {@link ResultSet}
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static void getAdminRole(Scanner scanner, ResultSet result) throws SQLException {
        char choice = ' ';
        while (choice != Constants.EXIT) {
            printAdminRoleMenu(result);
            choice = getSelectedMenu(scanner);
            getAdminRoleOptions(scanner, choice);
        }
    }

    private static void getNormalUserRole(Scanner scanner, ResultSet result) {
    }

    /**
     * Prints menu for Admin Role
     * 
     * @param result
     *            {@link ResultSet}
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static void printAdminRoleMenu(ResultSet result) throws SQLException {
        LOGGER.log(Level.INFO, "Welcome {0} !" + "\nEmployee Management System (Admin Menu)" + "\na) Add a new Employee"
                + "\nb) Delete an Employee" + "\nc) Terminate an Employee" + "\nd) View Employee List" + "\ne) Search an Employee"
                + "\nf) Exit", new Object[] { result.getString("fullname") });
    }

    /**
     * Gets the user selected menu options
     * 
     * @param scanner
     *            {@link Scanner}
     * @return str {@link Character} menu choice
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static char getSelectedMenu(Scanner scanner) {
        String str = CommonService.getInputData(scanner, "Select an option : ");
        return str.toLowerCase().charAt(0);
    }

    private static void getAdminRoleOptions(Scanner scanner, char option) throws SQLException {
        switch (option) {
        case 'a':
            LOGGER.log(Level.INFO, "Add New Employee : ");
            UserDaoImpl.addNewEmployee(scanner);
            break;
        case 'b':
            LOGGER.log(Level.INFO, "Delete an Employee : ");
            deleteExistingEmployee(scanner);
            return;
        case 'c':
            LOGGER.log(Level.INFO, "Terminate an Employee : ");
            return;
        case 'd':
            LOGGER.log(Level.INFO, "Employee List : ");
            getEmployeeList();
            return;
        case 'e':
            LOGGER.log(Level.INFO, "Search an Employee : ");
            String username = CommonService.getInputData(scanner, "Enter Username : ");
            userDao.searchEmployee(username);
            return;
        default:
            System.out.println("Invalid entry, Please choose from menu option.");
            return;
        }
    }

    private static void getEmployeeList() {
        List<Employee> list = employeeDao.findAll();
        LOGGER.log(Level.INFO, "Number of Employee {0} : \n{1}", new Object[] { list.size(), list });
    }

    private static void deleteExistingEmployee(Scanner scanner) {
        employee.setEmployeeId(InputValidation.numberValidation(scanner, "Enter user id : "));
        boolean isDeleted = userDao.delete(employee.getEmployeeId());
        if (isDeleted) {
            LOGGER.log(Level.INFO, "Successfully deleted employee with id {0}.", new Object[] { employee.getEmployeeId() });
        } else {
            LOGGER.log(Level.WARNING, "Failed to delete an employee with id {0}.", new Object[] { employee.getEmployeeId() });
        }
    }

}
