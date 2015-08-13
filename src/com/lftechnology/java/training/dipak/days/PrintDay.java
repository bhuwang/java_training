package com.lftechnology.java.training.dipak.days;

import java.util.Scanner;
import java.util.logging.Logger;

/*program called PrintDayInWord, which prints �Sunday�, �Monday�, ... �Saturday� if the int variable "day" is 0, 1, ..., 6, respectively.
 * Otherwise, it shall print �Not a valid day�
*/
public class PrintDay {
	private final static Logger LOGGER = Logger.getLogger(PrintDay.class.getName());
	/**
	 * <p>This method checks whether the day number matches to the day or not</p>
	 * @param dayNumber
	 * @return day
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	String getDay(int dayNumber){
		String day;
		switch(dayNumber){
		case 1:	day="Sunday";
				break;
		case 2: day="Monday";
				break;
		case 3: day="Tuesday";
				break;
		case 4: day="Wednesday";
				break;
		case 5: day="Thursday";
				break;
		case 6:day="Friday";
				break;
		case 7: day="Saturday";
				break;
		default: day="Not a valid day";
				 break;
		}
		return day;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(;;){
			LOGGER.info("Enter a number(0-7) or press -1 to terminate::");
			int day;
			label1:for(;;){
				try{
					day=(Integer.parseInt(sc.nextLine()));
					break label1;
				}catch(NumberFormatException nfe){
					LOGGER.info("Characters entered.Re-enter the values.");
				}
			}						
			if(day<0){
				break;
			}
			
			PrintDay pd1=new PrintDay();
			String displayText=pd1.getDay(day);
			System.out.println(displayText);
		}		
		sc.close();
	}

}
