package com.lftechnology.java.training.srijan.basics.manchestersats;

import java.util.logging.Logger;

public class PointsStructure {
	private static final int WIN;
	private static final int LOSE;
	private static final int DRAW;
	private int points;
	private int counts;
	private int wins;
	private int draws;
	private int lose;

	static {
		WIN = 3;
		LOSE = 0;
		DRAW = 1;
	}

	public PointsStructure() {
		this.points = 0;
		this.counts = 1;
		this.wins = 0;
		this.draws = 0;
		this.lose = 0;
	}

	private static final Logger LOGGER = Logger.getLogger(PointsStructure.class.getName());

	/**
	 * <p>
	 * This method helps to get Points from an Array
	 * </p>
	 * 
	 * @param numberOfMatches
	 *            {@link Integer}
	 * @param fixturesWithScore
	 *            {@link String}
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */	
	public void getPoints(int numberOfMatches, String[] fixturesWithScore) {
		String result = "";
		int stringHomePosition = 0;
		int stringAwayPosition = 2;
		for (int i = 0; i < numberOfMatches; i++) {
			if ("Manchester United".equals(fixturesWithScore[stringHomePosition])) {
				result = determineResult(fixturesWithScore, stringHomePosition);
			}

			else if ("Manchester United".equals(fixturesWithScore[stringAwayPosition])) {
				result = resultDetermine(fixturesWithScore, stringAwayPosition);
			}
			stringHomePosition = stringHomePosition + 4;
			stringAwayPosition = stringAwayPosition + 4;
			displayPoints(result, numberOfMatches);

		}
	}

	/**
	 * <p>
	 * Determines WIN, LOSE, or DRAW for Home Game
	 * </p>
	 * 
	 * @param fixturesWithScore
	 *            {@link String}
	 * @param stringPosition
	 *            {@link Integer}
	 * @return WIN, LOSE or DRAW {@link String}
	 */
	public String determineResult(String[] fixturesWithScore, int stringPosition) {
		if (Integer.parseInt(fixturesWithScore[stringPosition + 1]) > Integer
				.parseInt(fixturesWithScore[stringPosition + 3])) {
			return "WIN";
		} else if (Integer.parseInt(fixturesWithScore[stringPosition + 1]) < Integer
				.parseInt(fixturesWithScore[stringPosition + 3])) {
			return "LOSE";
		} else
			return "DRAW";
	}

	/**
	 * <p>
	 * Determines WIN, LOSE or DRAW for Away Game
	 * </p>
	 * 
	 * @param fixturesWithScore
	 *            {@link String}
	 * @param stringPosition
	 *            {@link Integer}
	 * @return WIN, LOSE, or DRAW {@link String}
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */
	public String resultDetermine(String[] fixturesWithScore, int stringPosition) {
		if (Integer.parseInt(fixturesWithScore[stringPosition + 1]) > Integer
				.parseInt(fixturesWithScore[stringPosition - 1])) {
			return "WIN";
		} else if (Integer.parseInt(fixturesWithScore[stringPosition + 1]) < Integer
				.parseInt(fixturesWithScore[stringPosition - 1])) {
			return "LOSE";
		} else
			return "DRAW";
	}

	/**
	 * <p>
	 * Displays points
	 * </p>
	 * <p>
	 * Displays Number of Wins
	 * </p>
	 * <p>
	 * Displays Number of Draws
	 * </p>
	 * <p>
	 * Displays Number of Lose
	 * </p>
	 * 
	 * @param result
	 *            {@link String}
	 * @param numberOfWeeks
	 *            {@link Integer}
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */
	public void displayPoints(String result, int numberOfWeeks) {
		if ("WIN".equals(result)) {
			points = points + WIN;
			wins++;
		} else if ("LOSE".equals(result)) {
			points = points + LOSE;
			lose++;
		} else {
			points = points + DRAW;
			draws++;
		}
		if (counts == numberOfWeeks) {
			LOGGER.info("Total Points" + points);
			LOGGER.info("Wins= " + wins);
			LOGGER.info("Draws= " + draws);
			LOGGER.info("Lose= " + lose);
		}
		counts++;
	}
}
