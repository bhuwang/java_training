package com.lftechnology.java.training.srijan.basics.generics;

import java.util.logging.Logger;

public class GenericType<T> {
	private T t;
	private T t1;
	private static final Logger LOGGER = Logger.getLogger(GenericType.class.getName());
	public GenericType(T t, T t1){
		this.t = t;
		this.t1 = t1;
	}
	
	public static void main(String[] args){
		GenericType<String> genericType = new GenericType<>("","");
		LOGGER.info("value before set funtion is called " + genericType.get1() + genericType.get2());
		genericType.set("Srijan","Bajracharya");
		LOGGER.info("value After set funtion is called " + genericType.get1() + genericType.get2());
	}
	
	public void set(T t, T t1){
		this.t = t;
		this.t1 = t1;
	}
	
	public T get1(){
		return t;
	}
	
	public T get2(){
		return t1;
	}
	
//commented portion is vunerable to classcastException
	    /*private Object t;
	    private static final Logger LOGGER = Logger.getLogger(GenericType.class.getName());
	    public Object get() {
	        return t;
	    }
	 
	    public void set(Object t) {
	        this.t = t;
	    }
	 
	        public static void main(String args[]){
	        GenericType type = new GenericType();
	        type.set("Pankaj"); 
	        String str = (String) type.get(); //type casting, error prone and can cause ClassCastException
	        LOGGER.info("value After set funtion is called" + str);
	        }*/
	
}
