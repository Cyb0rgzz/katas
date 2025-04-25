package org.katas;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestBookDiscountCalculator {

    private PriceCalculator calculator;

    @Before
    public void setup() {
        DiscountStrategyFactory factory = new DiscountStrategyFactory();
        calculator = new PriceCalculator(factory);
    }

    @Test
    public void testSingleBookNoDiscount() {
        Map<BookTitle, Integer> bookMap = new HashMap<>();
        bookMap.put(BookTitle.CLEAN_CODE, 1);
        BookBasket basket = new BookBasket(bookMap);

        double price = calculator.calculatePrice(basket);

        assertEquals(50.0, price, 0.0);
    }

    @Test
    public void testTwoIdenticalBooksNoDiscount() {
        Map<BookTitle, Integer> bookMap = new HashMap<>();
        bookMap.put(BookTitle.CLEAN_CODE, 2);
        BookBasket basket = new BookBasket(bookMap);

        double price = calculator.calculatePrice(basket);

        assertEquals(100.0, price, 0.0);
    }

    @Test
    public void testTwoDifferentBooksDiscount() {
        Map<BookTitle, Integer> bookMap = new HashMap<>();
        bookMap.put(BookTitle.CLEAN_CODE, 1);
        bookMap.put(BookTitle.THE_CLEAN_CODER, 1);
        BookBasket basket = new BookBasket(bookMap);

        double price = calculator.calculatePrice(basket);
        assertEquals(95.0, price, 0.0); // 5% discount on 100
    }

    @Test
    public void testThreeDifferentBooksDiscount() {
        Map<BookTitle, Integer> bookMap = new HashMap<>();
        bookMap.put(BookTitle.CLEAN_CODE, 1);
        bookMap.put(BookTitle.THE_CLEAN_CODER, 1);
        bookMap.put(BookTitle.CLEAN_ARCHITECTURE, 1);

        BookBasket basket = new BookBasket(bookMap);

        double price = calculator.calculatePrice(basket);

        assertEquals(135.0, price, 0.0);
    }


}
