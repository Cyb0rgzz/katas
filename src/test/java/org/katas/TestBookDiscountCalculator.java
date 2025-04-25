package org.katas;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestBookDiscountCalculator {
    @Test
    public void testSingleBookNoDiscount() {
        Map<BookTitle, Integer> bookMap = new HashMap<>();
        bookMap.put(BookTitle.CLEAN_CODE, 1);

        BookBasket basket = new BookBasket(bookMap);

        PriceCalculator calculator = new PriceCalculator();
        double price = calculator.calculatePrice(basket);

        assertEquals(50.0, price, 0.0);
    }

    @Test
    public void testTwoIdenticalBooksNoDiscount() {
        Map<BookTitle, Integer> bookMap = new HashMap<>();
        bookMap.put(BookTitle.CLEAN_CODE, 2);

        BookBasket basket = new BookBasket(bookMap);
        PriceCalculator calculator = new PriceCalculator();
        double price = calculator.calculatePrice(basket);

        assertEquals(100.0, price, 0.0);
    }

    @Test
    public void testTwoDifferentBooksDiscount() {
        Map<BookTitle, Integer> bookMap = new HashMap<>();
        bookMap.put(BookTitle.CLEAN_CODE, 1);
        bookMap.put(BookTitle.THE_CLEAN_CODER, 1);

        BookBasket basket = new BookBasket(bookMap);
        PriceCalculator calculator = new PriceCalculator();
        double price = calculator.calculatePrice(basket);

        assertEquals(95.0, price); // 5% discount on 100
    }
}
