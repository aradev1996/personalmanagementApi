package com.technikum.personalmanagement.service;

import com.technikum.personalmanagement.entity.PersonEntity;
import com.technikum.personalmanagement.repository.PersonRepository;
import com.technikum.personalmanagement.validator.PersonBirthDateValidator;
import com.technikum.personalmanagement.validator.PersonRequiredFieldsSetValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final PersonRequiredFieldsSetValidator personRequiredFieldsSetValidator;

    private final PersonBirthDateValidator personBirthDateValidator;

    public PersonServiceImpl(PersonRepository personRepository, PersonRequiredFieldsSetValidator personRequiredFieldsSetValidator, PersonBirthDateValidator personBirthDateValidator) {
        this.personRepository = personRepository;
        this.personRequiredFieldsSetValidator = personRequiredFieldsSetValidator;
        this.personBirthDateValidator = personBirthDateValidator;
    }

    @Override
    public PersonEntity save(PersonEntity personEntity) {
        personRequiredFieldsSetValidator.validate(personEntity);
        personBirthDateValidator.validate(personEntity);
        return personRepository.save(personEntity);
    }

    @Override
    public List<PersonEntity> getAll() {
        return personRepository.findAll();
    }

    @Override
    public PersonEntity findById(UUID personId) {
        Optional<PersonEntity> personById = personRepository.findById(personId);

        Assert.isTrue(personById.isPresent(), String.format("Person with id %s not found", personById.toString()));

        return personById.get();
    }

    @Override
    public void deletePerson(UUID personId) {
        personRepository.deleteById(personId);
    }

    @Override
    public int countActivePerson() {
        return personRepository.getAllActive().size();
    }

    @Override
    public int countInActivePerson() {
        return personRepository.getAllInActive().size();
    }
}
