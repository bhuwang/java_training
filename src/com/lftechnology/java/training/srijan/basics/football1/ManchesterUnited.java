package com.lftechnology.java.training.srijan.basics.football1;

import java.util.logging.Logger;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ManchesterUnited {

	private static final Logger LOGGER = Logger.getLogger(ManchesterUnited.class.getName());
	
	public static void main(String[] args) {
		int numberOfGameWeeks = 0;
		String club = "";
		Scanner input = new Scanner(System.in);
		Scanner clubNameString = new Scanner(System.in);
		try{
			LOGGER.info("Enter the number of GameWeek");
			numberOfGameWeeks = input.nextInt();
			LOGGER.info("Enter club's name your want to see stat of:");
			club = clubNameString.nextLine();
			inputFixtures(numberOfGameWeeks, club);
		}catch(InputMismatchException ex){
			LOGGER.info("Error:Input MisMatchException" + ex.getMessage());
		}catch(NoSuchElementException ex){
			LOGGER.info("Error Message" + ex.getMessage());
		}finally{
		input.close();
		clubNameString.close();
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
	public static void inputFixtures(int numberOfGameWeeks, String clubName) {
		ManchesterUnitedStats manchesterUnitedStats = new ManchesterUnitedStats(numberOfGameWeeks, clubName);
		String[] gamesFixtures = new String[numberOfGameWeeks * 2];
		String matches = "";
		Scanner intake = new Scanner(System.in);
		int stringLengthCount = 0;
		LOGGER.info(clubName + " Game Fixtures");
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
