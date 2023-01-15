package practise.patients;

import practise.patients.patientFiles.Appointment;
import practise.patients.patientFiles.PatientFile;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AppointmentCalendar {
    final HashMap<Appointment, PatientFile> appointmentMap = new HashMap<>();

    /**
     * Adds an appointment at the specified time for the specified patient.
     * @param year Year of appointment
     * @param month Month of appointment, 0 means January
     * @param dayOfMonth Day of appointment
     * @param hour Start time hour of appointment
     * @param minute Start time minute of appointment
     * @param hour0 End time hour of appointment
     * @param minute0 End time minute of appointment
     * @param patientFile Patient who the appointment is for
     */
    public void addAppointment(int year, int month, int dayOfMonth, int hour, int minute, int hour0, int minute0, PatientFile patientFile) {
        appointmentMap.put(new Appointment(year, month, dayOfMonth, hour, minute, hour0, minute0), patientFile);
    }

    /**
     * Removes the specified appointment from the Calendar
     * @param appointment Appointment to be removed
     */
    public void removeAppointment(Appointment appointment) {
        appointmentMap.remove(appointment);
    }

    /**
     * Displays all appointments for the specified day on the console
     * @param year Current year
     * @param month Current month, 0 means January
     * @param dayOfMonth Current day
     */
    public void viewAppointments(int year, int month, int dayOfMonth) {
        appointmentMap.entrySet().stream()
                .filter(e -> (e.getKey().getYear()==year) && (e.getKey().getMonth()==month) && (e.getKey().getDayOfMonth()==dayOfMonth))
                .forEach(e -> System.out.println(e.getKey().getHour()+" Uhr bis "+e.getKey().getHour0()+" Uhr: "+e.getValue().getPatient().getName()));
    }

    /**
     * Displays the appointment at the specified time on the console, or a notification if there is none
     * @param year Year of appointment
     * @param month Month of appointment, 0 means January
     * @param dayOfMonth Day of appointment
     * @param hour Time of appointment
     */
    public void searchAppointmentByTime(int year, int month, int dayOfMonth, int hour, int minute) {
        Optional<Map.Entry<Appointment, PatientFile>> o = appointmentMap.entrySet().stream()
                .filter(e -> (e.getKey().getYear() == year) && (e.getKey().getMonth() == month) && (e.getKey().getDayOfMonth() == dayOfMonth)
                        && ((e.getKey().getHour()*60+e.getKey().getMinute()) <= (hour*60+minute)) && ((e.getKey().getHour0()*60+e.getKey().getMinute0()) >= (hour*60+minute)))
                .findAny();
        if (o.isPresent()) {
            System.out.println(o.get().getKey().getHour()+" Uhr bis "+o.get().getKey().getHour0()+" Uhr: "+o.get().getValue().getPatient().getName());
        } else {
            System.out.println("There is no appointment at this time!");
        }
    }

    /**
     * Returns the appointment at the specified time, or throws an Exception if there is none
     * @param year Year of appointment
     * @param month Month of appointment, 0 means January
     * @param dayOfMonth Day of appointment
     * @param hour Time of appointment
     * @return Resulting appointment
     * @throws Exception In case there is no appointment at the specified time
     */
    public Appointment getAppointmentByTime(int year, int month, int dayOfMonth, int hour, int minute) throws Exception {
        Optional<Map.Entry<Appointment, PatientFile>> o = appointmentMap.entrySet().stream()
                .filter(e -> (e.getKey().getYear() == year) && (e.getKey().getMonth() == month) && (e.getKey().getDayOfMonth() == dayOfMonth)
                        && ((e.getKey().getHour()*60+e.getKey().getMinute()) <= (hour*60+minute)) && ((e.getKey().getHour0()*60+e.getKey().getMinute0()) >= (hour*60+minute)))
                .findAny();
        if (o.isPresent()) {
            return o.get().getKey();
        } else {
            throw new Exception("There is no appointment at this time!");
        }
    }

    /**
     * Displays the appointment for the specified patient on the console, or a notification if there is none
     * @param patientFile Patient who the appointment is for
     */
    public void searchAppointmentByPatient(PatientFile patientFile) {
        Optional<Map.Entry<Appointment, PatientFile>> o = appointmentMap.entrySet().stream()
                .filter(e -> e.getValue()==patientFile)
                .findAny();
        if (o.isPresent()) {
            System.out.println(o.get().getKey().getHour()+" Uhr bis "+o.get().getKey().getHour0()+" Uhr: "+o.get().getValue().getPatient().getName());
        } else {
            System.out.println("This patient has no appointment!");
        }
    }

    /**
     * Returns the appointment for the specified patient, or throws an Exception if there is none
     * @param patientFile Patient who the Appointment is for
     * @return Resulting appointment
     * @throws Exception In case there is no Appointment for the specified patient
     */
    public Appointment getAppointmentByPatient(PatientFile patientFile) throws Exception {
        Optional<Map.Entry<Appointment, PatientFile>> o = appointmentMap.entrySet().stream()
                .filter(e -> e.getValue()==patientFile)
                .findAny();
        if (o.isPresent()) {
            return o.get().getKey();
        } else {
            throw new Exception("This patient has no appointment!");
        }
    }

    public HashMap<Appointment, PatientFile> getAppointmentMap() {
        return appointmentMap;
    }
}
