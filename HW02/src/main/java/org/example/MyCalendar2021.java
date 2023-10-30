package org.example;

import java.text.SimpleDateFormat; // use SimpleDateFormat to format date
import java.util.Calendar; // use Calendar to get day of week
import java.util.Date; // use Date to format date

public class MyCalendar2021 {

    public String myDays(int month, int day){
        Calendar calendar = Calendar.getInstance(); // construct a Calendar instance
//        int currentYear = calendar.get(Calendar.YEAR);

        Calendar selectedDate = Calendar.getInstance();
        selectedDate.set(2021, month - 1, day); // set year, month, day, month - 1 because month starts from 0

        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE"); // format day of week to "EEEE" -> "Monday"
        Date date = selectedDate.getTime(); // convert Calendar to Date
        String dayOfWeek = dayFormat.format(date); // format date to day of week

        return dayOfWeek;
    }
}
