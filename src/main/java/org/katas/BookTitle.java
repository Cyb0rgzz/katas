package org.katas;

public enum BookTitle {
    CLEAN_CODE("Clean Code"),
    THE_CLEAN_CODER("The Clean Coder"),
    CLEAN_ARCHITECTURE("Clean Architecture"),
    TDD_BY_EXAMPLE("Test Driven Development by Example"),
    WORKING_WITH_LEGACY_CODE("Working Effectively With Legacy Code");

    private final String title;

    BookTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
