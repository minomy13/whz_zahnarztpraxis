package practise.calendar1;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class Calendar1 {
    private GregorianCalendar cal;
    public Calendar1(int year, int month, int dayOfMonth, int hours, int minutes)
    {
        Calendar cal = new GregorianCalendar(year, month, dayOfMonth, hours, minutes);
    }
    public void setYearAndMonth(int year, int month, int dayOfMonth, int hours, int minutes) {
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        cal.set(Calendar.HOUR, hours);
        cal.set(Calendar.MINUTE, minutes);
    }

    public Date getTime() {
        return cal.getTime();
    }
    public void nextDay(){
        cal.add(Calendar.DAY_OF_MONTH, +1);
        //System.out.println("Date: " + cal.getTime());
    }
    public void nextHour(){
        cal.add(Calendar.HOUR, +1);
        //System.out.println("Date: " + cal.getTime());
     }
}
