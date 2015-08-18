package com.lftechnology.java.training.krishna.basics.manchester;

public class CopyOfManchesterDemo {

	public static void main(String[] args) {

		String resultString = "Manchester United 1 Chelsea 0, Arsenal 1 Manchester United 1, Manchester United 3 Fulham 1, Liverpool 2 Manchester United 1, Swansea 2 Manchester United 4";
		String[] resultArray = resultString.split(",");

		int numberOfWins = 0;
		int numberOfDraws = 0;
		int numberOfDefeats = 0;
		int goalsScored = 0;
		int goalsConceded = 0;
		int numberOfPoints = 0;

		for (int i = 0; i < resultArray.length; i++) {
			String matchResult = Manchester.getResults(resultArray[i].trim());
			String[] splitMatchResult = matchResult.split("-");

			if (splitMatchResult[0].equals("0")) {
				numberOfDefeats++;
			}

			if (splitMatchResult[0].equals("1")) {
				numberOfDraws++;
				numberOfPoints = numberOfPoints + 1;
			}

			if (splitMatchResult[0].equals("3")) {
				numberOfWins++;
				numberOfPoints = numberOfPoints + 3;
			}

			goalsScored = goalsScored + Integer.parseInt(splitMatchResult[1]);
			goalsConceded = goalsConceded + Integer.parseInt(splitMatchResult[2]);
		}

		System.out.println("No. of wins =" + numberOfWins);
		System.out.println("No. of draws =" + numberOfDraws);
		System.out.println("No. of defeats =" + numberOfDefeats);

		System.out.println("Goals Scored =" + goalsScored);
		System.out.println("Goals Conceded =" + goalsConceded);

		System.out.println("No. of points =" + numberOfPoints);

	}

}
