package practise.patients.patientFiles;

import practise.patients.treatment.TreatmentType;

public class Report {
    final String report;
    final TreatmentType treatmentType;

    public Report(String report, TreatmentType treatmentType) {
        this.report = report;
        this.treatmentType = treatmentType;
    }

    public String getReport() {
        return report;
    }

    public TreatmentType getTreatmentType() {
        return treatmentType;
    }
}
