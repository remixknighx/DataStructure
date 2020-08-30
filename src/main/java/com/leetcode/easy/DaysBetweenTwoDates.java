package com.leetcode.easy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * [1360] Number of Days Between Two Dates
 * @link https://leetcode.com/problems/number-of-days-between-two-dates/description/
 */
public class DaysBetweenTwoDates {

    public int daysBetweenDates(String date1, String date2) {
        DateTimeFormatter defaultDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse(date1, defaultDateFormat);
        LocalDate localDate2 = LocalDate.parse(date2, defaultDateFormat);
        LocalDate firstDate = null;
        LocalDate secondDate = null;
        if (localDate1.isBefore(localDate2)) {
            firstDate = localDate1;
            secondDate = localDate2;
        } else {
            firstDate = localDate2;
            secondDate = localDate1;
        }
        int betweenDays = 0;
        if (firstDate.getYear() != secondDate.getYear()) {
            betweenDays += secondDate.getDayOfYear();
            if (firstDate.isLeapYear()) {
                betweenDays += (366 - firstDate.getDayOfYear());
            } else {
                betweenDays += (365 - firstDate.getDayOfYear());
            }
            for (int i = firstDate.getYear()+1; i < secondDate.getYear(); i++) {
                if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                    betweenDays += 366;
                } else {
                    betweenDays += 365;
                }
            }
        } else {
            // 同一年
            betweenDays = secondDate.getDayOfYear() - firstDate.getDayOfYear();
        }
        return betweenDays;
    }

}
