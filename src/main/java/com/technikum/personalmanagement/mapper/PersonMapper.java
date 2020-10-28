package com.technikum.personalmanagement.mapper;

import com.technikum.personalmanagement.converter.DateConverter;
import com.technikum.personalmanagement.entity.PersonEntity;
import com.technikum.personalmanagement.model.PersonRequest;
import com.technikum.personalmanagement.model.PersonResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PersonMapper {

    private final DateConverter dateConverter;

    public PersonMapper(DateConverter dateConverter) {this.dateConverter = dateConverter;}

    public PersonEntity mapFromRequestToEntity(PersonRequest personRequest) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(UUID.randomUUID());
        personEntity.setStatus(personRequest.getStatus());
        personEntity.setRecordingDate(dateConverter.convert(personRequest.getRecordingDate()));
        personEntity.setFirstName(personRequest.getFirstName());
        personEntity.setLastName(personRequest.getLastName());
        personEntity.setBirthDate(dateConverter.convert(personRequest.getBirthDate()));
        personEntity.setSalary(Integer.parseInt(personRequest.getSalary()));
        personEntity.setLeavingDate(dateConverter.convert(personRequest.getLeavingDate()));
        personEntity.setAdress(personRequest.getAdress());

        return personEntity;
    }

    public PersonResponse mapFromEntityToResponse(PersonEntity personEntity) {
        return new PersonResponse(personEntity.getId().toString(), personEntity.getFirstName(), personEntity.getLastName(), personEntity.getAdress(),
                personEntity.getBirthDate().toString(), personEntity.getRecordingDate().toString(),
                personEntity.getLeavingDate().toString(), personEntity.getSalary().toString(), personEntity.getStatus(), personEntity.getHolidayDays().toString());


    }
}
