package org.katas;

public enum BookDiscount {
    NONE(0.0),
    TWO_BOOKS(0.05);

    private final double discountRate;

    BookDiscount(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public static BookDiscount determineDiscount(int uniqueBooks) {
        return switch (uniqueBooks) {
            case 2 -> TWO_BOOKS;
            default -> NONE;
        };
    }
}
