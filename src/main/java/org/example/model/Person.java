package org.example.model;

import java.util.Objects;

public class Person {

    // for creating person information attributes

    private int personId;
    private String type;
    private String firstName;
    private String lastName;

    // toString method for showing output otherwise garbage value is seen in output

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", type='" + type + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    // getter and setter method for set attributes with particular variables

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    // equals and hashcode used for Map for validate attributes with respective their attributes

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getPersonId() == person.getPersonId() && Objects.equals(getType(), person.getType()) && Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonId(), getType(), getFirstName(), getLastName());
    }
}
