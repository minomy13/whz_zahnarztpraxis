package practise.employees.employeeFiles;

import practise.patients.patientFiles.PatientFile;

import java.util.ArrayList;

public class EmployeeFileHandler {

    public final ArrayList<EmployeeFile> employees = new ArrayList<>();

    public void hireEmployee(String name, String job) {
        employees.add(new EmployeeFile(name, job));
    }

    public void fireEmployee(int index) {
        employees.remove(index);
    }

    public void viewEmployees() {
        int i = 0;
        for (EmployeeFile p : employees) {
            System.out.println(i + ": " + p.getEmployee().getName());
            i++;
        }
    }
}
