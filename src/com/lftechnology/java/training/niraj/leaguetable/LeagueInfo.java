/**
 * 
 */
package com.lftechnology.java.training.niraj.leaguetable;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Helper class containing methods and properties that describes league table
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public class LeagueInfo {

	private int wins = 0;
	private int loss = 0;
	private int draw = 0;
	private int points;
	private int goalFor = 0;
	private int goalAgainst = 0;
	private String team;
	private String result;
	private String[] resultList;

	public LeagueInfo(String result, String team) {
		setResult(result);
		setTeam(team);
		setResultList(parseResults());
	}

	public int getWins() {
		return wins;
	}

	public int getLoss() {
		return loss;
	}

	public int getDraw() {
		return draw;
	}

	public int getPoints() {
		return points;
	}

	public int getGoalFor() {
		return goalFor;
	}

	public int getGoalAgainst() {
		return goalAgainst;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String[] getResultList() {
		return resultList;
	}

	public void setResultList(String[] resultList) {
		this.resultList = resultList;
	}

	/**
	 * Parse the list of result in a string to an array
	 * 
	 * @return {@link String[]}
	 * @author Niraj Rajbhandari<nirajrajbhandari@lftechnology.com>
	 */
	private String[] parseResults() {
		return this.result.split(",");

	}

	/**
	 * Get League information related to a particular club
	 * 
	 * @return {@link String}
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	public String getLeagueInfo() {
		String[][] specificResult = parseParticularResult();
		calculateLeagueInfo(specificResult);
		return this.toString();
	}

	/**
	 * Parse result of a particular match
	 * 
	 * @return {@link String[][]} array of result of each match
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	public String[][] parseParticularResult() {
		String[] temp;
		String[][] specificResultList = new String[resultList.length][4];
		for (int i = 0; i < resultList.length; i++) {
			if (resultList[i].contains(team)) {
				temp = resultList[i].split(" ");
				specificResultList[i] = temp;
			}
		}
		return specificResultList;
	}

	/**
	 * Calculate the information related to league table
	 * 
	 * @param specificResultList
	 *            {@link String[][]}
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	public void calculateLeagueInfo(String[][] specificResultList) {
		int goal;
		Map<String, Integer> scoreInfo;
		String opponent = "";
		for (String[] specificResult : specificResultList) {
			scoreInfo = new HashMap<String, Integer>();
			for (String s : specificResult) {
				try {
					goal = Integer.parseInt(s);
					scoreInfo = calculateGoalInfo(goal, opponent, scoreInfo);
				} catch (NumberFormatException ne) {
					opponent = s.trim();
				}
			}
			setWinLossInfo(scoreInfo);

		}
		setTotalPoints();
	}

	/**
	 * Calculate the goal information of all the result for a particular team
	 * 
	 * @param goal
	 *            {@link Integer}
	 * @param opponent
	 *            {@link String}
	 * @param scoreInfo
	 *            {@link Map}
	 * @return {@link Map}
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	private Map<String, Integer> calculateGoalInfo(int goal, String opponent,
			Map<String, Integer> scoreInfo) {

		if (!opponent.equalsIgnoreCase(team)) {
			scoreInfo.put(Constants.CONCEDED, goal);
			goalAgainst += goal;
		} else {
			scoreInfo.put(Constants.SCORED, goal);
			goalFor += goal;
		}
		return scoreInfo;
	}

	/**
	 * set win loss information of a particular team
	 * 
	 * @param scoreInfo
	 *            {@link Map}
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	private void setWinLossInfo(Map<String, Integer> scoreInfo) {
		if (scoreInfo.get(Constants.SCORED) > scoreInfo.get(Constants.CONCEDED)) {
			wins++;
		} else if (scoreInfo.get(Constants.SCORED) == scoreInfo
				.get(Constants.CONCEDED)) {
			draw++;
		} else {
			loss++;
		}
	}

	/**
	 * Set total point of a team
	 * 
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	private void setTotalPoints() {
		points = (wins * 3) + draw;
	}

	@Override
	public String toString() {
		return "\n\t TEAM = " + team + "\n\t WINS = " + wins + "\n\t LOSS = "
				+ loss + "\n\t DRAW = " + draw + "\n\t GOAL FOR = " + goalFor
				+ "\n\t GOAL AGAINST = " + goalAgainst + "\n\t TOTAL POINTS = "
				+ points + "\n";
	}

}
