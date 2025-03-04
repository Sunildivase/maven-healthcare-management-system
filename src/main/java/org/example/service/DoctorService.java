package org.example.service;

import org.example.exception.InvalidContact;
import org.example.exception.InvalidExperienceException;
import org.example.model.Doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorService {

    private static Scanner scanner = new Scanner(System.in);

    List<Doctor> doctorList = new ArrayList<>();

    void printDoctor(Doctor doctor){
        System.out.println(doctor);
    }

    public void addDoctor(){
        System.out.println("please enter doctor id");
        int doctorId=0;
        try{
            doctorId = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException nfe){
            throw new NumberFormatException("enter valid input");
        }

        if(doctorId<=0){
            throw new NumberFormatException("please enter valid number");
        }

        System.out.println("please enter first Name");
        String firstName = scanner.nextLine();

        System.out.println("please enter last Name");
        String lastName = scanner.nextLine();

        System.out.println("please enter age");
        int age = 0;
        try{
            age =  Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("enter valid input");
        }

        if(age <= 0){
            throw new NumberFormatException("enter valid input");
        }

        System.out.println("please enter gender");
        String gender = scanner.nextLine();

        System.out.println("please enter contactNo");
        Long contactNo =0L;
        try{
            contactNo = Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("enter valid input");
        }
        if(contactNo !=10){

        }else{
            throw new InvalidContact("enter valid input");
        }

        System.out.println("please enter speciality");
        String speciality = scanner.nextLine();

        System.out.println("please enter experience");
        int experience=0;
        try{
            experience = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("enter valid input");
        }
        if(experience < 0){
            throw new InvalidExperienceException("enter valid experience");
        }

        Doctor doctor = new Doctor();
        doctor.setDoctorId(doctorId);
        doctor.setFirstName(firstName);
        doctor.setLastName(lastName);
        doctor.setAge(age);
        doctor.setGender(gender);
        doctor.setContactNo(contactNo);
        doctor.setSpeciality(speciality);
        doctor.setExperience(experience);

        doctorList.add(doctor);

    }

    public void viewDoctor(){
        for(Doctor doctor: doctorList){
            System.out.println("doctor list: "+doctor);
        }
    }

    public void deleteDoctor(int doctorId){
        Doctor removedDoctor=doctorList.remove(doctorId);
        System.out.println("removed doctor: "+removedDoctor);
    }
}
