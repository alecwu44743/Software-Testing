package org.example;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtendWith;



class MainTest {
    // print the pass or fail message abc

    Main main = new Main();

    @BeforeEach // To initialize the test
    void init() {
        main = new Main();
//        System.out.println("init");
        System.out.println("[>] Init MainTest\n");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("╯°□°）╯")
    void checkTriangle() {
        System.out.println("[+] Here is checkTriangle test");
        System.out.println("0 -> not a triangle");
        System.out.println("1 -> equilateral triangle");
        System.out.println("2 -> isosceles triangle");
        System.out.println("3 -> scalene triangle");

        int actualValue = main.checkTriangle(6, 6, 3);
        int expectedValue = 2;

        assertEquals(expectedValue, actualValue);

        assertEquals(1, main.checkTriangle(6, 6, 6), "Should be equilateral triangle");
        assertEquals(2, main.checkTriangle(6, 6, 3), "Should be isosceles triangle");
        assertEquals(3, main.checkTriangle(6, 5, 3), "Should be scalene triangle");
        assertEquals(3, main.checkTriangle(6, 3, 5), "Should be scalene triangle");
        assertEquals(1, main.checkTriangle(6, 6, 6), "Should be equilateral triangle");
        assertEquals(2, main.checkTriangle(6, 6, 3), "Should be isosceles triangle");
        assertEquals(0, main.checkTriangle(6, 6, 12), "Should be not a triangle");

        System.out.println("[v] checkTriangle test passed\n");
    }

    @org.junit.jupiter.api.Test
    void main() {
        System.out.println("[+] Here is main test for exception");

        Exception exception = assertThrows(Exception.class, () -> {
            main.numberCheck(-1);
        });
        System.out.println("Case #1: pass");
        System.out.println("Input is -1, " + "Exception message: " + exception.getMessage());

        exception = assertThrows(Exception.class, () -> {
            main.numberCheck(0);
        });
        System.out.println("Case #2: pass");
        System.out.println("Input is 0, " + "Exception message: " + exception.getMessage());

        System.out.println("[v] main test passed");
    }
}