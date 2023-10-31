package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MyCalendar2021Test {

    @DisplayName("Test for myDays using csvSource")
    @ParameterizedTest(name = "{index} => month={0}, day={1}, res={2}")
    @CsvSource({
            "1, 1, 星期五",
            "2, 4, 星期四",
            "3, 1, 星期一",
            "12, 20, 星期一",
            "12, 21, 星期二",
            "12, 22, 星期三",
            "12, 25, 星期六",
    })
    void test_myDays(int mon, int day, String res) { // test for myDays using csvSource
        MyCalendar2021 myCalendar2021 = new MyCalendar2021();
        assertEquals(res, myCalendar2021.myDays(mon, day));
    }

    @DisplayName("Test for myDays using csvFileSource")
    @ParameterizedTest(name = "{index} => month={0}, day={1}, res={2}")
    @CsvFileSource(resources = "/test_myDays.csv", numLinesToSkip = 1)
    void test_myDays_withfile(int mon, int day, String res) { // test for myDays using csvFileSource 
        MyCalendar2021 myCalendar2021 = new MyCalendar2021();
        assertEquals(res, myCalendar2021.myDays(mon, day));
    }
}