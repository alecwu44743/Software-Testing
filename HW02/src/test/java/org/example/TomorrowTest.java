package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TomorrowTest {

    @ParameterizedTest
    @CsvSource({
            "2021-01-01, 2021-01-02",
            "2021-01-31, 2021-02-01",
            "2023-12-31, 2024-01-01",
            "2021-02-28, 2021-03-01",
    })
    void nextDay(String inputDate, String res) {
        Tomorrow tomorrow = new Tomorrow();
        assertEquals(res, tomorrow.nextDay(inputDate));
    }
}