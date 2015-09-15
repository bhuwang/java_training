package com.lftechnology.java.training.sanish.application.model.domain;

import com.lftechnology.java.training.sanish.application.dbconnection.DbConnect;
import com.lftechnology.java.training.sanish.application.model.dao.EmployeeDao;
import com.lftechnology.java.training.sanish.application.model.dao.UserDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * UserEmployee model
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class UserEmployee {
    private static final Logger LOGGER = Logger.getLogger(UserEmployee.class.getName());
    private User user;
    private Employee employee;

    public User getUser() {
        return user;
    }

    public Employee getEmployee() {
        return employee;
    }

    public int getUserId() {
        return user.getUserId();
    }

    public int getEmployeeId() {
        return employee.getEmployeeId();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Save userEmployee data
     *
     * @return {@link Boolean}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public Boolean saveUserEmployee() {
        try {
            UserDao userDao = new UserDao();
            EmployeeDao employeeDao = new EmployeeDao();
            Connection dbConnect = DbConnect.getDbConnection();
            dbConnect.setAutoCommit(false);
            int userId = userDao.addNew(user);
            if (userId != -1) {
                user.setUserId(userId);
                employee.setUserId(userId);
                int employeeId = employeeDao.addNew(employee);
                if (employeeId != -1) {
                    employee.setEmployeeId(employeeId);
                    dbConnect.commit();
                    return true;
                } else {
                    dbConnect.rollback();
                }
            } else {
                dbConnect.rollback();
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Exception : {0}", new Object[] { e });
            DbConnect.DbClose();
        }

        return false;
    }
}
