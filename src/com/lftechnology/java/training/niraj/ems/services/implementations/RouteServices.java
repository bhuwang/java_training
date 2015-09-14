package com.lftechnology.java.training.niraj.ems.services.implementations;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.lftechnology.java.training.niraj.ems.controllers.EmployeeController;
import com.lftechnology.java.training.niraj.ems.controllers.LoginController;
import com.lftechnology.java.training.niraj.ems.domains.Employee;
import com.lftechnology.java.training.niraj.ems.enums.Roles;
import com.lftechnology.java.training.niraj.ems.utils.Constants;
import com.lftechnology.java.training.niraj.ems.utils.UserNumInputImpl;

public class RouteServices {
    private static final Logger LOGGER = Logger.getLogger(RouteServices.class.getName());
    private static UserNumInputImpl userInput = new UserNumInputImpl();

    private RouteServices() {

    }

    public static void routeLandingPage() {
        try (Scanner scanner = new Scanner(System.in)) {
            LoginController loginController = new LoginController();
            LOGGER.info(Constants.LANDING_MENU);
            int userChoice = RouteServices.userInput.getInput(scanner, 1, 2);
            switch (userChoice) {
            case 1:
                loginController.login();
                break;
            case 2:
                loginController.register();
                break;
            default:
                LOGGER.warning("Please select a valid option");
                break;
            }
        } catch (InputMismatchException se) {
            LOGGER.warning("Please select a valid input");
        }

    }

    public static void routeAfterLogin(Employee employee) {
        if (employee != null) {
            try (Scanner scanner = new Scanner(System.in)) {
                String role = employee.getRole();
                if (role.equals(Roles.ADMIN.getRole())) {
                    routeAfterLoginAdmin(scanner, employee);
                } else {
                    routeAfterLoginUser(scanner, employee);
                }

            } catch (InputMismatchException se) {
                LOGGER.warning("Please select a valid input");
            }
        } else {
            routeLandingPage();
        }

    }

    private static void routeAfterLoginAdmin(Scanner scanner, Employee employee) {
        LOGGER.info(Constants.AFTER_LOGIN_ADMIN_MENU);
        EmployeeController employeeController = new EmployeeController();
        int userChoice = RouteServices.userInput.getInput(scanner, 1, 5);
        System.out.println(userChoice);
        switch (userChoice) {
        case 1:
            employeeController.add(employee);
            break;
        case 2:
            employeeController.search(employee);
            break;
        case 3:
            employeeController.listUsers(employee);
            break;
        case 4:
            employeeController.editProfile(employee);
            break;
        case 5:
            employeeController.logout();
            break;
        default:
            LOGGER.warning("Please select a valid option");
            break;
        }
    }

    private static void routeAfterLoginUser(Scanner scanner, Employee employee) {
        LOGGER.info(Constants.AFTER_LOGIN_USER_MENU);
        EmployeeController employeeController = new EmployeeController();
        int userChoice = RouteServices.userInput.getInput(scanner, 1, 3);
        switch (userChoice) {
        case 1:
            employeeController.search(employee);
            break;
        case 2:
            employeeController.editProfile(employee);
            break;
        case 3:
            employeeController.logout();
            break;
        default:
            LOGGER.warning("Please select a valid option");
            break;
        }
    }
}
