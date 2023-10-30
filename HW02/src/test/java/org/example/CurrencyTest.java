package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyTest {

    @ParameterizedTest
    @CsvSource({
            "USD, 100, NTD, 3000, USD, 200",
            "NTD, 3000, USD, 100, NTD, 6000",
            "NTD, 2650, NTD, 2650, NTD, 5300",
            "USD, 100, USD, 100, USD, 200",
            "USD, 100, NTD, 3000, USD, 200",
    })
    void add(String currency1, double amount1, String currency2, double amount2, String resCurrency, double resAmount) {
        Currency currency = new Currency(amount1, currency1);
        Currency currencyOther = new Currency(amount2, currency2);
        Currency res = currency.add(currencyOther);
        assertEquals(resCurrency, res.currency);
        assertEquals(resAmount, res.amount);
    }

    @ParameterizedTest
    @CsvSource({
            "USD, 100, Amount: 100.00 USD",
            "NTD, 3000, Amount: 3000.00 NTD",
            "NTD, 2650.79, Amount: 2650.79 NTD",
    })
    void myCurrency(String currency, double amount, String res) {
        Currency currency1 = new Currency(amount, currency);
        assertEquals(res, currency1.myCurrency());
    }
}