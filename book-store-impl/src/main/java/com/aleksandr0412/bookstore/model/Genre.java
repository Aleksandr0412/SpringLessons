package com.aleksandr0412.bookstore.model;

/**
 * Представление жанров книги в системе
 */
public enum Genre {
    FANTASY,
    CLASSICS,
    DETECTIVE,
    HORROR,
    UNKNOWN;

    public static Genre of(String genre) {
        for(Genre g : Genre.values()) {
            if (g.name().equalsIgnoreCase(genre)) {
                return g;
            }
        }
        return UNKNOWN;
    }
}
