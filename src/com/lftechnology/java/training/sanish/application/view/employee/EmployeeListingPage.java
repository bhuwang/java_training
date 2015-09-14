package com.lftechnology.java.training.sanish.application.view.employee;

import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.model.domain.UserEmployee;
import com.lftechnology.java.training.sanish.application.utility.OutputFormatter;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Employee listing page view
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class EmployeeListingPage {
    private static final Logger LOGGER = Logger.getLogger(EmployeeListingPage.class.getName());

    /**
     * Render employee listing page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void renderPage(List<UserEmployee> userEmployeeList) {
        String pageContent = "\n========================================== Employee Listing Page ======================================\n";
        pageContent += "\n Active User list \n";
        pageContent += "\n " +
                OutputFormatter.getStringForListCol("User Id", 10) +
                OutputFormatter.getStringForListCol("User Name", 30) +
                OutputFormatter.getStringForListCol("Full Name", 30) +
                OutputFormatter.getStringForListCol("Email", 30) +
                OutputFormatter.getStringForListCol("Address", 30) +
                OutputFormatter.getStringForListCol("Department", 30) +
                OutputFormatter.getStringForListCol("Role", 30) + "\n";
        pageContent += "\n-------------------------------------------------------------------------------------------------------------"
                    + "---------------------------------------------------------------------------------------------------------------\n";
        for (UserEmployee userEmployee : userEmployeeList) {
            pageContent += "\n " +
                    OutputFormatter.getStringForListCol(userEmployee.getUser().getUserId(), 10) +
                    OutputFormatter.getStringForListCol(userEmployee.getUser().getUserName(), 30) +
                    OutputFormatter.getStringForListCol(userEmployee.getEmployee().getFullName(), 30) +
                    OutputFormatter.getStringForListCol(userEmployee.getUser().getEmail(), 30) +
                    OutputFormatter.getStringForListCol(userEmployee.getEmployee().getAddress(), 30) +
                    OutputFormatter.getStringForListCol(userEmployee.getEmployee().getDepartment(), 30) +
                    OutputFormatter.getStringForListCol(userEmployee.getEmployee().getRole(), 30) + "\n";
        }

        pageContent += "\n\n Options :\n" + " 1. Search Employee\n" + " 2. Back To Employee Dashboard";
        pageContent += "\n >> type option";
        LOGGER.log(Level.INFO, pageContent, new Object[] {});
    }
}
