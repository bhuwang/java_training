
package com.lftechnology.java.training.srijan.basics.coreapp.domain;

public class SearchEmployee {

	private String searchChoice;
	private String choiceValue;

	public SearchEmployee() {
		this.searchChoice = "";
		this.choiceValue = "";
	}

	public String getSearchChoice() {

		return searchChoice;
	}

	public String getChoiceValue() {

		return choiceValue;
	}

	public void setSearchChoice(String searchChoice) {

		this.searchChoice = searchChoice;
	}

	public void setChoiceValue(String choiceValue) {

		this.choiceValue = choiceValue;
	}
}
