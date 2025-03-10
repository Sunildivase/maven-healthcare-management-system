package com.healthcareDemo.impl;

import com.healthcareDemo.model.Billing;
import com.healthcareDemo.service.BillingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaymentService implements BillingService {

    private static final Scanner scanner = new Scanner(System.in);

    List<Billing> billings = new ArrayList<>();

    @Override
    public void payment() {

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

        billings.add(billing);

    }

    public void receipt(){
        for(Billing billing: billings){
            System.out.println("bill generated: "+billing);
        }
    }

    public void updatePayment(int billId,int totalBill){

    }

    public void deletePayment(int billId){
        Billing removedBilling = billings.remove(1);
        System.out.println("removed bill: "+removedBilling);
    }
}
