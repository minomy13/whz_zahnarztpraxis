package practise.employees;

public class Employee {

    private final String name;
    private final String job;
    private String come = null;
    private String go = null;

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

    public void setCome(String come) {
        this.come = come;
    }
    public void setGo(String go) {
        this.go = go;
    }

    public String getCome() {
        return come;
    }

    public String getGo() {
        return go;
    }
}
