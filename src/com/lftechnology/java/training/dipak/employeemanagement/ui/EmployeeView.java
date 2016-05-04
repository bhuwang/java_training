package com.lftechnology.java.training.dipak.employeemanagement.ui;

import java.io.Console;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.dipak.employeemanagement.LoggerFormatter;
import com.lftechnology.java.training.dipak.employeemanagement.controller.EmployeeController;
import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;
import com.lftechnology.java.training.dipak.employeemanagement.domain.UserType;

/**
 * <p>
 * This class is used to provide the employee view. And contains all the functionalities of the user.
 * </p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 *
 */
public class EmployeeView {

    private String exceptionOccurred = "\n\t\tException: {0}";
    private static final Logger LOGGER = Logger.getLogger(EmployeeView.class.getName());

    static {
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.INFO);
        LOGGER.addHandler(ch);
        LOGGER.setUseParentHandlers(false);

        LoggerFormatter myFormat = new LoggerFormatter();

        ch.setFormatter(myFormat);
    }

    /**
     * <p>
     * This method takes the input from the console to insert a user into the database. And after completioin of that it calls a addEmployee
     * method in controller layer.
     * </p>
     * 
     * @param employee
     * @param sc
     */
    public void addEmployee(Employee employee, Scanner sc) {
        String userName = null;
        String password = null;
        String fullName = null;
        String department = null;
        String address = null;
        int count = 0;
        boolean isTerminated = false;
        UserType role = null;
        Console cnsl = null;

        for (;;) {
            try {
                cnsl = System.console();
                LOGGER.info("\nPlease enter the employee username::");
                userName = sc.nextLine();
                LOGGER.info("\nPleasse enter the password for the password::");
                char[] pwd = cnsl.readPassword();
                password = String.valueOf(pwd);
                LOGGER.info("\nplease enter the fullname::");
                fullName = sc.nextLine();
                LOGGER.info("\nPlease enter the department::");
                department = sc.nextLine();
                LOGGER.info("\nPlease enter the address::");
                address = sc.nextLine();
                LOGGER.info("\nPlease enter whether the user is terminated::(true/false)");
                isTerminated = sc.nextBoolean();
                LOGGER.info("\nPlease enter the user type::(ADMIN->1/USER->2)");
                int role2 = sc.nextInt();
                if (role2 == 1) {
                    role = UserType.ADMIN;
                } else if (role2 == 2) {
                    role = UserType.USER;
                }
                break;
            } catch (Exception ex) {
                LOGGER.log(Level.INFO, exceptionOccurred, ex);
                LOGGER.info("\nPlease re-enter the values.");
            }

        }

        employee.setAddress(address);
        employee.setDepartment(department);
        employee.setFullName(fullName);
        employee.setIsTerminated(isTerminated);
        employee.setUserName(userName);
        employee.setPassword(password);
        employee.setRole(role);

        EmployeeController ec = new EmployeeController();
        count = ec.addEmployee(employee);

        if (count == 0) {
            LOGGER.info("\n\t\tInsertion failed. No users were added. Please check and enter the data again.");
        } else {
            LOGGER.log(Level.INFO, "\nNumber of users added={0}", count);
        }

    }

    /**
     * <p>
     * This method is used to take up the full name from the console who are to be deleted. And after completion of that it calls the
     * terminateEmployee method placed on the controller layer.
     * </p>
     * 
     * @param em
     * @param sc
     */
    public void terminateEmployee(Employee em, Scanner sc) {

        String fullName = null;
        int count = 0;
        try {
            LOGGER.info("\nPlease enter the employee fullname::");
            fullName = sc.nextLine();
            em.setFullName(fullName);

            EmployeeController ec = new EmployeeController();

            count = ec.terminateEmployee(em);

        } catch (Exception ex) {
            LOGGER.log(Level.INFO, exceptionOccurred, ex);
        }
        if (count == 0) {
            LOGGER.info("\n\tNo users were deleted. Please check the fullname again.");
        } else {
            LOGGER.log(Level.INFO, "\nNumber of users deleted = {0}", count);
        }
    }

    /**
     * <p>
     * This method takes up the input from the console for the various filters that are used to search the employee data. After completion
     * of that,it calls the viewEmployee method in the controller layer.
     * </p>
     * 
     * @param empl
     * @param sc
     */
    public void viewEmployee(Employee empl, Scanner sc) {
        ResultSet rs = null;
        String fullName = null;
        String department = null;
        String address = null;
        try {
            LOGGER.info("\nPlease enter the employee fullname::");
            fullName = sc.nextLine();

            LOGGER.info("\nPlease enter the department::");
            department = sc.nextLine();

            LOGGER.info("\nPlease enter the address::");
            address = sc.nextLine();

            empl.setFullName(fullName);
            empl.setAddress(address);
            empl.setDepartment(department);

            EmployeeController ec = new EmployeeController();

            rs = ec.viewEmployee(empl);

            if (rs.next()) {
                LOGGER.info("\n eid \t\t username \t\t fullname \t\t department \t\t address \t\t\n");
                do {
                    LOGGER.log(Level.INFO, "\n{0} \t\t {1} \t\t {2} \t\t {3} \t\t\t {4} \t\t\n",
                            new Object[] { rs.getInt(1), rs.getString(2), rs.getString(5), rs.getString(6), rs.getString(7) });
                } while (rs.next());
            } else {
                LOGGER.info("\nNo records found. \n");
            }

        } catch (Exception ex) {
            LOGGER.log(Level.INFO, exceptionOccurred, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                LOGGER.log(Level.INFO, exceptionOccurred, e);
            }
        }
    }

    /**
     * <p>
     * This method is used to take the input of the various fields to be edited in the personal data. After completion of this, it calls the
     * editEmployee method placed in the controller layer.
     * </p>
     * 
     * @param emp1
     * @param sc
     * @return
     */
    public Employee editEmployeeDetails(Employee emp1, Scanner sc) {
        LOGGER.info("\n\t\tWelcome to the edit mode....\n");
        String userName = null;
        String password = null;
        String fullName = null;
        String department = null;
        String address = null;
        Console cnsl = null;
        try {
            cnsl = System.console();
            LOGGER.info("\nEnter new username::");
            userName = sc.nextLine();

            LOGGER.info("\nEnter new password::");
            char[] pwd = cnsl.readPassword();
            password = String.valueOf(pwd);

            LOGGER.info("\nEnter new fullname::");
            fullName = sc.nextLine();

            LOGGER.info("\nEnter new department::");
            department = sc.nextLine();

            LOGGER.info("\nEnter new address::");
            address = sc.nextLine();

            if (!("".equals(userName))) {
                emp1.setUserName(userName);
            }
            if (!("".equals(password))) {
                emp1.setPassword(password);
            }
            if (!("".equals(fullName))) {
                emp1.setFullName(fullName);
            }
            if (!("".equals(department))) {
                emp1.setDepartment(department);
            }
            if (!("".equals(address))) {
                emp1.setAddress(address);
            }

            EmployeeController ec = new EmployeeController();

            return ec.editEmployeeDetails(emp1);

        } catch (Exception ex) {
            LOGGER.log(Level.INFO, exceptionOccurred, ex);
        }
        return emp1;
    }

}
