package com.lftechnology.java.training.dipak.packageandexecutablejar.addnumber;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * <p>The program adds two user inputted numbers and displays the sum.</p>
 * @author Dipak Thapa <dipakthapa@lftechnology.com>
 */
public class AddNumber {
	private int sum;
	private int number1;
	private int number2;
	private static final Logger LOGGER=Logger.getLogger(AddNumber.class.getName());
	public AddNumber(int num1,int num2) {
		number1=num1;
		number2=num2;
	}
	/**
	 * <p>This method computes the sum of user inputted numbers.</p>
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public void computeSum() {
		sum=number1+number2;
	}
	/**
	 * <p>This method displays the sum.</p>
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public void displaySum() {
		LOGGER.log(Level.INFO, "The sum of {0} and {1} is {2}",new Object[] {number1,number2,sum});
	}
	public static void main(String[] args) {
		int number1=0;
		int number2=0;
		try(Scanner sc=new Scanner(System.in)){
			LOGGER.info("Enter number1");
			number1=Integer.parseInt(sc.nextLine());
			LOGGER.info("Enter number2");
			number2=Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException nfe) {
			LOGGER.log(Level.INFO,"{0}",nfe);
			System.exit(0);
		}
		AddNumber add=new AddNumber(number1, number2);
		add.computeSum();
		add.displaySum();
	}

}
