package com.technikum.personalmanagement.model;

public class UrlaubResponse {

    private final String startDate;

    private final String endDate;

    private final PersonResponse personResponse;


    public UrlaubResponse(String startDate, String endDate, PersonResponse personResponse) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.personResponse = personResponse;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public PersonResponse getPersonResponse() {
        return personResponse;
    }
}
