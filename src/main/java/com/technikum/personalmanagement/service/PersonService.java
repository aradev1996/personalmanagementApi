package com.technikum.personalmanagement.service;

import com.technikum.personalmanagement.entity.PersonEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface PersonService {

    PersonEntity save(PersonEntity personEntity);

    List<PersonEntity> getAll();

    PersonEntity findById(UUID personId);

    void deletePerson(UUID personId);

    int countActivePerson();

    int countInActivePerson();
}
