package com.technikum.personalmanagement.validator;

import com.technikum.personalmanagement.UnitTestBase;
import com.technikum.personalmanagement.entity.UrlaubEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("UrlaubRemainingDaysValidatorTest")
class UrlaubRemainingDaysValidatorTest extends UnitTestBase {

    UrlaubRemainingDaysValidator testable = new UrlaubRemainingDaysValidator(new UrlaubStartEndDateCounter());

    @Test
    @DisplayName("validate: success")
    public void _1() {
        UrlaubEntity urlaubEntity = randomizer().createRandomObject(UrlaubEntity.class);
        urlaubEntity.setStartDate(LocalDate.now().plusDays(1));
        urlaubEntity.setEndDate(LocalDate.now().plusDays(10));
        urlaubEntity.getPerson().setHolidayDays(10);

        testable.validate(urlaubEntity);
    }

    @Test
    @DisplayName("validate: remaining days are shorter, should throw")
    public void _2() {
        UrlaubEntity urlaubEntity = randomizer().createRandomObject(UrlaubEntity.class);
        urlaubEntity.setStartDate(LocalDate.now().plusDays(1));
        urlaubEntity.setEndDate(LocalDate.now().plusDays(10));
        urlaubEntity.getPerson().setHolidayDays(2);


        assertThrows(IllegalArgumentException.class, () -> testable.validate(urlaubEntity));
    }
}
