package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void getYear() {
    }

    @Test
    void getMonth() {
    }

    @Test
    void getDay() {
    }

    @Test
    void tomorrow() {
        Date date = new Date(2020, 12, 31);
        Date exp = new Date(2021, 1, 1);
        assertEquals(exp.toString(), date.tomorrow().toString());
    }

    @Test
    void testToString() {
    }
}