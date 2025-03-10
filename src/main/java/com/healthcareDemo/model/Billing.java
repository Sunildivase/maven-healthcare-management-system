package com.healthcareDemo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data

public class Billing {
    private int billId;
    private int bill;
    private int totalBill;
    private int personId;

//    @Override
//    public String toString() {
//        return "Billing{" +
//                "billId=" + billId +
//                ", bill=" + bill +
//                ", totalBill=" + totalBill +
//                ", personId=" + personId +
//                '}';
//    }
//
//    public Billing(int billId, int bill, int totalBill, int personId) {
//        this.billId = billId;
//        this.bill = bill;
//        this.totalBill = totalBill;
//        this.personId = personId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Billing billing = (Billing) o;
//        return billId == billing.billId && bill == billing.bill && totalBill == billing.totalBill && personId == billing.personId;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(billId, bill, totalBill, personId);
//    }
}
