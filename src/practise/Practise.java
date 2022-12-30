package practise;

import practise.calendar1.Calendar1;
import practise.consulatation.ConsultationHandler;
import practise.employees.EmployeeHandler;
import practise.patients.PatientHandler;
import practise.stock.StockHandler;
import practise.clock.Clock;
import utils.logger.Logger;

public class Practise {
    public Logger logger = new Logger();
    private double budget;
    private Calendar1 calendar;
    private ConsultationHandler consultationHandler;
    private EmployeeHandler employeeHandler;
    private PatientHandler patientHandler;
    private StockHandler stockHandler;
    private final Clock clock;

    /**
     * Creates a new practise.
     *
     * @param budget Budget to start with
     * @param hour Time: amount of full hours since 00:00
     * @param minute Time: amount of full minutes since last full hour
     */
    public Practise(double budget,int hour,int minute) {
        this.budget = budget;

        // creates a new instance for every handler
        this.calendar = new Calendar1();
        this.consultationHandler = new ConsultationHandler();
        this.employeeHandler = new EmployeeHandler();
        this.patientHandler = new PatientHandler(this);
        this.stockHandler = new StockHandler(this);
        this.clock = new Clock(hour,minute,1);
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

    public ConsultationHandler getConsultationHandler() {
        return consultationHandler;
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
