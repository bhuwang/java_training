
package com.lftechnology.java.training.dipak.employeemanagement.controller;

import java.io.Console;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;
import com.lftechnology.java.training.dipak.employeemanagement.domain.UserType;
import com.lftechnology.java.training.dipak.employeemanagement.service.EmployeeService;
import com.lftechnology.java.training.dipak.employeemanagement.service.ServiceFactory;

/**
 * <p>
 * This class is used to take the data from the user based on the various functionalities provided by its member function.
 * </p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */
public class EmployeeController {

    private String exceptionOccurred = "Exception: {0}";
    private static final Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());

    /**
     * This method takes the input from the console and sets the employee object and calls the addEmployee method in service layer.
     * 
     * @param e
     * @param sc
     * @return count
     */
    public int addEmployee(Employee employee, Scanner sc) {

        String userName = null;
        String password = null;
        String fullName = null;
        String department = null;
        String address = null;
        int count = 0;
        boolean isTerminated = false;
        UserType role = null;
        for (;;) {
            try {
                LOGGER.info("Please enter the employee username::");
                userName = sc.nextLine();
                LOGGER.info("Pleasse enter the password for the password::");
                password = sc.nextLine();
                LOGGER.info("please enter the fullname::");
                fullName = sc.nextLine();
                LOGGER.info("Please enter the department::");
                department = sc.nextLine();
                LOGGER.info("Please enter the address::");
                address = sc.nextLine();
                LOGGER.info("Please enter whether the user is terminated::(true/false)");
                isTerminated = sc.nextBoolean();
                LOGGER.info("Please enter the user type::(ADMIN->1/USER->2)");
                int role2 = sc.nextInt();
                if (role2 == 1) {
                    role = UserType.ADMIN;
                } else if (role2 == 2) {
                    role = UserType.USER;
                }
                break;
            } catch (Exception ex) {
                LOGGER.log(Level.INFO, exceptionOccurred, ex);
                LOGGER.info("Please re-enter the values.");
            }

        }

        employee.setAddress(address);
        employee.setDepartment(department);
        employee.setFullName(fullName);
        employee.setIsTerminated(isTerminated);
        employee.setUserName(userName);
        employee.setPassword(password);
        employee.setRole(role);

        EmployeeService ed = ServiceFactory.getEmployeeService();
        count = ed.addEmployee(employee);

        return count;
    }

    /**
     * <p>
     * This method takes the name of the employee to be terminated and call terminateEmployee method in service layer. This method returns
     * the number of employees terminated.
     * </p>
     * 
     * @param e
     * @param sc
     * @return count
     */
    public int terminateEmployee(Employee em, Scanner sc) {

        String fullName = null;
        int count = 0;
        try {
            LOGGER.info("Please enter the employee fullname::");
            fullName = sc.nextLine();
            em.setFullName(fullName);

            EmployeeService ed = ServiceFactory.getEmployeeService();

            ed.terminateEmployee(em);

        } catch (Exception ex) {
            LOGGER.log(Level.INFO, exceptionOccurred, ex);
        }
        return count;
    }

    /**
     * <p>
     * This method takes the input for the filters and calls the viewEmployee method.
     * </p>
     * 
     * @param e
     * @param sc
     * @return
     */
    public ResultSet viewEmployee(Employee empl, Scanner sc) {

        String fullName = null;
        String department = null;
        String address = null;
        try {
            LOGGER.info("Please enter the employee fullname::");
            fullName = sc.nextLine();

            LOGGER.info("Please enter the department::");
            department = sc.nextLine();

            LOGGER.info("Please enter the address::");
            address = sc.nextLine();

            empl.setFullName(fullName);
            empl.setAddress(address);
            empl.setDepartment(department);

            EmployeeService ed = ServiceFactory.getEmployeeService();

            ed.viewEmployee(empl);

        } catch (Exception ex) {
            LOGGER.log(Level.INFO, exceptionOccurred, ex);
        }
        return null;
    }

    /**
     * <p>
     * This method takes the input for the fields to be edited and calls editEmployeeDetails in service layer.
     * </p>
     * 
     * @param e
     * @param sc
     * @return e
     */
    public Employee editEmployeeDetails(Employee emp1, Scanner sc) {
        Employee e = null;
        LOGGER.info("Welcome to the edit mode....");
        String userName = null;
        String password = null;
        String fullName = null;
        String department = null;
        String address = null;
        Console cnsl = null;
        try {
            cnsl = System.console();
            LOGGER.info("Enter new username::");
            userName = sc.nextLine();

            LOGGER.info("Enter new password::");
            char[] pwd = cnsl.readPassword();
            password = String.valueOf(pwd);

            LOGGER.info("Enter new fullname::");
            fullName = sc.nextLine();

            LOGGER.info("Enter new department::");
            department = sc.nextLine();

            LOGGER.info("Enter new address::");
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

            EmployeeService es = ServiceFactory.getEmployeeService();

            e = es.editEmployeeDetails(emp1);

        } catch (Exception ex) {
            LOGGER.log(Level.INFO, exceptionOccurred, ex);
        }

        return e;
    }

}
