
package com.lftechnology.java.training.dipak.employeemanagement.service;

import java.sql.ResultSet;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.dipak.employeemanagement.LoggerFormatter;
import com.lftechnology.java.training.dipak.employeemanagement.api.EmployeeApi;
import com.lftechnology.java.training.dipak.employeemanagement.dao.DaoFactory;
import com.lftechnology.java.training.dipak.employeemanagement.dao.EmployeeDao;
import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;

/**
 * <p>
 * This class implements the EmployeeApi interface and hence has all the overwritten methods.
 * </p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */
public class EmployeeService implements EmployeeApi {
    private static final Logger LOGGER = Logger.getLogger(EmployeeService.class.getName());

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
     * This method calls the addEmployee in DAO layer.
     * </p>
     * 
     * @param e
     * @return numberOfUserInserted
     */
    @Override
    public int addEmployee(Employee e) {

        int numberOfUserInserted = 0;
        EmployeeDao ed = DaoFactory.getEmployeeDao();

        numberOfUserInserted = ed.addEmployee(e);

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

        ResultSet rs = null;

        EmployeeDao ed = DaoFactory.getEmployeeDao();
        rs = ed.viewEmployee(e);

        return rs;
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
    public Employee editEmployeeDetails(Employee employee) {

        EmployeeDao ed = DaoFactory.getEmployeeDao();

        return ed.editEmployeeDetails(employee);
    }

}
