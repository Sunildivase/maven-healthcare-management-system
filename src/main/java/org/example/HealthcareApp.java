package org.example;

import org.example.controller.*;
import org.example.exception.InvalidContact;
import org.example.service.PersonService;

import java.util.Scanner;


public class HealthcareApp {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws org.example.exception.NumberFormatException {

        int option = 0;
        do {

            System.out.println("--------healthcare-management-system----------");
            System.out.println("1. create person");
            System.out.println("2. create doctor");
            System.out.println("3. create hospital");
            System.out.println("4. create department");
            System.out.println("5. create appointment");
            System.out.println("6. create prescription");
            System.out.println("7. create billing");

            System.out.println("please enter the option");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            }


            switch (option) {
                case 1:
                    PersonController personController = new PersonController();
                    personController.run();
                    System.out.println("person created successfully");
                    break;

                case 2:
                    DoctorController doctorController = new DoctorController();
                    doctorController.run();
                    System.out.println("doctor created successfully");
                    break;

                case 3:
                    HospitalController hospitalController = new HospitalController();
                    hospitalController.run();
                    System.out.println("hospital created successfully");
                    break;

                case 4:
                    DepartmentController departmentController = new DepartmentController();
                    departmentController.run();
                    System.out.println("department created successfully");
                    break;

                case 5:
                    AppointmentController appointmentController = new AppointmentController();
                    appointmentController.run();
                    System.out.println("appointment created successfully");
                    break;

                case 6:
                    PrescriptionController prescriptionController = new PrescriptionController();
                    prescriptionController.run();
                    System.out.println("prescription created successfully");
                    break;

                case 7:
                    BillingController billingController = new BillingController();
                    billingController.run();
                    System.out.println("bill generated successfully");
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
