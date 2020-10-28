package com.technikum.personalmanagement.service;

import com.technikum.AbstractTestBase;
import com.technikum.personalmanagement.PersonalmanagementApplication;
import com.technikum.personalmanagement.entity.PersonEntity;
import com.technikum.personalmanagement.entity.UrlaubEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("urlaub integration")
@Transactional
@SpringBootTest(classes = PersonalmanagementApplication.class)
class UrlaubServiceTest extends AbstractTestBase {

    @Autowired
    UrlaubService urlaubService;

    @Autowired
    PersonService personService;

    @Test
    @DisplayName("urlaub erstellen")
    public void _1() {
        PersonEntity person = personService.findById(UUID.fromString("81711e77-5b7a-4b48-adcc-700f5e9ab156"));
        UrlaubEntity exepectedUrlaub = randomizer().createRandomObject(UrlaubEntity.class);
        exepectedUrlaub.setPerson(person);
        UrlaubEntity savedEntity = urlaubService.save(exepectedUrlaub);

        assertEquals(exepectedUrlaub.getId(), savedEntity.getId());
        assertEquals(exepectedUrlaub.getStartDate(), savedEntity.getStartDate());
        assertEquals(exepectedUrlaub.getEndDate(), savedEntity.getEndDate());
        assertEquals(exepectedUrlaub.getPerson(), savedEntity.getPerson());
    }

    @Test
    @DisplayName("alle urlaube lesen")
    public void _2() {
        createRandomUrlaub();
        createRandomUrlaub();
        createRandomUrlaub();

        List<UrlaubEntity> allUrlaub = urlaubService.getAll();

        assertEquals(3, allUrlaub.size());
    }

    public UrlaubEntity createRandomUrlaub() {
        UrlaubEntity exepectedUrlaub = randomizer().createRandomObject(UrlaubEntity.class);
        PersonEntity person = personService.findById(UUID.fromString("81711e77-5b7a-4b48-adcc-700f5e9ab156"));
        exepectedUrlaub.setPerson(person);

        return urlaubService.save(exepectedUrlaub);
    }


}
