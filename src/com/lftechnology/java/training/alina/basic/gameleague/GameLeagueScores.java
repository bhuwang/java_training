package com.lftechnology.java.training.alina.basic.gameleague;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class GameLeagueScores shows the number of scores of wins, draws, defeats
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class GameLeagueScores {
	private static final Logger LOGGER = Logger
			.getLogger(GameLeagueScores.class.getName());
	private static String getScores = null;

	public static void main(String[] args) {
		try {
			String results = "Manchester United 1 Chelsea 0,"
					+ " Arsenal 1 Manchester United 1,"
					+ " Manchester United 3 Fulham 1,"
					+ " Liverpool 2 Manchester United 1,"
					+ " Swansea 2 Manchester United 4";
			String resultSet[] = results.split(",");
			GameInfo game = new GameInfo();
			for (int i = 0; i < resultSet.length; i++) {
				getScores = game.getGameScores(resultSet[i].trim());
			}
			LOGGER.log(Level.INFO, "Game Scores of Manchester United : {0}",
					new Object[] { getScores });
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, "Exception Message : {0}", e.getMessage());
		}
	}
}