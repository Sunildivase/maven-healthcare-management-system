package com.healthcareDemo.repository;

import com.healthcareDemo.model.Doctor;
import com.healthcareDemo.service.ConnectionService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepository {

    private static Connection connection = null;

    private void initConnection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = new ConnectionService().getConnection();
        }
    }
    public boolean addDoctor(Doctor doctor){
        try{
            this.initConnection();
            Statement statement = connection.createStatement();
            return statement.execute("insert into doctor (doctorId, firstName, lastName, age, gender, contactNo, speciality, experience) values ("+doctor.getDoctorId()+", '"+doctor.getFirstName()+"', '"+doctor.getLastName()+"', "+doctor.getAge()+", '"+doctor.getGender()+"', '"+doctor.getContactNo()+"', '"+doctor.getSpeciality()+"', "+doctor.getExperience()+");");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            try {
            if(connection!=null){
                connection.close();
            }
            } catch (SQLException e) {
                System.err.println("connection closed: "+e.getMessage());
            }

        }

    }

    public List<Doctor> viewDoctor(Doctor doctor){

        List<Doctor> doctorList = new ArrayList<>();

        try{
            this.initConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from doctor");
            while (resultSet.next()){
                int doctorId= resultSet.getInt("doctorId");
                String firstName = resultSet.getString("firstName");

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
        return doctorList;
    }

    public boolean deleteDoctor(int doctorId){

        try {
            this.initConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("delete from doctor where doctorId="+doctorId);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(connection!=null){
                try{
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("connection closed: "+e.getMessage());
                }
            }
        }
        return false ;
    }
}
