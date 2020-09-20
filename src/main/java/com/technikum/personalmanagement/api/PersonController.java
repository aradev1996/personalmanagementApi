package com.technikum.personalmanagement.api;

import com.technikum.personalmanagement.entity.PersonEntity;
import com.technikum.personalmanagement.mapper.PersonMapper;
import com.technikum.personalmanagement.model.PersonRequest;
import com.technikum.personalmanagement.model.PersonResponse;
import com.technikum.personalmanagement.model.PersonStatisticsModel;
import com.technikum.personalmanagement.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


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
    public List<PersonResponse> getAll() {
        List<PersonEntity> allPerson = personService.getAll();

        return allPerson.stream().map(mapper::mapFromEntityToResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PersonResponse getPersonById(@PathVariable("id") UUID id) {
        return mapper.mapFromEntityToResponse(personService.findById(id));
    }

    @PostMapping("/create")
    public void create(@RequestBody PersonRequest personRequest) {
        personService.save(mapper.mapFromRequestToEntity(personRequest));
    }

    @PutMapping("/{id}")
    public PersonResponse update(@PathVariable("id") UUID id, @RequestBody PersonRequest personRequest) {
        PersonEntity mappedPersonEntity = mapper.mapFromRequestToEntity(personRequest);
        mappedPersonEntity.setId(id);

        PersonEntity savedPersonEntity = personService.save(mappedPersonEntity);

        return mapper.mapFromEntityToResponse(savedPersonEntity);
    }

    @PutMapping("/{id}/status")
    public PersonResponse setStatus(@PathVariable("id") UUID id) {
        PersonEntity personEntity = personService.findById(id);
        personEntity.setStatus(false);
        PersonEntity savedEntity = personService.save(personEntity);

        return mapper.mapFromEntityToResponse(savedEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    @GetMapping("/statistic")
    public PersonStatisticsModel getTrends() {
        return new PersonStatisticsModel(personService.getAll().size(),
                personService.countActivePerson(),
                personService.countInActivePerson());
    }


    /*private void createDemo(UUID uuid) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(uuid);
        personEntity.setBirthDate(LocalDate.now());
        personEntity.setFirstName("testName");
        personEntity.setLastName("testn");
        personEntity.setAdress("test-adress 123");
        personEntity.setSalary(2000);
        personEntity.setLeavingDate(LocalDate.now());
        personEntity.setRecordingDate(LocalDate.now());
        personEntity.setStatus(false);

        personService.save(personEntity);
    }*/
}
