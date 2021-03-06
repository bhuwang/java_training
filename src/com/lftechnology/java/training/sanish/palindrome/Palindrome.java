package com.lftechnology.java.training.sanish.palindrome;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Provide palindrome calculation functions
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class Palindrome {
    private static final Logger LOGGER = Logger.getLogger(Palindrome.class.getName());

    private Palindrome() {

    }

    /**
     * Calculate and return largest palindrome number made from the product of
     * two provided digit numbers
     *
     * @param digitLength {@link Integer} digit length of two product from which have
     *                    find largest palindrome number
     * @return {@link Long} largest palindrome number
     * @throws Exception Digit length greater than 4 not supported
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static long getLargestPalindrome(int digitLength) {
        long maxNum = (long) Math.pow(10, digitLength) - 1;
        long minNum = (long) Math.pow(10, (long) digitLength - 1);
        long multipleNum;
        for (long i = maxNum; i > minNum; i--) {
            for (long j = maxNum; j > minNum; j--) {
                multipleNum = j * i;
                if (isPalindromNum(multipleNum)) {
                    LOGGER.log(Level.INFO, "{0}*{1}={2}", new Object[]{i, j, multipleNum});
                    return multipleNum;
                }
            }
        }

        return 0;
    }

    /**
     * Check is supplied number is palindrom number or not
     *
     * @param number {@link Long} number that have to check is palindrom number
     * @return {@link Boolean} true if supplied number is palindrom else false
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static boolean isPalindromNum(long number) {
        long originalNumber = number;
        long preNumber = number;
        long reverse = 0;
        while (originalNumber != 0) {
            reverse = reverse * 10;
            reverse += originalNumber % 10;
            originalNumber = originalNumber / 10;
        }

        return preNumber == reverse;
    }
}
