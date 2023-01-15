package practise.employees;

import practise.Practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeeHandler {
    private final Practise practise;
    private final ArrayList<Employee> employees = new ArrayList<>();
    private final Map<String/*Date*/, Map<String/*Name*/, String>> timeStampMap = new HashMap<>();

    public EmployeeHandler(Practise practise) {
        this.practise = practise;
    }

    /**
     * Creates a new Employee
     *
     * @param name Name of new Employee
     * @param job  Job of new Employee
     */
    public void hireEmployee(String name, String job) {
        employees.add(new Employee(name, job));
    }

    /**
     * Deletes a Employee
     *
     * @param index Index of Employee in ArrayList "employees"
     */
    public void fireEmployee(int index) {
        employees.remove(index);
    }

    /**
     * Shows all Employees
     */
    public void viewEmployees() {
        int i = 1;
        for (Employee e : employees) {
            System.out.println(i + ": " + e.getName() + " " + e.getJob());
            i++;
        }
    }

    public String getEmployeeName(int index) {
        return employees.get(index).getName();
    }

    /**
     * Sets "come" of an Employee
     *
     * @param index Index of Employee in Arraylist "employees"
     */
    public void employeeCome(int index) {
        employees.get(index).setCome(practise.getCalendar().getCurrentTime());
    }

    /**
     * Sets "go" of an Employee
     *
     * @param index Index of Employee in Arraylist "employees"
     */
    public void employeeGo(int index) {
        employees.get(index).setGo(practise.getCalendar().getCurrentTime());
    }

    public String getEmployeeCome(int index) {
        return employees.get(index).getCome();
    }

    public String getEmployeeGo(int index) {
        return employees.get(index).getGo();
    }

    /**
     * calculates work time for given employee index and prints it on console
     */
    public void getWorkTime() {
        for(int i = 0; i < employees.size(); i++) {
            String a1 = employees.get(i).getGo();
            String a2 = a1.substring(0, a1.length() - 2);
            String b1 = employees.get(i).getCome();
            String b2 = b1.substring(0, b1.length() - 2);
            System.out.println(employees.get(i).getName() + " worked: " + (Integer.parseInt(a2) - Integer.parseInt(b2)) + " hours today");
        }
    }

    /**
     * At the End of the Day: safes all Employee timeStamps to a HashMap with:
     * first key: today date, second key: employee.name, entry: timeStamps
     */
    public void addEmployeeTimeStamp() {
        HashMap<String, String> buffer = new HashMap<>();
        for (Employee e : employees) {
            buffer.put(e.getName(), ": " + "Came: " + e.getCome() + ", Gone: " + e.getGo());
        }
        timeStampMap.put(practise.getCalendar().getDay(), buffer);
    }

    /**
     * Gets the timeStamps of an Employee
     *
     * @param keyDate Date in format MM.DD.YYYY
     * @param keyName Name of the Employee
     * @return timeStamps
     */
    public String getComeAndGo(String keyDate, String keyName) {
        return keyName + ", " + keyDate + timeStampMap.get(keyDate).get(keyName);
    }

    /**
     * Gets the timeStamps of all Employees from a specific Date
     *
     * @param keyDate Date in format MM.DD.YYYY
     */
    public void getComeAndGoAll(String keyDate) {
        //System.out.println("Datum: " + keyDate);
        ArrayList<String> j = new ArrayList<>(timeStampMap.get(keyDate).keySet());
        for (int i = 0; i < timeStampMap.get(keyDate).size(); i++) {
            System.out.println(j.get(i) + timeStampMap.get(keyDate).get(j.get(i)));
        }
    }
}
