package com.healthcareDemo.controller;

import com.healthcareDemo.service.AppointmentService;

import java.util.Scanner;

public class AppointmentController {

    private static final Scanner scanner = new Scanner(System.in);

    AppointmentService appointmentService = new AppointmentService();

    public void run(){
        int option=0;
        do {
            System.out.println("-----Appointment-information-------");
            System.out.println("1. fill the information");
            System.out.println("2. view Appointments");
            System.out.println("3. update Appointment");
            System.out.println("4. delete appointment");

            System.out.println("please select the option");
            option = Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    try {
                        appointmentService.addAppointment();
                    }catch (NumberFormatException e){
                        System.err.println(e.getMessage());
                    }
                    break;

                case 2:
                    appointmentService.viewAppointment();
                    break;

                case 3:
                    appointmentService.updateAppointment(1,1);
                    break;

                case 4:
                    appointmentService.deleteAppointment(1);
                    break;

                default:
                    System.out.println("please enter valid inputs");
                    break;
            }

        }while(option!=0);{
            System.out.println("Thank you!!!");
        }
    }
}
