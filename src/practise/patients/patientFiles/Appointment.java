package practise.patients.patientFiles;

public class Appointment {
    final int year, month, dayOfMonth, hour;

    public Appointment(int year, int month, int dayOfMonth, int hour) {
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
        this.hour = hour;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public int getHour() {
        return hour;
    }
}
