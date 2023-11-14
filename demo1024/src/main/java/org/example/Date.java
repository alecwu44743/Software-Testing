package org.example;

import org.apache.commons.lang3.StringUtils;

public class Date {
    private int y;
    private int m;
    private int d;

    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int y, int m, int d) {
        this.y = y;
        this.m = m;
        this.d = d;
    }

    public int getYear() {
        return y;
    }

    public int getMonth() {
        return m;
    }

    public int getDay() {
        return d;
    }

    public Date tomorrow() {
        int year = y;
        int month = m;
        int day = d + 1;

        int daysInCurrentMonth = daysInMonth(month, isLeapYear(year));

        if (day > daysInCurrentMonth) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }

        return new Date(year, month, day);
    }

    private int daysInMonth(int month, boolean isLeapYear) {
        if (month == 2 && isLeapYear) {
            return 29;
        } else {
            return DAYS_IN_MONTH[month];
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public String toString() {
        String[] r = {String.valueOf(y), String.valueOf(m), String.valueOf(d)};
        return StringUtils.join(r, "-");
    }
}
