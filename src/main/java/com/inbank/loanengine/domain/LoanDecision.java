package com.inbank.loanengine.domain;

public class LoanDecision {

    private final String status;
    private final Integer approvedAmount;
    private final Integer approvedPeriod;

    public LoanDecision(String status, Integer approvedAmount, Integer approvedPeriod) {
        this.status = status;
        this.approvedAmount = approvedAmount;
        this.approvedPeriod = approvedPeriod;
    }

    public String  getStatus() {
        return status;
    }

    public Integer getApprovedAmount() {
        return approvedAmount;
    }

    public Integer getApprovedPeriod() {
        return approvedPeriod;
    }
}
