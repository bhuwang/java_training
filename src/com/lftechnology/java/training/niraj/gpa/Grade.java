package com.lftechnology.java.training.niraj.gpa;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Helper class that contains methods to calculate students grade
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public class Grade {
	private static final Logger LOGGER = Logger
			.getLogger(Grade.class.getName());

	private Grade() {

	}

	private static String[] subjects = new String[] { Constants.ENGLISH,
			Constants.MATHS, Constants.ECONOMICS, Constants.COMPUTER,
			Constants.ACCOUNTS };

	public static String[] getSubjects() {
		return subjects;
	}

	/**
	 * Set subject marks for student
	 * 
	 * @param scanner
	 *            {@link Scanner}
	 * @param studentInfo
	 *            {@link StudentInfo}
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	public static void setSubjectMarks(Scanner scanner, StudentInfo studentInfo) {

		LOGGER.log(Level.INFO, "Marks obtained by {0} in :",
				new Object[] { studentInfo.getName() });
		int totalMarkObtained = 0;
		int mark;

		for (int i = 0; i < subjects.length; i++) {
			LOGGER.log(Level.INFO, subjects[i]);
			while (!scanner.hasNextInt()) {
				LOGGER.log(Level.WARNING, "Please provide a number");
				scanner.next();
			}
			mark = scanner.nextInt();
			totalMarkObtained += mark;
			studentInfo.setMarks(subjects[i], mark);
		}

		studentInfo.setMarkObtained(totalMarkObtained);
		float percentage = calculatePercentage(totalMarkObtained);
		char grade = calculateGrade(percentage);
		studentInfo.setPercentage(percentage);
		studentInfo.setGrade(grade);
	}

	/**
	 * Calculate the percentage of the student
	 * 
	 * @param totalMarksObtained
	 *            {@link Integer}
	 * @return {@link Float} percentage obtained by the student
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	public static float calculatePercentage(int totalMarksObtained) {
		return (float) (totalMarksObtained / Grade.subjects.length);
	}

	/**
	 * Calculate grade of the student
	 * 
	 * @param percentage
	 *            {@link Float}
	 * @return {@link Character} grade obtained by the student
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	public static char calculateGrade(float percentage) {

		char grade;
		if (percentage >= 80) {
			grade = 'A';
		} else if (percentage < 80 && percentage >= 70) {
			grade = 'B';
		} else if (percentage < 70 && percentage >= 60) {
			grade = 'C';
		} else if (percentage < 60 && percentage >= 50) {
			grade = 'D';
		} else if (percentage < 50 && percentage >= 40) {
			grade = 'E';
		} else {
			grade = 'F';
		}
		return grade;

	}

}
