package org.example;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtendWith;



class MainTest {
    // print the pass or fail message
    public static void printPassOrFail(
            int expectedValue, int actualValue, int caseNumber,
            int sideA, int sideB, int sideC) {
        if (expectedValue == actualValue) { // if the test passes, print pass
            System.out.println("Case #" + caseNumber + ": pass");
        } else { // if the test fails, print fail
            System.out.println("Case #" + caseNumber + ": fail");
        }

        // print the expected and actual values, and the three sides
        System.out.println("side a: " + sideA + ", side b: " + sideB + ", side c: " + sideC);
        System.out.println("Expected: " + expectedValue + ", Actual: " + actualValue);
        System.out.println();
    }

    Main main = new Main();

    @BeforeEach // To initialize the test
    void init() {
        main = new Main();
//        System.out.println("init");
        System.out.println("[>] Init MainTest");
    }

    @org.junit.jupiter.api.Test
    void checkTriangle() {
        System.out.println("Here is checkTriangle test\n");
        System.out.println("1 -> equilateral triangle");
        System.out.println("2 -> isosceles triangle");
        System.out.println("3 -> scalene triangle");
        System.out.println();

        int actualValue = main.checkTriangle(6, 6, 3);
        int expectedValue = 2;

        assertEquals(expectedValue, actualValue);

        assertEquals(1, main.checkTriangle(6, 6, 6), "Should be equilateral triangle");
        // print pass message if the test passes
        printPassOrFail(1, main.checkTriangle(6, 6, 6), 1, 6, 6, 6);

        assertEquals(2, main.checkTriangle(6, 6, 3), "Should be isosceles triangle");
        printPassOrFail(2, main.checkTriangle(6, 6, 3), 2, 6, 6, 3);

        assertEquals(3, main.checkTriangle(6, 5, 3), "Should be scalene triangle");
        printPassOrFail(3, main.checkTriangle(6, 5, 3), 3, 6, 5, 3);

        assertEquals(3, main.checkTriangle(6, 3, 5), "Should be scalene triangle");
        printPassOrFail(3, main.checkTriangle(6, 3, 5), 4, 6, 3, 5);

        assertEquals(1, main.checkTriangle(6, 6, 6), "Should be equilateral triangle");
        printPassOrFail(1, main.checkTriangle(6, 6, 6), 5, 6, 6, 6);

        assertEquals(2, main.checkTriangle(6, 6, 3), "Should be isosceles triangle");
        printPassOrFail(2, main.checkTriangle(6, 6, 3), 6, 6, 6, 3);
    }

    @org.junit.jupiter.api.Test
    void main() {
        System.out.println("Here is main test for exception\n");

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
    }
}