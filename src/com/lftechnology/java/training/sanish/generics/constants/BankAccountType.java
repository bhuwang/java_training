package com.lftechnology.java.training.sanish.generics.constants;

/**
 * Provide bank account types
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public enum BankAccountType {
    SAVING("Saving"), FIX("Fix Deposit");
    private String accountType;

    BankAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }
}
