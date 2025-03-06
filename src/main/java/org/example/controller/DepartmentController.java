package org.example.controller;

import org.example.exception.InvalidId;
import org.example.service.DepartmentService;

import java.util.Scanner;

public class DepartmentController {

    private static final Scanner scanner = new Scanner(System.in);

    DepartmentService departmentService = new DepartmentService();

    public void run(){
        int option=0;
        do {
            System.out.println("------department-information------");
            System.out.println("1. fill department information");
            System.out.println("2. view departments");
//            System.out.println("3. update department");
            System.out.println("3. delete department");

            System.out.println("please select the option");
            option= Integer.parseInt(scanner.nextLine());

            switch (option){
                case 1:
                    try {
                        departmentService.addDepartment();
                    }catch (NumberFormatException | InvalidId e){
                        System.err.println(e.getMessage());
                    }
                    break;

                case 2:
                    departmentService.viewDepartment();
                    break;

//                case 3:
//                    departmentService.updateDepartment(1,"Orthopedic");
//                    break;

                case 3:
                    departmentService.deleteDepartment(1);
                    break;

                default:
                    System.out.println("please enter valid input");
                    break;
            }

        }while(option!=0);{
            System.out.println("Thank you!!!");
        }
   }
}
