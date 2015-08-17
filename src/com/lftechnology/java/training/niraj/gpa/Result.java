package com.lftechnology.java.training.niraj.gpa;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Get list of students as per their GPA
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 *
 */
public class Result {
	private static final Logger LOGGER = Logger.getLogger(Result.class
			.getName());

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			LOGGER.log(Level.INFO, "No. of students : ");
			while (!scanner.hasNextInt()) {
				LOGGER.log(Level.WARNING, "Please provide an integer : ");
				scanner.next();
			}
			int noOfStudents = scanner.nextInt();
			ArrayList<StudentInfo> studentList = getStudentInfo(noOfStudents,
					scanner, Constants.DESCENDING);
			LOGGER.log(Level.INFO, "List of Students :");
			for (StudentInfo studentInfo : studentList) {
				LOGGER.log(Level.INFO, studentInfo.toString());
			}

		} catch (InputMismatchException e) {
			LOGGER.log(Level.WARNING, "Please provide a valid input");
		}

	}

	/**
	 * Get student information from the user
	 * 
	 * @param noOfStudents
	 *            {@link Integer}
	 * @param scanner
	 *            {@link Scanner}
	 * @param order
	 *            {@link Constants} ASCENDING | DESCENDING
	 * @return {@link ArrayList} ordered student list
	 * @throws InputMismatchException
	 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
	 */
	private static ArrayList<StudentInfo> getStudentInfo(int noOfStudents,
			Scanner scanner, String order) throws InputMismatchException {

		ArrayList<StudentInfo> studentList = new ArrayList<StudentInfo>();
		StudentInfo studentInfo;
		for (int i = 0; i < noOfStudents; i++) {
			studentInfo = new StudentInfo();
			LOGGER.log(Level.INFO, "Student {0}", new Object[] { (i + 1) });
			studentInfo.setStudentInfo(scanner);
			studentList.add(studentInfo);
		}
		ArrayList<StudentInfo> orderedStudentList = StudentInfo
				.getSortedStudentInfoList(studentList, order);
		return orderedStudentList;
	}
}
