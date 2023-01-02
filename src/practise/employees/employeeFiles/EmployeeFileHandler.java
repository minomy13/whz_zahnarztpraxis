package practise.employees.employeeFiles;

import java.util.ArrayList;

public class EmployeeFileHandler {

    public final ArrayList<Employee> employees = new ArrayList<>();

    public void hireEmployee(String name, String job) {
        employees.add(new Employee(name, job));
    }

    public void fireEmployee(int index) {
        employees.remove(index);
    }

    public void viewEmployees() {
        int i = 0;
        for (Employee e : employees) {
            System.out.println(i + ": " + e.getName());
            i++;
        }
    }
}
