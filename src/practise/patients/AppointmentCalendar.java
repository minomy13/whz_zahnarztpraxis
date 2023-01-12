package practise.patients;

import practise.patients.patientFiles.*;
import java.util.HashMap;

public class AppointmentCalendar {
    private HashMap<Appointment, PatientFile> appointmentMap = new HashMap<>();

    public void addAppointment(Appointment appointment, PatientFile patientfile) {
        appointmentMap.put(appointment, patientfile);
    }

    public void removeAppointment(Appointment appointment) {
        appointmentMap.remove(appointment);
    }
    //TODO search for appointment and patientFile

    public void viewAppointments(int month, int dayOfMonth) {
        //TODO give out appointments based on filters
    }
}
