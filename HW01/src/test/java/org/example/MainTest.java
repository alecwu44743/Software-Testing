package org.example;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;


class MainTest {

    Main main = new Main();

    @BeforeEach
    void init() {
        main = new Main();
//        System.out.println("init");
        System.out.println("Here is before each");
    }

    @org.junit.jupiter.api.Test
    void checkTriangle() {
        System.out.println("Here is plus test");
        int actualValue = main.checkTriangle(6, 6, 3);
        int expectedValue = 2;

        assertEquals(expectedValue, actualValue);
    }

    @org.junit.jupiter.api.Test
    void main() {
    }
}