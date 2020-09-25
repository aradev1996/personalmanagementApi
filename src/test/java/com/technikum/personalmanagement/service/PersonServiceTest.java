package com.technikum.personalmanagement.service;

import com.technikum.AbstractTestBase;
import com.technikum.personalmanagement.PersonalmanagementApplication;
import com.technikum.personalmanagement.entity.PersonEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayName("person service")
@Transactional
@SpringBootTest(classes = PersonalmanagementApplication.class)
class PersonServiceTest extends AbstractTestBase {

    @Autowired
    PersonService personService;

    @Test
    @DisplayName("save")
    public void _1() {
        PersonEntity expectedPerson = randomizer().createRandomObject(PersonEntity.class);
        expectedPerson.setBirthDate(LocalDate.MIN);

        PersonEntity result = personService.save(expectedPerson);

        assertEquals(expectedPerson.getFirstName(), result.getFirstName());
        assertEquals(expectedPerson.getLastName(), result.getLastName());
        assertEquals(expectedPerson.getStatus(), result.getStatus());
        assertEquals(expectedPerson.getSalary(), result.getSalary());
        assertEquals(expectedPerson.getRecordingDate(), result.getRecordingDate());
        assertEquals(expectedPerson.getLeavingDate(), result.getLeavingDate());
        assertEquals(expectedPerson.getAdress(), result.getAdress());
    }

    @Test
    @DisplayName("get all")
    public void _2() {
        createRandomPerson();
        createRandomPerson();
        createRandomPerson();

        List<PersonEntity> result = personService.getAll();

        assertEquals(3, result.size());
    }

    @Test
    @DisplayName("find by id")
    public void _3() {
        PersonEntity expectedPerson = createRandomPerson();

        PersonEntity result = personService.findById(expectedPerson.getId());

        assertEquals(expectedPerson, result);
    }

    @Test
    @DisplayName("find by id not found, throws Exception")
    public void _4() {
        assertThrows(IllegalArgumentException.class, () -> personService.findById(UUID.randomUUID()));
    }

    @Test
    @DisplayName("delete person by id")
    public void _5() {
        PersonEntity expectedPerson = createRandomPerson();

        personService.deletePerson(expectedPerson.getId());

        assertEquals(0, personService.getAll().size());
    }

    @Test
    @DisplayName("count active person")
    public void _6() {
        PersonEntity person1 = createRandomPerson();
        person1.setStatus(true);
        PersonEntity person2 = createRandomPerson();
        person2.setStatus(true);
        PersonEntity person3 = createRandomPerson();
        person3.setStatus(false);

        assertEquals(2, personService.countActivePerson());
    }

    @Test
    @DisplayName("count inactive person")
    public void _7() {
        PersonEntity person1 = createRandomPerson();
        person1.setStatus(false);
        PersonEntity person2 = createRandomPerson();
        person2.setStatus(false);
        PersonEntity person3 = createRandomPerson();
        person3.setStatus(true);

        assertEquals(2, personService.countInActivePerson());
    }

    public PersonEntity createRandomPerson() {
        PersonEntity expectedPerson = randomizer().createRandomObject(PersonEntity.class);
        expectedPerson.setBirthDate(LocalDate.MIN);
        return personService.save(expectedPerson);
    }
}
