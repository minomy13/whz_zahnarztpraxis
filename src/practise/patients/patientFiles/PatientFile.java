package practise.patients.patientFiles;

public class PatientFile {
    private static int currentId = 0;
    final Patient patient;
    final int id;
    private Report report;

    /**
     * Creates a new patient file
     *
     * @param name Name of new patient
     */
    public PatientFile(String name, int yearOfBirth) {
        this.patient = new Patient(name, yearOfBirth);
        this.id = currentId++;
    }

    /**
     * Creates a new report for this patient, replacing any previous reports
     *
     * @param report             Report text for this patient
     * @param treatmentTypeIndex Treatment for this patient
     */
    public void createReport(String report, int treatmentTypeIndex) {
        this.report = new Report(report, treatmentTypeIndex);
    }

    public Patient getPatient() {
        return patient;
    }

    public Report getReport() {
        return report;
    }
}
