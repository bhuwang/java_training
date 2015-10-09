package com.lftechnology.java.training.alina.jdbc.dao.employee;

import java.sql.SQLException;
import java.util.List;

import com.lftechnology.java.training.alina.jdbc.api.CrudService;
import com.lftechnology.java.training.alina.jdbc.domain.Employee;

/**
 * EmployeeDao is interface that extends CrudService and adds other necessary function interfaces
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public interface EmployeeDao extends CrudService<Employee> {
    /**
     * Employee searching functionality
     * 
     * @param sql
     *            {@link STRING}
     * @param searchContent
     *            {@link STRING}
     * @return
     * @author Alina Shakya <alinashakya@lftechnology.com>
     * @throws SQLException 
     */
    List<Employee> searchEmployee(String... searchContent) throws SQLException;
}
