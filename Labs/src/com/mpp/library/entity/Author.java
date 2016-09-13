package com.mpp.library.entity;

public class Author {
    private String firstName;
    private String lastName;
    private String shortBio;

    public Author(String firstName, String lastName, String shortBio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.shortBio = shortBio;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getShortBio() {
        return shortBio;
    }

    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }
}
