package com.healthcareDemo.service;

import com.healthcareDemo.model.Appointment;
import com.healthcareDemo.repository.AppointmentRepository;

import java.sql.SQLException;
import java.util.*;

public class AppointmentService {

    private static final Scanner scanner = new Scanner(System.in);

    Map<Integer, Appointment> appointmentMap = new HashMap<>();

    AppointmentRepository appointmentRepository = new AppointmentRepository();

    void printAppointment(Appointment appointment) {
        System.out.println(appointment);
    }

    public void addAppointment() throws SQLException {

        System.out.println("please enter appointmentId");
        int appointmentId = 0;
        try {
            appointmentId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("enter valid number");
        }

        System.out.println("please enter personId");
        int personId = 0;
        try {
            personId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("enter valid number");
        }
        System.out.println("please enter doctorId");
        int doctorId = 0;
        try {
            doctorId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("enter valid number");
        }

        System.out.println("please enter hospitalId");
        int hospitalId = 0;
        try {
            hospitalId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("enter valid number");
        }

        System.out.println("please enter departmentId");
        int deptId = 0;
        try {
            deptId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("enter valid number");
        }

        Appointment appointment = new Appointment(appointmentId, personId, doctorId, hospitalId, deptId);

        appointmentRepository.addAppointment(appointment);

    }

    public List<Appointment> viewAppointment() throws SQLException {

        Appointment appointment = new Appointment();

        List<Appointment> appointmentList = appointmentRepository.viewAppointment(appointment);

        return appointmentList;
    }

    public void updateAppointment(int appointmentId, int newDoctorId) throws SQLException {

        Appointment appointment = new Appointment();

        List<Appointment> appointmentList = new ArrayList<>();

        if (appointmentList.contains(appointmentId)) {

            appointmentRepository.updateAppointment(appointment);

        } else {
            appointmentRepository.addAppointment(appointment);
        }

    }

    public void deleteAppointment(int appointmentId) throws SQLException {

        boolean removedAppointment = appointmentRepository.deleteAppointment(appointmentId);
        System.out.println("removed appointment: " + removedAppointment);
    }

}
