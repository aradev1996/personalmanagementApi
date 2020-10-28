package com.technikum.personalmanagement.validator;

import com.technikum.personalmanagement.entity.PersonEntity;
import com.technikum.personalmanagement.entity.UrlaubEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import static java.time.temporal.ChronoUnit.DAYS;

@Component
public class UrlaubRemainingDaysValidator {

    public void validate(UrlaubEntity urlaubEntity) {
        long daysBetween = DAYS.between(urlaubEntity.getStartDate(), urlaubEntity.getEndDate());

        Assert.isTrue(daysBetween < urlaubEntity.getPerson().getHolidayDays(), "Remaining holidays must greater than between start & end days");
    }
}
