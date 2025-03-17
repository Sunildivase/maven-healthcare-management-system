package com.healthcareDemo.service;

import com.healthcareDemo.exception.InvalidContact;
import com.healthcareDemo.model.Person;
import com.healthcareDemo.repository.PersonRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonService {

    private PersonRepository personRepository = new PersonRepository();

    // scanner created for taking the input value to system

    private static final Scanner scanner = new Scanner(System.in);

    // list collection is used to store data.
    // duplicate value added to list.

    List<Person> personList = new ArrayList<>();

    void printPerson(Person person) {
        System.out.println(person);
    }

    // method for add person

    public Person addPerson() throws com.healthcareDemo.exception.NumberFormatException {
        System.out.println("please enter id");
        int personId = 0;
        try {
            personId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new com.healthcareDemo.exception.NumberFormatException("invalid input");
        }
        if (personId <= 0) {
            throw new com.healthcareDemo.exception.NumberFormatException("please enter valid input");
        }


        System.out.println("please enter type");
        String type = scanner.nextLine();

        System.out.println("please enter firstName");
        String firstName = scanner.nextLine();

        System.out.println("please enter lastName");
        String lastName = scanner.nextLine();

        System.out.println("please enter age");
        int age = 0;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new com.healthcareDemo.exception.NumberFormatException("invalid input");
        }

        if (age <= 0) {
            throw new com.healthcareDemo.exception.NumberFormatException("please enter valid input");
        }

        System.out.println("please enter gender");
        String gender = scanner.nextLine();

        System.out.println("please enter contactNo");

        long contactNo = 0L;
        try {
            contactNo = Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new com.healthcareDemo.exception.NumberFormatException("please enter valid number");
        }

        if (contactNo != 10) {

        }else{
            throw new InvalidContact("please enter 10 digit number");
        }

        System.out.println("please enter alternate Mobile");
        long alternateMobile = 0L;
        try {
            alternateMobile = Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new com.healthcareDemo.exception.NumberFormatException("please enter valid number");
        }

        if (alternateMobile != 10) {

        }else{
            throw new InvalidContact("please enter 10 digit number");
        }

        System.out.println("please enter address");
        String address = scanner.nextLine();

        Person person = new Person();
        person.setPersonId(personId);
        person.setType(type);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAge(age);
        person.setGender(gender);
        person.setContactNo(contactNo);
        person.setAlternateMobile(alternateMobile);
        person.setAddress(address);

        personRepository.addPerson(person);
        personRepository.viewPerson(person);
        personRepository.deletePerson(person);

        personList.add(person);
        return person;
    }

    // method for display person

    public void viewPerson() {
        for (Person person : personList) {
            System.out.println("person list: " + person);
        }

        // if we want to give some discount or filter records by using stream()
        // we need to convert class to record

//        List<Person> people = personList.stream() //streaming object
//                .parallel() // parallel processing
//                .filter(person -> person.setGender("female"))  // if-else condition
//                .map(person -> person)
//                .toList();  // creating list of filtered data

    }

    // method for delete or remove person

    public void deletePerson(int personId) {

        Person removedPerson = personList.remove(personId);
        System.out.println("removed Person" + removedPerson);

    }

}
