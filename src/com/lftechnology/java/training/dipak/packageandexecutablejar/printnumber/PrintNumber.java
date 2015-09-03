package com.lftechnology.java.training.dipak.packageandexecutablejar.printnumber;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * <p>This program prints the number from 1 to 10.</p>
 * @author Dipak Thapa <dipakthapa@lftechnology.com>
 *
 */
public class PrintNumber {

	private static final Logger LOGGER = Logger.getLogger(PrintNumber.class.getName());
	/**
	 * <p>This method displays all the numbers from 1  to the range</p>
	 * @param range
	 */
	public void display(int range) {

		for (int i = 1; i <= range; i++) {
			LOGGER.log(Level.INFO, "{0}", i);
		}
	}

	public static void main(String[] args) {
		PrintNumber pn=new PrintNumber();		
		pn.display(10);
	}

}
