package com.technikum.personalmanagement.validator;

import com.technikum.personalmanagement.UnitTestBase;
import com.technikum.personalmanagement.entity.PersonEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("person required fields set validator")
class PersonRequiredFieldsSetValidatorTest extends UnitTestBase {

    PersonRequiredFieldsSetValidator testable = new PersonRequiredFieldsSetValidator();

    @Test
    @DisplayName("all fields set")
    public void _1() {
        PersonEntity personEntity = randomizer().createRandomObject(PersonEntity.class);

        testable.validate(personEntity);
    }

    @Test
    @DisplayName("id: null, should throw excpetion")
    public void _2() {
        PersonEntity personEntity = randomizer().createRandomObject(PersonEntity.class);
        personEntity.setId(null);

        assertThrows(IllegalArgumentException.class, () -> testable.validate(personEntity));
    }

    @Test
    @DisplayName("adress: null, should throw excpetion")
    public void _3() {
        PersonEntity personEntity = randomizer().createRandomObject(PersonEntity.class);
        personEntity.setAdress(null);

        assertThrows(IllegalArgumentException.class, () -> testable.validate(personEntity));
    }

    @Test
    @DisplayName("birthdate: null, should throw excpetion")
    public void _4() {
        PersonEntity personEntity = randomizer().createRandomObject(PersonEntity.class);
        personEntity.setBirthDate(null);

        assertThrows(IllegalArgumentException.class, () -> testable.validate(personEntity));
    }

    @Test
    @DisplayName("firstname: null, should throw excpetion")
    public void _5() {
        PersonEntity personEntity = randomizer().createRandomObject(PersonEntity.class);
        personEntity.setFirstName(null);

        assertThrows(IllegalArgumentException.class, () -> testable.validate(personEntity));
    }

    @Test
    @DisplayName("lastname: null, should throw excpetion")
    public void _6() {
        PersonEntity personEntity = randomizer().createRandomObject(PersonEntity.class);
        personEntity.setLastName(null);

        assertThrows(IllegalArgumentException.class, () -> testable.validate(personEntity));
    }

    @Test
    @DisplayName("recordingdate: null, should throw excpetion")
    public void _7() {
        PersonEntity personEntity = randomizer().createRandomObject(PersonEntity.class);
        personEntity.setRecordingDate(null);

        assertThrows(IllegalArgumentException.class, () -> testable.validate(personEntity));
    }

    @Test
    @DisplayName("status: null, should throw excpetion")
    public void _8() {
        PersonEntity personEntity = randomizer().createRandomObject(PersonEntity.class);
        personEntity.setStatus(null);

        assertThrows(IllegalArgumentException.class, () -> testable.validate(personEntity));
    }

    @Test
    @DisplayName("salary: null, should throw excpetion")
    public void _9() {
        PersonEntity personEntity = randomizer().createRandomObject(PersonEntity.class);
        personEntity.setSalary(null);

        assertThrows(IllegalArgumentException.class, () -> testable.validate(personEntity));
    }

}
