package com.healthcareDemo.repository;

import com.healthcareDemo.model.Billing;
import com.healthcareDemo.service.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillingRepository {

    private static Connection connection = null;

    List<Billing> billingList = new ArrayList<>();

    public void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }

    public boolean addBilling(Billing billing) throws SQLException {
        this.initConnection();
        String query = "insert into billing(billId,bill,totalBill,personId) values (?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, billing.getBillId());
            preparedStatement.setInt(2, billing.getBill());
            preparedStatement.setInt(3, billing.getTotalBill());
            preparedStatement.setInt(4, billing.getPersonId());

            System.out.println("inserted data: " + billing);

            int insertedRow = preparedStatement.executeUpdate();

            return insertedRow > 0;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

    }

    public Billing viewBilling(Billing billing) throws SQLException {


        this.initConnection();
        String query = "select * from billing";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            System.out.println("all records: "+billing);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try{
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("connection closed: "+e.getMessage());
            }
        }

        return billing;
    }

    public boolean deleteBilling(int billId) throws SQLException {
        this.initConnection();
        String query = "delete from billing where billId=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, billId);


            System.out.println("deleted row: " + billId);

            int deletedRow = preparedStatement.executeUpdate();

            return deletedRow > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}

