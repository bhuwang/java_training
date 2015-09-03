package com.lftechnology.java.training.srijan.basics.genericstutorial;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenericSumCalculator {
	private int numberOfInputs;
	private static final Logger LOGGER = Logger.getLogger(GenericSumCalculator.class.getName());
	List<Integer> intList = new ArrayList<Integer>();
	List<Double> doubleList = new ArrayList<Double>();
	
	public GenericSumCalculator(){
		this.numberOfInputs = 0;
	}
	
	/**
	 * <p>inputs number of inputs user will give</p>
	 * <p>inputs integer numbers</p>
	 * @author srijan
	 */
	public void inputIntegerData(){
		Scanner input = null;
		try{
		input = new Scanner(System.in);
		int inputNumber = 0;
		LOGGER.info("Enter number of integer you will input");
		numberOfInputs = input.nextInt();
		LOGGER.info("Enter integer numbers");
		for(int i =0;i<numberOfInputs;i++){
			inputNumber = input.nextInt();
			intList.add(inputNumber);
		}
		LOGGER.log(Level.INFO,"numbers entered in integer list:{0}",intList);
		addNumbers(intList);
		}catch(InputMismatchException ex){
			LOGGER.info("please enter integer value:" + ex);
		}finally{
		input.close();
		}
	}
	
	/**
	 * <p>inputs from user  number of inputs user will give</p>
	 * <p>inputs double numbers</p>
	 * @author srijan
	 */
	public void inputDoubleData(){
		Scanner input = null;
		try{
		input = new Scanner(System.in);
		
		double inputNumber = 0;
		LOGGER.info("Enter number of double number you will input");
		numberOfInputs = input.nextInt();
		LOGGER.info("Enter numbers(double type");
		for(int i = 0;i<numberOfInputs;i++){
			inputNumber = input.nextDouble();
			doubleList.add(inputNumber);
		}
		LOGGER.log(Level.INFO,"numbers entered in double list: {0}",doubleList);
		addNumbers(doubleList);
		}catch(InputMismatchException ex){
			LOGGER.info("please enter double value" + ex);
		}finally{
			input.close();
		}
		
	}
	
	/**
	 * <p>adds integer and double from a list and shows result</p>
	 * @param list
	 */
	public void addNumbers(List<? extends Number> list){
		double sum = 0;
		for(Number number : list){
			sum += number.doubleValue();
		}
		LOGGER.log(Level.INFO,"The sum: {0}", sum);
	}
}
