package org.example;

import org.example.service.PersonService;

import java.util.Scanner;

/**
 * Hello world!
 */
public class HealthcareApp {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        int option = 0;
        do {
            System.out.println("--------halthcare-management-system----------");
            System.out.println("1.create person");

            System.out.println("please enter the option");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    PersonService personService = new PersonService();
                    personService.addPerson();
                    personService.viewPerson();
//                    try {
//                        personService.deletePerson(1);
//                    } catch (Exception e) {
//                        throw new Exception("invalid data");
//                    }

                    System.out.println("person created successfully");
                    break;

                default:
                    System.out.println("please enter valid input");
                    break;

            }

        } while (option != 0);
        {
            System.out.println("Thank you!!!");
        }

    }
}
