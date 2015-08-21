package com.lftechnology.java.training.krishna.basics.gpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * StudentRecordDemo.java
 * 
 * Log the output on the console.
 * 
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */

public class StudentRecordDemo {

	// constructor
	private StudentRecordDemo() {

	}

	private static final Logger LOGGER = Logger
			.getLogger(StudentRecordDemo.class.getName());

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			Map<Integer, Object> studentData = new HashMap<Integer, Object>();
			LOGGER.log(Level.INFO, "Please enter the no. of student: ");
			int studentCount = ScannerValidation.numberValidation(scanner);
			for (int j = 1; j <= studentCount; j++) {
				int studentId = j;
				LOGGER.log(Level.INFO, "Please enter the name: ");
				String name = ScannerValidation.nameValidation(scanner);
				LOGGER.log(Level.INFO, "Please enter the class: ");
				int classDomain = ScannerValidation.numberValidation(scanner);
				LOGGER.log(Level.INFO, "Please enter the roll number: ");
				int rollNumber = ScannerValidation.numberValidation(scanner);

				Student students = new Student(studentId, name, classDomain,
						rollNumber);
				setSubjectInformation(scanner, students);
				StudentRecord.getStudnetReport(students,
						students.getSubjects(), studentData);
			}

			TreeMap<Integer, Object> sortedReports = StudentRecord
					.sortedStudentReport(studentData);
			StudentRecord.displayStudentDetails(sortedReports);
			scanner.close();
		} catch (NumberFormatException e) {
			LOGGER.log(Level.WARNING, "NumberFormatException Message : {0}",
					e.getMessage());
		}
	}

	/**
	 * This method is used to set subject name and marks
	 *
	 * @param scanner
	 *            {@link Scanner}
	 * @param students
	 *            {@link Student}
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static void setSubjectInformation(Scanner scanner, Student students) {
		ArrayList<Subject> subjectMarks = new ArrayList<Subject>();
		LOGGER.log(Level.INFO, "Please enter the no. of subject: ");
		int subjectCount = ScannerValidation.numberValidation(scanner);
		for (int i = 1; i <= subjectCount; i++) {
			LOGGER.log(Level.INFO, "Please enter the name of subject[" + i
					+ "]: ");
			String subject = ScannerValidation.nameValidation(scanner);
			LOGGER.log(Level.INFO, "Please enter the " + subject.toUpperCase()
					+ " marks[" + i + "]: ");
			int marks = ScannerValidation.markValidation(scanner);
			subjectMarks.add(new Subject(subject, marks));
			students.setSubjects(subjectMarks);
		}
	}

}
