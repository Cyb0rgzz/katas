package org.katas;

public class NoDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double currentPrice) {
        return currentPrice;
    }
}
