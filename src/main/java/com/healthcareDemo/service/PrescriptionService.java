package com.healthcareDemo.service;

import com.healthcareDemo.model.Prescription;
import com.healthcareDemo.repository.PrescriptionRepository;

import java.sql.SQLException;
import java.util.*;

public class PrescriptionService {

    PrescriptionRepository prescriptionRepository = new PrescriptionRepository();

    private static final Scanner scanner = new Scanner(System.in);

    Map<Integer, Prescription> prescriptionMap = new HashMap<>();

    void printPrescription(Prescription prescription){
        System.out.println(prescription);
    }

    public void addPrescription() throws SQLException {

        System.out.println("please enter prescriptionId");
        int prescriptionId = Integer.parseInt(scanner.nextLine());

        System.out.println("please enter prescription details");
        String prescriptionDetails = scanner.nextLine();

        System.out.println("please enter personId");
        int personId = Integer.parseInt(scanner.nextLine());

        Prescription prescription = new Prescription(prescriptionId,prescriptionDetails,personId);

        prescriptionRepository.addPrescription(prescription);

    }

    public List<Prescription> viewPrescription() throws SQLException {

        Prescription prescription = new Prescription();

        List<Prescription> prescriptionList =prescriptionRepository.viewPrescription(prescription);

        return prescriptionList;
    }

    public void updatePrescription(){

    }
    public void deletePrescription(int prescriptionId) throws SQLException {

        boolean removedPrescription = prescriptionRepository.deletePrescription(prescriptionId);
        System.out.println("removed prescription: "+removedPrescription);

    }
}
