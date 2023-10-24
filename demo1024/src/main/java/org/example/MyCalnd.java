package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class MyCalnd {
    public String myDays(int month, int day){
        Calendar calendar = Calendar.getInstance();
//        int currentYear = calendar.get(Calendar.YEAR);

        Calendar selectedDate = Calendar.getInstance();
        selectedDate.set(2021, month - 1, day);

        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");
        Date date = selectedDate.getTime();
        String dayOfWeek = dayFormat.format(date);

        return dayOfWeek;
    }
}
