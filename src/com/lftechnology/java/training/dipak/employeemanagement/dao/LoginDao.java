
package com.lftechnology.java.training.dipak.employeemanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.dipak.employeemanagement.api.UserApi;
import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;
import com.lftechnology.java.training.dipak.employeemanagement.domain.User;
import com.lftechnology.java.training.dipak.employeemanagement.domain.UserType;

/**
 * <p>
 * This class contains method that interact with database to check whether the username and password entered is valid or not.
 * </p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */
public class LoginDao implements UserApi {
    private String connectionFailedMessage = "Connection Setup Failed";
    private static final Logger LOGGER = Logger.getLogger(LoginDao.class.getName());

    /**
     * <p>
     * This method checks whether the username and password is valid or not and if the user is terminated or not. If all conditions are met
     * then it returns a result set then the employee object is set with the result set. This object is returned.
     * </p>
     * 
     * @param u
     * @return employee
     */
    @Override
    public Employee validateLogin(User u) {

        Employee employee = new Employee();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        con = DbConnection.setConnection();

        String sql = "select * from employee where username= ? and password= ? and isTerminated=false";

        if (con != null) {
            try {
                pst = con.prepareStatement(sql);

                pst.setString(1, u.getUserName());
                pst.setString(2, u.getPassword());

                rs = pst.executeQuery();

                if (rs.next()) {
                    employee.setId(rs.getInt("eid"));
                    employee.setUserName(rs.getString("username"));
                    employee.setPassword(rs.getString("password"));
                    employee.setAddress(rs.getString("address"));
                    employee.setIsTerminated(rs.getBoolean("isTerminated"));
                    employee.setDepartment(rs.getString("department"));
                    employee.setFullName(rs.getString("fullname"));
                    UserType ut = UserType.valueOf(rs.getString("role"));
                    employee.setRole(ut);

                } else {
                    employee.setId(0);
                }

            } catch (SQLException e) {
                LOGGER.log(Level.INFO, "{0}", e);
            } finally {
                try {
                    con.close();
                    pst.close();
                    rs.close();
                } catch (SQLException e) {
                    LOGGER.log(Level.INFO, "{0}", e);
                }
            }

        } else {
            LOGGER.info(connectionFailedMessage);
        }
        return employee;
    }
}
