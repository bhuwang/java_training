package com.lftechnology.java.training.sanish.student;

/**
 * Provide mark information
 * 
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public class Mark {
	private String subject;
	private int markObtain;

	public Mark(String subject, int markObtain) {
		this.subject = subject;
		this.markObtain = markObtain;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getMarkObtain() {
		return markObtain;
	}

	public void setMarkObtain(int markObtain) {
		this.markObtain = markObtain;
	}

	@Override
	public String toString() {
		return "Mark [subject=" + subject + ", markObtain=" + markObtain + "]";
	}

}
