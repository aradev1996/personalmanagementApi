package com.technikum.personalmanagement.service;

import com.technikum.AbstractTestBase;
import com.technikum.personalmanagement.PersonalmanagementApplication;
import com.technikum.personalmanagement.entity.UrlaubEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("person service")
@Transactional
@SpringBootTest(classes = PersonalmanagementApplication.class)
class UrlaubServiceTest extends AbstractTestBase {

    @Autowired
    UrlaubService urlaubService;

    @Test
    @DisplayName("urlaub erstellen")
    public void _1() {
        UrlaubEntity exepectedUrlaub = randomizer().createRandomObject(UrlaubEntity.class);

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

        return urlaubService.save(exepectedUrlaub);
    }
}
