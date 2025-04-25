package org.katas;

import org.junit.Before;
import org.junit.Test;
import org.katas.discount.DiscountStrategyFactory;
import org.katas.model.BookBasket;
import org.katas.model.BookTitle;
import org.katas.pricecalcservice.PriceCalculator;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PriceCalculatorTest {

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
        assertEquals(95.0, price, 0.0); // 5% discount
    }

    @Test
    public void testThreeDifferentBooksDiscount() {
        Map<BookTitle, Integer> bookMap = new HashMap<>();
        bookMap.put(BookTitle.CLEAN_CODE, 1);
        bookMap.put(BookTitle.THE_CLEAN_CODER, 1);
        bookMap.put(BookTitle.CLEAN_ARCHITECTURE, 1);

        BookBasket basket = new BookBasket(bookMap);

        double price = calculator.calculatePrice(basket);

        assertEquals(135.0, price, 0.0); // 10% discount
    }

    @Test
    public void testFourDifferentBooksDiscount() {
        Map<BookTitle, Integer> bookMap = new HashMap<>();
        bookMap.put(BookTitle.CLEAN_CODE, 1);
        bookMap.put(BookTitle.THE_CLEAN_CODER, 1);
        bookMap.put(BookTitle.CLEAN_ARCHITECTURE, 1);
        bookMap.put(BookTitle.TDD_BY_EXAMPLE, 1);

        BookBasket basket = new BookBasket(bookMap);

        double price = calculator.calculatePrice(basket);

        assertEquals(160, price, 0.0); // 20% discount
    }

    @Test
    public void testFiveDifferentBooksDiscount() {
        Map<BookTitle, Integer> bookMap = new HashMap<>();
        bookMap.put(BookTitle.CLEAN_CODE, 1);
        bookMap.put(BookTitle.THE_CLEAN_CODER, 1);
        bookMap.put(BookTitle.CLEAN_ARCHITECTURE, 1);
        bookMap.put(BookTitle.TDD_BY_EXAMPLE, 1);
        bookMap.put(BookTitle.WORKING_WITH_LEGACY_CODE, 1);

        BookBasket basket = new BookBasket(bookMap);

        double price = calculator.calculatePrice(basket);

        assertEquals(187.50, price, 0.0); //25% discount
    }

    //@Test
    public void testMultipleBooksDiscount(){
        Map<BookTitle, Integer> bookMap = new HashMap<>();
        bookMap.put(BookTitle.CLEAN_CODE, 2);
        bookMap.put(BookTitle.THE_CLEAN_CODER, 2);
        bookMap.put(BookTitle.CLEAN_ARCHITECTURE, 2);
        bookMap.put(BookTitle.TDD_BY_EXAMPLE, 1);

        BookBasket basket = new BookBasket(bookMap);

        double price = calculator.calculatePrice(basket);

        assertEquals(280, price, 0.0);
    }

    @Test
    public void testEmptyBasket() {
        Map<BookTitle, Integer> bookMap = new HashMap<>();
        BookBasket basket = new BookBasket(bookMap);
        double price = calculator.calculatePrice(basket);

        assertEquals(0.0, price, 0.0);
    }

    @Test
    public void testNullBasket() {
        Map<BookTitle, Integer> bookMap = null;
        Exception exception = assertThrows(NullPointerException.class, () -> {
            BookBasket basket = new BookBasket(bookMap);
        });

        assertNotNull(exception, "A null book map should throw a NullPointerException.");
    }


}
