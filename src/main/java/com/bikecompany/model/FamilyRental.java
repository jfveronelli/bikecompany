package com.bikecompany.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;

public class FamilyRental implements Rental {

    private static final BigDecimal DISCOUNT = new BigDecimal("0.3");

    private final List<SingleRental> rentals;

    public FamilyRental(final SingleRental ... rentals) {
        if (rentals.length < 3 || rentals.length > 5 || Arrays.stream(rentals).anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("A FamilyRental must include 3 to 5 rentals");
        }
        this.rentals = Collections.unmodifiableList(Arrays.asList(rentals));
    }

    public List<SingleRental> getRentals() {
        return rentals;
    }

    private BigDecimal getSubTotalPrice() {
        return rentals.stream().map(Rental::getTotalPrice).reduce(BigDecimal::add).orElse(ZERO);
    }

    @Override
    public BigDecimal getTotalPrice() {
        return getSubTotalPrice().multiply(ONE.subtract(DISCOUNT));
    }

}