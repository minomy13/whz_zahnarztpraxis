package practise.employees;

import practise.Practise;

import java.util.*;

public class EmployeeHandler {
    //TODO documentations
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
        int i = 1;
        for (Employee e : employees) {
            System.out.println(i + ": " + e.getName() + e.getJob());
            i++;
        }
    }

    public String getEmployeeName(int index) {
        return employees.get(index).getName();
    }

    public void employeeCome(int index) {
        employees.get(index).setCome(practise.getCalendar().getCurrentTime());
    }

    public String getEmployeeCome(int index) {
        return employees.get(index).getCome();
    }

    public String getEmployeeGo(int index) {
        return employees.get(index).getGo();
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

    public String getComeAndGo(String keyDate, String keyName) { //gibt Datum und Damen eines Employee wieder
        return keyName + ", " + keyDate + timeStampMap.get(keyDate).get(keyName);
    }

    public void getComeAndGoAll(String keyDate) { //gibt Datum und Namen wieder
        System.out.println("Datum: " + keyDate);
        ArrayList<String> j = new ArrayList<>();
        timeStampMap.get(keyDate).keySet().stream().forEach(k -> j.add(k));
        for(int i = 0; i < timeStampMap.get(keyDate).size(); i++) {
            System.out.println(j.get(i) + timeStampMap.get(keyDate).get(j.get(i)));
        }
    }
}
