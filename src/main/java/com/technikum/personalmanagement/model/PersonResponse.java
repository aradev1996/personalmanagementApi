package com.technikum.personalmanagement.model;

public class PersonResponse {

    private String userId;

    private String firstName;

    private String lastName;

    private String adress;

    private String birthDate;

    private String recordingDate;

    private String leavingDate;

    private String salary;

    private boolean status;

    public PersonResponse(String userId, String firstName, String lastName, String adress, String birthDate,
                          String recordingDate, String leavingDate, String salary, boolean status) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.birthDate = birthDate;
        this.recordingDate = recordingDate;
        this.leavingDate = leavingDate;
        this.salary = salary;
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public String getAdress() {
        return adress;
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

    public boolean isStatus() {
        return status;
    }
}
