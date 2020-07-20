package com.example.one_avtivity_multiple_fragments;


public class KisiModel {
    private String person;
    private int gender;
    private int workingstatus;

    public KisiModel(String person, int gender, int workingstatus) {
        this.person = person;
        this.gender = gender;
        this.workingstatus = workingstatus;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getWorkingstatus() {
        return workingstatus;
    }

    public void setWorkingstatus(int workingstatus) {
        this.workingstatus = workingstatus;
    }
}
