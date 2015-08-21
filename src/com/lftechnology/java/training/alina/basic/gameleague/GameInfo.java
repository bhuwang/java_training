package com.lftechnology.java.training.alina.basic.gameleague;

/**
 * Class GameInfo consists of game score informations of Manchester United
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class GameInfo {
	private int noOfWins = 0;
	private int noOfDraws = 0;
	private int noOfDefeats = 0;
	private int noOfGoalScored = 0;
	private int noOfGoalConceded = 0;
	private int noOfPoints = 0;
	private int firstScore = 0;
	private int secondScore = 0;
	private GameStatus goalPoint;

	/**
	 * Enum function for Game status
	 * 
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public enum GameStatus {
		WIN("Win"), DRAW("Draw"), LOSE("Lose"), NO_MATCH("0");
		private String status;

		private GameStatus(String status) {
			this.status = status;
		}
	}

	public int getNoOfWins() {
		return noOfWins;
	}

	public void setNoOfWins(int noOfWins) {
		this.noOfWins = noOfWins;
	}

	public int getNoOfDraws() {
		return noOfDraws;
	}

	public void setNoOfDraws(int noOfDraws) {
		this.noOfDraws = noOfDraws;
	}

	public int getNoOfDefeats() {
		return noOfDefeats;
	}

	public void setNoOfDefeats(int noOfDefeats) {
		this.noOfDefeats = noOfDefeats;
	}

	public int getNoOfGoalScored() {
		return noOfGoalScored;
	}

	public void setNoOfGoalScored(int noOfGoalScored) {
		this.noOfGoalScored = noOfGoalScored;
	}

	public int getNoOfGoalConceded() {
		return noOfGoalConceded;
	}

	public void setNoOfGoalConceded(int noOfGoalConceded) {
		this.noOfGoalConceded = noOfGoalConceded;
	}

	public int getNoOfPoints() {
		return noOfPoints;
	}

	public void setNoOfPoints(int noOfPoints) {
		this.noOfPoints = noOfPoints;
	}

	/**
	 * Function used to get the game scores
	 * 
	 * @param result
	 *            {@link String} team and score sets
	 * @return {@link String} manchester united scores
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public String getGameScores(String result) {
		String[] resultArray = result.split(" ");
		int counter = 0;
		int outputValue = 0;
		for (int i = 0; i < resultArray.length; i++) {
			try {
				outputValue = Integer.parseInt(resultArray[i]);
				if (counter == 0) {
					firstScore = outputValue;
					counter++;
				} else {
					secondScore = outputValue;
				}
			} catch (NumberFormatException e) {
			}
		}
		getGoalPoint(result);
		return this.toString();
	}

	/**
	 * Function used to get goal points in different matches
	 * 
	 * @param result
	 *            {@link String} team and score sets
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public void getGoalPoint(String result) {
		int team = result.indexOf("Manchester United");
		int opponentScore = 0, selfScore = 0;
		if (team == 0) {
			if (firstScore > secondScore) {
				goalPoint = GameStatus.WIN;
			} else if (secondScore > firstScore) {
				goalPoint = GameStatus.LOSE;
			} else if (firstScore == secondScore) {
				goalPoint = GameStatus.DRAW;
			}
			selfScore = firstScore;
			opponentScore = secondScore;
		} else if (team > 0) {
			if (secondScore > firstScore) {
				goalPoint = GameStatus.WIN;
			} else if (firstScore > secondScore) {
				goalPoint = GameStatus.LOSE;
			} else if (firstScore == secondScore) {
				goalPoint = GameStatus.DRAW;
			}
			selfScore = secondScore;
			opponentScore = firstScore;
		} else {
			goalPoint = GameStatus.NO_MATCH;
		}
		scoreCalculation(goalPoint, selfScore, opponentScore);
	}

	/**
	 * Function used to calculate game score
	 * 
	 * @param goalPoint
	 *            {@link String} points in different matches
	 * @param selfScore
	 *            {@link {@link Integer} points scored
	 * @param opponentScore
	 *            {@link Integer} points conceded
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public void scoreCalculation(GameStatus goalPoint, int selfScore,
			int opponentScore) {
		if (goalPoint == GameStatus.LOSE) {
			this.noOfDefeats++;
		}
		if (goalPoint == GameStatus.DRAW) {
			this.noOfDraws++;
		}
		if (goalPoint == GameStatus.WIN) {
			this.noOfWins++;
		}
		this.noOfGoalScored += selfScore;
		this.noOfGoalConceded += opponentScore;
		this.noOfPoints = this.noOfGoalScored;
	}

	@Override
	public String toString() {
		return "\n\t No. of wins = " + noOfWins + "\n\t No. of draws = "
				+ noOfDraws + "\n\t No. of defeats = " + noOfDefeats
				+ "\n\t Goal Scored = " + noOfGoalScored
				+ "\n\t Goal Conceded = " + noOfGoalConceded
				+ "\n\t No. of points = " + noOfPoints + "\n";
	}
}
