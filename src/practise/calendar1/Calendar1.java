package practise.calendar1;

import java.util.Calendar;
import java.util.Date;

public class Calendar1 {
    private final Calendar cal = Calendar.getInstance();

    public Calendar1(int year, int month, int dayOfMonth, int hours, int minutes, int seconds) {
        cal.set(year, month, dayOfMonth, hours, minutes, seconds);
    }

    public void setCalendar(int year, int month, int dayOfMonth, int hours, int minutes) {
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        cal.set(Calendar.HOUR_OF_DAY, hours);
        cal.set(Calendar.MINUTE, minutes);
    }

    public Calendar getCal() {
        return cal;
    }

    public Date getTime() {
        return cal.getTime();
    }

    /**
     * moves the calendar one day ahead
     */
    public void nextDay() {
        cal.add(Calendar.DAY_OF_MONTH, +1);
    }

    /**
     * Advances the time
     *
     * @param days Amount of days to advance time by
     */
    public void advanceDays(int days) {
        cal.add(Calendar.DAY_OF_MONTH, +days);
    }

    /**
     * moves the current calendar day one hour ahead
     */
    public void nextHour() {
        cal.add(Calendar.HOUR_OF_DAY, +1);
        //System.out.println("Date: " + cal.getTime());
    }

    /**
     * Advances the time
     *
     * @param minutes Amount of minutes to advance time by
     */
    public void advanceMinutes(int minutes) {
        cal.add(Calendar.MINUTE, +minutes);
    }

    /**
     * Advances the time
     *
     * @param hours Amount of hours to advance time by
     */
    public void advanceHours(int hours) {
        cal.add(Calendar.HOUR_OF_DAY, +hours);
    }

    public String getDay() {
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return day + "." + month + "." + year;
    }

    public String getCurrentTime() {
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        return hour + "." + min;
    }
}
