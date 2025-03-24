package com.healthcareDemo.controller;

import com.healthcareDemo.service.BillingService;

import java.sql.SQLException;
import java.util.Scanner;

public class BillingController {

    private static final Scanner scanner = new Scanner(System.in);

    // data hidden concept

    BillingService billingService = new BillingService();

    public void run() throws SQLException {
        int option=0;
        do{
            System.out.println("-------billing-information");
            System.out.println("1. fill information of bill");
            System.out.println("2.view billing");
            System.out.println("3.update billing");
            System.out.println("4. delete billing");

            System.out.println("please select option");
            option = Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    try {
                        billingService.addBilling();
                    }catch (NumberFormatException e){
                        System.err.println(e.getMessage());
                    }
                    break;

                case 2:
                    billingService.viewBilling();
                    break;

                case 3:
                    billingService.updateBilling(1,1500);
                    break;

                case 4:
                    billingService.deleteBilling(1);
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
