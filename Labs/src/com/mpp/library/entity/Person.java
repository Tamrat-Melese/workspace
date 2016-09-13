package com.mpp.library.entity;

import com.mpp.library.role.UserRole;

import java.util.HashSet;
import java.util.Set;

public class Person {
    private String ID;
    private String firstName;
    private String lastName;
    private Address address;
    private String phoneNumber;
    private Set<UserRole> roles;

    public Person(String ID, String firstName, String lastName, Address address, String phoneNumber) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        roles = new HashSet<>();
    }

    public Person addRole(UserRole ur){
        roles.add(ur);
        return this;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }
}
