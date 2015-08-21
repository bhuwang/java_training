package com.lftechnology.java.training.sanish.game;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Football League game result display program
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class FootballLeague {
    private final static Logger LOGGER = Logger.getLogger(FootballLeague.class.getName());
    private static String resultSet = "Manchester United 1 Chelsea 0, Arsenal 1 Manchester United 1, Manchester United 3 Fulham 1, Liverpool 2 Manchester United 1, Swansea 2 Manchester United 4";
    private static ArrayList<Game> games = new ArrayList<Game>();

    public static void main(String[] args) {
        Game game;
        String teamName = "Manchester United";
        String[] gameResultSets = resultSet.split(", ");
        for (String gameResultText : gameResultSets) {
            game = new Game(gameResultText);
            game.processGameResult();
            games.add(game);
        }

        LeagueResult.displayLeagueGameResultOfTeam(games, teamName);
    }
}
