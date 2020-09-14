package com.technikum.personalmanagement.converter;


import com.technikum.personalmanagement.UnitTestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("date converter")
class DateConverterTest extends UnitTestBase {

    final DateConverter testable = new DateConverter();

    @DisplayName("convert")
    @ParameterizedTest
    @EnumSource(value = TestData.class)
    public void _1(TestData testData) {
        if (!testData.shouldThrow()) {
            assertValue(testData);
        } else {
            assertException(testData);
        }
    }

    @Test
    @DisplayName("convert: should throw when null")
    public void _2() {
        assertThrows(IllegalArgumentException.class, () -> testable.convert(null));
    }

    @Test
    @DisplayName("convert: should throw when empty")
    public void _3() {
        assertThrows(IllegalArgumentException.class, () -> testable.convert(""));
    }

    private void assertValue(TestData testData) {
        assertEquals(testData.getExpected(), testable.convert(testData.getInput()));
    }

    private void assertException(TestData testData) {
        assertThrows(DateConverterException.class, () -> testable.convert(testData.getInput()));
    }

    enum TestData {
        _2000_01_12("2000-01-12", LocalDate.parse("2000-01-12"), false),
        _2020_01_15("2020 01 15", LocalDate.parse("2020-01-15"), false),
        _2010_05("2010 05", LocalDate.parse("2010-05-01"), false),
        _2018("2018", LocalDate.parse("2018-01-01"), false),
        _05_05_2015("05.05.2015", LocalDate.parse("2015-05-05"), false),
        _INVALID_1("05_05_2015", null, true),
        _INVALID_2("04 01", null, true);

        private final String input;

        private final LocalDate expected;

        private final boolean shouldThrow;

        TestData(String input, LocalDate expected, boolean shouldThrow) {
            this.input = input;
            this.expected = expected;
            this.shouldThrow = shouldThrow;
        }

        public String getInput() {
            return input;
        }

        public LocalDate getExpected() {
            return expected;
        }

        public boolean shouldThrow() {
            return shouldThrow;
        }
    }
}
