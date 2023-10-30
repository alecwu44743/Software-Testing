package org.example;

import java.text.DecimalFormat;
public class Currency {
    double amount;
    String currency;

    public Currency(double _amount, String _currency) {
        this.amount = _amount;
        this.currency = _currency;
    }

    public Currency add(Currency other) {
        // this.currency = "USD"; -> should change to "USD" then sum up, NTD / 30 -> USD
        // other.currency = "NTD"; -> should change to "NTD" then sum up, USD * 30 -> NTD

        if (this.currency.equals("USD") && other.currency.equals("NTD")) { // this.currency == "USD" && other.currency == "NTD"
            return new Currency(this.amount + other.amount / 30, "USD");
        } else if (this.currency.equals("NTD") && other.currency.equals("USD")) { // this.currency == "NTD" && other.currency == "USD"
            return new Currency(this.amount + other.amount * 30, "NTD");
        } else { // this.currency == other.currency
            return new Currency(this.amount + other.amount, this.currency);
        }
    }

    public String myCurrency() {
        DecimalFormat df = new DecimalFormat("0.00");
        String correctAmount = df.format(this.amount);

        return "Amount: " + correctAmount + " " + this.currency;
    }
}
