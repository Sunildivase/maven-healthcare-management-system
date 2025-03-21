package com.healthcareDemo.service;

import com.healthcareDemo.model.Prescription;
import com.healthcareDemo.repository.PrescriptionRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PrescriptionService {

    PrescriptionRepository prescriptionRepository = new PrescriptionRepository();

    private static final Scanner scanner = new Scanner(System.in);

    Map<Integer, Prescription> prescriptionMap = new HashMap<>();

    void printPrescription(Prescription prescription){
        System.out.println(prescription);
    }

    public void addPrescription(){

        System.out.println("please enter prescriptionId");
        int prescriptionId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter prescription details");
        String prescriptionDetails = scanner.nextLine();

        System.out.println("please enter personId");
        int personId = Integer.parseInt(scanner.nextLine());

        Prescription prescription = new Prescription(prescriptionId,prescriptionDetails,prescriptionId);

        prescriptionMap.put(prescriptionId,prescription);

    }

    public void viewPrescription(){

        Set<Map.Entry<Integer,Prescription>> entrySet = prescriptionMap.entrySet();
        for(Map.Entry<Integer,Prescription> prescriptionEntry : entrySet){
            System.out.println("key: "+prescriptionEntry.getKey()+" "+"value: "+prescriptionEntry.getValue());
        }
    }

    public void updatePrescription(){

    }
    public void deletePrescription(int prescriptionId){

        Prescription removedPrescription = prescriptionMap.remove(prescriptionId);
        System.out.println("removed prescription: "+removedPrescription);

    }
}
