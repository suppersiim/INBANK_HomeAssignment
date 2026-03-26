package com.inbank.loanengine.controller;

import com.inbank.loanengine.domain.LoanDecision;
import com.inbank.loanengine.domain.LoanRequest;
import com.inbank.loanengine.service.LoanDecisionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loan")
@CrossOrigin(origins = "*")
public class LoanDecisionController {

    private final LoanDecisionService loanDecisionService;

    public LoanDecisionController(LoanDecisionService loanDecisionService) {
        this.loanDecisionService = loanDecisionService;
    }

    // Posting loan decision request, validating the input and returning the loan decision
    @PostMapping("/decision")
    public LoanDecision getDecision(@RequestBody LoanRequest request) throws Exception {

        if (request.getLoanAmount() < 2000 || request.getLoanAmount() > 10000) {
            throw new IllegalArgumentException("Loan amount must be between 2000 and 10000");
        }
        if (request.getLoanPeriod() < 12 || request.getLoanPeriod() > 60) {
            throw new IllegalArgumentException("Loan period must be between 12 and 60 months");
        }


        return loanDecisionService.processLoanDecision(request);
    }
}