package practise.patients.patientFiles;

import java.util.ArrayList;

public class PatientFileHandler {
    final ArrayList<PatientFile> files = new ArrayList<>();

    /**
     * Creates a new patient file
     *
     * @param name Name of new patient
     */
    public void create(String name, int yearOfBirth) {
        files.add(new PatientFile(name, yearOfBirth));
    }

    /**
     * Removes a patient file
     *
     * @param index Patient index, use viewFiles to view indexes
     */
    public void remove(int index) {
        files.remove(index);
    }

    /**
     * Displays all patient names with their index
     */
    public void viewFiles() {
        int i = 0;
        for (PatientFile p : files) {
            System.out.println(i + ": " + p.getPatient().getName());
            i++;
        }
    }

    public PatientFile getFileByNameAndBirth(String name, int yearOfBirth) throws Exception {
        boolean found = false;
        int i = 0;
        while (!found && (i < files.size())) {
            if ((files.get(i).getPatient().getName().equals(name)) && (files.get(i).getPatient().getYearOfBirth() == yearOfBirth)) {
                return files.get(i);
            } else {
                i++;
            }
        }
        throw new Exception("No such patient!");
    }

    public ArrayList<PatientFile> getFiles() {
        return files;
    }
}
