package practise.patients;

import practise.Practise;
import practise.patients.patientFiles.PatientFileHandler;
import practise.patients.treatment.Treatment;
import practise.stock.Item;
import utils.touple.Touple;

import java.util.ArrayList;

public class PatientHandler {
    final PatientFileHandler patientFileHandler = new PatientFileHandler();
    final ArrayList<Treatment> treatments = new ArrayList<>();
    private final Practise practise;

    public PatientHandler(Practise practise) {
        this.practise = practise;
    }

    /**
     * Creates a new type of treatment
     *
     * @param name Name of treatment
     * @param cost Cost of treatment
     */
    public void addTreatment(String name, double cost, ArrayList<Touple<Item, Integer>> needs) {
        treatments.add(new Treatment(name, cost, needs));
    }

    /**
     * Removes a type of treatment
     *
     * @param index Treatment index, use viewTreatments to view indexes
     */
    public void removeTreatment(int index) {
        treatments.remove(index);
    }

    /**
     * Displays all Treatment names and costs with their index
     */
    public void viewTreatments() {
        int i = 0;
        for (Treatment t : treatments) {
            System.out.println(i + ": " + t.getName() + ", " + t.getCost());
            i++;
        }
    }

    public ArrayList<Treatment> getTreatments() {
        return treatments;
    }

    public PatientFileHandler getPatientFileHandler() {
        return patientFileHandler;
    }
}