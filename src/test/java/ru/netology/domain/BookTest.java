package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {
    @Test
    public void shouldCheckMatchesWhenNameIsTrue() {
        Book book = new Book(1, "Cien anos de soledad", 1740, "Маркес Габриэль Гарсиа");
        boolean actual = book.matches("Cien");
        assertEquals(true, actual);
    }

    @Test
    public void shouldCheckMatchesWhenNameIsFalseAuthorIsTrue() {
        Book book = new Book(2, "El doble", 880, "Достоевский Федор Михайлович");
        boolean actual = book.matches("Михайлович");
        assertEquals(true, actual);
    }

    @Test
    public void shouldCheckMatchesWhenNameIsFalseAuthorIsFalse() {
        Book book = new Book(3, "Blade", 999, "Marvel Comics");
        boolean actual = book.matches("amarillo");
        assertEquals(false, actual);
    }
}