package com.lftechnology.java.training.sanish.game;

public class Team {
    private String teamName;
    private int goalScored;
    private int goalConceded;
    private String gameResult;
    private int gamePoints;

    public Team(String teamName, int goalScored, int goalConceded) {
        this.teamName = teamName;
        this.goalScored = goalScored;
        this.goalConceded = goalConceded;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getGoalScored() {
        return goalScored;
    }

    public void setGoalScored(int goalScored) {
        this.goalScored = goalScored;
    }

    public int getGoalConceded() {
        return goalConceded;
    }

    public void setGoalConceded(int goalConceded) {
        this.goalConceded = goalConceded;
    }

    public String getGameResult() {
        return gameResult;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    public int getGamePoints() {
        return gamePoints;
    }

    public void setGamePoints(int gamePoints) {
        this.gamePoints = gamePoints;
    }

    @Override
    public String toString() {
        return "teamName=" + teamName + ", goalScored=" + goalScored
                + ", goalConceded=" + goalConceded + ", gameResult="
                + gameResult + ", gamePoints=" + gamePoints;
    }

}
