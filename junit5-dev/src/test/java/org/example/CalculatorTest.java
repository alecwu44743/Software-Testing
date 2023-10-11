package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator c;
    Person person = new Person("John", "Doe");

    @BeforeAll
    static void initAll() {
        System.out.println("Here is before all\n");
    }

    @BeforeEach
    void init() {
        c = new Calculator();
//        System.out.println("init");
        System.out.println("Here is before each");
    }

    @org.junit.jupiter.api.Test
    void plusTest() {
//        Calculator c = new Calculator();
        System.out.println("Here is plus test");
        int actualValue = c.plus(1, 2);
        int expectedValue = 3;
        assertEquals(expectedValue, actualValue);

        assertEquals(5, c.plus(1, 4));

        assertEquals(-1, c.plus(-1, 0));
    }

    @org.junit.jupiter.api.Test
    void multiplyTest() {
//        Calculator c = new Calculator();
        System.out.println("Here is multiply test");
        int actualValue = c.multiply(1, 2);
        int expectedValue = 2;
        assertEquals(expectedValue, actualValue);

        assertEquals(4, c.multiply(1, 4));

        assertEquals(0, c.multiply(-1, 0));


   }

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();

        System.out.println("Here is test addition");
        assertAll("Addition test",
                () -> assertEquals(2, calculator.plus(1, 1)),
                () -> assertEquals(5, calculator.plus(2, 3)),
                () -> assertEquals(7, calculator.plus(3, 4))
        );
    }
//    在 JUnit 中，assertAll() 方法是一個非常有用的斷言方法，
//    它用於同時執行多個斷言，並在所有斷言完成後報告所有失敗的斷言。
//    這對於進行多個相關斷言的測試非常有用，因為它可以讓你一次性檢查多個條件，而不需要分開處理每個斷言。

    @Test
    void dependentAssertions() {
        System.out.println("Here is dependent assertions");
        assertAll("properties",
                () -> {
                    String firstName = person.getFirstName();
                    assertNotNull(firstName);

                    assertAll("first name",
                            () -> assertTrue(firstName.startsWith("J")),
                            () -> assertTrue(firstName.endsWith("n"))
                    );
                },
                () -> {
                    String lastName = person.getLastName();
                    assertNotNull(lastName);

                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("D")),
                            () -> assertTrue(lastName.endsWith("e"))
                    );
                }
        );
    }


   @AfterEach
    void tearDown() {
         System.out.println("Here is after each\n");
    }
}