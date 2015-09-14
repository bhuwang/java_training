package com.lftechnology.java.training.alina.jdbc.service;

import java.sql.Timestamp;

/**
 * DateTimeService consists of date and time related functionalities
 * 
 * @author Alina Shakya <alinashakya@lftechnology.com>
 */
public class DateTimeService {
    public static Timestamp getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
        return new Timestamp(today.getTime());
    }
}
