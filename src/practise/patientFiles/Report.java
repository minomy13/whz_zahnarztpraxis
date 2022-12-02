package practise.patientFiles;

import practise.treatment.Treatment;

public class Report {
    final String report;
    final Treatment treatment;

    public Report(String report, Treatment treatment) {
        this.report = report;
        this.treatment = treatment;
    }

    public String getReport() {
        return report;
    }

    public Treatment getTreatment() {
        return treatment;
    }
}
