package org.katas.discount.impl;

import org.katas.discount.DiscountStrategy;

public class NoDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double currentPrice) {
        return currentPrice;
    }
}
