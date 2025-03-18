package com.healthcareDemo.repository;

import com.healthcareDemo.model.Hospital;
import com.healthcareDemo.service.ConnectionService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HospitalRepository {

    private static Connection connection = null;

    private void initConnection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = new ConnectionService().getConnection();
        }
    }

    List<Hospital> hospitalList = new ArrayList<>();

    public boolean addHospital(Hospital hospital){

        try{
            this.initConnection();
            Statement statement = connection.createStatement();
            return statement.execute("INSERT INTO hospital(hospitalId,hospitalName,address,emailId,contactNo) values("+hospital.getHospitalId()+",'"+hospital.getHospitalName()+"','"+hospital.getAddress()+"','"+hospital.getEmailId()+"',"+hospital.getContactNo()+")");
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


    }

    public List<Hospital> viewHospital(Hospital hospital){

        try{
            this.initConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM hospital");
            while (resultSet.next()){
                int hospitalId = resultSet.getInt("hospitalId");
                String hospitalName = resultSet.getString("hospitalName");
                String address = resultSet.getString("address");
                String emailId = resultSet.getString("emailId");
                Long contactNo = resultSet.getLong("contactNo");

                hospitalList.add(hospital);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if(connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("connection closed: "+e.getMessage());
            }
        }

        return hospitalList;
    }

    public boolean deleteHospital(int hospitalId){

        return false;
    }
}
