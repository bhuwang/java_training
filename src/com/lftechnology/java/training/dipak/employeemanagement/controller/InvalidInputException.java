package com.lftechnology.java.training.dipak.employeemanagement.controller;

public class InvalidInputException extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidInputException(String message) {
        super(message);
    }
}
