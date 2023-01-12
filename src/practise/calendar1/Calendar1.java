package practise.calendar1;
import java.util.Calendar;
import java.util.Date;

public class Calendar1 {
    Calendar cal = Calendar.getInstance();
    public Calendar1(int year, int month, int dayOfMonth, int hours, int minutes)
    {
        cal.set(year, month, dayOfMonth, hours, minutes);
    }

    public void setCalendar(int year, int month, int dayOfMonth, int hours, int minutes) {
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        cal.set(Calendar.HOUR, hours);
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
    public void nextDay(){
        cal.add(Calendar.DAY_OF_MONTH, +1);
        //System.out.println("Date: " + cal.getTime());
    }

    /**
     * moves the current calendar day one hour ahead
     */
    public void nextHour(){
        cal.add(Calendar.HOUR, +1);
        //System.out.println("Date: " + cal.getTime());
     }

}
