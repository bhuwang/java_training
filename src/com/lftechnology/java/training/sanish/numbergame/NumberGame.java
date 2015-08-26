package com.lftechnology.java.training.sanish.numbergame;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NumberGame {
    private static final Logger LOGGER = Logger.getLogger(NumberGame.class
            .getName());

    private NumberGame() {
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            startGuessNumber(scanner);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Exception Message : {0}",
                    new Object[]{e});
        }
    }

    /**
     * Start guess number game
     *
     * @param scanner {@link Scanner}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void startGuessNumber(Scanner scanner) {
        GuessNumberGame guessNumberGame = new GuessNumberGame();
        int guessNumber;
        LOGGER.log(Level.INFO, "Enter a guess number (1-20):");
        for (; ; ) {
            guessNumber = getNumber(scanner, 1, 20);
            try {
                guessNumberGame.setGuessNum(guessNumber);
                if (guessNumberGame.isMatchGuessNum()) {
                    guessNumberGame.showCorrectGuessMsg();
                    break;
                } else {
                    guessNumberGame.showIncorrectGuessMsg();
                }
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Exception : {1}", new Object[]{e});
            }
        }
    }

    /**
     * Scan number from console and return number
     *
     * @param {@link Scanner}
     * @param {@link Integer} Minimum value acceptable
     * @param {@link Integer} Maximum value acceptable
     * @return {@link Integer}
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static int getNumber(Scanner scanner, int min, int max) {
        int num;
        for (; ; ) {
            while (!scanner.hasNextInt()) {
                LOGGER.log(Level.WARNING, "Please enter valid number : ");
                scanner.next();
            }
            num = scanner.nextInt();
            if (num < min || num > max) {
                LOGGER.log(Level.WARNING,
                        "Please enter number within range ({0}-{1}) : ",
                        new Object[]{min, max});
            } else {
                break;
            }
        }

        return num;
    }
}
