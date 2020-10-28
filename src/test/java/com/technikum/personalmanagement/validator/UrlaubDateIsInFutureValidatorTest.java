package com.technikum.personalmanagement.validator;

import com.technikum.personalmanagement.UnitTestBase;
import com.technikum.personalmanagement.entity.UrlaubEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("urlaub date validator test")
class UrlaubDateIsInFutureValidatorTest extends UnitTestBase {

    UrlaubDateIsInFutureValidator testable = new UrlaubDateIsInFutureValidator();

    @Test
    @DisplayName("validate: success")
    public void _1() {
        UrlaubEntity urlaubEntity = randomizer().createRandomObject(UrlaubEntity.class);
        urlaubEntity.setStartDate(LocalDate.now().plusDays(1));
        urlaubEntity.setEndDate(LocalDate.now().plusDays(1));

        testable.validate(urlaubEntity);
    }

    @Test
    @DisplayName("validate: start date is in past, should throw exception")
    public void _2() {
        UrlaubEntity urlaubEntity = randomizer().createRandomObject(UrlaubEntity.class);
        urlaubEntity.setStartDate(LocalDate.now().minusDays(1));
        urlaubEntity.setEndDate(LocalDate.now().plusDays(1));

        assertThrows(IllegalArgumentException.class, () -> testable.validate(urlaubEntity));
    }

    @Test
    @DisplayName("validate: end date is in past, should throw exception")
    public void _3() {
        UrlaubEntity urlaubEntity = randomizer().createRandomObject(UrlaubEntity.class);
        urlaubEntity.setStartDate(LocalDate.now().plusDays(1));
        urlaubEntity.setEndDate(LocalDate.now().minusDays(1));

        assertThrows(IllegalArgumentException.class, () -> testable.validate(urlaubEntity));
    }
}
