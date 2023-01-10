package practise.employees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeeHandler {

    public final ArrayList<Employee> employees = new ArrayList<>();
    public final Map<String/*Date*/,Map<String/*Name*/,Employee>> timeStampMap = new HashMap<>();

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

    public void employeeCome(String KeyName) {
        employees.get(KeyName).setCome();
    }

    public void employeeGo(String KeyName) {
        employees.get(KeyName).setGo();
    }

    public void addEmployeesComeAndGo() { //soll am Ende des Tages ausgeführt werden
        HashMap<String, Employee> buffer = new HashMap<>();
        for (Employee e : employees) {
            buffer.put(e.getName(), e);
            timeStampMap.put(Calendar1.getDate(), buffer);
        }
    }

    public String getComeAndGo(String keyDate, int keyName) { //gibt datum und namen wieder
        return keyDate + " gekommen: " + timeStampMap.get(keyDate).get(keyName).getCome() +
                         " gegangen: " + timeStampMap.get(keyDate).get(keyName).getGo();
    }
}
