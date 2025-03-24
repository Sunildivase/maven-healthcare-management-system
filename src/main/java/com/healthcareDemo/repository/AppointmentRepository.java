package com.healthcareDemo.repository;

import com.healthcareDemo.model.Appointment;
import com.healthcareDemo.service.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {

    private static Connection connection = null;

    public void initConnection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = new ConnectionService().getConnection();
        }
    }

    private static final List<Appointment> appointmentList = new ArrayList<>();

    public boolean addAppointment(Appointment appointment) throws SQLException {

        this.initConnection();
        String query = "insert into appointment(appointmentId,personId,doctorId,hospitalId,deptId) values(?,?,?,?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,appointment.getAppointmentId());
            preparedStatement.setInt(2,appointment.getPersonId());
            preparedStatement.setInt(3,appointment.getDoctorId());
            preparedStatement.setInt(4,appointment.getHospitalId());
            preparedStatement.setInt(5,appointment.getDepartmentId());

            System.out.println("inserting data: "+appointment);

            int rowInserted = preparedStatement.executeUpdate();

            return rowInserted > 0;
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

    public boolean updateAppointment(Appointment appointment) throws SQLException {

        this.initConnection();
        String query = "update appointment set personId=?,doctorId=?,hospitalId=?,deptId=? where appointmentId=?";
        try(PreparedStatement preparedStatement=connection.prepareStatement(query)){
            preparedStatement.setInt(1,appointment.getAppointmentId());
            preparedStatement.setInt(2,appointment.getPersonId());
            preparedStatement.setInt(3,appointment.getDoctorId());
            preparedStatement.setInt(4,appointment.getHospitalId());
            preparedStatement.setInt(5,appointment.getDepartmentId());

            System.out.println("updated data: "+preparedStatement);

            int updatedRow = preparedStatement.executeUpdate();

            return updatedRow > 0;
        }

    }

    public List<Appointment> viewAppointment(Appointment appointment) throws SQLException {

        this.initConnection();

        try{
            String query = "select * from appointment";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()){

                int appointmentId = resultSet.getInt("appointmentId");
                int personId = resultSet.getInt("personId");
                int doctorId = resultSet.getInt("doctorId");
                int hospitalId = resultSet.getInt("hospitalId");
                int deptId = resultSet.getInt("deptId");

                appointmentList.add(appointment);

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

        return appointmentList;
    }

    public boolean deleteAppointment(int appointmentId) throws SQLException {

        this.initConnection();
        String query = "delete from appointment where appointmentId=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,appointmentId);


            System.out.println("deleted row: "+appointmentId);

            int deletedRow = preparedStatement.executeUpdate();

            return deletedRow > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
