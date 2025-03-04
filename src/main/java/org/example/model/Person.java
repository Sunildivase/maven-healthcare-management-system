package org.example.model;

import java.util.Objects;

public class Person {

    // for creating person information attributes

    private int personId;
    private String type;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private Long contactNo;
    private Long alternateMobile;
    private String address;

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", type='" + type + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", contactNo=" + contactNo +
                ", alternateMobile=" + alternateMobile +
                ", address='" + address + '\'' +
                '}';
    }
// toString method for showing output otherwise garbage value is seen in output

    // getter and setter method for set attributes with particular variables

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getContactNo() {
        return contactNo;
    }

    public void setContactNo(Long contactNo) {
        this.contactNo = contactNo;
    }

    public Long getAlternateMobile() {
        return alternateMobile;
    }

    public void setAlternateMobile(Long alternateMobile) {
        this.alternateMobile = alternateMobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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
        return getPersonId() == person.getPersonId() && getAge() == person.getAge() && Objects.equals(getType(), person.getType()) && Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getGender(), person.getGender()) && Objects.equals(getContactNo(), person.getContactNo()) && Objects.equals(getAlternateMobile(), person.getAlternateMobile()) && Objects.equals(getAddress(), person.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonId(), getType(), getFirstName(), getLastName(), getAge(), getGender(), getContactNo(), getAlternateMobile(), getAddress());
    }
}

