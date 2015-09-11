package com.lftechnology.java.training.alina.jdbc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.lftechnology.java.training.alina.jdbc.dao.employee.impl.EmployeeDaoImpl;
import com.lftechnology.java.training.alina.jdbc.dao.user.impl.UserDaoImpl;
import com.lftechnology.java.training.alina.jdbc.dbutils.DbFacade;
import com.lftechnology.java.training.alina.jdbc.domain.Employee;
import com.lftechnology.java.training.alina.jdbc.domain.User;
import com.lftechnology.java.training.alina.jdbc.service.UserService;
import com.lftechnology.java.training.alina.jdbc.service.UtilityService;

public class EmployeeController {

    private static final Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());
    private static UserDaoImpl userDao = new UserDaoImpl();
    private static EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

    /**
     * Adds new employee
     * 
     * @param scanner
     *            {@link Scanner}
     * @throws SQLException
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void addNewEmployee(Scanner scanner) throws SQLException {
        User user = new User();
        Employee employee = new Employee();
        Connection connection = DbFacade.getDbConnection();
        connection.setAutoCommit(false);
        user = UserService.setLoginInfo(scanner);
        int userId = userDao.addNew(user);
        if (userId != 0) {
            employee = UserService.setEmployeeInfo(scanner, userId);
            int employeeId = employeeDao.addNew(employee);
            if (employeeId != 0) {
                connection.commit();
                LOGGER.log(Level.INFO, "\n=====>\nSuccessfully added new employee of ID : {0}.\n=====>\n", new Object[] { employeeId });
            } else {
                LOGGER.log(Level.INFO, "\n=====>\nFailed to add new employee.\n=====>\n");
            }
        }
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
    public static boolean checkMatchedRole(Scanner scanner, Boolean roleStatus) {
        Employee employee = new Employee();
        String role = UtilityService.getInputData(scanner, "Enter role (user/admin): ");
        if (role.equals(Employee.EmployeeRole.ADMIN.role) || role.equals(Employee.EmployeeRole.USER.role)) {
            roleStatus = true;
            employee.setRole(role);
        } else {
            LOGGER.log(Level.INFO, "\n=====>\nRole should be user/admin. Please enter valid role\n=====>\n");
            roleStatus = false;
        }
        return roleStatus;
    }

    /**
     * Delete existing employee by username
     * 
     * @param scanner
     *            {@link Scanner}
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void deleteExistingEmployee(Scanner scanner) {
        Employee employee = new Employee();
        employee.setFullname(UtilityService.getInputData(scanner, "Enter fullname : "));
        boolean isDeleted = employeeDao.delete(employee.getFullname());
        if (isDeleted) {
            LOGGER.log(Level.INFO, "\n=====>\nSuccessfully deleted employee with Name {0}.\n=====>\n",
                    new Object[] { employee.getFullname() });
        } else {
            LOGGER.log(Level.WARNING, "\n=====>\nFailed to delete an employee with Name {0}.\n=====>\n",
                    new Object[] { employee.getFullname() });
        }
    }

    /**
     * Terminate existing employee
     * 
     * @param scanner
     *            {@link Scanner}
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void terminateExistingEmployee(Scanner scanner) {
        Employee employee = new Employee();
        employee.setFullname(UtilityService.getInputData(scanner, "Enter fullname : "));
        boolean isDeleted = userDao.delete(employee.getFullname());
        if (isDeleted) {
            LOGGER.log(Level.INFO, "\n=====>\nSuccessfully terminated employee with Name {0}.\n=====>\n",
                    new Object[] { employee.getFullname() });
        } else {
            LOGGER.log(Level.WARNING, "\n=====>\nFailed to terminate an employee with Name {0}.\n=====>\n",
                    new Object[] { employee.getFullname() });
        }
    }

    /**
     * Gets Employee lists
     * 
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void getEmployeeList() {
        List<Employee> list = employeeDao.findAll();
        LOGGER.log(Level.INFO, "\n<=====>\nNumber of Employee : {0} \n<=====>\n\n{1}", new Object[] { list.size(), list });
    }

    /**
     * Search existing employee from the list
     * 
     * @param scanner
     *            {@link Scanner}
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void searchExistingEmployee(Scanner scanner) {
        String searchContent = UtilityService.getInputData(scanner, "Search Employee by fullname, department or address : ");
        String sql =
                "select * from employee e inner join user u on e.user_id=u.user_id where e.fullname=? or e.department=? or e.address=?";
        List<Employee> list = userDao.searchEmployee(sql, searchContent, searchContent, searchContent);
        LOGGER.log(Level.INFO, "\n<=====>\nNumber of Employee : {0} \n<=====>\n\n{1}", new Object[] { list.size(), list });
    }

}
