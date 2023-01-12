package practise.employees;

import practise.calendar1.Calendar1;
import practise.Practise;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EmployeeHandler {

    private final Practise practise;
    public final ArrayList<Employee> employees = new ArrayList<>();
    public final Map<Date/*Date*/,Map<String/*Name*/,Employee>> timeStampMap = new HashMap<>();

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

    public void employeeCome(int index) {
        employees.get(index).setCome(practise.getCalendar().getTime());
    }

    public void employeeGo(int index) {
        employees.get(index).setCome(practise.getCalendar().getTime());
    }

    public void addEmployeesComeAndGo() { //soll am Ende des Tages ausgeführt werden
        HashMap<String, Employee> buffer = new HashMap<>();
        for (Employee e : employees) {
            buffer.put(e.getName(), e);
            timeStampMap.put(practise.getCalendar().getTime(), buffer);
        }
    }

    public String getComeAndGo(String keyDate, String keyName) { //gibt datum und namen wieder
        return keyDate + " gekommen: " + timeStampMap.get(keyDate).get(keyName).getCome() +
                         " gegangen: " + timeStampMap.get(keyDate).get(keyName).getGo();
    }
}
