package com.lftechnology.java.training.krishna.basics.manchester;

public class CopyOfManchester {
	public static String getResults(String result) {

		String pointAndGoals = "";

		String[] resultArray = result.split(" ");
		int firstScore = 0;
		int secondScore = 0;
		int counter = 0;

		for (int i = 0; i < resultArray.length; i++) {
			try {
				int outputValue = 0;
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

		String HOME_WIN = "3";
		String AWAY_WIN = "3";
		String DRAW = "1";
		String LOSS = "0";

		int man_utd = result.indexOf("Manchester United");

		if (man_utd == 0) {
			if (firstScore > secondScore) {
				pointAndGoals = HOME_WIN + "-" + firstScore + "-"
						+ secondScore;
			} else if (secondScore > firstScore) {
				pointAndGoals = LOSS + "-" + firstScore + "-" + secondScore;
			} else if (firstScore == secondScore) {
				pointAndGoals = DRAW + "-" + firstScore + "-" + secondScore;
			}
		} else if (man_utd > 0) {
			if (secondScore > firstScore) {
				pointAndGoals = AWAY_WIN + "-" + secondScore + "-"
						+ firstScore;
			} else if (firstScore > secondScore) {
				pointAndGoals = LOSS + "-" + secondScore + "-" + firstScore;
			} else if (firstScore == secondScore) {
				pointAndGoals = DRAW + "-" + secondScore + "-" + firstScore;
			}
		}

		return pointAndGoals;
	}
}
