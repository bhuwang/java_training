package com.lftechnology.java.training.sanish.numbergame;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Guess number program in between 1 - 20
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class GuessNumberGame {
	private static final Logger LOGGER = Logger
			.getLogger(GuessNumberGame.class.getName());
	private static final int MIN_RANDOM_NUM = 1;
	private static final int MAX_RANDOM_NUM = 20;

	private int randomNum;
	private int guessNum;
	private int guessCount = 0;

	/**
	 * Constructor
	 *
	 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
	 */
	public GuessNumberGame() {
		Random random = new Random();
		int randNum = random.nextInt(MAX_RANDOM_NUM - MIN_RANDOM_NUM) + MIN_RANDOM_NUM;
		setRandomNum(randNum);
	}

	/**
	 * Return randomNum value
	 *
	 * @return {@link Integer}
	 */
	public int getRandomNum() {
		return randomNum;
	}

	/**
	 * Set randomNum value
	 *
	 * @param randomNum
	 *            {@link Integer}
	 */
	public void setRandomNum(int randomNum) {
		this.randomNum = randomNum;
	}

	/**
	 * Return guessNum value
	 *
	 * @return {@link Integer}
	 */
	public int getGuessNum() {
		return guessNum;
	}

	/**
	 * Set guessNum value. If parameter guessNum value greater than max random
	 * number set value then throw exception
	 *
	 * @param guessNum
	 *            {@link Integer} user guess number
	 * @throws Exception
	 *             Guess number should be less or equal to [MAX_RANDOM_NUM]
	 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
	 */
	public void setGuessNum(int guessNum) throws Exception {
		if (guessNum >= MIN_RANDOM_NUM && guessNum <= MAX_RANDOM_NUM) {
			this.guessNum = guessNum;
		} else {
			throw new Exception("Guess number should be in range form "
					+ MIN_RANDOM_NUM + " to " + MAX_RANDOM_NUM);
		}
	}

	/**
	 * Return guessCount value
	 *
	 * @return {@link Integer}
	 */
	public int getGuessCount() {
		return guessCount;
	}

	/**
	 * Set guessCount value
	 *
	 * @param guessCount
	 *            {@link Integer}
	 */
	public void setGuessCount(int guessCount) {
		this.guessCount = guessCount;
	}

	/**
	 * Check is user guess number match with randomly generated number
	 *
	 * @return {@link Boolean} true if match else false
	 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
	 */
	public boolean isMatchGuessNum() {
		if (this.guessNum == this.getRandomNum()) {
			this.guessCount++;
			return true;
		} else {
			this.guessCount++;
			return false;
		}
	}

	/**
	 * Log correct user guess number message
	 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
	 */
	public void showCorrectGuessMsg() {
		LOGGER.info("Your Guess is Correct. Congratulations!");
		LOGGER.log(Level.INFO, "Number of attempts : {0}",
				new Object[] { guessCount });
	}

	/**
	 * Log incorrect user guess number message
	 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
	 */
	public void showIncorrectGuessMsg() {
		if (this.guessNum < this.randomNum) {
			LOGGER.log(Level.INFO,
					"Your Guess is incorrect. It should be greater. Enter number again :");
		} else {
			LOGGER.log(Level.INFO,
					"Your Guess is incorrect. It should be smaller. Enter number again :");
		}
	}

}
