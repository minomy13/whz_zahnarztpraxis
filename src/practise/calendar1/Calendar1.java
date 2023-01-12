package practise.calendar1;
import java.util.Calendar;
import java.util.Date;

public class Calendar1 {
    private Calendar cal = Calendar.getInstance();
    public Calendar1(int year, int month, int dayOfMonth, int hours, int minutes, int seconds)
    {
        cal.set(year, month, dayOfMonth, hours, minutes, seconds);
    }

    public void setCalendar(int year, int month, int dayOfMonth, int hours, int minutes) {
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        cal.set(Calendar.HOUR_OF_DAY, hours);
        cal.set(Calendar.MINUTE, minutes);
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
        cal.add(Calendar.HOUR_OF_DAY, +1);
        //System.out.println("Date: " + cal.getTime());
     }

}
