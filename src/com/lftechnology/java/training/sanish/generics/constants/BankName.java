package com.lftechnology.java.training.sanish.generics.constants;

/**
 * Provide bank names
 *
 * @author Sanish Maharjan <sanishmaharjan@lftechnology.com>
 */
public enum BankName {
    ID_1("Global"), ID_2("Nepal Investment"), ID_3("NBI");
    private String bankName;

    BankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return this.bankName;
    }
}
