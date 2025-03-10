package com.healthcareDemo.service;

import com.healthcareDemo.model.Appointment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AppointmentService {

    private static final Scanner scanner = new Scanner(System.in);

    Map<Integer, Appointment> appointmentMap = new HashMap<>();

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

        appointmentMap.put(appointmentId, appointment);

    }

    public void viewAppointment() {
        Set<Map.Entry<Integer, Appointment>> entrySet = appointmentMap.entrySet();
        for (Map.Entry<Integer, Appointment> appointmentEntry : entrySet) {
            System.out.println("key: " + appointmentEntry.getKey() + " " + "value: " + appointmentEntry.getValue());
        }
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
