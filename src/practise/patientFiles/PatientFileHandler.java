package practise.patientFiles;

import java.util.ArrayList;

public class PatientFileHandler {
    final ArrayList<PatientFile> files = new ArrayList<>();

    /** Creates a new patient file
     *
     * @param name Name of new patient
     */
    public void create(String name) {
        files.add(new PatientFile(name));
    }

    /** Removes a patient file
     * @param index Patient index, use viewFiles to view indexes
     */
    public void remove(int index) {
        files.remove(index);
    }

    /** Displays all patient names with their index */
    public void viewFiles() {
        int i = 0;
        for(PatientFile p : files) {
            System.out.println(i+": "+p.getPatient().getName());
            i++;
        }
    }

    public ArrayList<PatientFile> getFiles() {
        return files;
    }
}
