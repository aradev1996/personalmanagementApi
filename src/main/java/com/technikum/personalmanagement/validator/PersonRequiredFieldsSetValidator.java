package com.technikum.personalmanagement.validator;

import com.technikum.personalmanagement.entity.PersonEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class PersonRequiredFieldsSetValidator {

    public void validate(PersonEntity personEntity) {
        Assert.notNull(personEntity.getId(), "Id is null");
        Assert.notNull(personEntity.getAdress(), "Adress is null");
        Assert.notNull(personEntity.getBirthDate(), "Birthdate is null");
        Assert.notNull(personEntity.getFirstName(), "Firstname is null");
        Assert.notNull(personEntity.getLastName(), "Lastname is null");
        Assert.notNull(personEntity.getLeavingDate(), "Leavingdate is null");
        Assert.notNull(personEntity.getRecordingDate(), "Recordingdate is null");
        Assert.notNull(personEntity.getStatus(), "Status is null");
        Assert.notNull(personEntity.getSalary(), "Salary is null");
    }

}
