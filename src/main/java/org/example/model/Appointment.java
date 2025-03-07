package org.example.model;

import java.util.Objects;

public class Appointment {
    private int appointmentId;
    private int personId;
    private int doctorId;
    private int hospitalId;
    private int departmentId;

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", personId=" + personId +
                ", doctorId=" + doctorId +
                ", hospitalId=" + hospitalId +
                ", departmentId=" + departmentId +
                '}';
    }

    public Appointment(int appointmentId, int personId, int doctorId, int hospitalId, int departmentId) {
        this.appointmentId = appointmentId;
        this.personId = personId;
        this.doctorId = doctorId;
        this.hospitalId = hospitalId;
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return appointmentId == that.appointmentId && personId == that.personId && doctorId == that.doctorId && hospitalId == that.hospitalId && departmentId == that.departmentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, personId, doctorId, hospitalId, departmentId);
    }
}
