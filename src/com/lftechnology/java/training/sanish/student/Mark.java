package com.lftechnology.java.training.sanish.student;

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

	public void setMarkObtain(int maskObtain) {
		this.markObtain = maskObtain;
	}

}