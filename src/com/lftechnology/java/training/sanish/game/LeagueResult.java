package com.lftechnology.java.training.sanish.game;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provide football league game results funcitons
 *
 * @autor Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class LeagueResult {
    private static final Logger LOGGER = Logger.getLogger(LeagueResult.class.getName());

    private LeagueResult() {
    }

    /**
     * Display League game result of specific team
     *
     * @param games    {@link Game} list of games
     * @param teamName {@link String} team name
     * @author Sanish Maharjan <sanishmaharjan@lftechology.com>
     */
    public static void displayLeagueGameResultOfTeam(ArrayList<Game> games, String teamName) {
        Team team;
        int totalGoalScore = 0, totalGoalConceded = 0, totalGameScore = 0, winGameCount = 0,
                lossGameCount = 0, drawGameCount = 0;
        for (Game game : games) {
            team = game.getTeamByName(teamName);
            if (team != null) {
                totalGoalScore += team.getGoalScored();
                totalGoalConceded += team.getGoalConceded();
                totalGameScore += team.getGamePoints();
                if (team.getGameResult() == Constants.WIN) {
                    winGameCount++;
                } else if (team.getGameResult() == Constants.LOSS) {
                    lossGameCount++;
                } else {
                    drawGameCount++;
                }
            }
        }

        LOGGER.log(Level.INFO, "League game result \n" +
                "==================================== \n" +
                "No. of wins \t {0} \n" +
                "No. of draws \t {1} \n" +
                "No. of defeats \t {2} \n" +
                "Goal Scored \t {3} \n" +
                "Goal Conceded \t {4} \n" +
                "No. of points \t {5}", new Object[]{winGameCount, drawGameCount, lossGameCount, totalGoalScore,
                totalGoalConceded, totalGameScore});
    }
}
