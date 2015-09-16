package com.lftechnology.java.training.alina.jdbc.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lftechnology.java.training.alina.jdbc.constants.Constants;
import com.lftechnology.java.training.alina.jdbc.dao.employee.impl.EmployeeDaoImpl;
import com.lftechnology.java.training.alina.jdbc.domain.Employee;

/**
 * Utility service consists of common functionalities
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class UtilityService {

    private static final Logger LOGGER = Logger.getLogger(UtilityService.class.getName());

    private UtilityService() {

    }

    /**
     * Gets input data,validates empty field
     * 
     * @param scanner
     *            {@link Scanner}
     * @param fieldLabel
     *            {@link String}
     * @return {@link String} input value
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static String getInputData(Scanner scanner, String fieldLabel) {
        String fieldValue = null;
        boolean emptyStatus = true;
        while (emptyStatus) {
            LOGGER.log(Level.INFO, fieldLabel);
            if (!scanner.hasNextLine()) {
                scanner.nextLine();
            } else {
                fieldValue = scanner.nextLine();
                if (fieldValue.isEmpty()) {
                    boolean displayStatus = checkEmptyField(fieldLabel);
                    if (!displayStatus) {
                        continue;
                    }
                } else {
                    emptyStatus = false;
                }
            }
        }
        return fieldValue;
    }

    /**
     * Checks for empty search contexts
     * 
     * @param fieldLabel
     * @return displatStatus {@link Boolean} checks if displayed value or not
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    private static boolean checkEmptyField(String fieldLabel) {
        boolean displayStatus;
        if (fieldLabel == Constants.SEARCH_EMPLOYEE_CRITERIA) {
            EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
            List<Employee> list = employeeDao.findAll();
            Collections.sort(list);
            LOGGER.log(Level.INFO, Constants.EMPLOYEE_NUMBER, new Object[] { list.size(), list });
            displayStatus = true;
        } else {
            LOGGER.log(Level.WARNING, Constants.FIELD_NOT_EMPTY);
            displayStatus = false;
        }
        return displayStatus;
    }

    /**
     * Gets the user selected menu options
     * 
     * @param scanner
     *            {@link Scanner}
     * @return str {@link Character} menu choice
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static char getSelectedMenu(Scanner scanner, String fieldLabel) {
        String str = UtilityService.getInputData(scanner, fieldLabel);
        return str.toLowerCase().charAt(0);
    }

    /**
     * Gets key value from map
     * 
     * @param dictionary
     *            {@link Map}
     * @return key key value from map
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static String getKeyValue(Map<String, String> dictionary) {
        for (String key : dictionary.keySet()) {
            return key;
        }
        return null;
    }

    /**
     * Used to clear the console
     * 
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static final void clearConsole() {
        try {
            final String operatingSystem = System.getProperty("os.name");
            if (operatingSystem.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            LOGGER.log(Level.WARNING, Constants.EXCEPTION_MESSAGE, new Object[] { e });
        }
    }
}
