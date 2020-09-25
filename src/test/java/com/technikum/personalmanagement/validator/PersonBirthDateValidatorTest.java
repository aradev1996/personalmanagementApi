package com.technikum.personalmanagement.validator;


import com.technikum.personalmanagement.UnitTestBase;
import com.technikum.personalmanagement.entity.PersonEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("person birth date validator")
class PersonBirthDateValidatorTest extends UnitTestBase {

    PersonBirthDateValidator testable = new PersonBirthDateValidator();

    @Test
    @DisplayName("validate: older than 14")
    public void _1() {
        PersonEntity personEntity = randomizer().createRandomObject(PersonEntity.class);
        personEntity.setBirthDate(LocalDate.parse("2000-01-01"));

        testable.validate(personEntity);
    }

    @Test
    @DisplayName("validate: younger than 14, should throw exception")
    public void _2() {
        PersonEntity personEntity = randomizer().createRandomObject(PersonEntity.class);
        personEntity.setBirthDate(LocalDate.now());

        assertThrows(IllegalArgumentException.class, () -> testable.validate(personEntity));
    }

}
