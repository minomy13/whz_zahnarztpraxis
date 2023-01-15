package practise.patients.patientFiles;

public class Appointment {
    final int year, month, dayOfMonth, hour, minute, hour0, minute0;

    public Appointment(int year, int month, int dayOfMonth, int hour, int minute, int hour0, int minute0) {
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
        this.hour = hour;
        this.minute = minute;
        this.hour0 = hour0;
        this.minute0 = minute0;
    }

    public int getMinute() {
        return minute;
    }

    public int getMinute0() {
        return minute0;
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
