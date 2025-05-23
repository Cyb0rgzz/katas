package org.katas.pricecalcservice;

import org.katas.discount.DiscountStrategy;
import org.katas.discount.DiscountStrategyFactory;
import org.katas.model.BookBasket;
import org.katas.model.BookTitle;

import java.util.Map;

public class PriceCalculator {

    private static final double BOOK_PRICE = 50.0;
    private final DiscountStrategyFactory discountStrategyFactory;

    public PriceCalculator(DiscountStrategyFactory discountStrategyFactory) {
        this.discountStrategyFactory = discountStrategyFactory;
    }

    public double calculatePrice(BookBasket basket) {
        Map<BookTitle, Integer> bookMap = basket.getBookMap();
        int totalBooks = bookMap.values().stream().mapToInt(Integer::intValue).sum();
        double basePrice = totalBooks * BOOK_PRICE;

        DiscountStrategy strategy = discountStrategyFactory.createStrategy(bookMap);
        return strategy.applyDiscount(basePrice);
    }
}
