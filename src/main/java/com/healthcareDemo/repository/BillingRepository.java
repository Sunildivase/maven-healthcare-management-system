package com.healthcareDemo.repository;

import com.healthcareDemo.model.Billing;
import com.healthcareDemo.service.ConnectionService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillingRepository {

    private static Connection connection = null;

    List<Billing> billingList = new ArrayList<>();

    public void initConnection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = new ConnectionService().getConnection();
        }
    }

    public boolean payment(Billing billing){

        return false;
    }

    public boolean receipt(Billing billing){

        return false;
    }

    public boolean deletePayment(int billId){

        return false;
    }
}
