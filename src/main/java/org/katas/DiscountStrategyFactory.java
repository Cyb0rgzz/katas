package org.katas;

import java.util.Map;

public class DiscountStrategyFactory {

    public DiscountStrategy createStrategy(Map<BookTitle, Integer> bookMap) {
        int uniqueBooks = bookMap.size();
        BookDiscount discount = BookDiscount.determineDiscount(uniqueBooks);
        return discount.getDiscountRate() == 0.0 ? new NoDiscount() : new PercentageDiscount(discount.getDiscountRate());
    }
}