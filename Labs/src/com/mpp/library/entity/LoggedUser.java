package com.mpp.library.entity;

public class LoggedUser {
    private static LoggedUser instance;

    private Person person;

    private LoggedUser(){}

    public static LoggedUser getInstance(){
        if(instance == null) instance = new LoggedUser();
        return instance;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
