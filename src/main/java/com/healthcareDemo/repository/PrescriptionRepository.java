package com.healthcareDemo.repository;

import com.healthcareDemo.model.Prescription;
import com.healthcareDemo.service.ConnectionService;
import com.healthcareDemo.service.PrescriptionService;

import java.sql.Connection;
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

    public boolean addPrescription(Prescription prescription){

        return false;
    }

    public boolean viewPrescription(Prescription prescription){

        return false;
    }

    public boolean updatePrescription(Prescription prescription){

        return false;
    }

    public boolean deletePrescription(int prescriptionId){

        return false;
    }
}
