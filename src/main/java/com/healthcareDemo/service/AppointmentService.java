package com.healthcareDemo.service;

import com.healthcareDemo.model.Appointment;
import com.healthcareDemo.repository.AppointmentRepository;

import java.util.*;

public class AppointmentService {

    private static final Scanner scanner = new Scanner(System.in);

    Map<Integer, Appointment> appointmentMap = new HashMap<>();

    AppointmentRepository appointmentRepository = new AppointmentRepository();

    void printAppointment(Appointment appointment) {
        System.out.println(appointment);
    }

    public void addAppointment() {

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

    public void viewAppointment() {

        List<Appointment> appointmentList = appointmentRepository.viewAppointment(appointmentMap);

        System.out.println("appointment: "+appointmentList);
    }

    public void updateAppointment(int appointmentId, int newDoctorId) {
        if (appointmentMap.containsKey(appointmentId)) {

            updateAppointment(appointmentId, newDoctorId);

        } else {
            addAppointment();
        }

    }

    public void deleteAppointment(int appointmentId) {
        Appointment removedAppointment = appointmentMap.remove(appointmentId);
        System.out.println("removed appointment: " + removedAppointment);
    }

}
