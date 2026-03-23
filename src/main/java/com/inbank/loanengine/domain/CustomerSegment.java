package com.inbank.loanengine.domain;

public class CustomerSegment {

    private final int creditModifier;

    final Integer debt = null;
    final Integer segment_1 = 100;
    final Integer segment_2 = 300;
    final Integer segment_3 = 1000;


    public CustomerSegment(int creditModifier) {
        this.creditModifier = creditModifier;
    }

    public int getCreditModifier() {
        return creditModifier;
    }
}
