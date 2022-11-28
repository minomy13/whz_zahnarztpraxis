package practise;

import practise.calendar.Calendar;
import practise.consulatation.ConsultationHandler;
import practise.employees.EmployeeHandler;
import practise.patients.PatientHandler;
import practise.stock.StockHandler;

public class Practise {
    private double budget;

    private Calendar calendar;
    private ConsultationHandler consultationHandler;
    private EmployeeHandler employeeHandler;
    private PatientHandler patientHandler;
    private StockHandler stockHandler;

    /**
     * Creates a new practise.
     *
     * @param budget Budget to start with
     */
    public Practise(double budget) {
        this.budget = budget;

        // creates a new instance for every handler
        this.calendar = new Calendar();
        this.consultationHandler = new ConsultationHandler();
        this.employeeHandler = new EmployeeHandler();
        this.patientHandler = new PatientHandler();
        this.stockHandler = new StockHandler();
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

    public Calendar getCalendar() {
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
