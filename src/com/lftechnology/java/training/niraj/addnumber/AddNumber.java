package com.lftechnology.java.training.niraj.addnumber;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Gets the number from user and produce the sum
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 */
public class AddNumber {

    private static final Logger LOGGER = Logger.getLogger(AddNumber.class.getName());

    private AddNumber() {

    }

    public static void main(String[] args) {
        try {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            int sum = AddNumber.add(num1, num2);
            LOGGER.log(Level.INFO, "Sum:{0}", sum);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.SEVERE, "Exception:{0}", e);
        }

    }

    /**
     * <p>
     * Gets the sum of two number
     * </p>
     * 
     * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
     * @param num1
     *            int
     * @param num2
     *            int
     * @return sum of two numbers
     */
    public static int add(int num1, int num2) {

        return num1 + num2;
    }

}
