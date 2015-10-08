package com.lftechnology.java.training.niraj.ems.enums;

public enum Operators {
    OR("OR"), AND("AND");
    private final String operator;

    private Operators(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}
