
package com.lftechnology.java.training.dipak.employeemanagement.ui;

import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;

/**
 * <p>
 * This class contains a static method that copies the Employee object to another Employee object.
 * </p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */
public class DuplicateEmployee {

    private DuplicateEmployee() {

    }

    public static Employee duplicateEmployeeObject(Employee e1, Employee e2) {

        e2.setId(e1.getId());
        e2.setUserName(e1.getUserName());
        e2.setPassword(e1.getPassword());
        e2.setFullName(e1.getFullName());
        e2.setAddress(e1.getAddress());
        e2.setDepartment(e1.getDepartment());
        e2.setIsTerminated(e1.getIsTerminated());
        e2.setRole(e1.getRole());

        return e2;
    }
}
