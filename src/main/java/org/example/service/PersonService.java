package org.example.service;

import org.example.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonService {

    // scanner created for taking the input value to system

    private static final Scanner scanner = new Scanner(System.in);

    // list collection is used to store data.
    // duplicate value added to list.

    List<Person> personList = new ArrayList<>();

    void printPerson(Person person) {
        System.out.println(person);
    }

    // method for add person

    public void addPerson() {
        System.out.println("please enter id");
        int personId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter type");
        String type = scanner.nextLine();

        System.out.println("please enter firstName");
        String firstName = scanner.nextLine();

        System.out.println("please enter lastName");
        String lastName = scanner.nextLine();

        Person person = new Person();
        person.setPersonId(personId);
        person.setType(type);
        person.setFirstName(firstName);
        person.setLastName(lastName);

        personList.add(person);
    }

    // method for display person

    public void viewPerson() {
        for (Person person : personList) {
            System.out.println("person list: " + person);
        }
    }

    // method for delete or remove person

    public void deletePerson(int personId) {

        Person removedPerson = personList.remove(personId);
        System.out.println("removed Person" + removedPerson);

    }

}
