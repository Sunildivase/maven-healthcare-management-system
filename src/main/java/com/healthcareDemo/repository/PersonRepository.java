package com.healthcareDemo.repository;

import com.healthcareDemo.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    List<Person> personList = new ArrayList<>();

    public void addPerson(Person person){
        personList.add(person);
    }

    public void viewPerson(Person person){
        System.out.println("persons: "+ person);
    }

    public void deletePerson(Person person){
        personList.remove(person);
    }
}