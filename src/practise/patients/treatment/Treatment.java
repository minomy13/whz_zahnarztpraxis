package practise.patients.treatment;

import practise.patients.patientFiles.PatientFile;

public class Treatment {
    private final TreatmentType treatmentType;
    private final PatientFile patientFile;

    public Treatment(TreatmentType treatmentType, PatientFile patientFile) {
        this.treatmentType = treatmentType;
        this.patientFile = patientFile;
    }

    public TreatmentType getTreatmentType() {
        return treatmentType;
    }

    public PatientFile getPatientFile() {
        return patientFile;
    }
}
