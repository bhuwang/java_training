package com.lftechnology.java.training.srijan.basics.ManUtdStats;

import java.util.logging.Logger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManchesterUnited {

	private static final Logger LOGGER = Logger.getLogger(ManchesterUnited.class.getName());

	public static void main(String[] args) {
		int numberOfGameWeeks = 0;
		Scanner input = new Scanner(System.in);
		try{
			LOGGER.info("Enter the number of GameWeek");
			numberOfGameWeeks = input.nextInt();
			inputFixtures(numberOfGameWeeks);
		}catch(InputMismatchException ex){
			LOGGER.info("Error:Input MisMatchException" + ex.getMessage());
		}finally{
		input.close();
		}
	}

	/**
	 * <p>
	 * Inputs number of Gameweeks
	 * </p>
	 * <p>
	 * Inputs GameWeeks Fixtures
	 * </p>
	 * 
	 * @param numberOfGameWeeks
	 * @author Srijan Bajracharya <srijanbajracharya@lftechnology.com>
	 */
	public static void inputFixtures(int numberOfGameWeeks) {
		ManchesterUnitedStats manchesterUnitedStats = new ManchesterUnitedStats(numberOfGameWeeks);
		String[] gamesFixtures = new String[numberOfGameWeeks * 2];
		String matches = "";
		Scanner intake = new Scanner(System.in);
		int stringLengthCount = 0;
		LOGGER.info("Manchester United Game Fixtures");
		for (int i = 1; i <= numberOfGameWeeks; i++) {
			int count = 0;
			LOGGER.info("GameWeek" + i);
			LOGGER.info("Home Team=");
			for (int j = 0; j < 2; j++) {
				matches = intake.nextLine();
				gamesFixtures[stringLengthCount] = matches;
				if (count == 0) {
					LOGGER.info("Away Team=");
					count++;
				}
				stringLengthCount++;
			}
		}
		manchesterUnitedStats.displayGameweekFixtures(numberOfGameWeeks, gamesFixtures);
		manchesterUnitedStats.inputGameweekScores(numberOfGameWeeks, gamesFixtures);
		intake.close();		
	}
}
