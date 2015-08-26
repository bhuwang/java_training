package com.lftechnology.java.training.sanish.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Provide result calculation static functions
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class ResultCalculation {
    private ResultCalculation() {
    }

    /**
     * Calculate & set student's total marks, percentage and grade obtain
     *
     * @param {@link ArrayList} list of student objects
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void calculateResult(List<Student> students, int totalSubject) {
        int totalMarks;
        List<Mark> marks = new ArrayList<Mark>();
        Result studeResult;
        float percentage;
        for (Student student : students) {
            marks = student.getMarks();
            totalMarks = 0;
            for (Mark mark : marks) {
                totalMarks += mark.getMarkObtain();
            }

            studeResult = student.getResult();
            studeResult.setTotalMarks(totalMarks);
            percentage = totalMarks / totalSubject;
            studeResult.setPercentage(percentage);
            studeResult.setGrade(getGrade(percentage));
        }
    }

    /**
     * Return grade base on percentage supplied
     *
     * @param percentage {@link Float} percentage obtain by student
     * @return {@link Character} grade obtain
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
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
     * Order students by total marks obtains
     *
     * @param students {@link Student} List of students
     * @param order    {@link String} possible value asc | desc
     * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
     */
    public static void orderByTotalMarks(ArrayList<Student> students,
                                         String order) {
        if (order.equals(Constants.ASCENDING)) {
            Collections.sort(students);
        } else {
            Comparator<Student> comparator = Collections.reverseOrder();
            Collections.sort(students, comparator);
        }
    }
}
