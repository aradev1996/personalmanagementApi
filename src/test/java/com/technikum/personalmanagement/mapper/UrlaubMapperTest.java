package com.technikum.personalmanagement.mapper;

import com.technikum.personalmanagement.UnitTestBase;
import com.technikum.personalmanagement.converter.DateConverter;
import com.technikum.personalmanagement.entity.PersonEntity;
import com.technikum.personalmanagement.entity.UrlaubEntity;
import com.technikum.personalmanagement.model.UrlaubResponse;
import com.technikum.personalmanagement.service.PersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("UrlaubMapperTest")
class UrlaubMapperTest extends UnitTestBase {

    @Autowired
    DateConverter dateConverter;

    @Autowired
    PersonService personService;

    @Autowired
    PersonMapper personMapper;

    @Autowired
    UrlaubMapper testable;

    @Test
    @DisplayName("mapFromEntityToResponse")
    public void _1() {
        UrlaubEntity expected = randomizer().createRandomObject(UrlaubEntity.class);

        UrlaubResponse result = testable.mapFromEntityToResponse(expected);

        assertEquals(expected.getEndDate().toString(),result.getEndDate());
        assertEquals(expected.getPerson().getId(),result.getPersonResponse().getUserId());
        assertEquals(expected.getStartDate().toString(),result.getStartDate());
    }

    @Test
    @DisplayName("mapFromRequestToEntity")
    public void _2() {
        UrlaubEntity expected = randomizer().createRandomObject(UrlaubEntity.class);

        UrlaubResponse result = testable.mapFromEntityToResponse(expected);

        assertEquals(expected.getEndDate().toString(),result.getEndDate());
        assertEquals(expected.getPerson().getId(),result.getPersonResponse().getUserId());
        assertEquals(expected.getStartDate().toString(),result.getStartDate());
    }
}
