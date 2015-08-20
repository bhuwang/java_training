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

	private static final Logger LOGGER = Logger
			.getLogger(StudentRecordDemo.class.getName());

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);

			Map<Integer, Object> studentData = new HashMap<Integer, Object>();

			LOGGER.log(Level.INFO, "Please enter the no of student: ");
			int studentCount = scanner.nextInt();
			for (int j = 1; j <= studentCount; j++) {
				int studentId = j;

				LOGGER.log(Level.INFO, "Please enter the name: ");
				String name = scanner.next();
				LOGGER.log(Level.INFO, "Please enter the class: ");
				int classDomain = scanner.nextInt();
				LOGGER.log(Level.INFO, "Please enter the roll number: ");
				int rollNumber = scanner.nextInt();

				Student students = new Student(studentId, name, classDomain,
						rollNumber);
				ArrayList<Subject> subjectMarks = new ArrayList<Subject>();

				LOGGER.log(Level.INFO, "Please enter the no of subject: ");
				int subjectCount = scanner.nextInt();
				for (int i = 1; i <= subjectCount; i++) {
					LOGGER.log(Level.INFO, "Please enter the name of subject["
							+ i + "]: ");
					String subject = scanner.next();
					LOGGER.log(Level.INFO,
							"Please enter the " + subject.toUpperCase()
									+ " marks[" + i + "]: ");
					int marks = scanner.nextInt();
					subjectMarks.add(new Subject(subject, marks));
					students.setSubjects(subjectMarks);
				}

				StudentRecord.getStudnetReport(students,
						students.getSubjects(), studentData);
			}
			;
			TreeMap<Integer, Object> sortedReports = StudentRecord
					.sortedStudentReport(studentData);
			System.out.println(sortedReports);
			StudentRecord.displayStudentDetails(sortedReports);

		} catch (NumberFormatException e) {
			LOGGER.log(Level.WARNING, "NumberFormatException Message : {0}",
					e.getMessage());
		}
	}

}
