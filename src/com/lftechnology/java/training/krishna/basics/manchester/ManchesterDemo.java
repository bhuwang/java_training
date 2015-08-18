package com.lftechnology.java.training.krishna.basics.manchester;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ManchesterDemo.java
 * 
 * Log the output on the console.
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class ManchesterDemo {
	private final static Logger LOGGER = Logger.getLogger(ManchesterDemo.class.getName());

	/**
	 * This is the main method which makes use of getMatchScore() method.
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static void main(String[] args) {

		String resultString = "Manchester United 1 Chelsea 0, Arsenal 1 Manchester United 1, Manchester United 3 Fulham 1, Liverpool 2 Manchester United 1, Swansea 2 Manchester United 4";
		try {
			HashMap<String, Integer> result = (HashMap<String, Integer>) Manchester.getMatchScore(resultString);

			LOGGER.log(
					Level.INFO,
					"No. of wins: {0} No. of draws: {1} No. of defeats: {2} Goals Scored: {3} Goals Conceded: {4} No. of points: {5}",
					new Object[] { result.get("numberOfWins"),
							result.get("numberOfDraws"),
							result.get("numberOfDefeats"),
							result.get("goalsScored"),
							result.get("goalsConceded"),
							result.get("numberOfPoints") });
		} catch (NumberFormatException e) {
			LOGGER.log(Level.WARNING, "NumberFormatException Message: {0}", e.getMessage());
		}
	}

}
