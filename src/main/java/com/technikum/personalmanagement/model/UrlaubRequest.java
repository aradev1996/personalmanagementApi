package com.technikum.personalmanagement.model;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode
public class UrlaubRequest implements Serializable {

    private String startDate;

    private String endDate;

    private UUID personId;

    public UrlaubRequest(String startDate, String endDate, UUID personId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.personId = personId;
    }

    public UrlaubRequest() {
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }
}
