package com.technikum.personalmanagement.model;

public class PersonStatisticsModel {

    private int allPersonCount;

    private int activePerson;

    private int inActivePerson;

    public PersonStatisticsModel(int allPersonCount, int activePerson, int inActivePerson) {
        this.allPersonCount = allPersonCount;
        this.activePerson = activePerson;
        this.inActivePerson = inActivePerson;
    }

    public int getAllPersonCount() {
        return allPersonCount;
    }

    public int getActivePerson() {
        return activePerson;
    }

    public int getInActivePerson() {
        return inActivePerson;
    }
}
