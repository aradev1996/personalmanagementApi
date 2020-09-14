package com.technikum.personalmanagement.mapper;


import com.technikum.personalmanagement.UnitTestBase;
import com.technikum.personalmanagement.converter.DateConverter;
import com.technikum.personalmanagement.entity.PersonEntity;
import com.technikum.personalmanagement.model.PersonRequest;
import com.technikum.personalmanagement.model.PersonResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("person mapper")
class PersonMapperTest extends UnitTestBase {

    private final PersonMapper testable = new PersonMapper(new DateConverter());

    @Test
    @DisplayName("mapFromEntityToResponse")
    public void _1() {
        PersonEntity expected = randomizer().createRandomObject(PersonEntity.class);

        PersonResponse result = testable.mapFromEntityToResponse(expected);

        assertEquals(expected.getFirstName(), result.getFirstName());
        assertEquals(expected.getLastName(), result.getLastName());
        assertEquals(expected.getBirthDate().toString(), result.getBirthDate());
        assertEquals(expected.getLeavingDate().toString(), result.getLeavingDate());
        assertEquals(expected.getRecordingDate().toString(), result.getRecordingDate());
        assertEquals(expected.getSalary().toString(), result.getSalary());
        assertEquals(expected.getStatus(), result.isStatus());
    }


    @Test
    @DisplayName("mapFromRequestToEntity")
    public void _2() {
        String date = "2019-01-01";
        PersonRequest expected = randomizer().appendFixedField("birthDate", date, PersonRequest.class)
                .appendFixedField("recordingDate", date, PersonRequest.class)
                .appendFixedField("leavingDate", date, PersonRequest.class)
                .appendFixedField("salary", "2000", PersonRequest.class)
                .createRandomObject(PersonRequest.class);

        PersonEntity result = testable.mapFromRequestToEntity(expected);

        assertEquals(expected.getFirstName(), result.getFirstName());
        assertEquals(expected.getLastName(), result.getLastName());
        assertEquals(expected.getBirthDate(), result.getBirthDate().toString());
        assertEquals(expected.getLeavingDate(), result.getLeavingDate().toString());
        assertEquals(expected.getRecordingDate(), result.getRecordingDate().toString());
        assertEquals(expected.getSalary(), result.getSalary().toString());
        assertEquals(expected.getStatus(), result.getStatus());
    }


}
