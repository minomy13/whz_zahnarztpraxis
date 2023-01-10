package practise.patients.treatment;

import practise.patients.patientFiles.Patient;

public class Treatment {
    private final TreatmentType treatmentType;
    private final Patient patient;

    public Treatment(TreatmentType treatmentType, Patient patient) {
        this.treatmentType = treatmentType;
        this.patient = patient;
    }

    public TreatmentType getTreatmentType() {
        return treatmentType;
    }

    public Patient getPatient() {
        return patient;
    }
}
