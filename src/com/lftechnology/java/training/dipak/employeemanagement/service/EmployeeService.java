
package com.lftechnology.java.training.dipak.employeemanagement.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.dipak.employeemanagement.LoggerFormatter;
import com.lftechnology.java.training.dipak.employeemanagement.api.EmployeeApi;
import com.lftechnology.java.training.dipak.employeemanagement.dao.DaoFactory;
import com.lftechnology.java.training.dipak.employeemanagement.dao.EmployeeDao;
import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;
import com.lftechnology.java.training.dipak.employeemanagement.domain.UserType;

/**
 * <p>
 * This class implements the EmployeeApi interface and hence has all the overwritten methods.
 * </p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */
public class EmployeeService implements EmployeeApi {

    private static final Logger LOGGER = Logger.getLogger(EmployeeService.class.getName());

    /**
     * <p>
     * This method checks whether the fields which are not supposed to be empty are empty or not. Returns if they empty with a message else
     * calls the addEmployee in DAO layer.
     * </p>
     * 
     * @param e
     * @return numberOfUserInserted
     */
    @Override
    public int addEmployee(Employee e) {

        int numberOfUserInserted = 0;
        EmployeeDao ed = DaoFactory.getEmployeeDao();

        if (e.getUserName().length() == 0) {
            LOGGER.info("The username field can't be empty. Please re-check and try again.");
            return numberOfUserInserted;
        } else if (e.getPassword().length() == 0) {
            LOGGER.info("The password field can't be empty. Please re-check and try again.");
            return numberOfUserInserted;
        } else if (e.getRole().equals(UserType.INVALID)) {
            LOGGER.info("The role field should either be ADMIN or USER. Please re-check and try again.");
            return numberOfUserInserted;
        } else if (e.getFullName().length() == 0) {
            LOGGER.info("The fullname field can't be empty. Please re-check and try again.");
            return numberOfUserInserted;
        }

        numberOfUserInserted = ed.addEmployee(e);

        if (numberOfUserInserted == 0) {
            LOGGER.info("Insertion failed. No users were added. Please check and enter the data again.");
        } else {
            LOGGER.log(Level.INFO, "Number of users added={0}", numberOfUserInserted);
        }

        return numberOfUserInserted;
    }

    /**
     * <p>
     * This method calls the viewEmployee in DAO layer and displays the result set obtained.
     * </p>
     * 
     * @param e
     * @return
     */
    @Override
    public ResultSet viewEmployee(Employee e) {

        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.FINEST);
        LOGGER.addHandler(ch);
        LOGGER.setUseParentHandlers(false);

        LoggerFormatter myFormat = new LoggerFormatter();

        ch.setFormatter(myFormat);

        ResultSet rs = null;

        EmployeeDao ed = DaoFactory.getEmployeeDao();

        rs = ed.viewEmployee(e);
        try {
            LOGGER.info("eid\t\tusername\t\tfullname\t\tdepartment\t\taddress\t\t\n");
            while (rs.next()) {
                LOGGER.log(Level.INFO, "{0}\t\t{1}\t\t{2}\t\t{3}\t\t{4}\t\t\n",
                        new Object[] { rs.getInt(1), rs.getString(2), rs.getString(5), rs.getString(6), rs.getString(7) });
            }
        } catch (SQLException e1) {
            LOGGER.log(Level.INFO, "Exception::{0}", e1);
        }

        return null;
    }

    /**
     * <p>
     * This method calls the terminateEmployee method present in the DAO layer and prints the number of employees terminated.
     * </p>
     * 
     * @param e
     * @return numberOfTerminatedUsers
     */
    @Override
    public int terminateEmployee(Employee e) {

        EmployeeDao ed = DaoFactory.getEmployeeDao();
        int numberOfTerminatedUsers = 0;

        numberOfTerminatedUsers = ed.terminateEmployee(e);

        if (numberOfTerminatedUsers == 0) {
            LOGGER.info("No users were deleted. Please check the fullname again.");
        } else {
            LOGGER.log(Level.INFO, "Number of users deleted={0}", numberOfTerminatedUsers);
        }

        return numberOfTerminatedUsers;

    }

    /**
     * <p>
     * This method calls editEmployeeDetails method present in DAO layer.
     * </p>
     * 
     * @param e
     * @return e
     */
    @Override
    public Employee editEmployeeDetails(Employee emp) {

        EmployeeDao ed = DaoFactory.getEmployeeDao();

        emp = ed.editEmployeeDetails(emp);

        return emp;
    }

}
