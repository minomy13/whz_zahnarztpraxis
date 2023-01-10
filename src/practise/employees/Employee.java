package practise.employees;

import practise.calendar1.Calendar1;

import java.util.Date;

public class Employee {

    private final String name;
    private final String job;
    private Date come;
    private Date go;

    public Employee(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job; }

    public void setCome(Date date) {
        this.come = date;
    }

    public void setGo(Date date) {
        this.go = date;
    }

    public Date getCome() {
        return come;
    }

    public Date getGo() {
        return go;
    }

}
