
package com.lftechnology.java.training.dipak.employeemanagement.service;

import java.sql.ResultSet;
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
