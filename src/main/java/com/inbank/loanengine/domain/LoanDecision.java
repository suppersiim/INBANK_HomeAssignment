package com.inbank.loanengine.domain;

public class LoanDecision {

    private final String status;
    private final Integer loanAmount;
    private final Integer loanPeriod;

    public LoanDecision(String status, Integer loanAmount, Integer loanPeriod) {
        this.status = status;
        this.loanAmount = loanAmount;
        this.loanPeriod = loanPeriod;
    }
}
