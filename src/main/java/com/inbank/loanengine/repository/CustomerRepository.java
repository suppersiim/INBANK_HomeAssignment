package com.inbank.loanengine.repository;

import com.inbank.loanengine.domain.CustomerSegment;

public interface CustomerRepository {

    CustomerSegment findByPersonalCode(String personalCode) throws Exception;

}
