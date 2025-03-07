package org.example.service;

import org.example.model.Billing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BillingService {

    private static final Scanner scanner = new Scanner(System.in);

    Map<Integer, Billing> billingMap = new HashMap<>();

    void printBilling(Billing billing){
        System.out.println(billing);
    }

    public void addBilling(){

    }
    public void viewBilling(){

    }
    public void updateBilling(){

    }
    public void deleteBilling(){

    }
}
