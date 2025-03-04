package org.example.controller;

import org.example.exception.InvalidContact;
import org.example.exception.InvalidEmail;
import org.example.service.HospitalService;

import java.util.Scanner;

public class HospitalController {

    private static final Scanner scanner = new Scanner(System.in);

    HospitalService hospitalService = new HospitalService();
    public void run() {
        int option = 0;
        do {
            System.out.println("----hospital-information------");
            System.out.println("1. fill hospital information");
            System.out.println("2. view hospitals");
            System.out.println("3. delete hospital");

            System.out.println("please select the option");
            option=Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    try {
                        hospitalService.addHospital();
                    }catch (NumberFormatException | InvalidContact | InvalidEmail e){
                        System.err.println(e.getMessage());
                    }
                    break;

                case 2:
                    hospitalService.viewHospital();
                    break;

//                case 3:
//                    hospitalService.deleteHospital(1);
//                    break;

                default:
                    System.out.println("please enter valid inputs");
                    break;
            }

        }while(option!=0);{
            System.out.println("Thank you!!!");
        }
    }
}
