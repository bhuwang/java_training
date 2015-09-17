
package com.lftechnology.java.training.dipak.employeemanagement.controller;

import java.sql.ResultSet;
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
    private static Logger LOGGER = Logger.getLogger(EmployeeController.class.getName());

    /**
     * This method takes the input from the view and sets the employee object and calls the addEmployee method in service layer.
     * 
     * @param e
     * @return count
     */
    public int addEmployee(Employee employee) {
        int count = 0;
        EmployeeService ed = ServiceFactory.getEmployeeService();

        if (employee.getUserName().length() == 0) {
            LOGGER.info("\n\t\tThe username field can't be empty. Please re-check and try again.\n");
            return count;
        } else if (employee.getPassword().length() == 0) {
            LOGGER.info("\n\t\tThe password field can't be empty. Please re-check and try again.\n");
            return count;
        } else if (employee.getRole().equals(UserType.INVALID)) {
            LOGGER.info("\n\t\tThe role field should either be ADMIN or USER. Please re-check and try again.\n");
            return count;
        } else if (employee.getFullName().length() == 0) {
            LOGGER.info("\n\t\tThe fullname field can't be empty. Please re-check and try again.\n");
            return count;
        }
        count = ed.addEmployee(employee);

        return count;
    }

    /**
     * <p>
     * This method takes the name of the employee to be terminated from the view and call terminateEmployee method in service layer. This
     * method returns the number of employees terminated.
     * </p>
     * 
     * @param e
     * @return count
     */
    public int terminateEmployee(Employee em) {
        int count = 0;

        EmployeeService ed = ServiceFactory.getEmployeeService();

        count = ed.terminateEmployee(em);

        return count;
    }

    /**
     * <p>
     * This method takes the input for the filters from view and calls the viewEmployee method.
     * </p>
     * 
     * @param e
     * @return rs
     */
    public ResultSet viewEmployee(Employee empl) {
        ResultSet rs = null;
        EmployeeService ed = ServiceFactory.getEmployeeService();

        rs = ed.viewEmployee(empl);

        return rs;
    }

    /**
     * <p>
     * This method receives the input from the view layer and checks whether the userName field fulfills the format or not. and calls
     * editEmployeeDetails in service layer.
     * </p>
     * 
     * @param emp1
     * @return e
     */
    public Employee editEmployeeDetails(Employee emp1) {

        EmployeeService es = ServiceFactory.getEmployeeService();

        String userNameFormat = "[a-zA-z][a-zA-z0-9._@]+";

        if (emp1.getUserName().length() != 0 && !(emp1.getUserName().matches(userNameFormat))) {
            LOGGER.info("\n\t\tThe username field doesn't match the format. Please re-check and try again.\n");
            LOGGER.info("\n\tNo rows edited.\n");
            return emp1;
        }
        return es.editEmployeeDetails(emp1);

    }

}
