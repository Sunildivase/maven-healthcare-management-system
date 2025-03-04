package org.example.controller;

import org.example.exception.InvalidContact;
import org.example.exception.InvalidExperienceException;
import org.example.service.DoctorService;

import java.util.Scanner;

public class DoctorController {

    private static final Scanner scanner = new Scanner(System.in);

    public void run() {

        int option = 0;
        DoctorService doctorService = new DoctorService();
        do {

            System.out.println("----Doctor-Information-----");
            System.out.println("1. fill doctor's information");
            System.out.println("2. view doctors");
            System.out.println("3. removed doctors");

            System.out.println("please enter the option");
            option= Integer.parseInt(scanner.nextLine());

            switch(option){
                case 1:
                    try {
                        doctorService.addDoctor();
                    } catch (NumberFormatException | InvalidContact | InvalidExperienceException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    doctorService.viewDoctor();
                    break;

//                case 3:
//                    doctorService.deleteDoctor(1);
//                    break;

                default:
                    System.out.println("please enter valid option");
                    break;

            }
        } while (option != 0);{
            System.out.println("Thnak you !!!");
        }
    }
}