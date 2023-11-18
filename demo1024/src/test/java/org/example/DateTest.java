package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void testTommorow1() {
        Date date = new Date(2020, 12, 20);
        Date exp = new Date(2020, 12, 21);
        assertEquals(exp.toString(), date.tomorrow().toString());
    }

    @Test
    void tomorrow() {
        Date date = new Date(2020, 12, 31);
        Date exp = new Date(2021, 1, 1);
        assertEquals(exp.toString(), date.tomorrow().toString());
    }

    @Test
    void testLeapYear(){
        Date date = new Date(2020, 2, 28);
        Date exp = new Date(2020, 2, 29);
        assertEquals(exp.toString(), date.tomorrow().toString());
    }

    @Test
    void testNewMonth(){
        Date date = new Date(2020, 1, 31);
        Date exp = new Date(2020, 2, 1);
        assertEquals(exp.toString(), date.tomorrow().toString());
    }

    @Test
    void testNewYear(){
        Date date = new Date(2020, 12, 31);
        Date exp = new Date(2021, 1, 1);
        assertEquals(exp.toString(), date.tomorrow().toString());
    }

    @Test
    void testGetYear(){
        Date date = new Date(2020, 12, 31);
        Date exp = new Date(2020, 12, 31);
        assertEquals(exp.getYear(), date.getYear());
    }

    @Test
    void testGetMonth(){
        Date date = new Date(2020, 12, 31);
        Date exp = new Date(2020, 12, 31);
        assertEquals(exp.getMonth(), date.getMonth());
    }

    @Test
    void testGetDay(){
        Date date = new Date(2020, 12, 31);
        Date exp = new Date(2020, 12, 31);
        assertEquals(exp.getDay(), date.getDay());
    }
}