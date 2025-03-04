package org.example.model;

import java.util.Objects;

public class Hospital {
    private int hospitalId;
    private String hospitalName;
    private String address;
    private String emailId;
    private Long contactNo;

    // creating constructor for optimize code

    public Hospital(int hospitalId, String hospitalName, String address, String emailId, Long contactNo) {
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
        this.address = address;
        this.emailId = emailId;
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "hospitalId=" + hospitalId +
                ", hospitalName='" + hospitalName + '\'' +
                ", address='" + address + '\'' +
                ", emailId='" + emailId + '\'' +
                ", contactNo=" + contactNo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospital hospital = (Hospital) o;
        return hospitalId == hospital.hospitalId && Objects.equals(hospitalName, hospital.hospitalName) && Objects.equals(address, hospital.address) && Objects.equals(emailId, hospital.emailId) && Objects.equals(contactNo, hospital.contactNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospitalId, hospitalName, address, emailId, contactNo);
    }
}
