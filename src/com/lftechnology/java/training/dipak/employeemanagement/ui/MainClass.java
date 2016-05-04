
package com.lftechnology.java.training.dipak.employeemanagement.ui;

import java.util.Scanner;

import com.lftechnology.java.training.dipak.employeemanagement.domain.Employee;
import com.lftechnology.java.training.dipak.employeemanagement.domain.User;
import com.lftechnology.java.training.dipak.employeemanagement.domain.UserType;

/**
 * <p>
 * This class contains a main method. Hence the execution takes place from that method.
 * </p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */
public class MainClass {

    private MainClass() {
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LoginView lv=new LoginView();
        
        Employee employee = lv.inputLoginData(new User(), sc);

        while (!UserType.INVALID.equals(employee.getRole())) {
            
            employee=lv.inputLoginData(new User(), sc);
        }

    }

}
