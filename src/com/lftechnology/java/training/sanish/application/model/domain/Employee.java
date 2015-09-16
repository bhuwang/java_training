package com.lftechnology.java.training.sanish.application.model.domain;

import com.lftechnology.java.training.sanish.application.component.Constants;
import com.lftechnology.java.training.sanish.application.model.Model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Employee model
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class Employee implements Model<Employee> {
    private static final Logger LOGGER = Logger.getLogger(Employee.class.getName());
    private int employeeId;
    private int userId;
    private String fullName;
    private String address;
    private String department;
    private String role;
    private String createdAt;
    private String modifiedAt;

    public int getEmployeeId() {
        return employeeId;
    }

    public int getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getDepartment() {
        return department;
    }

    public String getRole() {
        return role;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override public String getTable() {
        return "employees";
    }

    @Override public <V> V getAttribute(String key) {
        try {
            return (V) Employee.class.getDeclaredField(key).get(this);
        } catch (NoSuchFieldException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
        } catch (IllegalAccessException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
        }

        return null;
    }

    @Override public <V> void setAttribute(String key, V value) {
        try {
            Employee.class.getDeclaredField(key).set(this, value);
        } catch (NoSuchFieldException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
        } catch (IllegalAccessException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
        }
    }

    @Override public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        } else if (this == o) {
            return true;
        } else {
            Employee employeeModel = new Employee();
            return (employeeId == employeeModel.employeeId || userId == employeeModel.userId);
        }
    }

    @Override public void setResultSetAttributes(ResultSet rs) {
        String[] colWithStringDataType = { "fullName", "address", "department", "role", "createdAt", "modifiedAt" };
        String[] colWithIntDataType = { "employeeId", "userId" };
        String[] colWithBooleanDataType = {};
        String column = "";
        try {
            ResultSetMetaData metadata = rs.getMetaData();
            int colCount = metadata.getColumnCount();

            for (int i = 1; i <= colCount; i++) {

                column = metadata.getColumnName(i);

                if (Arrays.asList(colWithStringDataType).contains(column)) {
                    setAttribute(column, rs.getString(i));
                } else if (Arrays.asList(colWithIntDataType).contains(column)) {
                    setAttribute(column, rs.getInt(i));
                } else if (Arrays.asList(colWithBooleanDataType).contains(column)) {
                    setAttribute(column, rs.getBoolean(i));
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_ERROR_MSG_LABEL + "{0}", new Object[] { e });
        }
    }

    @Override public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", department='" + department + '\'' +
                ", role='" + role + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", modifiedAt='" + modifiedAt + '\'' +
                '}';
    }
}
