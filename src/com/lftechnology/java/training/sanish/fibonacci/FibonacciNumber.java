package com.lftechnology.java.training.sanish.fibonacci;

/**
 * Provide functions to operate with fibonacci number
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class FibonacciNumber {
    private FibonacciNumber() {

    }

    /**
     * Return sum 0f event fibonacci number with in given max limit
     *
     * @param firstNum        {@link Integer} first number of fibonacci number series
     * @param secondNum       {@link Integer} second number of fibonacci number series
     * @param maxFibonacciNum {@link Integer} maximum fibonacci number
     * @return {@link Integer}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static int sumEventFibonacciNumber(int firstNum, int secondNum, int maxFibonacciNum) {
        int nextNum = firstNum + secondNum;
        int eventFibonacciNumSum = 0;
        if (firstNum % 2 == 0) {
            eventFibonacciNumSum += firstNum;
        }

        if (secondNum % 2 == 0) {
            eventFibonacciNumSum += secondNum;
        }

        int num1 = firstNum;
        int num2 = secondNum;
        while (nextNum < maxFibonacciNum) {
            if (nextNum % 2 == 0) {
                eventFibonacciNumSum += nextNum;
            }

            num1 = num2;
            num2 = nextNum;
            nextNum = num1 + num2;
        }

        return eventFibonacciNumSum;
    }
}
