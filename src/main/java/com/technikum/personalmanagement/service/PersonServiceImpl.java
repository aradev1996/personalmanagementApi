package com.technikum.personalmanagement.service;

import com.technikum.personalmanagement.entity.PersonEntity;
import com.technikum.personalmanagement.repository.PersonRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {this.personRepository = personRepository;}

    @Override
    public PersonEntity save(PersonEntity personEntity) {
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
}
