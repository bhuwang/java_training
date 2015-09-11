package com.lftechnology.java.training.alina.jdbc.service;

import java.sql.Timestamp;

public class DateTimeService {
    public static Timestamp getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
        return new Timestamp(today.getTime());
    }
}
