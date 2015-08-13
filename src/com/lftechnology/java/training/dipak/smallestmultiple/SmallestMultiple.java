package com.lftechnology.java.training.dipak.smallestmultiple;

import java.util.logging.Logger;

/*2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
*
What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20
*/
public class SmallestMultiple {
	private final static Logger LOGGER = Logger.getLogger(SmallestMultiple.class.getName());
	private int smallest=0;
	private int startingPoint;
	private int endingPoint;
	
	SmallestMultiple(int start,int end){
		startingPoint=start;
		endingPoint=end;
	}
	
	/**
	 * <p>This method checks all numbers.The method doesn't terminate until a number if found</p>
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public void getMultiples(){
		for(int i=1;;i++){
			boolean isMultiple=checkMultiples(i);
			if(isMultiple){
				smallest=i;
				break;
			}
		}
	}
	/**
	 * <p>This method checks whether the number is multiple of numbers from 1-20 or not.</p>
	 * @param number
	 * @return true if the number is a multiple of all the numbers in the given range else false	 
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	
	private boolean checkMultiples(int number){
		int count=0;
		for(int i=startingPoint;i<=endingPoint;i++){
			if(number % i==0){
				count++;
			}else{
				break;
			}
		}
		if(count==20){
			return true;
		}else{
			return false;
		}
		
	}
	public static void main(String[] args) {
		SmallestMultiple sm1=new SmallestMultiple(1,20);
		
		sm1.getMultiples();
		
		LOGGER.info("The smallest multiple that can be divided evenly by all nos. from 1-20 is "+sm1.smallest);
	}

}
