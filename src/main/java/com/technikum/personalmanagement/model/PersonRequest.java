package com.technikum.personalmanagement.model;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class PersonRequest implements Serializable {

    private String firstName;

    private String lastName;

    private String birthDate;

    private String recordingDate;

    private String leavingDate;

    private String adress;

    private String salary;

    private boolean status;

    public PersonRequest() {
    }

    public PersonRequest(String firstName, String lastName, String birthDate, String recordingDate, String leavingDate, String salary, Boolean status, String adress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.recordingDate = recordingDate;
        this.leavingDate = leavingDate;
        this.salary = salary;
        this.status = status;
        this.adress = adress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getRecordingDate() {
        return recordingDate;
    }

    public String getLeavingDate() {
        return leavingDate;
    }

    public String getSalary() {
        return salary;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getAdress() {
        return adress;
    }
}
