package com.technikum.personalmanagement.validator;

import com.technikum.personalmanagement.entity.PersonEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class PersonBirthDateValidator {

    public void validate(PersonEntity personEntity) {
        LocalDate nowTimeMinusFourTeen = LocalDate.now().minus(14, ChronoUnit.YEARS);

        Assert.isTrue(personEntity.getBirthDate().isBefore(nowTimeMinusFourTeen),
                "Person must be older than 14");
    }
}
