package com.lftechnology.java.training.niraj.ems;


import com.lftechnology.java.training.niraj.ems.services.implementations.RouteServices;

/**
 * Employee Management System
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public class EmployeeManagement {

    private EmployeeManagement() {

    }

    public static void main(String[] args) {
        EmployeeManagement mgmt = new EmployeeManagement();
        mgmt.index();
    }

    /**
     * Entry point to the management system
     */
    private void index() {
        RouteServices.routeLandingPage();
    }

}
