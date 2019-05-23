package com.bikecompany.model;

import java.math.BigDecimal;

public enum BillingRate {

    HOURLY(BigDecimal.valueOf(5)),
    DAILY(BigDecimal.valueOf(20)),
    WEEKLY(BigDecimal.valueOf(60));

    private final BigDecimal price;

    BillingRate(final BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

}