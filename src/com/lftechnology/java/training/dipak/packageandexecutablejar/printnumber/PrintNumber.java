package com.lftechnology.java.training.dipak.packageandexecutablejar.printnumber;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * <p>This program prints the number from 1 to user given range.</p>
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
		int range=0;
		try(Scanner sc=new Scanner(System.in)){
			LOGGER.info("Enter the upper bound");
			range=Math.abs(Integer.parseInt(sc.nextLine()));
		}catch(NumberFormatException nfe) {
			LOGGER.log(Level.INFO,"{0}",nfe);
			System.exit(0);
		}
		pn.display(range);
	}

}
