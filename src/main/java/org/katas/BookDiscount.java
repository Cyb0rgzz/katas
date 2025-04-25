package org.katas;

public enum BookDiscount {
    NONE(0.0),
    TWO_BOOKS(0.05),
    THREE_BOOKS(0.10),
    FOUR_BOOKS(0.20),
    FIVE_BOOKS(0.25);

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
            case 3 -> THREE_BOOKS;
            case 4 -> FOUR_BOOKS;
            case 5 -> FIVE_BOOKS;
            default -> NONE;
        };
    }
}
