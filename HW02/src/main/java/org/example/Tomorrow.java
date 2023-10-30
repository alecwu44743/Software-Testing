package org.example;

import java.time.LocalDate; // use LocalDate to parse inputDate
import java.time.format.DateTimeFormatter; // use DateTimeFormatter to format date

public class Tomorrow {
    public String nextDay(String inputDate) {
        // use LocalDate to parse inputDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // format inputDate to yyyy-MM-dd
        LocalDate date = LocalDate.parse(inputDate, formatter); // parse inputDate to LocalDate

        // add one day to inputDate
        LocalDate nextDay = date.plusDays(1); // add one day to inputDate

        // format outputDate to yyyy-MM-dd, and return
        String outputDate = nextDay.format(formatter); // format nextDay to yyyy-MM-dd
        return outputDate;
    }
}
