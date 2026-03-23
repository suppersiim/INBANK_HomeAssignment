package com.inbank.loanengine.repository;

import com.inbank.loanengine.domain.CustomerSegment;

public class MockCustomerRepository implements CustomerRepository{

    // method determines if person has debt (return null) and if not returns the credit score of the person
    @Override
    public CustomerSegment findByPersonalCode(String personalCode) throws Exception {

        if (personalCode.equals("49002010965")) return null;
        else if (personalCode.equals("49002010976")) return new CustomerSegment(100);
        else if (personalCode.equals("49002010987")) return new CustomerSegment(300);
        else if (personalCode.equals("49002010998")) return new CustomerSegment(1000);
        else {
            System.out.println("ERROR - PERSONAL CODE NOT MATCHING");
            throw new Exception();
        }
    }


}
