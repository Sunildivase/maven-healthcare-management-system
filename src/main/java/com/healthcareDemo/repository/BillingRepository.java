package com.healthcareDemo.repository;

import com.healthcareDemo.model.Billing;
import com.healthcareDemo.service.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public List<Billing> viewBilling(Billing billing) throws SQLException {


        this.initConnection();

        try{
            String query = "select * from billing";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()){
                int billId = resultSet.getInt("billId");
                int bill = resultSet.getInt("bill");
                int totalBill = resultSet.getInt("totalBill");
                int personId = resultSet.getInt("personId");
            }

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

        return billingList;
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

