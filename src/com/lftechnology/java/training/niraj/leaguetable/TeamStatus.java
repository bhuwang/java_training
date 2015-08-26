package com.lftechnology.java.training.niraj.leaguetable;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Get a particular team's league status
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public class TeamStatus {
	private static final Logger LOGGER = Logger.getLogger(TeamStatus.class
			.getName());

	private TeamStatus() {
	}

	public static void main(String[] args) {
		String result = "Arsenal 1 Chelsea 0, Arsenal 1 Manchester United 1, Arsenal 3 Fulham 1, Liverpool 2 Arsenal 3, Swansea 2 Arsenal 4";
		String team = "Arsenal";

		LeagueInfo leagueInfo = new LeagueInfo(result, team);
		String info = leagueInfo.getLeagueInfo();
		LOGGER.log(Level.INFO,
				"The league table information about {0} is as follows: {1}",
				new Object[] { team, info });
	}

}
