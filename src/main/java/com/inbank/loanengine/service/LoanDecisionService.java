package com.inbank.loanengine.service;

public class LoanDecisionService {

    private final boolean hasDebt;
    private final double loanAmount;
    private final int loanPeriod;
    private final int creditModifier;
    private final int minimumLoanAmount = 2000;
    private final int maximumLoanAmount = 10000;

    public LoanDecisionService(boolean hasDebt, double loanAmout, int loanPeriod, int creditModifier) {
        this.hasDebt = hasDebt;
        this.loanAmount = loanAmout;
        this.loanPeriod = loanPeriod;
        this.creditModifier = creditModifier;
    }

    public boolean isHasDebt() {
        return hasDebt;
    }

    public double getLoanAmout() {
        return loanAmount;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public int getCreditModifier() {
        return creditModifier;
    }

    public int getMinimumLoanAmount() {
        return minimumLoanAmount;
    }

    public int getMaximumLoanAmount() {
        return maximumLoanAmount;
    }

    // giveLoan method returns true if the person does not have debt and false otherwise
    public boolean giveLoan(){
        if (isHasDebt()) return false;
        else return true;
    }

    // CalculateLoanAmount calculates the maximum loan amount a specific person can take (returns the value)
    public Integer CalculateLoanAmout(){

        int maxLoanAmout = getCreditModifier() * getLoanPeriod();

        if (maxLoanAmout >= getMinimumLoanAmount()){
            System.out.println("LOAN APPROVED");
            maxLoanAmout = Math.min(maxLoanAmout,getMaximumLoanAmount());
            return maxLoanAmout;
        }
        System.out.println("LOAN DISAPPROVED");
        return null;
    }


}
