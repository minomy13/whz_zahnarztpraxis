package practise.employees.employeeFiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeeFileHandler {

    public final ArrayList<Employee> employees = new ArrayList<>();
    public final Map<String/*Date*/,Map<String/*Name*/,Employee>> timeStampMap = new HashMap<>();
    public final Map<String,Employee> secondMap = new HashMap<>();

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

    public void addEmployeesComeAndGo() {
        employees.forEach(e -> timeStampMap.put(Calendar1.getDate(), secondMap.put(e.getName(),e)));
    }

    public String getComeAndGo(String keyDate, int keyName) {
        return keyDate + " gekommen: " + employees.get(keyName).getCome() + " gegangen: " + employees.get(keyName).getGo();
    }
}
