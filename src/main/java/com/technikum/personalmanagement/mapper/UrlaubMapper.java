package com.technikum.personalmanagement.mapper;

import com.technikum.personalmanagement.converter.DateConverter;
import com.technikum.personalmanagement.entity.UrlaubEntity;
import com.technikum.personalmanagement.model.UrlaubRequest;
import com.technikum.personalmanagement.model.UrlaubResponse;
import com.technikum.personalmanagement.service.PersonService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UrlaubMapper {

    private final DateConverter dateConverter;

    private final PersonService personService;

    private final PersonMapper personMapper;

    public UrlaubMapper(DateConverter dateConverter, PersonService personService, PersonMapper personMapper) {
        this.dateConverter = dateConverter;
        this.personService = personService;
        this.personMapper = personMapper;
    }

    public UrlaubEntity mapFromRequestToEntity(UrlaubRequest urlaubRequest) {
        UrlaubEntity urlaubEntity = new UrlaubEntity();
        urlaubEntity.setId(UUID.randomUUID());
        urlaubEntity.setStartDate(dateConverter.convert(urlaubRequest.getStartDate()));
        urlaubEntity.setEndDate(dateConverter.convert(urlaubRequest.getEndDate()));
        urlaubEntity.setPerson(personService.findById(urlaubRequest.getPersonId()));

        return urlaubEntity;
    }

    public UrlaubResponse mapFromEntityToResponse(UrlaubEntity urlaubEntity) {
        return new UrlaubResponse(urlaubEntity.getStartDate().toString(), urlaubEntity.getEndDate().toString(),
                personMapper.mapFromEntityToResponse(urlaubEntity.getPerson()));


    }
}
