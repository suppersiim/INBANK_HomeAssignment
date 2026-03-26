package com.inbank.loanengine.service;

import com.inbank.loanengine.domain.CustomerSegment;
import com.inbank.loanengine.domain.LoanDecision;
import com.inbank.loanengine.domain.LoanRequest;
import com.inbank.loanengine.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class LoanDecisionService {

    private final CustomerRepository customerRepository;

    public LoanDecisionService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public LoanDecision processLoanDecision(LoanRequest loanRequest) throws Exception {

        var customerSegment = customerRepository.findByPersonalCode(loanRequest.getPersonalCode().strip());

        if (customerSegment.getCreditModifier() == 0) {
            return new LoanDecision("REJECTED", null, null);
        }

        int maxLoanAmount = customerSegment.getCreditModifier() * loanRequest.getLoanPeriod();
        int newLoanPeriod = loanRequest.getLoanPeriod();

        if (maxLoanAmount < 2000) {

            // Loop for increasing the loan period until the maximum loan amount is at least 2000
            while (maxLoanAmount < 2000 && newLoanPeriod <= 60) {
                newLoanPeriod++;
                maxLoanAmount = customerSegment.getCreditModifier() * newLoanPeriod;

                if (maxLoanAmount >= 2000) {
                    break;
                }
            }

            // If new max loan is greater than 2000 and loan period is under 60 months, approve the loan, otherwise reject it
            if (maxLoanAmount > 2000){
                return new LoanDecision("APPROVED", maxLoanAmount, newLoanPeriod);

            } else return new LoanDecision("REJECTED", null, null);



        }

        maxLoanAmount = Math.min(maxLoanAmount, 10000);

        return new LoanDecision("APPROVED", maxLoanAmount, loanRequest.getLoanPeriod());
    }


}