package com.lftechnology.java.training.sanish.application;

import com.lftechnology.java.training.sanish.application.dbconnection.DbConnect;
import com.lftechnology.java.training.sanish.application.login.UserLogin;
import com.lftechnology.java.training.sanish.application.model.dao.UserDao;
import com.lftechnology.java.training.sanish.application.model.domain.User;
import com.lftechnology.java.training.sanish.application.utility.UserInput;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());

    private static Scanner inputScanner;
    private static boolean isUserlogin = false;
	public static void main(String[] args) {
		LoginController();

	}

    /**
     * Login Controller
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void LoginController(){
        LOGGER.log(Level.INFO, "============================= Login Page ======================");
        try (Scanner scanner = new Scanner(System.in)) {
            inputScanner = scanner;
            while(isUserlogin != true){
                isUserlogin = UserLogin.loginUser(inputScanner);
                if(!isUserlogin){
                    LOGGER.log(Level.WARNING, "Invalid userName or password. Please try again.");
                }
            }

            if(isUserlogin){
                EmployeeController();
            }
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "Exception Message : {0}", e.getMessage());
        }finally {
            DbConnect.DbClose();
        }
    }

    /**
     * Employee Dashboard
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void EmployeeController(){
        LOGGER.log(Level.INFO, "============================= Employee Dashboard ======================");
    }


}