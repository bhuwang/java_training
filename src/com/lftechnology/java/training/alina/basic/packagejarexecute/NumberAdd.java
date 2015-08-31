package com.lftechnology.java.training.alina.basic.packagejarexecute;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 * NumberAdd Class is used to display the sum of two numbers
 * </p>
 * <p>
 * Steps :
 * </p>
 * <ol type="a">
 * <li>Create a Java application AddNumber, which takes two number from User and prints sum.</li>
 * <li>Create Executable Jar</li>
 * <li>Run java application from command line which should take values from user.</li>
 * <li>Print sum</li>
 * <li>Create JavaDoc of Application</li>
 * </ol>
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class NumberAdd {

    private static final Logger LOGGER = Logger.getLogger(NumberAdd.class.getName());

    private NumberAdd() {

    }

    /**
     * Main method used to calculate and display the sum of numbers
     * 
     * @param args
     * @author Alina Shakya <alinashakya@lftechnology.com>
     */
    public static void main(String[] args) {
        try {
            int totalSum = 0;
            for (int i = 0; i < args.length; i++) {
                totalSum += Integer.parseInt(args[i]);
            }
            LOGGER.log(Level.INFO, "Sum of two numbers is : {0}", totalSum);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.WARNING, "Exception message : {0}", new Object[] { e });
        }
    }
}
