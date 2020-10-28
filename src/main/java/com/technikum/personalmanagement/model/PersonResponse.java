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

    private String holidayDays;

    public PersonResponse(String userId, String firstName, String lastName, String adress, String birthDate,
                          String recordingDate, String leavingDate, String salary, boolean status, String holidayDays) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.birthDate = birthDate;
        this.recordingDate = recordingDate;
        this.leavingDate = leavingDate;
        this.salary = salary;
        this.status = status;
        this.holidayDays = holidayDays;
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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setRecordingDate(String recordingDate) {
        this.recordingDate = recordingDate;
    }

    public void setLeavingDate(String leavingDate) {
        this.leavingDate = leavingDate;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getHolidayDays() {
        return holidayDays;
    }

    public void setHolidayDays(String holidayDays) {
        this.holidayDays = holidayDays;
    }
}
