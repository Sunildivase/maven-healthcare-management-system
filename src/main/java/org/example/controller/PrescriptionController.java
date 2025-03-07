package org.example.controller;

import org.example.service.PrescriptionService;

import java.util.Scanner;

public class PrescriptionController {

    private static final Scanner scanner = new Scanner(System.in);

    PrescriptionService prescriptionService = new PrescriptionService();

    public void run(){
        int option=0;
        do{
            System.out.println("-------Prescription-Information---------");
            System.out.println("1. fill prescription details");
            System.out.println("2. view prescription");
            System.out.println("3. update prescription");
            System.out.println("4. delete prescription");

            System.out.println("please select the option");
            option = Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    prescriptionService.addPrescription();
                    break;

                case 2:
                    prescriptionService.viewPrescription();
                    break;

                case 3:
                    prescriptionService.updatePrescription();
                    break;

                case 4:
                    prescriptionService.deletePrescription(1);
                    break;

                default:
                    System.out.println("please enter valid input");
                    break;
            }

        }while(option!=0);{
            System.out.println("please enter valid input");
        }
    }
}
