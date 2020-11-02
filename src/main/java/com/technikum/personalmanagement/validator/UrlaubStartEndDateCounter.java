package com.technikum.personalmanagement.validator;

import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Component
public class UrlaubStartEndDateCounter {

    public int getDays(LocalDate start, LocalDate end) {
        if (start.getDayOfWeek() == DayOfWeek.SATURDAY ||
                start.getDayOfWeek() == DayOfWeek.SUNDAY) {
            start = start.plusWeeks(1).with(DayOfWeek.MONDAY);
        }

        int count = 1;
        while (start.isBefore(end)) {
            count++;
            if (start.getDayOfWeek() == DayOfWeek.FRIDAY)
                start = start.plusDays(3);
            else
                start = start.plusDays(1);
        }

        return count;
    }
}
