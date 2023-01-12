package practise;

import practise.employees.EmployeeHandler;
import practise.calendar1.Calendar1;
import practise.patients.AppointmentCalendar;
import practise.patients.PatientHandler;
import practise.patients.patientFiles.Appointment;
import practise.patients.patientFiles.PatientFile;
import practise.patients.treatment.*;
import practise.stock.StockHandler;
import practise.patients.treatment.Rooms;
import utils.logger.Logger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map.Entry;

public class Practise {
    public Logger logger = new Logger();
    private double budget;
    private final PatientHandler patientHandler = new PatientHandler(this);
    private final StockHandler stockHandler = new StockHandler(this);
    private final EmployeeHandler employeeHandler = new EmployeeHandler(this);
    private Calendar1 calendar;
    private ArrayList<Rooms> roomHandler = new ArrayList<>();
    private final AppointmentCalendar appointmentCalendar = new AppointmentCalendar();

    /**
     * Creates a new practise.
     *
     * @param budget Budget to start with
     * @param hour Time: amount of full hours since 00:00
     * @param minute Time: amount of full minutes since last full hour
     */
    public Practise(double budget,int year, int month, int dayOfMonth, int hour,int minute, int second) {
        this.budget = budget;
        this.calendar = new Calendar1(year, month, dayOfMonth, hour, minute, second);
    }

    public void addRoom(TreatmentType treatmenttype)
    {
        roomHandler.add(new Rooms(treatmenttype));
    }

    public void advanceTime(int days, int hours) throws Exception {
        if (days<0 || hours<0) {
            throw new Exception("Invalid parameters! Need to be at least 0!");
        } else {
            calendar.advanceDays(days);
            calendar.advanceHours(hours);
            boolean done=false;
            while (!done) {
                boolean found=false;
                boolean through=false;
                Iterator<Entry<Appointment, PatientFile>> it = appointmentCalendar.getAppointmentMap().entrySet().iterator();
                Entry<Appointment, PatientFile> result;
                while (!found && !through) {
                    if (!it.hasNext()) {
                        through=true;
                    } else {
                        Entry<Appointment, PatientFile> entry = it.next();
                        Calendar ca = Calendar.getInstance();
                        ca.set(Calendar.YEAR, entry.getKey().getYear());
                        ca.set(Calendar.MONTH, entry.getKey().getMonth());
                        ca.set(Calendar.DAY_OF_MONTH, entry.getKey().getDayOfMonth());
                        ca.set(Calendar.HOUR_OF_DAY, entry.getKey().getHour());
                        if (calendar.getCal().after(ca)) {
                            result = entry;
                            found = true;
                        }
                    }
                }
                if (result == null) { //Fehlermeldung von IntelliJ ist Fehlalarm
                    done=true;
                } else {
                    patientHandler.startTreatment(result.getValue().getReport().getTreatmentType(),result.getValue().getPatient());
                    appointmentCalendar.removeAppointment(result.getKey());
                }
            }
        }
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
}
