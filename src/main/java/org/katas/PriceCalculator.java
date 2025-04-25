package org.katas;

public class PriceCalculator {

    private static final double BOOK_PRICE = 50.0;

    public double calculatePrice(BookBasket basket) {
        return basket.getBookMap().values().stream().mapToInt(Integer::intValue).sum() * BOOK_PRICE;
    }
}
