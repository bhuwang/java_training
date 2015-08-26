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
            guessNumber = scanner.nextInt();
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
}
