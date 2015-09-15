
package com.lftechnology.java.training.dipak.employeemanagement.api;

import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;
import com.lftechnology.java.training.dipak.employeemanagement.domain.User;

/**
 * <p>
 * This interface is used to define the logging mechanism.
 * </p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */
public interface UserApi {

    /**
     * <p>
     * This method is used to validate the logged in user.
     * </p>
     * 
     * @param u
     * @return
     */
    public Employee validateLogin(User u);
}
