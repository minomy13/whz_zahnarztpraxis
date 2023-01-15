package practise;

import org.jetbrains.annotations.NotNull;
import practise.calendar1.Calendar1;
import practise.employees.EmployeeHandler;
import practise.patients.AppointmentCalendar;
import practise.patients.PatientHandler;
import practise.patients.patientFiles.Appointment;
import practise.patients.patientFiles.PatientFile;
import practise.patients.treatment.Rooms;
import practise.patients.treatment.Treatment;
import practise.stock.StockHandler;
import utils.logger.Logger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map.Entry;

public class Practise {
    private final PatientHandler patientHandler = new PatientHandler(this);
    private final StockHandler stockHandler = new StockHandler(this, 5, 10);
    private final EmployeeHandler employeeHandler = new EmployeeHandler(this);
    private final ArrayList<Rooms> roomHandler = new ArrayList<>();
    public Logger logger = new Logger();
    private double budget;
    private Calendar1 calendar;

    /**
     * Creates a new practise.
     *
     * @param budget Budget to start with
     * @param year Current year
     * @param month Current month
     * @param dayOfMonth Current day of month
     * @param hourOfDay Current hour of day
     * @param minute Current minute of hour
     * @param second Current second of minute
     */
    public Practise(double budget, int year, int month, int dayOfMonth, int hourOfDay, int minute, int second) {
        this.budget = budget;
        this.calendar = new Calendar1(year, month, dayOfMonth, hourOfDay, minute, second);
    }

    public void addRoom(Rooms room) {
        roomHandler.add(room);
    }

    //public int getRoomNumber(int index) {return rooms.get(index).getRoomNumber();}

    public void removeRoom(int roomNumber) {
        roomHandler.remove(roomNumber);
    }


    /**
     * Advances the time by the specified amount and executes any appointments that are scheduled for the time that is now past or present
     *
     * @param days  Amount of days to advance by
     * @param hours Amount of hours to advance by
     * @param minutes Amount of minutes to advance by
     * @throws Exception In case the stock was not sufficient for the treatments that need to be executed
     */
    public void advanceTime(int days, int hours, int minutes) throws Exception {
        if (days < 0 || hours < 0 || minutes < 0) {
            throw new RuntimeException("Invalid parameters! Need to be at least 0!");
        } else {
            calendar.advanceDays(days);
            calendar.advanceHours(hours);
            calendar.advanceMinutes(minutes);
            for (Rooms room : roomHandler) {
                room.getAppointmentCalendar().getAppointmentMap().entrySet().stream()
                        .filter(e -> {
                            Calendar ca = Calendar.getInstance();
                            ca.set(e.getKey().getYear(), e.getKey().getMonth(), e.getKey().getDayOfMonth(), e.getKey().getHour(), e.getKey().getMinute());
                            return !calendar.getCal().before(ca);
                        })
                        .forEach(e -> {
                            try {
                                patientHandler.startTreatment(e.getValue().getReport().getTreatmentType(), e.getValue(), room);
                            } catch (Exception ex) {
                                throw new RuntimeException(ex);
                            }
                        });   //Starts all treatments with past or present start time
//                for (Entry<Appointment, PatientFile> entry : room.getAppointmentCalendar().getAppointmentMap().entrySet()) {  //non-functional alternative
//                    Calendar ca = Calendar.getInstance();
//                    ca.set(entry.getKey().getYear(), entry.getKey().getMonth(), entry.getKey().getDayOfMonth(), entry.getKey().getHour(), 0);
//                    if (!calendar.getCal().before(ca)) {
//                        patientHandler.startTreatment(entry.getValue().getReport().getTreatmentType(), entry.getValue());
//                    }
//                }   //Starts all treatments with past or present start time
                boolean through = false;
                while (!through) {
                    Entry<Appointment, PatientFile> result = findFirstEndedAppointment(room.getAppointmentCalendar());
                    if (result == null) {   //if there are no more appointments with past or present end time

                        through = true;
                    } else {
                        patientHandler.endTreatment(patientHandler.getIndex(result.getValue()), room);
                        room.getAppointmentCalendar().removeAppointment(result.getKey());
                    }
                }   //ends all treatments with past or present end time and deletes the corresponding appointments from the appointment calendar
            }
        }
    }

    /**
     * Returns first Appointment with past or present end time in specified Appointment Calendar
     *
     * @param appointmentCalendar Appointment Calendar to search
     * @return Resulting Entry of Appointment and PatientFile, or null if there are no more Appointments with past end time
     */
    public Entry<Appointment, PatientFile> findFirstEndedAppointment(@NotNull AppointmentCalendar appointmentCalendar) {
        boolean found = false;
        boolean through = false;
        Iterator<Entry<Appointment, PatientFile>> it = appointmentCalendar.getAppointmentMap().entrySet().iterator();
        Entry<Appointment, PatientFile> result = null;
        while (!found && !through) {
            if (!it.hasNext()) {
                through = true;
            } else {
                Entry<Appointment, PatientFile> entry = it.next();
                Calendar ca = Calendar.getInstance();
                ca.set(entry.getKey().getYear(), entry.getKey().getMonth(), entry.getKey().getDayOfMonth(), entry.getKey().getHour0(), entry.getKey().getMinute0());
                if (!calendar.getCal().before(ca)) {
                    result = entry;
                    found = true;
                }
            }
        }
        return result;
    }

    /**
     * Increases budget of practise by given amount.
     *
     * @param amount Amount to be increased
     */
    public void increaseBudget(double amount) {
        budget += amount;
    }

    /**
     * Decreases budget of practise by given amount.
     *
     * @param amount Amount to be decreased
     */
    public void decreaseBudget(double amount) {
        budget -= amount;
    }

    public double getBudget() {
        return budget;
    }

    public Calendar1 getCalendar() {
        return calendar;
    }

    public EmployeeHandler getEmployeeHandler() {
        return employeeHandler;
    }

    public PatientHandler getPatientHandler() {
        return patientHandler;
    }

    public StockHandler getStockHandler() {
        return stockHandler;
    }

    public ArrayList<Rooms> getRoomHandler() {
        return roomHandler;
    }


}
