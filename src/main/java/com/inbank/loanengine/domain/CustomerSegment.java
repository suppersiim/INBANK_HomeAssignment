package com.inbank.loanengine.domain;

public class CustomerSegment {

    private final int creditModifier;
/*
    final int debt = 0;
    final int segment_1 = 100;
    final int segment_2 = 300;
    final int segment_3 = 1000;
*/

    public CustomerSegment(int creditModifier) {
        this.creditModifier = creditModifier;
    }

    public int getCreditModifier() {
        return creditModifier;
    }
}
