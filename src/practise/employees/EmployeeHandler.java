package practise.employees;

import practise.Practise;

import java.util.*;

public class EmployeeHandler {

    private final Practise practise;
    private final ArrayList<Employee> employees = new ArrayList<>();
    private final Map<String/*Date*/,Map<String/*Name*/, String>> timeStampMap = new HashMap<>();

    public EmployeeHandler(Practise practise) {
        this.practise = practise;
    }
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

    public String getEmployeeName(int index) {
        return employees.get(index).getName();
    }

    public void employeeCome(int index) {
        employees.get(index).setCome(practise.getCalendar().getCurrentTime());
    }

    public void employeeGo(int index) {
        employees.get(index).setGo(practise.getCalendar().getCurrentTime());
    }

    public void addEmployeeTimeStamp() {
        HashMap<String, String> buffer = new HashMap<>();
        for(Employee e: employees) {
            buffer.put(e.getName(), ": " + "Gekommen: " + e.getCome() + ", Gegangen: " + e.getGo());
        }
        timeStampMap.put(practise.getCalendar().getDay(), buffer);
    }

    public String getComeAndGo(String keyDate, String keyName) { //give date, name and timeStamps of one Employee
        return keyName + ", " + keyDate + timeStampMap.get(keyDate).get(keyName);
    }

    public void getComeAndGoAll(String keyDate) { //give date, name and timeStamps of all Employees
        System.out.println("Datum: " + keyDate);
        ArrayList<String> j = new ArrayList<>();
        timeStampMap.get(keyDate).keySet().stream().forEach(k -> j.add(k));
        for(int i = 0; i < timeStampMap.get(keyDate).size(); i++) {
            System.out.println(j.get(i) + timeStampMap.get(keyDate).get(j.get(i)));
        }
    }
}
