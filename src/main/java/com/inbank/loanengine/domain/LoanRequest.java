package com.inbank.loanengine.domain;

public class LoanRequest {

    private final String personalCode;
    private final int loanAmount;
    private final int loanPeriod;

    public LoanRequest(String personalCode, int loanAmount, int loanPeriod) {
        this.personalCode = personalCode;
        this.loanAmount = loanAmount;
        this.loanPeriod = loanPeriod;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }
}
