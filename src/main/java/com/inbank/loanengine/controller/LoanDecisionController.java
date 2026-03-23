package com.inbank.loanengine.controller;

public class LoanDecisionController {

    private final String personalCode;
    private final double loanAmount;
    private final int loanPeriod;

    public LoanDecisionController(String personalCode, double loanAmount, int loanPeriod) {
        this.personalCode = personalCode;
        this.loanAmount = loanAmount;
        this.loanPeriod = loanPeriod;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public int getMinimumLoanAmount() {
        return 2000;
    }

    public int getMaximumLoanAmount() {
        return 10000;
    }

    public int getMinimumLoanPeriod() {
        return 12;
    }

    public int getMaximumLoanPeriod() {
        return 60;
    }

    // getCreaditScore method determines if person has debt (return null) and if not returns the credit score of the
    // person
    public Integer getCreditScore() throws Exception {
        if (getPersonalCode().equals("49002010965")) return null;
        else if (getPersonalCode().equals("49002010976")) return 100;
        else if (getPersonalCode().equals("49002010987")) return 300;
        else if (getPersonalCode().equals("49002010998")) return 1000;
        else throw new Exception();
    }

    // InputController method validates that the input is in the correct (returns true) and if not returns false
    public boolean InputController() throws Exception {

        if (getCreditScore() != null &&
            getLoanAmount() >= getMinimumLoanAmount() && getLoanAmount() <= getMaximumLoanAmount() &&
            getLoanPeriod() >= getMinimumLoanPeriod() && getMinimumLoanPeriod() <= getMaximumLoanPeriod()
            ){
            return true;
        }
        return false;

    }

}
