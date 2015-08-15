package com.lftechnology.java.training.srijan.basics;

import java.util.logging.Logger;
//import sun.util.logging.PlatformLogger.Level;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * <p>
 * Set up a string variable to hold the following results:
 * </p>
 * <p>
 * String results =
 * "Manchester United 1 Chelsea 0, Arsenal 1 Manchester United 1, Manchester United 3 Fulham 1, Liverpool 2 Manchester United 1, Swansea 2 Manchester United 4"
 * ;
 * </p>
 * <p>
 * Write a programme to work out how many wins Manchester United had, how many
 * games they drew, and how many Manchester United lost.
 * </p>
 * <p>
 * Extend the programme to work out how many goals Manchester United scored and
 * how many they conceded.
 * </p>
 * <p>
 * Suppose a win gains you 3 points, a draw 1 point, and a loss no points. Have
 * your programme work out how many points in total Manchester United have
 * acquired.
 * </p>
 * <p>
 * When you have finished this exercise, the output in your textbox, listbox or
 * console should be as follows:
 * </p>
 * <p>
 * No. of wins = 3
 * </p>
 * <p>
 * No. of draws = 1
 * </p>
 * <p>
 * No. of defeats = 1
 * </p>
 * <p>
 * Goal Scored = 10
 * </p>
 * <p>
 * Goal Conceded = 6
 * </p>
 * <p>
 * No. of points = 10
 * </p>
 * 
 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
 *
 */
public class ManchesterUnitedStats {
	private static final Logger LOGGER = Logger.getLogger(ManchesterUnitedStats.class.getName());
	private String[] fixtureWithScore;
	// private static final Scanner inputScore = new Scanner(System.in);

	public ManchesterUnitedStats(int numberOfGameWeeks) {
		this.fixtureWithScore = new String[numberOfGameWeeks * 4];
		for (int i = 0; i < fixtureWithScore.length; i++) {
			fixtureWithScore[i] = "";
			System.out.println(fixtureWithScore.length);
		}
	}

	/**
	 * <p>
	 * Displays Manchester United's fixtures
	 * </p>
	 * 
	 * @param numberOfMatches
	 *            {@link Integer}
	 * @param gamesFixtures
	 *            {@link String}
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */
	public void displayGameweekFixtures(int numberOfMatches, String[] gamesFixtures) {
		int count = 0;
		LOGGER.info("Manchester United Fixtures:\n");
		for (int i = 0; i < gamesFixtures.length; i += 2) {
			if (count < 2) {
				LOGGER.info(gamesFixtures[i] + " vs " + gamesFixtures[i + 1] + "\n");
				count++;
			}
			count = 0;
		}
	}

	/**
	 * <p>
	 * Inputs Match Scores
	 * </p>
	 * 
	 * @param gamesFixtures
	 *            {@link String}
	 * @param numberOfMatches
	 *            {@link String}
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */
	public void inputGameweekScores(int numberOfMatches, String[] gamesFixtures) {
		Scanner inputScore = new Scanner(System.in);
		String scores = "";
		int arrayCounter = 0;
		int team = 0;

		try {
			for (int i = 1; i <= numberOfMatches; i++) {

				LOGGER.info("GameWeek" + i);
				LOGGER.info(gamesFixtures[team] + " vs " + gamesFixtures[team + 1]);
				fixtureWithScore[arrayCounter] = gamesFixtures[team];
				LOGGER.info(gamesFixtures[team] + " score: ");

				if (inputScore.hasNext()) {
					scores = inputScore.nextLine();
					fixtureWithScore[++arrayCounter] = scores;
					LOGGER.info(gamesFixtures[team + 1] + "score:");
					fixtureWithScore[++arrayCounter] = gamesFixtures[team + 1];
					scores = inputScore.nextLine();
					fixtureWithScore[++arrayCounter] = scores;
				}
				team = team + 2;
				arrayCounter++;
			}

		} catch (NoSuchElementException ex) {
			LOGGER.info("Error Message:" + ex.getMessage());
		} catch (ArrayIndexOutOfBoundsException exception) {
			LOGGER.info("Exception Message:" + exception.getMessage());
		} finally {
			displayFixturesAndScores(fixtureWithScore, numberOfMatches);
			inputScore.close();
		}
	}

	/**
	 * <p>
	 * Displays Fixtures And Scores of GameWeek Matches
	 * </p>
	 * 
	 * @param fixtureAndScores
	 *            {@link String}
	 * @param numberOfMatches
	 *            {@link Integer}
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */
	public void displayFixturesAndScores(String[] fixtureAndScores, int numberOfMatches) {
		int counter = 0;
		LOGGER.info("Fixtures And Scores");
		for (int i = 0; i < numberOfMatches; i++) {
			LOGGER.info(fixtureAndScores[counter] + " " + fixtureAndScores[counter + 1] + " "
					+ fixtureAndScores[counter + 2] + " " + fixtureAndScores[counter + 3]);
			// LOGGER.log(Level.INFO,
			// "{0}{1}",fixtureAndScores[counter],fixtureAndScores[counter +
			// 1]);
			counter = counter + 4;
		}
	}

}
