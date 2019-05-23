package com.bikecompany.model;

import org.junit.Test;

import java.math.BigDecimal;

import static com.bikecompany.model.BillingRate.DAILY;
import static com.bikecompany.model.BillingRate.HOURLY;
import static org.junit.Assert.assertEquals;

public class SingleRentalTest {

    @Test(expected = IllegalArgumentException.class)
    public void newSingleRentalMustThrowIllegalArgumentExceptionWhenBillingRateIsNull() {
        new SingleRental(null, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newSingleRentalMustThrowIllegalArgumentExceptionWhenTimeAmountIsZero() {
        new SingleRental(HOURLY, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newSingleRentalMustThrowIllegalArgumentExceptionWhenTimeAmountIsNegative() {
        new SingleRental(HOURLY, -1);
    }

    @Test
    public void getTotalPriceMustUseBillingRate() {
        SingleRental rental = new SingleRental(DAILY, 10);

        BigDecimal totalPrice = rental.getTotalPrice();

        assertEquals(0, totalPrice.compareTo(new BigDecimal(200)));
    }

}