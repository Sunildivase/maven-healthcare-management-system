package com.healthcareDemo.service;

import com.healthcareDemo.exception.InvalidContact;
import com.healthcareDemo.exception.InvalidEmail;
import com.healthcareDemo.model.Hospital;

import java.util.*;

public class HospitalService {

    private static final Scanner scanner = new Scanner(System.in);

    List<Hospital> hospitalList = new ArrayList<>();

    void printHospital(Hospital hospital){
        System.out.println(hospital);
    }

    public void addHospital(){

        System.out.println("please enter hospital id");
        int hospitalId=0;
        try {
             hospitalId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("enter valid number");
        }

        if(hospitalId<=0){
            throw new NumberFormatException("please enter positive number");
        }

        System.out.println("please enter hospital name");
        String hospitalName = scanner.nextLine();

        System.out.println("please enter address");
        String address = scanner.nextLine();

        System.out.println("please enter email id");
        String emailId = scanner.nextLine();
        if(emailId.contains("@")){

        }
        else{
            throw new InvalidEmail("please enter valid email");
        }

        System.out.println("please enter contactNo");
        Long contactNo= 0L;
        try {
             contactNo = Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("please enter valid input");
        }

        if(contactNo != 10){

        }else{
            throw new InvalidContact("please enter 10 digit number");
        }

        // code optimized by using constructor.

        Hospital hospital = new Hospital(hospitalId,hospitalName,address,emailId,contactNo);

        hospitalList.add(hospital);
    }
    public void viewHospital(){

        for(Hospital hospital: hospitalList){
            System.out.println("hospital list: "+hospital);
        }
    }
    public void deleteHospital(int hospitalId){

        Hospital removedHospital=hospitalList.remove(hospitalId);
    }
}
