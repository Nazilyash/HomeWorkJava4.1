package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmartphoneTest {
    @Test
    public void shouldCheckMatchesWhenNameIsTrue() {
        Smartphone smartphone = new Smartphone(1, "Redmi 9C", 9690, "Xiaomi");
        boolean actual = smartphone.matches("Red");
        assertEquals(true, actual);
    }

    @Test
    public void shouldCheckMatchesWhenNameIsFalseManufacturerIsTrue() {
        Smartphone smartphone = new Smartphone(2, "Blade A3", 5390, "ZTE");
        boolean actual = smartphone.matches("Z");
        assertEquals(true, actual);
    }

    @Test
    public void shouldCheckMatchesWhenNameIsFalseManufacturerIsFalse() {
        Smartphone smartphone = new Smartphone(3, "Xperia 1", 53900, "Sony");
        boolean actual = smartphone.matches("uno");
        assertEquals(false, actual);
    }

}