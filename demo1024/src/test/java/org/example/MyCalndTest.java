package org.example;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;
class MyCalndTest {

    @ParameterizedTest
    @CsvSource({
            "12, 20, 星期一",
            "12, 21, 星期二",
            "12, 22, 星期三",
            "12, 25, 星期六",
    })
    void myDaysTest(int month, int day, String res) {
        MyCalnd myCalnd = new MyCalnd();
        assertEquals(res, myCalnd.myDays(month, day));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/daytest.csv", numLinesToSkip = 1)
    void myDaysTest_withfile(int m, int n, String res) {
        MyCalnd myCalnd = new MyCalnd();
        assertEquals(res, myCalnd.myDays(m, n));
    }
}