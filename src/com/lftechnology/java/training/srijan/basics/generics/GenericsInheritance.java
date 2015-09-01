package com.lftechnology.java.training.srijan.basics.generics;

import java.util.logging.Logger;
public class GenericsInheritance {
	private static Logger LOGGER = Logger.getLogger(GenericsInheritance.class.getName());
	public static void main(String[] args){
		String str = "Srijan";
		Object obj = new Object();
		obj = str;
		LOGGER.info("obj content: " + obj );
		
		MyClass<String> myClass = new MyClass<String>();
		MyClass<Object> myObject = new MyClass<Object>();
		obj = myClass;
		//myObject = myClass;//because myObject and myClass are different
		LOGGER.info("obj content: " + obj );
		obj = myObject;
		LOGGER.info("obj content: " + obj );
	}
	
	public static class MyClass<T>{
		
	}
}
