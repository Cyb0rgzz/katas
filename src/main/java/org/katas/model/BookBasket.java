package org.katas.model;

import java.util.HashMap;
import java.util.Map;

public class BookBasket {
    private final Map<BookTitle, Integer> bookMap;

    public BookBasket(Map<BookTitle, Integer> bookMap) {
        this.bookMap = new HashMap<>(bookMap);
    }

    public Map<BookTitle, Integer> getBookMap() {
        return new HashMap<>(bookMap);
    }
}