package com.lftechnology.java.training.niraj.ems.services.implementations;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.lftechnology.java.training.niraj.ems.domains.Employee;
import com.lftechnology.java.training.niraj.ems.exceptions.CustomException;
import com.lftechnology.java.training.niraj.ems.services.AbstractDao;
import com.lftechnology.java.training.niraj.ems.services.Roles;
import com.lftechnology.java.training.niraj.ems.services.Status;

public class EmployeeDaoImpl extends AbstractDao<Employee, String> {

    @Override
    public Employee save(Employee t) throws SQLException {
        if (t.getId() == null) {
            int id = insertQuery(t);
            t.setId(String.valueOf(id));

        } else {
            updateQuery(t);
        }
        return t;
    }

    @Override
    public Employee find(String s) throws SQLException {
        Employee employee = new Employee();
        List<Map<String, String>> resultList = findQuery(employee, s);
        for (Map<String, String> result : resultList) {
            employee.setUsername(result.get("username"));
            employee.setFullname(result.get("fullname"));
            employee.setAddress(result.get("address"));
            employee.setDepartment(result.get("department"));
            employee.setPassword(result.get("password"));
            employee.setId(result.get("id"));

            String role = result.get("role");
            if (role.equals(Roles.ADMIN.getRole())) {
                employee.setRole(Roles.ADMIN);
            } else {
                employee.setRole(Roles.USER);
            }

            String isTerminated = result.get("isTerminated");
            if (isTerminated.equals(Status.ACTIVE.getStatus())) {
                employee.setIsTerminated(Status.ACTIVE);
            } else {
                employee.setIsTerminated(Status.INACTIVE);
            }

            String status = result.get("status");
            if (status.equals(Status.INACTIVE.getStatus())) {
                employee.setStatus(Status.INACTIVE);
            } else {
                employee.setStatus(Status.ACTIVE);
            }
        }
        return employee;
    }

    @Override
    public boolean update(Employee t) throws SQLException, CustomException {
        if (t.getId() != null) {
            return updateQuery(t) > 0 ? true : false;
        } else {
            throw new CustomException("Invalid Employee Object");
        }
    }

    public boolean exists(Map<String, String> conditions) throws SQLException {
        int count = getCount(conditions);
        return count > 0 ? true : false;
    }

    public int getCount(Map<String, String> conditions) throws SQLException {
        return count("user", conditions);
    }

}
