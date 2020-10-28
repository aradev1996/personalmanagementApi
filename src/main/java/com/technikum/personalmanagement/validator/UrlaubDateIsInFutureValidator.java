package com.technikum.personalmanagement.validator;

import com.technikum.personalmanagement.entity.UrlaubEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.time.LocalDate;

@Component
public class UrlaubDateIsInFutureValidator {

    public void validate(UrlaubEntity urlaubEntity) {
        Assert.isTrue(urlaubEntity.getStartDate().isAfter(LocalDate.now()), "Startdate must be in future");
        Assert.isTrue(urlaubEntity.getEndDate().isAfter(LocalDate.now()), "Enddate must be in future");
    }
}
