package com.technikum.personalmanagement.validator;

import com.technikum.personalmanagement.entity.UrlaubEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class UrlaubRemainingDaysValidator {

    private final UrlaubStartEndDateCounter urlaubStartEndDateCounter;

    public UrlaubRemainingDaysValidator(UrlaubStartEndDateCounter urlaubStartEndDateCounter) {this.urlaubStartEndDateCounter = urlaubStartEndDateCounter;}

    public void validate(UrlaubEntity urlaubEntity) {
        int daysBetween = urlaubStartEndDateCounter.getDays(urlaubEntity.getStartDate(), urlaubEntity.getEndDate());

        Assert.isTrue(daysBetween < urlaubEntity.getPerson().getHolidayDays(), "Remaining holidays must greater than between start & end days");
    }

}
