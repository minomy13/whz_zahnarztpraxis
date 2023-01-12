package practise;

import practise.employees.employeeFiles.EmployeeHandler;
import practise.calendar1.Calendar1;
import practise.patients.PatientHandler;
import practise.patients.treatment.*;
import practise.stock.StockHandler;
import practise.patients.treatment.Rooms;
import utils.logger.Logger;

import java.util.ArrayList;

public class Practise {
    public Logger logger = new Logger();
    private double budget;
    private PatientHandler patientHandler;
    private StockHandler stockHandler;
    private EmployeeHandler employeeHandler;
    private Calendar1 calendar;
    private ArrayList<Rooms> roomHandler = new ArrayList<>();

    /**
     * Creates a new practise.
     *
     * @param budget Budget to start with
     * @param hour Time: amount of full hours since 00:00
     * @param minute Time: amount of full minutes since last full hour
     */
    public Practise(double budget,int year, int month, int dayOfMonth, int hour,int minute) {
        this.budget = budget;

        // creates a new instance for every handler
        this.calendar = new Calendar1(year, month, dayOfMonth, hour, minute);
        this.employeeHandler = new EmployeeFileHandler();
        this.patientHandler = new PatientHandler(this);
        this.stockHandler = new StockHandler(this);
    }

    public void addRoom(TreatmentType treatmenttype)
    {
        roomHandler.add(new Rooms(treatmenttype));
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

    public EmployeeFileHandler getEmployeeHandler() {
        return employeeHandler;
    }

    public PatientHandler getPatientHandler() {
        return patientHandler;
    }

    public StockHandler getStockHandler() {
        return stockHandler;
    }
}
