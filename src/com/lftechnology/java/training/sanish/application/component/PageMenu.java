package com.lftechnology.java.training.sanish.application.component;

import com.lftechnology.java.training.sanish.application.controller.EmployeeController;
import com.lftechnology.java.training.sanish.application.controller.LoginController;
import com.lftechnology.java.training.sanish.application.model.domain.Employee;

/**
 * Page menu options
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class PageMenu {
    private PageMenu() {
    }

    /**
     * Dashboard page menu options
     *
     * @param menuSelected {@link Integer}
     * @param employee     {@link Employee}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void dashboardMenu(int menuSelected, Employee employee) {
        if (menuSelected == 1) {
            EmployeeController.employeeListPage();
        } else if (menuSelected == 2) {
            EmployeeController.employeeSearchPage();
        } else if (menuSelected == 3) {
            EmployeeController.ownInformationEditPage();
        } else if (menuSelected == 4) {
            EmployeeController.changePasswordPage();
        } else if (menuSelected == 5 && employee.getRole().equals(Constants.ADMIN_ROLE)) {
            EmployeeController.addEmployeePage();
        } else if (menuSelected == 5 && employee.getRole().equals(Constants.USER_ROLE)) {
            LoginController.logoutPage();
        } else if (menuSelected == 6) {
            EmployeeController.editEmployeePage();
        } else if (menuSelected == 7) {
            EmployeeController.terminateEmployeePage();
        } else {
            LoginController.logoutPage();
        }
    }

    /**
     * List page menu options
     *
     * @param menuSelected {@link Integer}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void employeeListPageMenu(int menuSelected) {
        if (menuSelected == 1) {
            EmployeeController.employeeSearchPage();
        } else if (menuSelected == 2) {
            EmployeeController.employeeDashboardPage();
        } else {
            LoginController.logoutPage();
        }
    }

    /**
     * Edit own info page menu options
     *
     * @param menuSelected {@link Integer}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void employeeOwnPageMenu(int menuSelected) {
        if (menuSelected == 1) {
            EmployeeController.ownInformationEditPage();
        } else if (menuSelected == 2) {
            EmployeeController.employeeDashboardPage();
        } else {
            LoginController.logoutPage();
        }
    }

    /**
     * change password page menu options
     *
     * @param menuSelected {@link Integer}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void changePasswordPageMenu(int menuSelected) {
        if (menuSelected == 1) {
            EmployeeController.employeeDashboardPage();
        } else if (menuSelected == 2) {
            LoginController.logoutPage();
        }
    }

    /**
     * add employee page menu options
     *
     * @param menuSelected {@link Integer}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void addEmployeePageMenu(int menuSelected) {
        if (menuSelected == 1) {
            EmployeeController.addEmployeePage();
        } else if (menuSelected == 2) {
            EmployeeController.employeeDashboardPage();
        } else {
            LoginController.logoutPage();
        }
    }

    /**
     * edit employee page menu options
     *
     * @param menuSelected {@link Integer}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void editEmployeePageMenu(int menuSelected) {
        if (menuSelected == 1) {
            EmployeeController.editEmployeePage();
        } else if (menuSelected == 2) {
            EmployeeController.employeeDashboardPage();
        } else {
            LoginController.logoutPage();
        }
    }

    /**
     * terminate user page menu options
     *
     * @param menuSelected {@link Integer}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void terminatePageMenu(int menuSelected) {
        if (menuSelected == 1) {
            EmployeeController.employeeListPage();
        } else if (menuSelected == 2) {
            EmployeeController.employeeDashboardPage();
        } else {
            LoginController.logoutPage();
        }
    }

}
