package org.example.controller;

import org.example.exception.InvalidContact;
import org.example.exception.NumberFormatException;
import org.example.service.PersonService;

import java.util.Scanner;

public class PersonController {

    private static final Scanner scanner = new Scanner(System.in);

    public void run() throws NumberFormatException {

        int option = 0;

        PersonService personService = new PersonService();
        do {
            System.out.println("----person-information------");
            System.out.println("1. fill the person information");
            System.out.println("2. display the person");
            System.out.println("3. delete person");

            System.out.println("please enter the option");
            option= Integer.parseInt(scanner.nextLine());

            switch(option){
                case 1:
                    try {
                        personService.addPerson();
                    } catch (NumberFormatException | InvalidContact e) {
                        System.err.println(e.getMessage());
                    }

                    break;

                case 2:
                    personService.viewPerson();
                    break;

                case 3:
                    personService.deletePerson(1);
                    break;
            }

        } while (option != 0);
        {
            System.out.println("Thank you!!!");
        }
    }
}
