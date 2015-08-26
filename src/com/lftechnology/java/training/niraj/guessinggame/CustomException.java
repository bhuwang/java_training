
package com.lftechnology.java.training.niraj.guessinggame;

/**
 * Custom Runtime Exception
 * 
 * @author Niraj Rajbhandari <nirajrajbhandari@lftechnology.com>
 */
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomException(String message) {

		super(message);
	}

	public CustomException(String message, Throwable throwable) {

		super(message, throwable);
	}
}
