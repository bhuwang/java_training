package com.lftechnology.java.training.niraj.ems.services.implementations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.lftechnology.java.training.niraj.ems.domains.Employee;
import com.lftechnology.java.training.niraj.ems.enums.Roles;
import com.lftechnology.java.training.niraj.ems.enums.Status;
import com.lftechnology.java.training.niraj.ems.exceptions.CustomException;
import com.lftechnology.java.training.niraj.ems.services.AbstractDao;

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
        Map<String, String> condition = new LinkedHashMap<String, String>();
        condition.put(employee.getPrimaryKey(), s);
        List<Map<String, String>> resultList = findQuery(employee, condition);
        parseEmployeeObject(resultList, employee);
        return employee;
    }

    @Override
    public Employee findByAttributes(Map<String, String> conditions) throws SQLException {
        Employee employee = new Employee();
        List<Map<String, String>> resultList = findQuery(employee, conditions);
        parseEmployeeObject(resultList, employee);
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

    @Override
    public List<Employee> findAll() throws SQLException {
        Employee employee = new Employee();
        Employee searchResult;
        List<Employee> employeeList = new ArrayList<Employee>();
        List<Map<String, String>> results = findQuery(employee);
        System.out.println(results);
        for (Map<String, String> result : results) {
            searchResult = new Employee();
            setEmployeeObject(result, searchResult);
            employeeList.add(searchResult);
        }
        return employeeList;

    }

    @Override
    public List<Employee> findAll(Map<String, String> conditions) throws SQLException {
        Employee employee = new Employee();
        Employee searchResult;
        List<Employee> employeeList = new ArrayList<Employee>();
        List<Map<String, String>> results = findQuery(employee, conditions);
        for (Map<String, String> result : results) {
            searchResult = new Employee();
            setEmployeeObject(result, searchResult);
            employeeList.add(searchResult);
        }
        return employeeList;
    }

    @Override
    public boolean exists(Map<String, String> conditions) throws SQLException {
        int count = getCount(conditions);
        System.out.println(count);
        return count > 0 ? true : false;
    }

    @Override
    public int getCount(Map<String, String> conditions) throws SQLException {
        return count("users", conditions);
    }

    /**
     * Get count of total records in user table
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @return
     * @throws SQLException
     */
    public int getCount() throws SQLException {
        return count("users");
    }

    /**
     * Sets employee object
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param userInfo
     * @param employee
     */
    public void setEmployeeObject(Map<String, String> userInfo, Employee employee) {
        if (userInfo.containsKey("id")) {
            employee.setId(userInfo.get("id"));
        }
        if (userInfo.containsKey("address")) {
            employee.setAddress(userInfo.get("address"));
        }
        if (userInfo.containsKey("department")) {
            employee.setDepartment(userInfo.get("department"));
        }
        if (userInfo.containsKey("fullname")) {
            employee.setFullname(userInfo.get("fullname"));
        }
        if (userInfo.containsKey("password")) {
            employee.setPassword(userInfo.get("password"));
        }
        if (userInfo.containsKey("role")) {
            String role = userInfo.get("role");
            if (role.equals(Roles.ADMIN.getRole())) {
                employee.setRole(Roles.ADMIN);
            } else {
                employee.setRole(Roles.USER);
            }
        }
        if (userInfo.containsKey("isTerminated")) {
            String isTerminated = userInfo.get("isTerminated");
            if (isTerminated.equals(Status.ACTIVE.getStatus())) {
                employee.setIsTerminated(Status.ACTIVE);
            } else {
                employee.setIsTerminated(Status.INACTIVE);
            }
        }
        if (userInfo.containsKey("status")) {
            String status = userInfo.get("status");
            if (status.equals(Status.INACTIVE.getStatus())) {
                employee.setStatus(Status.INACTIVE);
            } else {
                employee.setStatus(Status.ACTIVE);
            }
        }
        if (userInfo.containsKey("username")) {
            employee.setUsername(userInfo.get("username"));
        }
    }

    /**
     * Parses employee object from {@link Map} of result
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param resultList
     * @param employee
     */
    private void parseEmployeeObject(List<Map<String, String>> resultList, Employee employee) {
        for (Map<String, String> result : resultList) {
            setEmployeeObject(result, employee);
        }
    }

}
