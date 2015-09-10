package com.lftechnology.java.training.niraj.ems.services.implementations;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.lftechnology.java.training.niraj.ems.domains.Employee;
import com.lftechnology.java.training.niraj.ems.exceptions.CustomException;
import com.lftechnology.java.training.niraj.ems.services.CrudService;
import com.lftechnology.java.training.niraj.ems.services.Roles;
import com.lftechnology.java.training.niraj.ems.services.Status;

public class UserServiceImpl implements CrudService<Employee, String> {

    private EmployeeDaoImpl employeeDao;

    public UserServiceImpl() {
        employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public Employee save(Employee t) throws SQLException {
        return employeeDao.save(t);
    }

    @Override
    public Employee find(String s) throws SQLException {
        // TODO Auto-generated method stub
        return employeeDao.find(s);
    }

    @Override
    public boolean update(Employee t) throws Exception {
        return employeeDao.update(t);

    }

    public boolean login(String username, String password) throws SQLException {
        Map<String, String> credentials = new LinkedHashMap<String, String>();
        credentials.put("username", username);
        credentials.put("password", password);
        return employeeDao.exists(credentials);
    }

    public boolean saveUserInfo(Map<String, String> userInfo) throws SQLException {
        Employee employee = new Employee();
        parseUserInfo(employee.getAttributes(), userInfo);
        setEmployeeInfo(employee, userInfo);
        save(employee);
        return employee.getId() != null ? true : false;

    }

    public boolean terminateEmployee(String id) throws SQLException, CustomException {
        Employee employee = employeeDao.find(id);
        boolean isTerminated = false;
        if (employee != null) {
            employee.setIsTerminated(Status.ACTIVE);
            isTerminated = employeeDao.update(employee);
        } else {
            throw new CustomException("Employee not found");
        }
        return isTerminated;
    }

    public boolean delete(String id) throws SQLException, CustomException {
        Employee employee = employeeDao.find(id);
        boolean isDeleted = false;
        if (employee != null) {
            employee.setStatus(Status.INACTIVE);
            isDeleted = employeeDao.update(employee);
        } else {
            throw new CustomException("Employee not found");
        }
        return isDeleted;
    }

    private void parseUserInfo(List<String> attributes, Map<String, String> userInfo) {
        for (String attribute : attributes) {
            if (!userInfo.containsKey(attribute)) {
                userInfo.put(attribute, null);
            }
        }
    }

    private void setEmployeeInfo(Employee employee, Map<String, String> userInfo) {
        employee.setAddress(userInfo.get("address"));
        employee.setDepartment(userInfo.get("department"));
        employee.setFullname(userInfo.get("fullname"));
        employee.setPassword(userInfo.get("password"));
        String role = userInfo.get("role");
        if (role.equals(Roles.ADMIN.getRole())) {
            employee.setRole(Roles.ADMIN);
        } else {
            employee.setRole(Roles.USER);
        }
        String isTerminated = userInfo.get("isTerminated");
        if (isTerminated.equals(Status.ACTIVE.getStatus())) {
            employee.setIsTerminated(Status.ACTIVE);
        } else {
            employee.setIsTerminated(Status.INACTIVE);
        }

        String status = userInfo.get("status");
        if (status.equals(Status.INACTIVE.getStatus())) {
            employee.setStatus(Status.INACTIVE);
        } else {
            employee.setStatus(Status.ACTIVE);
        }

        employee.setUsername(userInfo.get("username"));
    }
}
