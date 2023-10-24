package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void addOne(int v) {
        Calculator c = new Calculator();
        assertEquals(v + 1, c.add(v, 1));
    }

    @ParameterizedTest
    @NullSource // -> 1
    @EmptySource // -> 2
    @ValueSource(strings = { " ", "   ", "\t", "\n" }) // -> 3-6
    void nullEmptyAndBlankStrings(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }

    @ParameterizedTest
    @CsvSource({
            "apple,         1",
            "banana,        2",
            "'lemon, lime', 0xF1",
            "strawberry,    700_000"
    })
    void testWithCsvSource(String fruit, int rank) {
        assertNotNull(fruit);
        assertNotEquals(0, rank);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "-1, 1, 0",
            "1, -1, 0",
            "-1, -2, -3"
    })
    void addTest(int a, int b, int c) {
        Calculator calculator = new Calculator();
        assertEquals(c, calculator.add(a, b));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testfile.csv", numLinesToSkip = 1)
    void addTest_withfile(int a, int b, int c) {
        Calculator calculator = new Calculator();
        assertEquals(c, calculator.add(a, b));
    }
}