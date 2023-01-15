package practise.patients.patientFiles;

public class Appointment {
    final int year, month, dayOfMonth, hour, hour0;

    public Appointment(int year, int month, int dayOfMonth, int hour, int hour0) {
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
        this.hour = hour;
        this.hour0 = hour0;
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

    public int getHour0() {
        return hour0;
    }
}
