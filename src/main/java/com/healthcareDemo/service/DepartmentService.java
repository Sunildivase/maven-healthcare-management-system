package com.healthcareDemo.service;

import com.healthcareDemo.exception.InvalidId;
import com.healthcareDemo.model.Department;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DepartmentService {

    private static final Scanner scanner = new Scanner(System.in);

    Map<Integer, Department> departmentMap = new HashMap<>();

    void printDepartment(Department department){
        System.out.println(department);
    }

    public Department addDepartment() {

        System.out.println("please enter dept Id");
        int deptId=0;
        try {
            deptId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("enter valid number");
        }

        if(deptId<0){
            throw new InvalidId("please enter positive number");
        }

        System.out.println("please enter dept Name");
        String deptName = scanner.nextLine();

        System.out.println("please enter doctorId");
        int doctorId=0;
        try {
             doctorId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("enter valid input");
        }

        if(doctorId<0){
            throw new InvalidId("please enter positive number");
        }

        System.out.println("please enter hospitalId");
        int hospitalId=0;
        try {
             hospitalId = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            throw new NumberFormatException("enter valid number");
        }

        if(hospitalId<0){
            throw new InvalidId("please enter positive number");
        }

        // used constructor for optimize the code
        Department department = new Department(deptId, deptName, doctorId, hospitalId);

        departmentMap.put(deptId, department);
        return department;
    }

    public void viewDepartment(){
        Set<Map.Entry<Integer,Department>> entrySet = departmentMap.entrySet();
        for(Map.Entry<Integer,Department> departmentEntry: entrySet){
            System.out.println("key: "+departmentEntry.getKey()+" "+"value: "+departmentEntry.getValue());
        }

    }

//    public void updateDepartment(int deptId,String deptName){
//
//    }

    public void deleteDepartment(int deptId){

        Department removedDepartment = departmentMap.remove(deptId);
        System.out.println("removed department: "+removedDepartment);
    }
}
