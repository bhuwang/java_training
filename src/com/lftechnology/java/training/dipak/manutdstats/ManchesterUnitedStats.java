
package com.lftechnology.java.training.dipak.manutdstats;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Dipak Thapa <dipakthapa@lftechnology.com>
 */
public class ManchesterUnitedStats {

	private static final Logger LOGGER =
		Logger.getLogger(ManchesterUnitedStats.class.getName());
	private String results =
		"West Ham United 0 Manchester United 3,Manchester United 5 Manchester City 1 , Manchester United 1 Chelsea 0, Arsenal 1 Manchester United 1,  Manchester United 3 Fulham 1, Liverpool 2 Manchester United 1, Swansea 2 Manchester United 4";
	private String yourTeam = "";
	private int noOfWins = 0;
	private int noOfDraws = 0;
	private int noOfDefeats = 0;
	private int goalScored = 0;
	private int goalConceded = 0;
	private int noOfPoints = 0;

	public ManchesterUnitedStats(String team) {
		yourTeam = team;
	}

	/**
	 * <p> This method computes the all the statistics(win,losses,draws,goals)
	 * of the team </p>
	 * 
	 * @param team
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	void computeResults() {

		String tempResults = results.toLowerCase();
		String[] singleFixtureResult = tempResults.split(",");
		String yourTeamTemp = yourTeam.toLowerCase();
		for (int i = 0; i < singleFixtureResult.length; i++) {
			singleFixtureResult[i] = singleFixtureResult[i].trim();
			if (singleFixtureResult[i].contains(yourTeamTemp)) {
				getGoals(singleFixtureResult[i], yourTeamTemp);

			}

		}
	}

	void getGoals(String fixtureResult, String yourTeamTemp) {

		int goalsConceded = 0;
		int goalsScored = 0;
		int noOfDefeat = 0;
		int noOfDraw = 0;
		int noOfWin = 0;
		String[] temp = fixtureResult.split(" ");
		String team1 = "";
		for (String s : temp) {
			try {
				int goal = Integer.parseInt(s.trim());
				if (yourTeamTemp.equalsIgnoreCase(team1.trim())) {
					goalsScored = goal;
				}
				else {
					goalsConceded = goal;
				}
				team1 = "";
			}
			catch (NumberFormatException nfe) {
				team1 += s + " ";
			}
		}
		if (checkDraw(goalsScored, goalsConceded)) {
			noOfDraw++;
		}
		else if (checkWin(goalScored, goalConceded)) {
			noOfWin++;
		}
		else {
			noOfDefeat++;
		}
		this.goalScored += goalsScored;
		this.goalConceded += goalsConceded;

		this.noOfWins += noOfWin;
		this.noOfDefeats += noOfDefeat;
		this.noOfDraws += noOfDraw;
	}

	/**
	 * <p> This method checks whether the given match is won or lost comparing
	 * the goals scored and goals conceded.</p>
	 * 
	 * @param int
	 *            goalScored, int goalConceded
	 * @return true if the number of goalScored is greater than goalConceded
	 *         else false
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	boolean checkWin(int goalScored, int goalConceded) {

		return goalScored > goalConceded;
	}

	/**
	 * <p> This method checks whether the given match is draw or not based on
	 * the goals scored </p>
	 * 
	 * @param int
	 *            goalScored, int goalConceded
	 * @return true if the number of goals is equal else false
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	boolean checkDraw(int goalScored, int goalConceded) {

		return goalScored == goalConceded;
	}

	/**
	 * <p> This method computes the total points scored by the team </p>
	 * 
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	void computePoints() {

		noOfPoints = noOfWins * 3 + noOfDraws;
	}

	/**
	 * <p> This method displays the final result of the team statistics </p>
	 * 
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	void displayResults() {

		LOGGER.log(Level.INFO, "The final verdict of {0}::", yourTeam);
		LOGGER.log(Level.INFO, "Number of wins={0}", noOfWins);
		LOGGER.log(Level.INFO, "Number of draws={0}", noOfDraws);
		LOGGER.log(Level.INFO, "Number of defeats={0}", noOfDefeats);
		LOGGER.log(Level.INFO, "Number of goals scored={0}", goalScored);
		LOGGER.log(Level.INFO, "Number of goals conceded={0}", goalConceded);
		LOGGER.log(Level.INFO, "Number of points={0}", noOfPoints);
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		ManchesterUnitedStats mus1 =
			new ManchesterUnitedStats("manchester united");
		mus1.computeResults();
		mus1.computePoints();
		mus1.displayResults();
	}

}
