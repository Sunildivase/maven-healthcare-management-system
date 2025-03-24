package com.healthcareDemo.service;


import com.healthcareDemo.model.Billing;
import com.healthcareDemo.repository.BillingRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillingService {

    BillingRepository billingRepository = new BillingRepository();

    private static final Scanner scanner = new Scanner(System.in);

    List<Billing> billings = new ArrayList<>();


    public void addBilling() throws SQLException {

        System.out.println("please enter bill Id");
        int billId=0;
        try {
            billId = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            throw new NumberFormatException("invalid input");
        }

        System.out.println("please enter bill");
        int bill=0;
        try {
            bill = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("invalid input");
        }

        System.out.println("please enter total bill");
        int totalBill=0;
        try {
            totalBill = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("invalid input");
        }

        System.out.println("please enter person Id");
        int personId=0;
        try {
            personId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("invalid input");
        }

        Billing billing = new Billing(billId,bill,totalBill,personId);

        billingRepository.addBilling(billing);

    }

    public void viewBilling() throws SQLException {

        Billing billing = new Billing();

        List<Billing> billingList = new ArrayList<>();

        billingRepository.viewBilling(billing);

        System.out.println("bill generated: "+billingList);
    }

    public void updateBilling(int billId,int totalBill){

    }

    public void deleteBilling(int billId) throws SQLException {
        boolean removedBilling = billingRepository.deleteBilling(billId);
        System.out.println("removed bill: "+removedBilling);
    }
}


