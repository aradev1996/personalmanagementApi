package com.technikum.personalmanagement.api;

import com.technikum.personalmanagement.entity.PersonEntity;
import com.technikum.personalmanagement.mapper.PersonMapper;
import com.technikum.personalmanagement.model.PersonRequest;
import com.technikum.personalmanagement.model.PersonResponse;
import com.technikum.personalmanagement.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/person")
public class PersonController {

    private final PersonService personService;

    private final PersonMapper mapper;

    public PersonController(PersonService personService, PersonMapper mapper) {
        this.personService = personService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<PersonEntity> getAll() {

        createDemo(UUID.randomUUID());
        createDemo(UUID.randomUUID());
        createDemo(UUID.randomUUID());

        return personService.getAll();
    }

    @GetMapping("/{id}")
    public PersonResponse getPersonById(@RequestParam UUID id) {
        return mapper.mapFromEntityToResponse(personService.findById(id));
    }

    @PostMapping("/create")
    public void create(@RequestBody PersonRequest personRequest) {
        personService.save(mapper.mapFromRequestToEntity(personRequest));
    }

    @PutMapping("/{id}")
    public PersonResponse update(@RequestParam UUID id, @RequestBody PersonRequest personRequest) {
        PersonEntity mappedPersonEntity = mapper.mapFromRequestToEntity(personRequest);
        mappedPersonEntity.setId(id);

        PersonEntity savedPersonEntity = personService.save(mappedPersonEntity);

        return mapper.mapFromEntityToResponse(savedPersonEntity);
    }

    @PutMapping("/{id}/status")
    public PersonResponse setStatus(@RequestParam UUID id) {
        PersonEntity personEntity = personService.findById(id);
        personEntity.setStatus(false);
        PersonEntity savedEntity = personService.save(personEntity);

        return mapper.mapFromEntityToResponse(savedEntity);
    }


    private void createDemo(UUID uuid) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(uuid);
        personEntity.setBirthDate(LocalDate.now());
        personEntity.setFirstName("testName");
        personEntity.setLastName("testn");
        personEntity.setSalary(2000);
        personEntity.setLeavingDate(LocalDate.now());
        personEntity.setRecordingDate(LocalDate.now());
        personEntity.setStatus(true);

        personService.save(personEntity);
    }
}
