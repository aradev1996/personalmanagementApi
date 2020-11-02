package com.technikum.personalmanagement.validator;

import com.technikum.personalmanagement.UnitTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("urlaub start end date counter test")
class UrlaubStartEndDateCounterTest extends UnitTestBase {

    UrlaubStartEndDateCounter testable = new UrlaubStartEndDateCounter();

    @Test
    @DisplayName("get days")
    public void _1() {
        int days = testable.getDays(LocalDate.parse("2020-11-03"), LocalDate.parse("2020-11-12"));

        assertEquals(8, days);
    }
}
