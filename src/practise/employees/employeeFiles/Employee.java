package practise.employees.employeeFiles;

public class Employee {

    private final String name;
    private final String job;
    private String come;
    private String go   ;

    public Employee(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job; }

    public void setCome() {
        this.come = Calendar1.getTime();
    }

    public void setGo() {
        this.go = Calendar1.getTime();
    }

    public String getCome() {
        return come;
    }

    public String getGo() {
        return go;
    }

    public void addToTimeStampList() {
        EmployeeFileHandler.addEmployee(this));
    }
}
