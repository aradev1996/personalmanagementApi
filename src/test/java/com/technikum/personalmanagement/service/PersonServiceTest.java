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


@DisplayName("person integration test")
@Transactional
@SpringBootTest(classes = PersonalmanagementApplication.class)
class PersonServiceTest extends AbstractTestBase {

    @Autowired
    PersonService personService;

    @Test
    @DisplayName("person erstellen")
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
    @DisplayName("alle personen lesen")
    public void _2() {
        createRandomPerson();
        createRandomPerson();
        createRandomPerson();

        List<PersonEntity> result = personService.getAll();

        assertEquals(6, result.size());
    }

    @Test
    @DisplayName("person mit der UUID lesen")
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
    @DisplayName("person löschen")
    public void _5() {
        PersonEntity expectedPerson = createRandomPerson();

        personService.deletePerson(expectedPerson.getId());

        assertEquals(3, personService.getAll().size());
    }

    @Test
    @DisplayName("aktive personen")
    public void _6() {
        PersonEntity person1 = createRandomPerson();
        person1.setStatus(true);
        PersonEntity person2 = createRandomPerson();
        person2.setStatus(true);
        PersonEntity person3 = createRandomPerson();
        person3.setStatus(false);

        assertEquals(5, personService.countActivePerson());
    }

    @Test
    @DisplayName("inaktive personen")
    public void _7() {
        PersonEntity person1 = createRandomPerson();
        person1.setStatus(false);
        PersonEntity person2 = createRandomPerson();
        person2.setStatus(false);
        PersonEntity person3 = createRandomPerson();
        person3.setStatus(true);

        assertEquals(2, personService.countInActivePerson());
    }

    @Test
    @DisplayName("2 personen mit dem gleichen namen speichern")
    public void _8() {
        PersonEntity person1 = createRandomPerson();
        person1.setLastName("testLastName");
        person1.setFirstName("testFirstName");
        PersonEntity savedPerson1 = personService.save(person1);

        PersonEntity person2 = createRandomPerson();
        person2.setLastName("testLastName");
        person2.setFirstName("testFirstName");
        PersonEntity savedPerson2 = personService.save(person2);

        assertEquals(savedPerson1.getFirstName(), savedPerson2.getFirstName());
        assertEquals(savedPerson1.getLastName(), savedPerson2.getLastName());
    }

    public PersonEntity createRandomPerson() {
        PersonEntity expectedPerson = randomizer().createRandomObject(PersonEntity.class);
        expectedPerson.setBirthDate(LocalDate.MIN);
        return personService.save(expectedPerson);
    }
}
