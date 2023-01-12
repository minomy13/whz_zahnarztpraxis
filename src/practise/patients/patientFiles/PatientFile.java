package practise.patients.patientFiles;

import practise.patients.treatment.TreatmentType;

public class PatientFile {
    final Patient patient;
    private Report report;
    final int id;
    private static int currentId = 0;

    /**
     * Creates a new patient file
     *
     * @param name Name of new patient
     */
    public PatientFile(String name) {
        this.patient = new Patient(name);
        this.id = currentId++;
    }

    /**
     * Creates a new report for this patient, replacing any previous reports
     *
     * @param report    Report text for this patient
     * @param treatment Treatment for this patient
     */
    public void createReport(String report, TreatmentType treatment) {
        this.report = new Report(report, treatment);
    }

    public Patient getPatient() {
        return patient;
    }

    public Report getReport() {
        return report;
    }
}
