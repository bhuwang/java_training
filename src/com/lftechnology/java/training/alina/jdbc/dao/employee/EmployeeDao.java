package com.lftechnology.java.training.alina.jdbc.dao.employee;

import java.util.List;
import com.lftechnology.java.training.alina.jdbc.api.CrudService;
import com.lftechnology.java.training.alina.jdbc.domain.Employee;

public interface EmployeeDao extends CrudService<Employee> {
    List<Employee> searchEmployee(String sql, String... searchContent);
}
