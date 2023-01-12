package practise.employees;

import java.util.Calendar;
import java.util.Date;

public class Employee {

    private final String name;
    private final String job;
    private Calendar come;
    private Calendar go;

    public Employee(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public void setCome(Calendar date) {
        this.come = date;
    }

    public void setGo(Calendar date) {
        this.go = date;
    }

    public Calendar getCome() {
        return come;
    }

    public Calendar getGo() {
        return go;
    }
}
