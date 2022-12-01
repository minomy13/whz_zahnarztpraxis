package practise.patientFiles;

import practise.treatment.Treatment;

public class PatientFile {
    final Patient patient;
    private Report report;

    /** Creates a new patient file
     *
     * @param name Name of new patient
     */
    public PatientFile(String name) {
        this.patient = new Patient(name);
    }

    /** Creates a new report for this patient, replacing any previous reports
     *
     * @param report Report text for this patient
     * @param treatment Treatment for this patient
     */
    public void createReport(String report, Treatment treatment) {
        this.report = new Report(report, treatment);
    }

    public Patient getPatient() {
        return patient;
    }

    public Report getReport() {
        return report;
    }
}
