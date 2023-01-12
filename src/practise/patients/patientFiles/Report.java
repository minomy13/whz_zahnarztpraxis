package practise.patients.patientFiles;

public class Report {
    private final String report;
    private final int treatmentTypeIndex;

    public Report(String report, int treatmentTypeIndex) {
        this.report = report;
        this.treatmentTypeIndex = treatmentTypeIndex;
    }

    public String getReport() {
        return report;
    }

    public int getTreatmentType() {
        return treatmentTypeIndex;
    }
}
