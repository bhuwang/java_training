package com.lftechnology.java.training.krishna.basics.gpa;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * StudentRecord.java
 * 
 * This program calculates percentage and GPA
 * 
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class StudentRecord {

	private static final Logger LOGGER = Logger
			.getLogger(StudentRecordDemo.class.getName());

	/**
	 * Calculate the total marks of the student
	 *
	 * @param subjects
	 *            {@link ArrayList}
	 * @return total marks {@link int} total marks obtained by the student
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static int getTotalMarks(ArrayList<Subject> subjects) {
		int totalMarks = 0;
		for (Subject subject : subjects) {
			int marks = subject.getMarks();
			totalMarks += marks;
		}
		return totalMarks;
	}

	/**
	 * Calculate the total subject of the student
	 *
	 * @param subjects
	 *            {@link ArrayList}
	 * @return size {@link int} total subject
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static int getTotalSubject(ArrayList<Subject> subjects) {
		return subjects.size();
	}

	/**
	 * Calculate grade based on percentage
	 *
	 * @param percentage
	 *            {@link float} percentage obtained by student
	 * @return grade {@link char} grade obtained
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static char getGrade(float percentage) {
		if (percentage >= 80) {
			return 'A';
		} else if (percentage < 80 && percentage >= 60) {
			return 'B';
		} else if (percentage < 60 && percentage >= 40) {
			return 'C';
		} else {
			return 'D';
		}
	}

	/**
	 * Calculate the percentage of the student
	 *
	 * @param totalMarks
	 *            {@link int}
	 * @param totalSubjects
	 *            {@link int} total subjects
	 * @return percentage {@link float} percentage obtained by the student
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static float getPercentage(int totalMarks, int totalSubjects) {
		return (float) (totalMarks / totalSubjects);
	}

	/**
	 * This method display the report of student such as namee, percentage,
	 * total marks
	 *
	 * @param subjects
	 *            {@link ArrayList}
	 * @return grade {@link char} grade obtained by the student
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static Map<Integer, Object> getStudnetReport(Student students,
			ArrayList<Subject> subjects, Map<Integer, Object> studentData) {
		int totalMarks = getTotalMarks(subjects);
		int totalSubjects = getTotalSubject(subjects);
		float percentage = getPercentage(totalMarks, totalSubjects);
		char grade = getGrade(percentage);
		StudentReport studentReport = new StudentReport(students.getName(),
				totalMarks, percentage, grade);
		studentData.put(students.getStudentId(), studentReport);

		return studentData;
	}

	/**
	 * Get sorted list of student information
	 *
	 * @param studentData
	 *            {@link Map<Integer, Object>}
	 * @return sortedReport {@link TreeMap<Integer, Object>}
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static TreeMap<Integer, Object> sortedStudentReport(
			Map<Integer, Object> studentData) {
		CheckComparator comparator = new CheckComparator(studentData);
		TreeMap<Integer, Object> sortedReports = new TreeMap<Integer, Object>(
				comparator);
		sortedReports.putAll(studentData);
		return sortedReports;
	}

	/**
	 * This method is used to display all the student performance details
	 *
	 * @param sortedReports
	 *            {@link TreeMap<Integer, Object>}
	 * 
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 */
	public static void displayStudentDetails(
			TreeMap<Integer, Object> sortedReports) {

		Set<Map.Entry<Integer, Object>> entrySet = sortedReports.entrySet();
		for (Map.Entry<Integer, Object> entry : entrySet) {
			Object report = entry.getValue();
			LOGGER.log(Level.INFO, "{0}", new Object[] { report });
		}

	}

}
