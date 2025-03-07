package org.example.controller;

import org.example.impl.PaymentService;
import org.example.service.BillingService;

import java.util.Scanner;

public class BillingController {

    private static final Scanner scanner = new Scanner(System.in);

    // data hidden concept

    PaymentService billingService = new PaymentService();

    public void run(){
        int option=0;
        do{
            System.out.println("-------billing-information");
            System.out.println("1. payment Service");
            System.out.println("2.receipt");
            System.out.println("3.update payment");
            System.out.println("4. delete payment");

            System.out.println("please select option");
            option = Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    try {
                        billingService.payment();
                    }catch (NumberFormatException e){
                        System.err.println(e.getMessage());
                    }
                    break;

                case 2:
                    billingService.receipt();
                    break;

                case 3:
                    billingService.updatePayment(1,1500);
                    break;

                case 4:
                    billingService.deletePayment(1);
                    break;

                default:
                    System.out.println("please enter valid input");
                    break;

            }

        }while(option!=0);{
            System.out.println("Thank you!!!");
        }
    }
}
