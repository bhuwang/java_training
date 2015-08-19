package com.lftechnology.java.training.dipak;

import java.util.Scanner;
import java.util.logging.Logger;

public class Test {
	private static final Logger LOGGER = Logger.getLogger(Test.class.getName());

	private Test() {

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LOGGER.info("Enter your name with Salutation::");
		String inputName = scanner.nextLine();
		inputName = inputName.trim();

		String[] text = inputName.split(" ");

		LOGGER.info("Salutation::" + text[0]);
		String name = "";

		for (int i = 1; i < text.length; i++) {
			if (text[i].length() == 0) {
				name = name + text[i] + " ";
			}

		}
		LOGGER.info("Your name::" + name);
		scanner.close();
	}

}
