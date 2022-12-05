package com.example.testmongodb.EmployeesEntity;

import org.springframework.data.annotation.Id;

import java.util.Optional;

public class Employee {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Employee () {}

    public Employee (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Employee[id=&s, firstName=%s, lastName=%s]",
                id, firstName, lastName
        );
    }
}