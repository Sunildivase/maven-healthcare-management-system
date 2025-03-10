package com.healthcareDemo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data

public class Prescription {
    private int prescriptionId;
    private String  prescriptionDetails;
    private int personId;

//    @Override
//    public String toString() {
//        return "Prescription{" +
//                "prescriptionId=" + prescriptionId +
//                ", prescriptionDetails='" + prescriptionDetails + '\'' +
//                ", personId=" + personId +
//                '}';
//    }
//
//    public Prescription(int prescriptionId, String prescriptionDetails, int personId) {
//        this.prescriptionId = prescriptionId;
//        this.prescriptionDetails = prescriptionDetails;
//        this.personId = personId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Prescription that = (Prescription) o;
//        return prescriptionId == that.prescriptionId && personId == that.personId && Objects.equals(prescriptionDetails, that.prescriptionDetails);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(prescriptionId, prescriptionDetails, personId);
//    }
}
