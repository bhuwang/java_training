
package com.lftechnology.java.training.alina.basic.calculategpa;

/**
 * Class Course contains course details and marks calculations.
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class Course implements Comparable<Course> {

	private float subject1;
	private float subject2;
	private float subject3;
	private float subject4;
	private float subject5;
	private float totalMarks;

	public Course(
		float subject1, float subject2, float subject3, float subject4,
		float subject5) {

		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
		this.subject4 = subject4;
		this.subject5 = subject5;
	}

	public float getSubject1() {

		return subject1;
	}

	public void setSubject1(float subject1) {

		this.subject1 = subject1;
	}

	public float getSubject2() {

		return subject2;
	}

	public void setSubject2(float subject2) {

		this.subject2 = subject2;
	}

	public float getSubject3() {

		return subject3;
	}

	public void setSubject3(float subject3) {

		this.subject3 = subject3;
	}

	public float getSubject4() {

		return subject4;
	}

	public void setSubject4(float subject4) {

		this.subject4 = subject4;
	}

	public float getSubject5() {

		return subject5;
	}

	public void setSubject5(float subject5) {

		this.subject5 = subject5;
	}

	/**
	 * Function used to get total marks of subjects
	 * 
	 * @return totalMarks {@link Float} total marks in all subjects
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public float getTotalMarks() {

		return this.subject1 + this.subject2 + this.subject3 + this.subject4 +
			this.subject5;
	}
	
	public void setTotalMarks(float totalMarks) {

		this.totalMarks = totalMarks;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(totalMarks);
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (Float.floatToIntBits(totalMarks) != Float.floatToIntBits(other.totalMarks))
			return false;
		return true;
	}

	/**
	 * Function used to get percentage of a student
	 * 
	 * @return percentage {@link Float} percentage in particular standard
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public float getPercentage() {

		return getTotalMarks() / 5;
	}

	/**
	 * Function used to get grade on the basis of percentage
	 * 
	 * @return grade {@link Character} grade of student
	 * @author Alina Shakya <alinashakya@lftechnology.com>
	 */
	public char getGrade() {

		char grade;
		float percentage = getPercentage();
		if (percentage >= 80) {
			grade = 'A';
		}
		else if (percentage < 80 && percentage >= 70) {
			grade = 'B';
		}
		else if (percentage < 70 && percentage >= 60) {
			grade = 'C';
		}
		else if (percentage < 60 && percentage >= 50) {
			grade = 'D';
		}
		else if (percentage < 50 && percentage >= 40) {
			grade = 'E';
		}
		else {
			grade = 'F';
		}
		return grade;
	}

	@Override
	public String toString() {

		return "Total Marks : " + getTotalMarks() + ", Percentage : " +
			getPercentage() + ", Grade : " + getGrade();
	}

	@Override
	public int compareTo(Course val) {

		int percentageToCompare = (int) val.getPercentage();
		return (int) (this.getPercentage() - percentageToCompare);
	}
}
