package com.healthcareDemo.model;

import lombok.*;

@Setter
@Getter
@ToString
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Person {
    private int personId;
    private String type;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private Long contactNo;
    private Long alternateMobile;
    private String address;


}
