package practise.patients.patientFiles;

public class Patient {
    private final String name;
    private final int yearOfBirth;

    public Patient(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getName() {
        return name;
    }
}
