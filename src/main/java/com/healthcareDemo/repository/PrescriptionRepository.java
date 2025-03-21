package com.healthcareDemo.repository;

import com.healthcareDemo.model.Prescription;
import com.healthcareDemo.service.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionRepository {

    private static Connection connection = null;

    List<Prescription> prescriptionList = new ArrayList<>();

    public void initConnection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = new ConnectionService().getConnection();
        }
    }

    public boolean addPrescription(Prescription prescription) throws SQLException {

        this.initConnection();
        String query = "insert into prescription(prescriptionId,prescriptionDetails,personId) values (?,?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,prescription.getPrescriptionId());
            preparedStatement.setString(2,prescription.getPrescriptionDetails());
            preparedStatement.setInt(3,prescription.getPersonId());

            System.out.println("inserted data: "+prescription);

            int insertedRow = preparedStatement.executeUpdate();

            return insertedRow > 0;
        }
        finally {
            try{
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
               System.err.println(e.getMessage());
            }
        }


    }

    public Prescription viewPrescription(Prescription prescription) throws SQLException {


        this.initConnection();
        String query = "select * from prescription";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            System.out.println("view data: "+prescription);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            try{
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return prescription;
    }



    public boolean deletePrescription(int prescriptionId) throws SQLException {

        this.initConnection();
        String query = "delete from prescription where prescriptionId= ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,prescriptionId);

            System.out.println("deleted data: "+prescriptionId);

            int deletedRow = preparedStatement.executeUpdate();

            return deletedRow > 0;
        }catch (SQLException e){
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

    }
}
