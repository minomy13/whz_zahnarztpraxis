package practise.employees.employeeFiles;

import practise.employees.employeeFiles.Employee;
public class EmployeeFile {

    private final Employee employee;

    public EmployeeFile(String name, String job) {
        this.employee = new Employee(name, job);
    }

    public Employee getEmployee() {
        return employee;
    }
}
