package com.lftechnology.java.training.sanish.game;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    private String gameResultTxt;
    private Team teamA;
    private Team teamB;

    public Game(String gameResultTxt) {
        this.gameResultTxt = gameResultTxt;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public void processGameResult() {
        Pattern pattern = Pattern.compile("([a-z A-Z]*) (\\d+) ([a-z A-Z]*) (\\d+)");
        Matcher matcher = pattern.matcher(this.gameResultTxt);
        if (matcher.find()) {
            String teamAName = matcher.group(1);
            int teamAGoals = Integer.parseInt(matcher.group(2));
            String teamBName = matcher.group(3);
            int teamBGoals = Integer.parseInt(matcher.group(4));
            this.setGameResult(teamAName, teamBName, teamAGoals, teamBGoals);
        }
    }

    public void setGameResult(String teamAName, String teamBName, int teamAGoals, int teamBGoals) {
        teamA = new Team(teamAName, teamAGoals, teamBGoals);
        teamB = new Team(teamBName, teamBGoals, teamAGoals);
        if (teamAGoals > teamBGoals) {
            teamA.setGameResult(Constants.WIN);
            teamA.setGamePoints(Constants.WIN_SCORE);
            teamB.setGameResult(Constants.LOSS);
            teamB.setGamePoints(Constants.LOSS_SCORE);
        } else if (teamAGoals < teamBGoals) {
            teamA.setGameResult(Constants.LOSS);
            teamA.setGamePoints(Constants.LOSS_SCORE);
            teamB.setGameResult(Constants.WIN);
            teamB.setGamePoints(Constants.WIN_SCORE);
        } else {
            teamA.setGameResult(Constants.DRAW);
            teamA.setGamePoints(Constants.DRAW_SCORE);
            teamB.setGameResult(Constants.DRAW);
            teamB.setGamePoints(Constants.DRAW_SCORE);
        }
    }

    public Team getTeamByName(String teamName) {
        if (teamA != null && teamA.getTeamName().equals(teamName)) {
            return teamA;
        } else if (teamB != null && teamB.getTeamName().equals(teamName)) {
            return teamB;
        }

        return null;
    }

    @Override
    public String toString() {
        return "Game [" + teamA + "], [" + teamB + "]";
    }

}
