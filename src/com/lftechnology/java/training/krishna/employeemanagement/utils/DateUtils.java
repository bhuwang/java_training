
package com.lftechnology.java.training.krishna.employeemanagement.utils;

/**
 * This program is used for data and time.
 *
 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
 * @version 1.0
 */
public class DateUtils {

	/**
	 * This method is used to generate date in mysql format.
	 *
	 * @return date
	 * @author Krishna Timilsina <krishnatimilsina@lftechnology.com>
	 * @version 1.0
	 */
	public static java.sql.Date getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());

	}
}
