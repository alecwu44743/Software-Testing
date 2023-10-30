package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tomorrow {
    public String nextDay(String inputDate) {
        // use LocalDate to parse inputDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(inputDate, formatter);

        // add one day to inputDate
        LocalDate nextDay = date.plusDays(1);

        // format outputDate to yyyy-MM-dd, and return
        String outputDate = nextDay.format(formatter);
        return outputDate;
    }
}
