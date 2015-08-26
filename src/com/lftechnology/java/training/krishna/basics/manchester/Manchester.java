package com.lftechnology.java.training.krishna.basics.manchester;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Manchester.java
 * 
 * This program calculates the match information such as wins, draws, defeats,
 * points
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class Manchester {
	private static final Logger LOGGER = Logger.getLogger(Manchester.class
			.getName());
	private static final int WIN = 3;
	private static final int DRAW = 1;
	private static final int LOSE = 0;

	//constructor
	private Manchester() {

	}

	/**
	 * This method computes the match information such as wins, draws, defeats,
	 * points from the input string
	 * 
	 * @param resultString
	 *            {@link String} string of match information
	 * 
	 * @return matchScore - match score
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static Map<String, Integer> getMatchScore(String resultString) {
		int numberOfWins = 0;
		int numberOfDraws = 0;
		int numberOfDefeats = 0;
		int goalsScored = 0;
		int goalsConceded = 0;
		int numberOfPoints = 0;

		String[] resultArray = resultString.split(",");
		Map<String, Integer> matchScore = new HashMap<String, Integer>();

		for (int i = 0; i < resultArray.length; i++) {
			String matchResult = calculatePointAndGoal(resultArray[i].trim());
			String[] splitMatchResult = matchResult.split("-");

			if ("0".equals(splitMatchResult[0])) {
				numberOfDefeats++;
			}

			if ("1".equals(splitMatchResult[0])) {
				numberOfDraws++;
				numberOfPoints = numberOfPoints + DRAW;
			}

			if ("3".equals(splitMatchResult[0])) {
				numberOfWins++;
				numberOfPoints = numberOfPoints + WIN;
			}

			goalsScored = goalsScored + Integer.parseInt(splitMatchResult[1]);
			goalsConceded = goalsConceded + Integer.parseInt(splitMatchResult[2]);
		}
		matchScore.put("numberOfWins", numberOfWins);
		matchScore.put("numberOfDraws", numberOfDraws);
		matchScore.put("numberOfDefeats", numberOfDefeats);
		matchScore.put("goalsScored", goalsScored);
		matchScore.put("goalsConceded", goalsConceded);
		matchScore.put("numberOfPoints", numberOfPoints);

		return matchScore;
	}

	/**
	 * This method gives score number from input string.
	 * 
	 * @param result
	 *            {@link String} string of match information
	 * @return score - goal information 
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private static Map<String, Integer> getScoreOnly(String result) {
		int firstScore = 0;
		int secondScore = 0;
		int counter = 0;
		int numberOnlyValue = 0;

		String[] resultArray = result.split(" ");
		Map<String, Integer> score = new HashMap<String, Integer>();

		for (int i = 0; i < resultArray.length; i++) {
			String numberOnly = resultArray[i].replaceAll("[^0-9]", "");
			try {
				numberOnlyValue = Integer.parseInt(numberOnly);
				if (counter == 0) {
					firstScore = numberOnlyValue;
					counter++;
				} else {
					secondScore = numberOnlyValue;
				}
			} catch (NumberFormatException e) {
				LOGGER.log(Level.WARNING, "NumberFormatException: {0}", e.getMessage());
			}
		}
		score.put("firstScore", firstScore);
		score.put("secondScore", secondScore);
		return score;
	}

	/**
	 * This method computes the points and goals form given input string.
	 * 
	 * @param result
	 *            {@link String}  string of match information
	 * @return points - points and goals as a string
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	private static String calculatePointAndGoal(String result) {

		String points = "";

		Map<String, Integer> matchScore = (HashMap<String, Integer>) getScoreOnly(result);
		int firstScore = matchScore.get("firstScore");
		int secondScore = matchScore.get("secondScore");

		int manUnitedPos = result.indexOf("Manchester United");
		if (manUnitedPos == 0) {
			if (firstScore > secondScore) {
				points = WIN + "-" + firstScore + "-" + secondScore;
			} else if (secondScore > firstScore) {
				points = LOSE + "-" + firstScore + "-" + secondScore;
			} else if (firstScore == secondScore) {
				points = DRAW + "-" + firstScore + "-" + secondScore;
			}
		} else if (manUnitedPos > 0) {
			if (secondScore > firstScore) {
				points = WIN + "-" + secondScore + "-" + firstScore;
			} else if (firstScore > secondScore) {
				points = LOSE + "-" + secondScore + "-" + firstScore;
			} else if (firstScore == secondScore) {
				points = DRAW + "-" + secondScore + "-" + firstScore;
			}
		}
		return points;
	}
}