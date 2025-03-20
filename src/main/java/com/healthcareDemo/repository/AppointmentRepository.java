package com.healthcareDemo.repository;

import com.healthcareDemo.model.Appointment;
import com.healthcareDemo.service.ConnectionService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AppointmentRepository {

    private static Connection connection = null;

    public void initConnection() throws SQLException {
        if(connection == null || connection.isClosed()){
            connection = new ConnectionService().getConnection();
        }
    }

    public void addAppointment(Appointment appointment){

    }

    public List<Appointment> viewAppointment(Map<Integer, Appointment> appointment){

        return null;
    }

    public void deleteAppointment(int appointmentId){

    }
}
