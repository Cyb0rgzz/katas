package org.katas.discount.impl;

import org.katas.discount.DiscountStrategy;

public class PercentageDiscount implements DiscountStrategy {
    private final double discountRate;

    public PercentageDiscount(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double applyDiscount(double currentPrice) {
        return currentPrice * (1 - discountRate);
    }
}
