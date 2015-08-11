package com.lftechnology.java.training.dipak.multiples;

import java.util.Scanner;

import java.util.logging.Logger;

/*	
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

 *Find the sum of all the multiples of 3 or 5 below 1000.
*/

public class Multiples {
	private final static Logger LOGGER = Logger.getLogger(Multiples.class.getName());
	private int multiple[];	
	private int index=0;
	private int range;		
	Multiples(int range){
		this.range=range;		
		multiple=new int[range];	
	}
	
	/**
	 * <p>This method check all the multiples of the user defined numbers that are taken as input within the user
	 * defined range </p>
	 * @param  a[] 
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	
	public void getMultiples(int a[]){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<range;j++){		//Change according to the range
				if((j % a[i]) == 0 ){
					 boolean exists=ifexists(j);
					if(!exists){
						multiple[index++]=j;
					}
				}
			}
		}		
	}
	/**
	 * <p>This method checks whether the given number is a multiple of the user defined numbers or not. It returns a boolean value </p>
	 * @param  a
	 * @return temp
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public boolean ifexists(int number){
		boolean isMultiple=false;
		for(int k=0;k<index;k++){
			if(number == multiple[k]){
				isMultiple=true;
				break;
			}
		}
		return isMultiple;
	}
	/**
	 * <p>This method calculates the sum of all multiples</p>
	 * @param  
	 * @return sum
	 * @author Dipak Thapa <dipakthapa@lftechnology.com>
	 */
	public int sum(){
		int sum=0;
		for(int i=0;i<multiple.length;i++){
			sum+=multiple[i];
		}
		return sum;
	}
	public static void main(String[] args) {			
		for(;;){
			Scanner scanner=new Scanner(System.in);
			try{				
				LOGGER.info("Enter the upper bound(0 - ? )::");	
				
				int range=Math.abs(Integer.parseInt(scanner.nextLine()));			
				
				Multiples m1=new Multiples(range);
				LOGGER.info("Enter the number of divisors::");
				int n=Math.abs(Integer.parseInt(scanner.nextLine()));	
				
				int a[]=new int[n];			
				
				for(int i=0;i<n;i++){
					LOGGER.info("Enter the number whose multiples are to be determined::");
					a[i]=Math.abs(Integer.parseInt(scanner.nextLine()));	
				}
				
				m1.getMultiples(a);
				int sum=m1.sum();
				LOGGER.info("The sum is::"+sum);				
				scanner.close();
				break;
			}catch(NumberFormatException nfe){
				LOGGER.info("Characters or negative numbers entered.Re-enter the values.");
			}
			
		}			
	
	}

}
