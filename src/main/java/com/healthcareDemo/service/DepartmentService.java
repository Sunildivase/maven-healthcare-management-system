package com.healthcareDemo.service;

import com.healthcareDemo.exception.InvalidId;
import com.healthcareDemo.model.Department;
import com.healthcareDemo.repository.DepartmentRepository;

import java.sql.SQLException;
import java.util.*;

public class DepartmentService {

    private static final Scanner scanner = new Scanner(System.in);

    Map<Integer, Department> departmentMap = new HashMap<>();

    DepartmentRepository departmentRepository = new DepartmentRepository();

    void printDepartment(Department department){
        System.out.println(department);
    }

    public Department addDepartment() throws SQLException {

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

        System.out.println("department inserted successfully");

        departmentRepository.addDepartment(department);

        return department;
    }

    public List<Department> viewDepartment() throws SQLException {

        Department department = new Department();

        List<Department> departmentList =departmentRepository.viewDepartment(department);

        System.out.println("departments: "+departmentList);

        return departmentList;

    }

//    public void updateDepartment(int deptId,String deptName){
//
//    }

    public void deleteDepartment(int deptId) throws SQLException {

        boolean removedDepartment = departmentRepository.deleteDepartment(deptId);
        System.out.println("removed department: "+removedDepartment);
    }
}
