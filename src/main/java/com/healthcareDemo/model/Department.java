package com.healthcareDemo.model;


import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private int deptId;
    private String deptName;
    private int doctorId;
    private int hospitalId;

//    // create constructor for optimize code
//    // doesn't need of getter and setter method.
//
//    public Department(int deptId, String deptName, int doctorId, int hospitalId) {
//        this.deptId = deptId;
//        this.deptName = deptName;
//        this.doctorId = doctorId;
//        this.hospitalId = hospitalId;
//    }
//
//    @Override
//    public String toString() {
//        return "Department{" +
//                "deptId=" + deptId +
//                ", deptName='" + deptName + '\'' +
//                ", doctorId=" + doctorId +
//                ", hospitalId=" + hospitalId +
//                '}';
//    }
//
//    //  using HashMap collection so we need equals and hashcode.
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Department that = (Department) o;
//        return deptId == that.deptId && doctorId == that.doctorId && hospitalId == that.hospitalId && Objects.equals(deptName, that.deptName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(deptId, deptName, doctorId, hospitalId);
//    }
}
