package com.technikum.personalmanagement.converter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class DateConverter {

    private static final Logger log = LogManager.getLogger(DateConverter.class);

    private static final DateTimeFormatter DATE_FORMAT_PATTERN_1 = new DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM-dd").toFormatter();

    private static final DateTimeFormatter DATE_FORMAT_PATTERN_2 = new DateTimeFormatterBuilder()
            .appendPattern("yyyy MM dd").toFormatter();

    private static final DateTimeFormatter DATE_FORMAT_PATTERN_3 = new DateTimeFormatterBuilder()
            .appendPattern("yyyy MM").parseDefaulting(ChronoField.DAY_OF_MONTH, 1).toFormatter();

    private static final DateTimeFormatter DATE_FORMAT_PATTERN_4 = new DateTimeFormatterBuilder()
            .appendPattern("yyyy").parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1).toFormatter();

    private static final DateTimeFormatter DATE_FORMAT_PATTERN_5 = new DateTimeFormatterBuilder()
            .appendPattern("dd.MM.yyyy").toFormatter();

    private static final List<DateTimeFormatter> DATETIME_FORMATTERS = Arrays
            .asList(DATE_FORMAT_PATTERN_1, DATE_FORMAT_PATTERN_2, DATE_FORMAT_PATTERN_3,
                    DATE_FORMAT_PATTERN_4, DATE_FORMAT_PATTERN_5);

    public String convertToDefaultDateTimeFormat(LocalDateTime localDateTime) {
        return localDateTime.format(DATE_FORMAT_PATTERN_2);
    }

    public LocalDate convert(String dateAsString) {
        Assert.hasText(dateAsString, "dateAsString may not be null or empty");

        for (DateTimeFormatter formatter : DATETIME_FORMATTERS) {
            Optional<LocalDate> localDate = parseDate(dateAsString, formatter);
            if (localDate.isPresent()) {
                return localDate.get();
            }
        }

        return handleNoPatternMatched(dateAsString);
    }

    public LocalDateTime convertToLocalDateTime(String dateAsString) {
        LocalDate localDate = convert(dateAsString);

        return localDate.atStartOfDay();
    }

    private Optional<LocalDate> parseDate(String dateAsString, DateTimeFormatter dateTimeFormatter) {
        try {
            return Optional.of(LocalDate.parse(dateAsString, dateTimeFormatter));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    private LocalDate handleNoPatternMatched(String dateString) {
        log.error("An error has occurred during the date time convert of '{}'", dateString);
        throw new DateConverterException(String.format("Convert of %s failed.", dateString));
    }
}
