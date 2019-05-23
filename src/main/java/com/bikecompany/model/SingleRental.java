package com.bikecompany.model;

import java.math.BigDecimal;

public class SingleRental implements Rental {

    private final BillingRate billingRate;
    private final int timeAmount;

    public SingleRental(final BillingRate billingRate, final int timeAmount) {
        if (billingRate == null) {
            throw new IllegalArgumentException("The billingRate cannot be null");
        }
        if (timeAmount <= 0) {
            throw new IllegalArgumentException("The timeAmount must be > 0");
        }
        this.billingRate = billingRate;
        this.timeAmount = timeAmount;
    }

    public BillingRate getBillingRate() {
        return billingRate;
    }

    public int getTimeAmount() {
        return timeAmount;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return billingRate.getPrice().multiply(BigDecimal.valueOf(timeAmount));
    }

}