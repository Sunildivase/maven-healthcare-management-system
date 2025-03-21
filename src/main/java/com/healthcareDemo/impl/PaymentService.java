package com.healthcareDemo.impl;

import com.healthcareDemo.model.Billing;
import com.healthcareDemo.repository.BillingRepository;
import com.healthcareDemo.service.BillingService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaymentService implements BillingService {

    BillingRepository billingRepository = new BillingRepository();

    private static final Scanner scanner = new Scanner(System.in);

    List<Billing> billings = new ArrayList<>();

    @Override
    public void payment() throws SQLException {

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

        billingRepository.payment(billing);

    }

    public void receipt() throws SQLException {

        Billing billing = new Billing();

        List<Billing> billingList = new ArrayList<>();

        billingRepository.receipt(billing);

        System.out.println("bill generated: "+billingList);
    }

    public void updatePayment(int billId,int totalBill){

    }

    public void deletePayment(int billId) throws SQLException {
        boolean removedBilling = billingRepository.deletePayment(billId);
        System.out.println("removed bill: "+removedBilling);
    }
}
