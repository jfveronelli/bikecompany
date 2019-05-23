package com.bikecompany.model;

import org.junit.Test;

import java.math.BigDecimal;

import static com.bikecompany.model.BillingRate.DAILY;
import static com.bikecompany.model.BillingRate.HOURLY;
import static com.bikecompany.model.BillingRate.WEEKLY;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class FamilyRentalTest {

    @Test(expected = IllegalArgumentException.class)
    public void newFamilyRentalMustThrowIllegalArgumentExceptionWhenRentalsAreLessThan3() {
        new FamilyRental();
    }

    @Test(expected = IllegalArgumentException.class)
    public void newFamilyRentalMustThrowIllegalArgumentExceptionWhenRentalsAreMoreThan5() {
        SingleRental rental1 = createSingleRental();
        SingleRental rental2 = createSingleRental();
        SingleRental rental3 = createSingleRental();
        SingleRental rental4 = createSingleRental();
        SingleRental rental5 = createSingleRental();
        SingleRental rental6 = createSingleRental();

        new FamilyRental(rental1, rental2, rental3, rental4, rental5, rental6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newFamilyRentalMustThrowIllegalArgumentExceptionWhenARentalIsNull() {
        SingleRental rental1 = createSingleRental();
        SingleRental rental2 = createSingleRental();

        new FamilyRental(rental1, rental2, null);
    }

    @Test
    public void getTotalPriceMustAddPricesAndSubstractDiscount() {
        SingleRental rental1 = new SingleRental(HOURLY, 4);
        SingleRental rental2 = new SingleRental(DAILY, 3);
        SingleRental rental3 = new SingleRental(WEEKLY, 2);
        FamilyRental familyRental = new FamilyRental(rental1, rental2, rental3);

        BigDecimal totalPrice = familyRental.getTotalPrice();

        assertEquals(0, totalPrice.compareTo(new BigDecimal(140)));
    }

    private SingleRental createSingleRental() {
        return mock(SingleRental.class);
    }

}