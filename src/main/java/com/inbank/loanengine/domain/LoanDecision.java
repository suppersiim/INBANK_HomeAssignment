package com.inbank.loanengine.domain;

public class LoanDecision {

    private final String status;
    private final Integer approvedAmount;
    private final Integer approvedperiod;

    public LoanDecision(String status, Integer approvedAmount, Integer approvedperiod) {
        this.status = status;
        this.approvedAmount = approvedAmount;
        this.approvedperiod = approvedperiod;
    }
}
