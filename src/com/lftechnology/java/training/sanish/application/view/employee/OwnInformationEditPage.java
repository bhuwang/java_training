package com.lftechnology.java.training.sanish.application.view.employee;

import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.utility.UserInput;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Employee edit own information page view
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class OwnInformationEditPage {
    private static final Logger LOGGER = Logger.getLogger(OwnInformationEditPage.class.getName());

    /**
     * Render employee edit own information page
     *
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void renderPage(User user, Boolean showUserInfo) {
        String pageContent = "\n==================================== Employee Edit Own Information Page ===============================\n";
        if(showUserInfo){
            pageContent += "Own information :\n"
                    + "User Id : "+user.getUserId()+"\n"
                    + "User Name : "+user.getUserName()+"\n"
                    + "Email : "+user.getEmail()+"\n";

            pageContent += "\n\n Options :\n"
                    + " 1. Edit Own Information\n"
                    + " 2. Back To Employee Dashboard";
            pageContent += "\n >> type option";
        }
        LOGGER.log(Level.INFO, pageContent);
    }
}
